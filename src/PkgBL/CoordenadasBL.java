package PkgBL;

import java.sql.ResultSet;
import java.util.ArrayList;

import PkgBL.Entities.Coordenadas;
import PkgDataAccess.CoordenadasDAC;
import PkgFramework.AppException;

public class CoordenadasBL {
    ArrayList<Coordenadas> ccLsCoordenadas = new ArrayList<>();

    public ArrayList<Coordenadas> ccGetCoordenadaBL() throws Exception {
        try {
            CoordenadasDAC ccCoordenadaDac = new CoordenadasDAC();
            ResultSet ccRs = ccCoordenadaDac.ccGetCoordenadas();

            while (ccRs.next()) {
                Coordenadas ccCoordenada = new Coordenadas(
                        ccRs.getInt("CAP"),
                        ccRs.getString("GEO"),
                        ccRs.getString("TIPO_ARSENAL"));

                if (!ccValidarRepetido(ccLsCoordenadas, ccCoordenada)) {
                    ccLsCoordenadas.add(ccCoordenada);
                }

            }
            return ccLsCoordenadas;
        } catch (Exception e) {
            throw new AppException(e, getClass(), "Error en ccGetCoordenadaBL() " + e.getMessage());
        }

    }

    public boolean ccValidarRepetido(ArrayList<Coordenadas> ccLsCoordenadas, Coordenadas ccCoordenada) {

        for (Coordenadas coordenada : ccLsCoordenadas) {
            if (coordenada.ccGetCap() == ccCoordenada.ccGetCap()) {
                return true;
            }
        }
        return false;
    }

}
