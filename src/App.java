import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import PkgBL.CoordenadasBL;
import PkgBL.UsuarioBL;
import PkgBL.Entities.Coordenadas;
import PkgBL.Entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(ccEncriptarContrasena("1234") + "      81dc9bdb52d04dc20036dbd8313ed055");

        UsuarioBL u = new UsuarioBL();
        Usuario usuario = u.ccGetUsuarioBL(("Profe").toLowerCase(), ccEncriptarContrasena("1234"));
        System.out.println(
                usuario.ccGetNombre() + "    " + usuario.ccGetUsuario() + "     " + usuario.ccGetContrasena()

                        + "\ncontra no encrip ");

        CoordenadasBL csdf = new CoordenadasBL();
        for (Coordenadas s : csdf.ccGetCoordenadaBL()) {
            System.out.println(s.ccGetCap() + "    " + s.ccGetGeo() + "    " + s.ccGetTipoArsenal());
        }

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
