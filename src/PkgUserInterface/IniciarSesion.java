package PkgUserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IniciarSesion extends JFrame {
    private JPasswordField CC_passwordField;
    private JTextField CC_textField;
    private JButton CC_btnNewButton;
    public static void main(String[] args) {
		IniciarSesion frame = new   IniciarSesion();
		frame.setVisible(true);
	}
    public IniciarSesion(){
    	setBounds(new Rectangle(500, 200, 400, 400));
        JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		CC_passwordField = new JPasswordField();
		CC_passwordField.setBounds(123, 146, 126, 20);
		panel.add(CC_passwordField);
		CC_passwordField.setColumns(15);
		
		CC_textField = new JTextField();
		CC_textField.setBounds(123, 79, 126, 20);
		panel.add(CC_textField);
		CC_textField.setColumns(15);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(165, 54, 56, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(152, 121, 69, 14);
		panel.add(lblNewLabel_1);
		
		CC_btnNewButton = new JButton("Ingresar");
		CC_btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                
			}
		});
		CC_btnNewButton.setBounds(145, 210, 89, 23);
		panel.add(CC_btnNewButton);
        
    }
}