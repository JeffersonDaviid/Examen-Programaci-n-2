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

    public static void main(String[] args) {
        IniciarSesion frame = new IniciarSesion();
        frame.setVisible(true);
    }

    public IniciarSesion() {
        setBounds(new Rectangle(500, 200, 400, 400));
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        ccpasswordField = new JPasswordField();
        ccpasswordField.setBounds(123, 146, 126, 20);
        panel.add(ccpasswordField);
        ccpasswordField.setColumns(15);

        cctextField = new JTextField();
        cctextField.setBounds(123, 79, 126, 20);
        panel.add(cctextField);
        cctextField.setColumns(15);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(165, 54, 56, 14);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Contraseña");
        lblNewLabel_1.setBounds(152, 121, 69, 14);
        panel.add(lblNewLabel_1);

        ccbtnNewButton = new JButton("Ingresar");
        ccbtnNewButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    UsuarioBL ccUserBL = new UsuarioBL();
                    Usuario ccUsuario = ccUserBL.ccGetUsuarioBL(cctextField.getText().trim(),
                            ccEncriptarContrasena(new String(ccpasswordField.getPassword()).toLowerCase()));

                    if (ccUsuario != null) {
                        if (ccUsuario.ccGetUsuario().equalsIgnoreCase(cctextField.getText().trim())) {
                            Ventana ventana = new Ventana();
                            ventana.setVisible(true);
                            // this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario " +
                                    cctextField.getText().trim()
                                    + " no se encuentra en la base de datos.\nRevise sus datos e intente nuevamente");
                        }
                    }

                } catch (Exception e1) {
                }
            }
        });
        ccbtnNewButton.setBounds(145, 210, 89, 23);
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