package PkgBL;

import java.sql.ResultSet;
import java.util.ArrayList;

import PkgBL.Entities.Coordenadas;
import PkgDataAccess.CoordenadasDAC;
import PkgFramework.AppException;

public class CoordenadasBL {
    ArrayList<Coordenadas> ccLsCoordenadas = new ArrayList<>();

    /**
     * Metodo que consta a la base de datos y nos entrega una lista sin repeticiones
     * de CAP
     * 
     * @return
     * @throws Exception
     */
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

    /**
     * Metodo que se encarga de validar si existe un elemento repetido
     * 
     * @param ccLsCoordenadas
     * @param ccCoordenada
     * @return
     */

    public boolean ccValidarRepetido(ArrayList<Coordenadas> ccLsCoordenadas, Coordenadas ccCoordenada) {

        for (Coordenadas coordenada : ccLsCoordenadas) {
            if (coordenada.ccGetCap() == ccCoordenada.ccGetCap()) {
                return true;
            }
        }
        return false;
    }

}
