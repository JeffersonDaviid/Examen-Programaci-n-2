package PkgBL.Entities;

public class Coordenadas {
    private int ccCap;
    private String ccGeo;
    private String ccTipoArsenal;

    public Coordenadas(int ccCap, String ccGeo, String ccTipoArsenal) {
        this.ccCap = ccCap;
        this.ccGeo = ccGeo;
        this.ccTipoArsenal = ccTipoArsenal;
    }

    public int ccGetCap() {
        return ccCap;
    }

    public void ccSetCap(int ccCap) {
        this.ccCap = ccCap;
    }

    public String ccGetGeo() {
        return ccGeo;
    }

    public void ccSetGeo(String ccGeo) {
        this.ccGeo = ccGeo;
    }

    public String ccGetTipoArsenal() {
        return ccTipoArsenal;
    }

    public void ccSetTipoArsenal(String ccTipoArsenal) {
        this.ccTipoArsenal = ccTipoArsenal;
    }

}
