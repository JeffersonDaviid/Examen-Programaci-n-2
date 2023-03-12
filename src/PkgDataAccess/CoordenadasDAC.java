package PkgDataAccess;

import java.sql.ResultSet;

import PkgFramework.AppException;

public class CoordenadasDAC extends SQLiteDataHelper {

    public ResultSet ccGetCoordenadas() throws Exception {
        try {
            String ccSql = "SELECT "
                    + "CAP, GEO, TIPO_ARSENAL"
                    + " FROM "
                    + "CC_CEDULA";

            return ccGetResultSet(ccSql);

        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en ccGetCoordenadas() " + e.getMessage());
        }

    }
}
