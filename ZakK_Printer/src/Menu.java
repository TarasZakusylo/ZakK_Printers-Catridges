import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Клас, що пов'язує весь функціонал
 */

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JButton b_Pryntery;
	private JButton b_Kartryji;
	private JLabel l_kartunku;

	String s_Path_Mictce = "C:/ZakK_Printer/baza/";
	
	
	
	public Menu(final String s_NameProduct) {
		super(s_NameProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		label_Shapka = new JLabel("\u041E\u0431\u043B\u0456\u043A \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432 \u0442\u0430 \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0456\u0432");
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		label_Shapka.setBounds(17, 11, 967, 29);
		getContentPane().add(label_Shapka);

		b_Pryntery = new JButton(
				"\u041F\u0440\u0438\u043D\u0442\u0435\u0440\u0438");
		b_Pryntery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// перевірка чи не пустий файл із базою
				int i_k_File = 0;
				for (String path : fileInDirect(s_Path_Mictce)) {
//					System.out.println(path);
					i_k_File++;
				}
				if (i_k_File != 0) {						
					new Pryntery(s_NameProduct);
					setVisible(false);
				}
			}
		});
		b_Pryntery.setForeground(new Color(0, 0, 0));

		b_Pryntery.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Pryntery.setBounds(62, 83, 295, 36);
		getContentPane().add(b_Pryntery);

		b_Kartryji = new JButton("\u041A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0456");
		b_Kartryji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Kartryji(s_NameProduct);
				setVisible(false);
			}
		});
		b_Kartryji.setForeground(new Color(0, 0, 0));
		b_Kartryji.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Kartryji.setBounds(62, 135, 295, 36);
		getContentPane().add(b_Kartryji);
		
		JButton b_Remonty = new JButton("\u0420\u0435\u043C\u043E\u043D\u0442\u0438");
		b_Remonty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Remonty(s_NameProduct);
				setVisible(false);
			}
		});
		b_Remonty.setForeground(Color.BLACK);
		b_Remonty.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Remonty.setBounds(62, 182, 295, 36);
		getContentPane().add(b_Remonty);
		
		JButton b_People = new JButton("\u041A\u043E\u0440\u0438\u0441\u0442\u0443\u0432\u0430\u0447\u0456");
		b_People.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new People(s_NameProduct);
				setVisible(false);
			}
		});
		b_People.setForeground(Color.BLACK);
		b_People.setFont(new Font("Impact", Font.PLAIN, 25));
		b_People.setBounds(62, 229, 295, 36);
		getContentPane().add(b_People);
		
		JButton b_Doc = new JButton("\u0414\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0438");
		b_Doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Doc(s_NameProduct);
				setVisible(false);
			}
		});
		b_Doc.setForeground(Color.BLACK);
		b_Doc.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Doc.setBounds(62, 276, 295, 36);
		getContentPane().add(b_Doc);
						
						JButton b_DovidkovaInfom = new JButton("\u0414\u043E\u0432\u0456\u0434\u043A\u043E\u0432\u0430 \u0456\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0456\u044F");
						b_DovidkovaInfom.setForeground(Color.BLACK);
						b_DovidkovaInfom.setFont(new Font("Impact", Font.PLAIN, 25));
						b_DovidkovaInfom.setBounds(62, 324, 295, 36);
						getContentPane().add(b_DovidkovaInfom);
						
						JButton button = new JButton("\u041D\u0430\u043B\u0430\u0448\u0442\u0443\u0432\u0430\u043D\u043D\u044F (\u0437\u043D\u0430\u0445\u043E\u0434\u0436\u0435\u043D\u043D\u044F \u0431\u0430\u0437\u0438)");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
							}
						});
						button.setForeground(Color.BLACK);
						button.setFont(new Font("Impact", Font.PLAIN, 25));
						button.setBounds(62, 371, 295, 36);
						getContentPane().add(button);
				
						l_kartunku = new JLabel("");
						//		l_kartunku.setIcon(new ImageIcon("res/kartunka/kartunka_Avtoruzacia.png"));
								l_kartunku.setBounds(-1, 0, 995, 565);
								getContentPane().add(l_kartunku);


						setIconImage(Toolkit.getDefaultToolkit().getImage(new File("res/icon_save.png").toString()));
						    
							
								
		setVisible(true);
	}
	
	public static String[] fileInDirect(String Puth) {
		// шукаємо папки в каталозі

		File file_Mictce = new File(Puth);
		String[] s_mas_paths = { "null" };

		// System.out.println("Path exists? " + file_Mictce.exists()); // Файл
		// існує ?
		
		if (file_Mictce.exists()) {
			// Проверить является ли 'file_Mictce' папкой или нет?
			// System.out.println("Directory? " + file_Mictce.isDirectory());
			// Простое название
			// System.out.println("Simple Name: " + file_Mictce.getName());
			s_mas_paths = file_Mictce.list();
		} else {
			JOptionPane.showMessageDialog(null, "Базу не підключено \n"
					+ "Перевірте каталог:\n"
					+ "C:/ZakK_Printer/baza");
		}

		// виведення списку всіх об'єктів в каталозі
//		for (String path : s_mas_paths) {
//			System.out.println(path);
//		}
		return s_mas_paths;
	}
}
