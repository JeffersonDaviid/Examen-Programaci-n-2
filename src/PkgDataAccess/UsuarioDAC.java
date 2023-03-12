package PkgDataAccess;

import java.sql.ResultSet;

import PkgFramework.AppException;

public class UsuarioDAC extends SQLiteDataHelper {

    public ResultSet ccGetUsuarioBL(String usuario, String contrasenia) throws Exception {
        try {
            String ccSql = "SELECT "
                    + "USUARIO, CONTRASENIA, NOMBRE"
                    + " FROM "
                    + "CREDENCIALES"
                    + " WHERE "
                    + "USUARIO = '" + usuario + "' AND "
                    + "CONTRASENIA = '" + contrasenia + "'";

            return ccGetResultSet(ccSql);

        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en ccGetUsuarioBL(String usuario, String contrasenia) " + e.getMessage());
        }

    }

}
