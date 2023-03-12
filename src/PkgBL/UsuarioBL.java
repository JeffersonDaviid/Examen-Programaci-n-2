package PkgBL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import PkgBL.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;

public class UsuarioBL {

    public Usuario ccGetUsuarioBL(String usuario, String contrasenia) throws SQLException {
        try {
            UsuarioDAC ccUsuarioDac = new UsuarioDAC();
            ResultSet ccRs = ccUsuarioDac.ccGetUsuarioBL(usuario, contrasenia);

            Usuario ccUsuario = new Usuario(
                    ccRs.getString("USUARIO"),
                    ccRs.getString("CONTRASENIA"),
                    ccRs.getString("NOMBRE"));
            return ccUsuario;
        } catch (Exception e) {
            System.out.println(
                    "Fallo en ccGetUsuarioBL(String usuario, String contrasenia) ");
        }
        return null;
    }

    public static String ccEncriptarContrasena(String input) {
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
            e.printStackTrace();
        }
        return md5;

    }

}
