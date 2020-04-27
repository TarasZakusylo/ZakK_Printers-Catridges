import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Клас авторизації визначає права доступу та відправляє в клас меню відповідно
 * до доступу.
 * 
 * Функціонал не дописаний, бо пока не дуже зрозумів в його надобності
 */

public class Avtoryzacia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Login;
	private JTextField textField_Login;
	private JLabel label_Password;
	private JPasswordField passwordField_Password;
	private JButton b_Yvijtu;
	private JButton b_Reestracia;
	private JLabel l_kartunku;
	private JButton b_Ochustutu;
	private JLabel l_fon;

	public Avtoryzacia(String s_NameProduct) {
		super(s_NameProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		label_Login = new JLabel("Логін");
		label_Login.setBackground(new Color(165, 42, 42));
		label_Login.setHorizontalAlignment(SwingConstants.CENTER);
		label_Login.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		label_Login.setBounds(125, 256, 231, 29);
		getContentPane().add(label_Login);

		textField_Login = new JTextField();
		textField_Login.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		textField_Login.setToolTipText("");
		textField_Login.setText("1");
		textField_Login.setBounds(63, 298, 369, 36);
		getContentPane().add(textField_Login);
		textField_Login.setColumns(10);

		label_Password = new JLabel("Пароль");
		label_Password.setForeground(new Color(165, 42, 42));
		label_Password.setHorizontalAlignment(SwingConstants.CENTER);
		label_Password.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		label_Password.setBounds(125, 347, 231, 29);
		getContentPane().add(label_Password);

		passwordField_Password = new JPasswordField();
		passwordField_Password.setFont(new Font("Times New Roman", Font.ITALIC,
				20));
		passwordField_Password.setToolTipText("");
		passwordField_Password.setText("1");
		passwordField_Password.setBounds(63, 389, 369, 36);
		getContentPane().add(passwordField_Password);

		b_Yvijtu = new JButton("Увійти");
		b_Yvijtu.setForeground(new Color(0, 0, 0));

		b_Yvijtu.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Yvijtu.setBounds(33, 487, 215, 36);
		getContentPane().add(b_Yvijtu);

		b_Reestracia = new JButton("Реєстрація");
		b_Reestracia.setForeground(new Color(0, 0, 0));
		b_Reestracia.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Reestracia.setBounds(247, 487, 215, 36);
		getContentPane().add(b_Reestracia);

		b_Ochustutu = new JButton("Очистити");
		b_Ochustutu.setForeground(new Color(0, 0, 0));
		b_Ochustutu.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Ochustutu.setBounds(63, 451, 369, 36);
		getContentPane().add(b_Ochustutu);

		l_kartunku = new JLabel("");
//		l_kartunku.setIcon(new ImageIcon("res/kartunka/kartunka_Avtoruzacia.png"));
		l_kartunku.setBounds(-1, 0, 995, 565);
		getContentPane().add(l_kartunku);

		l_fon = new JLabel("");
//		l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		l_fon.setBounds(-1, 0, 995, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
