package PkgDataAccess;

import java.sql.ResultSet;

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
            System.out.println("Fallo en ccGetUsuarioBL() " + e.getMessage());
        }
        return null;

    }

}
