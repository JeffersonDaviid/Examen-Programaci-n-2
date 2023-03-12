package PkgBL;

import java.sql.ResultSet;

import PkgBL.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;
import PkgFramework.AppException;

public class UsuarioBL {

    /**
     * Metodo que consula en la base de datos, un usuriario atravez de usuario y
     * contraseña
     * 
     * @param usuario
     * @param contrasenia
     * @return
     * @throws Exception
     */
    public Usuario ccGetUsuarioBL(String usuario, String contrasenia) throws Exception {
        try {
            UsuarioDAC ccUsuarioDac = new UsuarioDAC();
            ResultSet ccRs = ccUsuarioDac.ccGetUsuarioBL(usuario, contrasenia);

            Usuario ccUsuario = new Usuario(
                    ccRs.getString("USUARIO"),
                    ccRs.getString("CONTRASENIA"),
                    ccRs.getString("NOMBRE"));
            return ccUsuario;
        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en ccGetUsuarioBL(String usuario, String contrasenia) " + e.getMessage());
        }
    }

}
