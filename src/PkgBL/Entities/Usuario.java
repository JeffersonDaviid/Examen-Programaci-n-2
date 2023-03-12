package PkgBL.Entities;

public class Usuario {
    private String ccUsuario;
    private String ccContrasena;
    private String ccNombre;

    public Usuario(String ccUsuario, String ccContrasena, String ccNombre) {
        this.ccUsuario = ccUsuario;
        this.ccContrasena = ccContrasena;
        this.ccNombre = ccNombre;
    }

    public String ccGetUsuario() {
        return ccUsuario;
    }

    public void ccSetUsuario(String ccUsuario) {
        this.ccUsuario = ccUsuario;
    }

    public String ccGetContrasena() {
        return ccContrasena;
    }

    public void ccSetContrasena(String ccContrasena) {
        this.ccContrasena = ccContrasena;
    }

    public String ccGetNombre() {
        return ccNombre;
    }

    public void ccSetNombre(String ccNombre) {
        this.ccNombre = ccNombre;
    }

}
