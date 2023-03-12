package PkgBL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

import javax.swing.plaf.synth.SynthStyleFactory;

import PkgBL.Entities.Usuario;
import PkgDataAccess.UsuarioDAC;
import PkgFramework.AppException;

public class UsuarioBL {

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
