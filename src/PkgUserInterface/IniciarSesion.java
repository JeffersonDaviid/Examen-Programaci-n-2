package PkgUserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import PkgBL.UsuarioBL;
import PkgBL.Entities.Usuario;

import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IniciarSesion extends JFrame {
    private JPasswordField ccpasswordField;
    private JTextField cctextField;
    private JButton ccbtnNewButton;
    private int ccnumintentos = 3;

    public static void main(String[] args) {
        IniciarSesion frame = new IniciarSesion();
        frame.setVisible(true);
    }

    public IniciarSesion() {
        setTitle("INICIAR SESION");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(new Rectangle(500, 200, 260, 300));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        ccpasswordField = new JPasswordField();
        ccpasswordField.setBounds(63, 128, 126, 20);
        panel.add(ccpasswordField);
        ccpasswordField.setColumns(15);

        cctextField = new JTextField();
        cctextField.setBounds(63, 61, 126, 20);
        panel.add(cctextField);
        cctextField.setColumns(15);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(105, 36, 56, 14);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Contraseña");
        lblNewLabel_1.setBounds(92, 103, 69, 14);
        panel.add(lblNewLabel_1);

        ccbtnNewButton = new JButton("Ingresar");
        ccbtnNewButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    UsuarioBL ccUserBL = new UsuarioBL();
                    Usuario ccUsuario = ccUserBL.ccGetUsuarioBL(cctextField.getText().trim().toLowerCase(),
                            ccEncriptarContrasena(new String(ccpasswordField.getPassword())));

                    if (ccUsuario != null && ccUsuario.ccGetUsuario().equalsIgnoreCase(cctextField.getText().trim())) {
                        Ventana ventana = new Ventana();
                        ventana.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e1) {
                } finally {
                    ccnumintentos--;
                    if (ccnumintentos == 0) {
                        JOptionPane.showMessageDialog(null, "Intentos fallidos");
                        setVisible(false);
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Revise sus datos e intente nuevamente\nIntento permitidos: " + ccnumintentos);

                }
            }
        });
        ccbtnNewButton.setBounds(85, 192, 89, 23);
        panel.add(ccbtnNewButton);

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