package PkgBL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

import PkgBL.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;
import PkgFramework.AppException;

public class UsuarioBL {

    public Usuario ccGetUsuarioBL(String usuario, String contrasenia) throws Exception {
        try {
            UsuarioDAC ccUsuarioDac = new UsuarioDAC();
            ResultSet ccRs = ccUsuarioDac.ccGetUsuarioBL(usuario, ccEncriptarContrasena(contrasenia));

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

    public static String ccEncriptarContrasena(String input) throws Exception {
        String md5 = null;
        if (null == input)
            return null;

        try {
            // Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            // Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            throw new AppException(e, "Error en ccEncriptarContrasena(String input) " + e.getMessage());
        }
        return md5;

    }

}
