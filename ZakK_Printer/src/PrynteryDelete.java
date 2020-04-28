import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * 
 */

public class PrynteryDelete extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JButton b_Menu;
	private JLabel l_fon;

	public ArrayList<String> al_Mictce = new ArrayList<String>();
	public ArrayList<String> al_Mictce2 = new ArrayList<String>();
	public ArrayList<String> al_Model = new ArrayList<String>();
	public ArrayList<String> al_Marka = new ArrayList<String>();
	public ArrayList<String> al_SN = new ArrayList<String>();

	String[] s_mas_Misctce = null;
	String[] s_mas_Misctce2 = null;
	String[] s_mas_Model = null;
	String[] s_mas_Marka = null;
	String[] s_mas_SN = null;

	String s_IP = "";
	String s_Koment = "";
	String s_Inv = "";
	String s_Stan = "";
	String s_MOL = "";
	
	String s_Path_Mictce = "C:/ZakK_Printer/baza/";
	
	@SuppressWarnings("rawtypes")
	JComboBox cB_Marka = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cB_Model = new JComboBox();

	private final JLabel l_SN = new JLabel(
			"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u0441\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440");
	@SuppressWarnings("rawtypes")
	private final JComboBox cB_SN = new JComboBox();
	private final JLabel l_Mistse2 = new JLabel(
			"\u0412\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");
	@SuppressWarnings("rawtypes")
	private JComboBox cB_Mistse2 = new JComboBox();
	private JTextField tF_IN;
	
	private final JLabel l_Mistse = new JLabel(
			"\u041C\u0456\u0441\u0446\u0435 \u0440\u043E\u0437\u0442\u0430\u0448\u0443\u0432\u0430\u043D\u043D\u044F");
	@SuppressWarnings("rawtypes")
	private JComboBox cB_Mistse = new JComboBox();
	private JTextField tF_IP_USB;
	private final JLabel l_DodatkovaInfa = new JLabel("\u0414\u043E\u0434\u0430\u0442\u043A\u043E\u0432\u0430 \u0456\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0456\u044F:");
	private TextArea tA_Koment = new TextArea();
	private final JLabel l_Stan = new JLabel("\u0421\u0442\u0430\u043D \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
	private final JTextField tF_Stan = new JTextField();
	
	private JTextField tF_MOL;
	
	private JButton b_SN;
	private JButton b_Model;
	private JButton b_Marka;
	private JButton b_Mistse2;
	private JButton b_Mictce;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PrynteryDelete(final String s_NameProduct) {
		super(s_NameProduct);

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true); 	// вікно по верх всіх вікон. При використанні JOptionPane необхідно відключати
		setSize(527, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				new File("res/ZakK.png").toString()));
		
		{ // початкове відображення Місця 1 рівня
			al_Mictce.add("");  // добавляємо пусте поле на початку
			for (String path : Menu.fileInDirect(s_Path_Mictce)) {
				al_Mictce.add(path); // отримуємо список всіх місць
				// System.out.println(al_Mictce);
			}

			// переписуємо ArrayList із всіма місцями в стрінговий масив, щоб
			// потім його записати в ЧекБокс
			s_mas_Misctce = al_Mictce.toArray(new String[al_Mictce.size()]);
			
			// виводимо / перевіряємо масив
			// System.out.println(Arrays.toString(s_mas_Misctce));
		}

		cB_Mistse = new JComboBox(s_mas_Misctce);
		cB_Mistse.setBounds(27, 104, 227, 20);
		getContentPane().setLayout(null);
//		cB_Mistse2 = new JComboBox(s_mas_Misctce2);
//		cB_Marka = new JComboBox(s_mas_Marka);
//		cB_Model = new JComboBox(s_mas_Model);

		label_Shapka = new JLabel(
				" \u0412\u0438\u0434\u0430\u043B\u0435\u043D\u043D\u044F");
		label_Shapka.setBounds(17, 11, 494, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);

		b_Menu = new JButton("\u041C\u0435\u043D\u044E");
		b_Menu.setBounds(875, 541, 109, 19);
		b_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu(s_NameProduct);
				setVisible(false);
			}
		});
		b_Menu.setForeground(new Color(0, 0, 0));

		b_Menu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(b_Menu);

		JLabel l_Marka = new JLabel(
				"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u043C\u0430\u0440\u043A\u0443 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Marka.setBounds(17, 191, 250, 14);
		l_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		l_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Marka);

		JLabel l_Model = new JLabel(
				"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u043C\u043E\u0434\u0435\u043B\u044C \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Model.setBounds(17, 247, 250, 14);
		l_Model.setHorizontalAlignment(SwingConstants.CENTER);
		l_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Model);
		
		l_SN.setBounds(17, 303, 250, 14);
		l_SN.setHorizontalAlignment(SwingConstants.CENTER);
		l_SN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_SN);
		l_Mistse2.setBounds(17, 135, 250, 14);
		l_Mistse2.setHorizontalAlignment(SwingConstants.CENTER);
		l_Mistse2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Mistse.setBounds(17, 79, 250, 14);

		l_Mistse.setHorizontalAlignment(SwingConstants.CENTER);
		l_Mistse.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Mistse);

		getContentPane().add(cB_Mistse);
		getContentPane().add(cB_Mistse);
		cB_Mistse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// обнуляємо масиви
				s_mas_Misctce2 = null;
				al_Mictce2.clear();
				s_mas_Marka = null;
				al_Marka.clear();
				s_mas_Model = null;
				al_Model.clear(); // cB_Model
				s_mas_SN = null;
				al_SN.clear();
				
				tF_IP_USB.setText("");
				tF_IN.setText("");
				tF_Stan.setText("");
				tA_Koment.setText("");
				tF_MOL.setText("");
				
				cB_Marka.setModel(new DefaultComboBoxModel());
				cB_Model.setModel(new DefaultComboBoxModel());
				cB_SN.setModel(new DefaultComboBoxModel());
				
				al_Mictce2.add("");
				
				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem())) {
					al_Mictce2.add(path);
				}
				
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Misctce2 = al_Mictce2.toArray(new String[al_Mictce2
						.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_Mistse2.setModel(new DefaultComboBoxModel(s_mas_Misctce2));

				b_Mictce.setBounds(277, 104, 227, 20);
				
				revalidate();
			}
		});

		getContentPane().add(l_Mistse2);
		cB_Mistse2.setBounds(27, 160, 227, 20);
		getContentPane().add(cB_Mistse2);
		cB_Mistse2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// обнуляємо масиви
				s_mas_Marka = null;
				al_Marka.clear();
				s_mas_Model = null;
				al_Model.clear();
				s_mas_SN = null;
				al_SN.clear();
				
				tF_IP_USB.setText("");
				tF_IN.setText("");
				tF_Stan.setText("");
				tA_Koment.setText("");
				tF_MOL.setText("");
				
				cB_Model.setModel(new DefaultComboBoxModel());
				cB_SN.setModel(new DefaultComboBoxModel());
				
				al_Marka.add("");
				
				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem()+
						"/"	+ (String) cB_Mistse2.getSelectedItem())) {
					al_Marka.add(path);
				}
				
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Marka = al_Marka.toArray(new String[al_Marka.size()]);

				// виводимо / перевіряємо масив
//				 System.out.println("s_mas_Marka "+Arrays.toString(s_mas_Marka));

				// Полностью переопределяем все элементы
				cB_Marka.setModel(new DefaultComboBoxModel(s_mas_Marka));

				b_Mistse2.setBounds(277, 159, 227, 20);
				
				revalidate();
			}
		});
		cB_Marka.setBounds(27, 216, 227, 20);
		getContentPane().add(cB_Marka);
		cB_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// обнуляємо масиви
				s_mas_Model = null;
				al_Model.clear();
				s_mas_SN = null;
				al_SN.clear();
				
				tF_IP_USB.setText("");
				tF_IN.setText("");
				tF_Stan.setText("");
				tA_Koment.setText("");
				tF_MOL.setText("");
				
				cB_SN.setModel(new DefaultComboBoxModel());
				
				al_Model.add("");
				
				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem()
						+ "/" + (String) cB_Mistse2.getSelectedItem()
						+ "/" + (String) cB_Marka.getSelectedItem())) {
					al_Model.add(path);
				}
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Model = al_Model.toArray(new String[al_Model.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_Model.setModel(new DefaultComboBoxModel(s_mas_Model));

				b_Marka.setBounds(277, 215, 227, 20);
				
				revalidate();
			}
		});
		cB_Model.setBounds(27, 272, 227, 20);
		getContentPane().add(cB_Model);
		cB_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// обнуляємо масиви
				s_mas_SN = null;
				al_SN.clear();

				tF_IP_USB.setText("");
				tF_IN.setText("");
				tF_Stan.setText("");
				tA_Koment.setText("");
				tF_MOL.setText("");
				
				al_SN.add("");
				
				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem()
						+ "/" + (String) cB_Mistse2.getSelectedItem()
						+ "/" + (String) cB_Marka.getSelectedItem()
						+ "/" + (String) cB_Model.getSelectedItem())) {
					al_SN.add(path);
				}

				// переписуємо ArrayList 
				// щоб потім його записати в ЧекБокс
				s_mas_SN = al_SN.toArray(new String[al_SN.size()]);

				// виводимо / перевіряємо масив
//				 System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_SN.setModel(new DefaultComboBoxModel(s_mas_SN));

				b_Model.setBounds(277, 272, 227, 20);
				
				revalidate();
			}
		});
		
		cB_SN.setBounds(27, 328, 227, 20);
		getContentPane().add(cB_SN);		
		cB_SN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				tF_IP_USB.setText("");
				tF_IN.setText("");
				tF_Stan.setText("");
				tA_Koment.setText("");
				tF_MOL.setText("");
				
				s_Inv = "";
				s_IP = "";
				s_Stan = "";
				s_Koment = "";
				s_MOL = "";
				
				// IP
				try {
					FileInputStream file_IP = new FileInputStream(new File(
							s_Path_Mictce
									+ (String) cB_Mistse.getSelectedItem()
									+ "/"
									+ (String) cB_Mistse2.getSelectedItem()
									+ "/" + (String) cB_Marka.getSelectedItem()
									+ "/" + (String) cB_Model.getSelectedItem()
									+ "/" + (String) cB_SN.getSelectedItem())
							+ "/IP");
					byte[] byte_file_IP = new byte[file_IP.available()];
					file_IP.read(byte_file_IP);
					file_IP.close();

					String[] s_mas_IP = new String(byte_file_IP, "Cp1251")
							.split("\n");

					for (String for_mas_IP : s_mas_IP) {
						// s_IP = s_IP + for_mas_IP + "\n";
						s_IP = for_mas_IP;
					}

					tF_IP_USB.setText(s_IP);

				} catch (Exception e1) {
				}

				// Комент
				try {
					FileInputStream file_Koment = new FileInputStream(new File(
							s_Path_Mictce
									+ (String) cB_Mistse.getSelectedItem()
									+ "/"
									+ (String) cB_Mistse2.getSelectedItem()
									+ "/" + (String) cB_Marka.getSelectedItem()
									+ "/" + (String) cB_Model.getSelectedItem()
									+ "/" + (String) cB_SN.getSelectedItem())
							+ "/Coment");
					byte[] byte_file_Koment = new byte[file_Koment.available()];
					file_Koment.read(byte_file_Koment);
					file_Koment.close();

					String[] s_mas_Koment = new String(byte_file_Koment,
							"Cp1251").split("\n");

					for (String for_mas_Koment : s_mas_Koment) {
						s_Koment = s_Koment + for_mas_Koment + "\n";
					}

					tA_Koment.setText(s_Koment);

				} catch (Exception e1) {
				}

				// Інв
				try {
					FileInputStream file_Inv = new FileInputStream(new File(
							s_Path_Mictce
									+ (String) cB_Mistse.getSelectedItem()
									+ "/"
									+ (String) cB_Mistse2.getSelectedItem()
									+ "/" + (String) cB_Marka.getSelectedItem()
									+ "/" + (String) cB_Model.getSelectedItem()
									+ "/" + (String) cB_SN.getSelectedItem())
							+ "/IN");
					byte[] byte_file_Inv = new byte[file_Inv.available()];
					file_Inv.read(byte_file_Inv);
					file_Inv.close();

					String[] s_mas_Inv = new String(byte_file_Inv, "Cp1251")
							.split("\n");

					for (String for_mas_Inv : s_mas_Inv) {
						// s_Inv = s_Inv + for_mas_Inv + "\n";
						s_Inv = for_mas_Inv;
					}

					tF_IN.setText(s_Inv);

				} catch (Exception e1) {
				}

				// Стан
				try {
					FileInputStream file_Stan = new FileInputStream(new File(
							s_Path_Mictce
									+ (String) cB_Mistse.getSelectedItem()
									+ "/"
									+ (String) cB_Mistse2.getSelectedItem()
									+ "/" + (String) cB_Marka.getSelectedItem()
									+ "/" + (String) cB_Model.getSelectedItem()
									+ "/" + (String) cB_SN.getSelectedItem())
							+ "/Stan");
					byte[] byte_file_Stan = new byte[file_Stan.available()];
					file_Stan.read(byte_file_Stan);
					file_Stan.close();

					String[] s_mas_Stan = new String(byte_file_Stan, "Cp1251")
							.split("\n");

					for (String for_mas_Stan : s_mas_Stan) {
						// s_Stan = s_Stan + for_mas_Stan + "\n";
						s_Stan = for_mas_Stan;
					}

					tF_Stan.setText(s_Stan);
				} catch (Exception e1) {
				}

				// MOL
				try {
					FileInputStream file_MOL = new FileInputStream(new File(
							s_Path_Mictce
									+ (String) cB_Mistse.getSelectedItem()
									+ "/"
									+ (String) cB_Mistse2.getSelectedItem()
									+ "/" + (String) cB_Marka.getSelectedItem()
									+ "/" + (String) cB_Model.getSelectedItem()
									+ "/" + (String) cB_SN.getSelectedItem())
							+ "/MOL");
					byte[] byte_file_MOL = new byte[file_MOL.available()];
					file_MOL.read(byte_file_MOL);
					file_MOL.close();

					String[] s_mas_MOL = new String(byte_file_MOL, "Cp1251")
							.split("\n");

					for (String for_mas_MOL : s_mas_MOL) {
						// s_Stan = s_Stan + for_mas_Stan + "\n";
						s_MOL = for_mas_MOL;
					}

					tF_MOL.setText(s_MOL);

				} catch (Exception e1) {
				}

				b_SN.setBounds(277, 328, 227, 20);
			}
		});
		
		tF_IP_USB = new JTextField();
		tF_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
		tF_IP_USB.setBounds(27, 434, 227, 20);
		getContentPane().add(tF_IP_USB);
		tF_IP_USB.setColumns(10);
		
		JLabel l_IN = new JLabel("\u0406\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440: ");
		l_IN.setBounds(17, 359, 250, 14);
		l_IN.setHorizontalAlignment(SwingConstants.CENTER);
		l_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IN);
		
		tF_IN = new JTextField();
		tF_IN.setBounds(27, 379, 227, 20);
		tF_IN.setHorizontalAlignment(SwingConstants.CENTER);
		tF_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_IN);
		
		JLabel l_IP_USB = new JLabel("IP / USB");
		l_IP_USB.setBounds(17, 409, 250, 14);
		l_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
		l_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IP_USB);
		
		l_DodatkovaInfa.setBounds(264, 361, 250, 14);
		l_DodatkovaInfa.setHorizontalAlignment(SwingConstants.CENTER);
		l_DodatkovaInfa.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		getContentPane().add(l_DodatkovaInfa);
		
		tA_Koment.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tA_Koment.setBounds(277, 381, 227, 177);
		getContentPane().add(tA_Koment);
		
		l_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		l_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Stan.setBounds(17, 465, 250, 14);		
		getContentPane().add(l_Stan);
		
		tF_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_Stan.setColumns(10);
		tF_Stan.setBounds(27, 485, 227, 20);
		
		getContentPane().add(tF_Stan);
		
		b_Mictce = new JButton(
				"\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u043C\u0456\u0441\u0446\u0435");
		b_Mictce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) cB_Mistse.getSelectedItem() == "") {
					komentar("Ви не обрали відділ / кабінет");
				} else {
					// метод видалення каталогу разом із його вмістом
					deleteKatalog(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem());

					// перестворюємо список
					al_Mictce.clear();
					al_Mictce.add("");
					for (String path : Menu.fileInDirect(s_Path_Mictce)) {
						al_Mictce.add(path);
					}
					s_mas_Misctce = al_Mictce.toArray(new String[al_Mictce
							.size()]);
					cB_Mistse.setModel(new DefaultComboBoxModel(s_mas_Misctce));
				}
			}
		});
		getContentPane().add(b_Mictce);
		
		b_Mistse2 = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u0432\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");
		b_Mistse2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) cB_Mistse2.getSelectedItem() == "") {
					komentar("Ви не обрали марку");
				} else {
					// метод видалення каталогу разом із його вмістом
					deleteKatalog(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem() + "/"
							+ (String) cB_Mistse2.getSelectedItem());

					// перестворюємо список
					al_Mictce2.clear();
					al_Mictce2.add("");
					for (String path : Menu.fileInDirect(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem())) {
						al_Mictce2.add(path);
					}
					s_mas_Misctce2 = al_Mictce2.toArray(new String[al_Mictce2
							.size()]);
					cB_Mistse2
							.setModel(new DefaultComboBoxModel(s_mas_Misctce2));
				}
			}
		});
		getContentPane().add(b_Mistse2);
		
		b_Marka = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u043C\u0430\u0440\u043A\u0443");
		b_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) cB_Marka.getSelectedItem() == "") {
					komentar("Ви не обрали модель");
				} else {
					// метод видалення каталогу разом із його вмістом
					deleteKatalog(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem()+ "/"
							+ (String) cB_Marka.getSelectedItem());

					// перестворюємо список
					al_Marka.clear();
					al_Marka.add("");
					for (String path : Menu.fileInDirect(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem())) {
						al_Marka.add(path);
					}
					s_mas_Marka = al_Marka.toArray(new String[al_Marka.size()]);
					cB_Marka.setModel(new DefaultComboBoxModel(s_mas_Marka));
				}
			}
		});
		getContentPane().add(b_Marka);
		
		b_Model = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u043C\u043E\u0434\u0435\u043B\u044C");
		b_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) cB_Model.getSelectedItem() == "") {
					komentar("Ви не обрали серійний номер");
				} else {
					// метод видалення каталогу разом із його вмістом
					deleteKatalog(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem()+ "/"
							+ (String) cB_Marka.getSelectedItem()+ "/"
							+ (String) cB_Model.getSelectedItem());

					// перестворюємо список
					al_Model.clear();
					al_Model.add("");
					for (String path : Menu.fileInDirect(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem()+ "/"
							+ (String) cB_Marka.getSelectedItem())) {
						al_Model.add(path);
					}
					s_mas_Model = al_Model.toArray(new String[al_Model.size()]);
					cB_Model.setModel(new DefaultComboBoxModel(s_mas_Model));
				}
			}
		});
		getContentPane().add(b_Model);
		
		b_SN = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u043F\u0440\u0438\u043D\u0442\u0435\u0440");
		b_SN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) cB_SN.getSelectedItem() == "") {
					komentar("Ви не обрали місце");
				} else {
					// метод видалення каталогу разом із його вмістом
					deleteKatalog(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem()+ "/"
							+ (String) cB_Marka.getSelectedItem()+ "/"
							+ (String) cB_Model.getSelectedItem()+ "/"
							+ (String) cB_SN.getSelectedItem());

					// перестворюємо список
					al_SN.clear();
					al_SN.add("");
					for (String path : Menu.fileInDirect(s_Path_Mictce
							+ (String) cB_Mistse.getSelectedItem()+ "/"
							+ (String) cB_Mistse2.getSelectedItem()+ "/"
							+ (String) cB_Marka.getSelectedItem()+ "/"
							+ (String) cB_Model.getSelectedItem())) {
						al_SN.add(path);
					}
					s_mas_SN = al_SN.toArray(new String[al_SN.size()]);
					cB_SN.setModel(new DefaultComboBoxModel(s_mas_SN));
				}
			}
		});
		getContentPane().add(b_SN);
		
		JLabel l_Poperedgenna = new JLabel("* \u0423\u0432\u0430\u0433\u0430 ! \u041F\u0440\u0438\u0432\u0438\u0434\u0430\u043B\u0435\u043D\u043D\u0456 \u0432\u0435\u0440\u0445\u043D\u0456\u0445 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u0456\u0439 \u0432\u0438\u0434\u0430\u043B\u044F\u0442\u044C\u0441\u044F \u0432\u0441\u0456 \u043D\u0438\u0436\u043D\u0456");
		l_Poperedgenna.setHorizontalAlignment(SwingConstants.CENTER);
		l_Poperedgenna.setFont(new Font("Dialog", Font.ITALIC, 15));
		l_Poperedgenna.setBounds(27, 51, 473, 17);
		getContentPane().add(l_Poperedgenna);
		
		JLabel l_MOL = new JLabel("\u041C\u0430\u0442\u0435\u0440\u0456\u0430\u043B\u044C\u043D\u043E \u0432\u0456\u0434\u043F\u043E\u0432\u0456\u0434\u0430\u043B\u044C\u043D\u0430 \u043E\u0441\u043E\u0431\u0430");
		l_MOL.setHorizontalAlignment(SwingConstants.CENTER);
		l_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_MOL.setBounds(17, 516, 250, 14);
		getContentPane().add(l_MOL);
		
		tF_MOL = new JTextField();
		tF_MOL.setHorizontalAlignment(SwingConstants.CENTER);
		tF_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_MOL.setColumns(10);
		tF_MOL.setBounds(27, 536, 227, 20);
		getContentPane().add(tF_MOL);
		
		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);
        
        setVisible(true);
		
	}
	
	void deleteKatalog(String Puth) {
		// Підтвердження на основі додаткового вікна JOptionPane.showOptionDialog
		Object[] options_Save = { "Так", "Ні" };
		
		setAlwaysOnTop(false); 
		int i_Save = JOptionPane.showOptionDialog(null,
				"Дійсо бажаєте видалити ?", "Подтверждение",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options_Save, null);
		setAlwaysOnTop(true);
		
		if (i_Save == JOptionPane.YES_OPTION) {
			recursiveDelete(new File(Puth));
			new File(Puth).delete();
			
			tF_IP_USB.setText("");
			tF_IN.setText("");
			tF_Stan.setText("");
			tA_Koment.setText("");
			tF_MOL.setText("");
			
			komentar("Видалено місце");
		}
	}
	
	void komentar(String text) {
		// змінюємо вікно , що є поверх всіх інших
		setAlwaysOnTop(false); 
		JOptionPane.showMessageDialog(null, text);
		setAlwaysOnTop(true);
	}
	
	// метод-рекурсія для видалення папки із файлами
	public static void recursiveDelete(File file) {
		// до конца рекурсивного цикла
//		System.out.println("file " + file);
		if (!file.exists())
			return;

		// если это папка, то идем внутрь этой папки и вызываем рекурсивное
		// удаление всего, что там есть
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				// рекурсивный вызов
				recursiveDelete(f);
			}
		}
		// вызываем метод delete() для удаления файлов и пустых(!) папок
		file.delete();
//		System.out.println("Удаленный файл или папка: " +
//		file.getAbsolutePath());
	}
	
}
