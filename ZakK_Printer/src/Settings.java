import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Клас, що містить налаштування - Можна змінювати місце знаходження бази
 */

public class Settings extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JLabel l_kartunku;

	String s_Path_Mictce = "C:/ZakK_Printer/baza/";
	private JLabel l_baza;
	private static JTextField tF_mistceBazy;

	JLabel l_SaveMisce = new JLabel("");

	public Settings(final String s_NameProduct) {
		super(s_NameProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				new File("res/ZakK.png").toString()));

		JButton b_Menu = new JButton("\u041C\u0435\u043D\u044E");
		b_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu(s_NameProduct);
				setVisible(false);
			}
		});
		b_Menu.setForeground(Color.BLACK);
		b_Menu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_Menu.setBounds(875, 11, 109, 23);
		getContentPane().add(b_Menu);

		tF_mistceBazy = new JTextField();
		tF_mistceBazy.setToolTipText("");
		tF_mistceBazy.setHorizontalAlignment(SwingConstants.LEFT);
		tF_mistceBazy.setForeground(Color.BLACK);
		tF_mistceBazy.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_mistceBazy.setColumns(10);
		tF_mistceBazy.setBounds(17, 76, 450, 20);
		getContentPane().add(tF_mistceBazy);

		label_Shapka = new JLabel(
				"\u041D\u0430\u043B\u0430\u0448\u0442\u0443\u0432\u0430\u043D\u043D\u044F");
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		label_Shapka.setBounds(17, 11, 967, 29);
		getContentPane().add(label_Shapka);

		l_kartunku = new JLabel("");
		// l_kartunku.setIcon(new
		// ImageIcon("res/kartunka/kartunka_Avtoruzacia.png"));
		// l_kartunku.setBounds(-1, 0, 995, 565);
		getContentPane().add(l_kartunku);

		l_baza = new JLabel(
				"\u041C\u0456\u0441\u0446\u0435 \u0437\u043D\u0430\u0445\u043E\u0434\u0436\u0435\u043D\u043D\u044F \u0431\u0430\u0437\u0438");
		l_baza.setHorizontalAlignment(SwingConstants.CENTER);
		l_baza.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_baza.setBounds(10, 51, 250, 14);
		getContentPane().add(l_baza);

		tF_mistceBazy.setText(puthBazy());
		
		l_SaveMisce.addMouseListener(new MouseAdapter() {

			private Formatter formatter_Path;

			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (tF_mistceBazy.getText().equals(null)
						|| tF_mistceBazy.getText().equals("")
						|| tF_mistceBazy.getText().equals(" ")
						|| tF_mistceBazy.getText().equals("  ")
						|| tF_mistceBazy.getText().equals("   ")) {
					JOptionPane.showMessageDialog(null,
							"Ви не ввели назву місця розташування");
				} else {

					try {
						String s_Path = "res/Puth";
						formatter_Path = new Formatter(s_Path);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти путь");
					}
					formatter_Path.format(tF_mistceBazy.getText());
					formatter_Path.close();

					JOptionPane.showMessageDialog(null, "Збережено");

				}
			}
		});

		l_SaveMisce.setBounds(477, 71, 25, 25);
		l_SaveMisce.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMisce);

		setVisible(true);
	}

	static String puthBazy() {
		String s_k = null;
		try {
			FileInputStream file_k = new FileInputStream(new File("res/Puth"));
			byte[] byte_file_k = new byte[file_k.available()];
			file_k.read(byte_file_k);
			file_k.close();
			
			String[] s_mas_k = new String(byte_file_k, "Cp1251").split("\n");

			for (String for_mas_k : s_mas_k) {
				// s_IP = s_IP + for_mas_IP + "\n";
				s_k = for_mas_k;
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,
					"Помилка відкриття файла \"res/Puth\"");
		}

		return s_k;
	}
}
