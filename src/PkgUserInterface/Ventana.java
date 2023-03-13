package PkgUserInterface;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import PkgBL.CoordenadasBL;
import PkgBL.Entities.Coordenadas;
import PkgFramework.Global;

public class Ventana extends JFrame {
    static JTextArea cctxtrF = new JTextArea();
    static JTextArea cctxtrF_1 = new JTextArea();

    public static void main(String[] args) throws Exception {
        Ventana frame = new Ventana();
        frame.setVisible(true);
    }

    public Ventana() throws Exception {
        // setResizable(false);
        setSize(800, 800);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        cctxtrF.setEditable(false);
        cctxtrF.setFocusable(false);
        cctxtrF.setWrapStyleWord(true);

        panel.add(cctxtrF);

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        cctxtrF_1.setWrapStyleWord(true);
        cctxtrF_1.setText(" Cap |  Geo |Tipo_Arsenal\r\n\r\n");
        cctxtrF_1.setFocusable(false);
        cctxtrF_1.setEditable(false);
        panel_1.add(cctxtrF_1);
        ccPresentarResumen();

    }

    public static void ccPresentarResumen() throws Exception {
        String ccData = "";
        String ccSecCarga = "";
        int ccCapacidadBelica = 0;

        ccData += " Cap\t|\tGeo\t|\tTipo_Arsenal\n\n";

        CoordenadasBL ccCoordenadaBl = new CoordenadasBL();
        ArrayList<Coordenadas> ccLsCoordenadaBl = ccCoordenadaBl.ccGetCoordenadaBL();
        for (Coordenadas s : ccLsCoordenadaBl) {
            ccData += s.ccGetCap() + "\t|\t" + s.ccGetGeo() + "\t|\t" + s.ccGetTipoArsenal() + "\n";

            System.out.println(s.ccGetCap() + "    " + s.ccGetGeo() + "    " + s.ccGetTipoArsenal() + ": "
                    + ccValidarCoordernada(s.ccGetTipoArsenal()));

            ccSecCarga += s.ccGetCap() + " ";
            ccCapacidadBelica += s.ccGetCap();

            if (ccValidarCoordernada(s.ccGetGeo())) {
                System.out.println("true");
            }
        }

        cctxtrF.setText(ccData);

        String ccDataResumen = "Developer-Nombre:\t" + Global.Global.CC_NOMBRE1 + " y\n\t\t" + Global.Global.CC_NOMBRE2
                + "\nDeveloper-Cedula:\t" + Global.Global.CC_CEDULA1 + " y " + Global.Global.CC_CEDULA2
                + "\nCapacidad-Belica:\t" + ccCapacidadBelica
                + "\nCoordenada-Total:\t" + ccCoordenadaBl.ccGetCoordenadaBL().size()
                + "\nCoordenada-SecCarga:\t" + ccSecCarga + "\n\n\n ARBOL BINARIO\n\n";

        for (int i = ccCoordenadaBl.ccGetCoordenadaBL().size(); i >= 1; i--) {
            for (int j = 1; j < ccCoordenadaBl.ccGetCoordenadaBL().size(); j++) {
                if (j == i) {
                    if (ccValidarCoordernada(ccLsCoordenadaBl.get(i).ccGetTipoArsenal())) {
                        ccDataResumen += ccLsCoordenadaBl.get(i).ccGetGeo() + " {  "
                                + ccLsCoordenadaBl.get(i).ccGetTipoArsenal() + "  BOMB-IPI  " + "  }\n";

                        System.out.println(ccLsCoordenadaBl.get(i).ccGetGeo() + " {  "
                                + ccLsCoordenadaBl.get(i).ccGetTipoArsenal() + "  BOMB-IPI" + "  }");
                    } else {

                        ccDataResumen += ccLsCoordenadaBl.get(i).ccGetGeo() + " {  "
                                + ccLsCoordenadaBl.get(i).ccGetTipoArsenal() + "  }\n";

                        System.out.println(ccLsCoordenadaBl.get(i).ccGetGeo() + " {  "
                                + ccLsCoordenadaBl.get(i).ccGetTipoArsenal() + "  }");
                    }
                } else {
                    ccDataResumen += "\t";

                    System.out.print("\t");

                }
            }
            System.out.println();
        }
        cctxtrF_1.setText(ccDataResumen);
    }

    /**
     * Expresion regular que valida la coordernada
     * 
     * @param ccCoodernada
     * @return
     */
    public static boolean ccValidarCoordernada(String ccCoodernada) {
        // String ccBomba = "^(a+bc*(d*|t*))$";
        String ccBomba = "a+bc*$";
        return ccCoodernada.matches(ccBomba);

    }

}