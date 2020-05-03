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
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 */

public class Pryntery extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JButton b_Menu;
	private JLabel l_fon;

	public static ArrayList<String> al_Mistce = new ArrayList<String>();
	public static ArrayList<String> al_Mistce1 = new ArrayList<String>();
	public ArrayList<String> al_Model = new ArrayList<String>();
	public ArrayList<String> al_Marka = new ArrayList<String>();
	public ArrayList<String> al_SN = new ArrayList<String>();

	static String[] s_mas_Mistce = null;
	static String[] s_mas_Mistce1 = null;
	String[] s_mas_Model = null;
	String[] s_mas_Marka = null;
	String[] s_mas_SN = null;

	String s_IP = "";
	String s_Koment = "";
	String s_Inv = "";
	String s_Stan = "";
	String s_MOL = "";
	
	static String s_Path_Printers = Settings.puthBazy() + "/Printers/";
	
	@SuppressWarnings("rawtypes")
	JComboBox cB_Marka = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cB_Model = new JComboBox();

	private final JLabel l_SN = new JLabel(
			"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u0441\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440");
	@SuppressWarnings("rawtypes")
	private final JComboBox cB_SN = new JComboBox();
	private final JButton b_Add = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043F\u0440\u0438\u043D\u0442\u0435\u0440");
	private final JLabel l_Mistse2 = new JLabel(
			"\u0412\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");
	@SuppressWarnings("rawtypes")
	private static JComboBox cB_Mistce1 = new JComboBox();
	private JTextField tF_IN;
	
	private final JLabel l_Mistse = new JLabel(
			"\u041C\u0456\u0441\u0446\u0435 \u0440\u043E\u0437\u0442\u0430\u0448\u0443\u0432\u0430\u043D\u043D\u044F");
	@SuppressWarnings("rawtypes")
	private static JComboBox cB_Mistse = new JComboBox();
	private JTextField tF_IP_USB;
	private final JLabel l_DodatkovaInfa = new JLabel("\u0414\u043E\u0434\u0430\u0442\u043A\u043E\u0432\u0430 \u0456\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0456\u044F:");
	private TextArea tA_Koment = new TextArea();
	private final JLabel l_Stan = new JLabel("\u0421\u0442\u0430\u043D \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
	private final JTextField tF_Stan = new JTextField();
	private final JButton b_Delete = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u043F\u0440\u0438\u043D\u0442\u0435\u0440");
	private final JButton b_Peremistyty = new JButton("\u041F\u0435\u0440\u0435\u043C\u0456\u0441\u0442\u0438\u0442\u0438 \u043F\u0440\u0438\u043D\u0442\u0435\u0440");

	Formatter formatter_IP;
	Formatter formatter_Inv;
	Formatter formatter_Koment;
	Formatter formatter_Stan;
	Formatter formatter_MOL;
	
	Formatter formatter_kilkistPraciyiychuhPrynteriv;
	
	private final JLabel l_MOL = new JLabel("\u041C\u0430\u0442\u0435\u0440\u0456\u0430\u043B\u044C\u043D\u043E \u0432\u0456\u0434\u043F\u043E\u0432\u0456\u0434\u0430\u043B\u044C\u043D\u0430 \u043E\u0441\u043E\u0431\u0430");
	private final JTextField tF_MOL = new JTextField();
	private final JLabel l_textKilkistPraciyiychuhPrynteriv = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u043F\u0440\u0430\u0446\u044E\u044E\u0447\u0438\u0445 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432:");
	private JTextField tF_poshukSN;
	
	boolean b_prynterObrano = false;
	
	@SuppressWarnings("serial")
	private final JPanel p_RamkaSN = new JPanel() {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Shape rect = new Rectangle(0, 0, 249, 106);
			g2.draw(rect);
		}
	};
	
	@SuppressWarnings("serial")
	// малюємо прямокутник
	JPanel p_RamkaMistce1 = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Shape rect = new Rectangle(0, 0, 962, 189);
			g2.draw(rect);
		}
	};
	
	private final JLabel l_PoshukSN = new JLabel("\u0412\u0432\u0435\u0434\u0456\u0442\u044C \u0441\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440");
	
	private JLabel l_IN;
	private JLabel l_IP_USB;
	private JButton b_Save;
	private JLabel l_textKilkistVsihPrynteriv;
	private JLabel l_KilkistVsihPrynteriv;
	private final JButton b_Kartryji = new JButton("\u0417\u0430\u0431\u0440\u043E\u043D\u044E\u0432\u0430\u0442\u0438 \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436");
	private final JButton b_Remonty = new JButton("\u041F\u0435\u0440\u0435\u0439\u0442\u0438 \u0434\u043E \u0440\u0435\u043C\u043E\u043D\u0442\u0456\u0432");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pryntery(final String s_NameProduct) {
		super(s_NameProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(new File("res/ZakK.png").toString()));

		{ 
			s_mas_Mistce = null;
			al_Mistce.clear();
			s_mas_Mistce1 = null;
			al_Mistce1.clear();
						
			s_mas_Marka = null;
			al_Marka.clear();
			s_mas_Model = null;
			al_Model.clear();
			s_mas_SN = null;
			al_SN.clear();
			
			// початкове відображення Місця 1 рівня
			al_Mistce.add("");  // добавляємо пусте поле на початку
			for (String path : Menu.fileInDirect(s_Path_Printers)) {
				al_Mistce.add(path); // отримуємо список всіх місць
				// System.out.println(al_Mictce);
			}

			// переписуємо ArrayList із всіма місцями в стрінговий масив, щоб
			// потім його записати в ЧекБокс
			s_mas_Mistce = al_Mistce.toArray(new String[al_Mistce.size()]);
			
			// виводимо / перевіряємо масив
			// System.out.println(Arrays.toString(s_mas_Misctce));
		}

		cB_Mistse = new JComboBox(s_mas_Mistce);
		cB_Mistse.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		cB_Mistse.setBounds(27, 104, 227, 20);
		getContentPane().setLayout(null);

		b_Menu = new JButton("\u041C\u0435\u043D\u044E");
		b_Menu.setBounds(875, 11, 109, 23);
		b_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cB_Mistce1.setModel(new DefaultComboBoxModel());

				new Menu(s_NameProduct);
				setVisible(false);
			}
		});
		b_Menu.setForeground(new Color(0, 0, 0));

		b_Menu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(b_Menu);

		label_Shapka = new JLabel(
				"\u041E\u0431\u043B\u0456\u043A \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432");
		label_Shapka.setBounds(17, 11, 967, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);

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
		
		b_Add.setFont(new Font("Sitka Text", Font.PLAIN, 15));		
		b_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PrynteryAdd(s_NameProduct);
			}
		});
		b_Add.setBounds(293, 216, 227, 23);
		getContentPane().add(b_Add);
		
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
				s_mas_Mistce1 = null;
				al_Mistce1.clear();
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
				
				al_Mistce1.add("");
				
				for (String path : Menu.fileInDirect(s_Path_Printers
						+ (String) cB_Mistse.getSelectedItem())) {
					al_Mistce1.add(path);
				}
				
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Mistce1 = al_Mistce1.toArray(new String[al_Mistce1
						.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_Mistce1.setModel(new DefaultComboBoxModel(s_mas_Mistce1));

				revalidate();
			}
		});

		getContentPane().add(l_Mistse2);
		cB_Mistce1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		cB_Mistce1.setBounds(27, 160, 227, 20);
		getContentPane().add(cB_Mistce1);
		cB_Mistce1.addActionListener(new ActionListener() {
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
				
				for (String path : Menu.fileInDirect(s_Path_Printers
						+ (String) cB_Mistse.getSelectedItem()+
						"/"	+ (String) cB_Mistce1.getSelectedItem())) {
					al_Marka.add(path);
				}
				
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Marka = al_Marka.toArray(new String[al_Marka.size()]);

				// виводимо / перевіряємо масив
//				 System.out.println("s_mas_Marka "+Arrays.toString(s_mas_Marka));

				// Полностью переопределяем все элементы
				cB_Marka.setModel(new DefaultComboBoxModel(s_mas_Marka));

				revalidate();
			}
		});
		cB_Marka.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
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
				
				for (String path : Menu.fileInDirect(s_Path_Printers
						+ (String) cB_Mistse.getSelectedItem()
						+ "/" + (String) cB_Mistce1.getSelectedItem()
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
				
				revalidate();
			}
		});
		cB_Model.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
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
				
				for (String path : Menu.fileInDirect(s_Path_Printers
						+ (String) cB_Mistse.getSelectedItem()
						+ "/" + (String) cB_Mistce1.getSelectedItem()
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

				revalidate();
			}
		});
		
		cB_SN.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		cB_SN.setBounds(27, 328, 227, 20);
		getContentPane().add(cB_SN);
		cB_SN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cB_SN.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Оберіть принтер");
				}else{
					daniPoPrynteru((String) cB_Mistse.getSelectedItem(),
							(String) cB_Mistce1.getSelectedItem(),
							(String) cB_Marka.getSelectedItem(),
							(String) cB_Model.getSelectedItem(),
							(String) cB_SN.getSelectedItem());
					b_prynterObrano = true;

					l_IN.setBounds(17, 379, 250, 14);
					tF_IN.setBounds(27, 404, 227, 20);
					l_IP_USB.setBounds(17, 440, 250, 14);
					tF_IP_USB.setBounds(27, 470, 227, 20);
					l_Stan.setBounds(283, 379, 250, 14);
					tF_Stan.setBounds(293, 404, 227, 20);
					l_MOL.setBounds(285, 440, 250, 14);
					tF_MOL.setBounds(295, 470, 227, 20);
					l_DodatkovaInfa.setBounds(561, 369, 407, 14);
					tA_Koment.setBounds(561, 389, 407, 107);
					b_Save.setBounds(27, 515, 941, 29);
					p_RamkaMistce1.setBounds(17, 363, 963, 190);
				}
			}
		});
		
		tF_IP_USB = new JTextField();
		tF_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
//		tF_IP_USB.setBounds(27, 460, 227, 20);
		getContentPane().add(tF_IP_USB);
		tF_IP_USB.setColumns(10);
		
		l_IN = new JLabel("\u0406\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440: ");
//		l_IN.setBounds(17, 379, 250, 14);
		l_IN.setHorizontalAlignment(SwingConstants.CENTER);
		l_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IN);
		
		tF_IN = new JTextField();
//		tF_IN.setBounds(27, 404, 227, 20);
		tF_IN.setHorizontalAlignment(SwingConstants.CENTER);
		tF_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_IN);
		
		l_IP_USB = new JLabel("IP / USB");
//		l_IP_USB.setBounds(17, 435, 250, 14);
		l_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
		l_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IP_USB);
		
//		l_DodatkovaInfa.setBounds(561, 369, 407, 14);
		l_DodatkovaInfa.setHorizontalAlignment(SwingConstants.CENTER);
		l_DodatkovaInfa.setFont(new Font("Sitka Text", Font.PLAIN, 15));		
		getContentPane().add(l_DodatkovaInfa);
		
		tA_Koment.setFont(new Font("Sitka Text", Font.PLAIN, 15));
//		tA_Koment.setBounds(561, 389, 407, 107);
		getContentPane().add(tA_Koment);
		
		b_Save = new JButton("\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438 \u0437\u043C\u0456\u043D\u0438");
		b_Save.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Підтвердження  на основі додаткового вікна JOptionPane.showOptionDialog
				Object[] options_Save = { "Так", "Ні" };
				int i_Save = JOptionPane.showOptionDialog(null,
						"Зберегти зміни ?", "Підтвердження",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options_Save, null);
				if (i_Save == JOptionPane.YES_OPTION) {

					// IP
					try {
						String s_Path_IP = s_Path_Printers
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistce1.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) cB_SN.getSelectedItem() + "/IP";
						formatter_IP = new Formatter(s_Path_IP);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти ІР");
					}
					formatter_IP.format(tF_IP_USB.getText());
					formatter_IP.close();

					// Інв
					try {
						String s_Path_Inv = s_Path_Printers
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistce1.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) cB_SN.getSelectedItem() + "/IN";
						formatter_Inv = new Formatter(s_Path_Inv);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Інвентарний");
					}
					formatter_Inv.format(tF_IN.getText());
					formatter_Inv.close();

					// Стан
					try {
						String s_Path_Stan = s_Path_Printers
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistce1.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) cB_SN.getSelectedItem() + "/Stan";
						formatter_Stan = new Formatter(s_Path_Stan);
						if(s_Stan.equals("Працюючий")){
							if(tF_Stan.getText().equals("Працюючий")){
							}else{
								kilkistPraciyiychuhPrynteriv(false);
							}
						}else{
							if(tF_Stan.getText().equals("Працюючий")){
								kilkistPraciyiychuhPrynteriv(true);
							}else{								
							}
						}
						
//						if(tF_Stan.getText().equals("Працюючий")){
//							kilkistPraciyiychuhPrynteriv(true);
//						}else{
//							kilkistPraciyiychuhPrynteriv(false);
//						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Стан");
					}
					formatter_Stan.format(tF_Stan.getText());
					formatter_Stan.close();

					// Koment
					try {
						String s_Path_Koment = s_Path_Printers
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistce1.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) cB_SN.getSelectedItem() + "/Coment";
						formatter_Koment = new Formatter(s_Path_Koment);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Додаткову інформацію");
					}
					formatter_Koment.format(tA_Koment.getText());
					formatter_Koment.close();
					
					// МОЛ
					try {
						String s_Path_MOL = s_Path_Printers
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistce1.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) cB_SN.getSelectedItem() + "/MOL";
						formatter_MOL = new Formatter(s_Path_MOL);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти МОЛ");
					}
					formatter_MOL.format(tF_MOL.getText());
					formatter_MOL.close();
					
					JOptionPane.showMessageDialog(null,
							"Інформацію збережено");
				}
			}
		});
//		b_Save.setBounds(27, 515, 941, 29);
		getContentPane().add(b_Save);
		
		l_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		l_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
//		l_Stan.setBounds(283, 379, 250, 14);		
		getContentPane().add(l_Stan);
		
		tF_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_Stan.setColumns(10);
//		tF_Stan.setBounds(293, 404, 227, 20);		
		getContentPane().add(tF_Stan);
		
        b_Delete.setFont(new Font("Sitka Text", Font.PLAIN, 15));		
        b_Delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new PrynteryDelete(s_NameProduct);
        	}
        });
        
       
        b_Delete.setBounds(293, 272, 227, 23);
        
        getContentPane().add(b_Delete);
        b_Peremistyty.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        b_Peremistyty.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(b_prynterObrano == true){
        			new PrynteryPeremistyty(s_NameProduct, (String) cB_Mistse.getSelectedItem(),
        					(String) cB_Mistce1.getSelectedItem(), (String) cB_Marka.getSelectedItem(),
        					(String) cB_Model.getSelectedItem(), (String) cB_SN.getSelectedItem());        			
        		}else{
        			JOptionPane.showMessageDialog(null, "Оберіть принтер");
        		}
        	}
        });
        b_Peremistyty.setBounds(293, 325, 227, 23);
        
        getContentPane().add(b_Peremistyty);
        l_MOL.setHorizontalAlignment(SwingConstants.CENTER);
        l_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
//      l_MOL.setBounds(285, 435, 250, 14);
        getContentPane().add(l_MOL);
        
        tF_MOL.setHorizontalAlignment(SwingConstants.CENTER);
        tF_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        tF_MOL.setColumns(10);
//      tF_MOL.setBounds(295, 460, 227, 20);        
        getContentPane().add(tF_MOL);
                
        l_textKilkistVsihPrynteriv = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u0432\u0441\u0456\u0445 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432:");
        l_textKilkistVsihPrynteriv.setHorizontalAlignment(SwingConstants.CENTER);
        l_textKilkistVsihPrynteriv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        l_textKilkistVsihPrynteriv.setBounds(560, 187, 299, 14);
        getContentPane().add(l_textKilkistVsihPrynteriv);
        
        l_KilkistVsihPrynteriv = new JLabel(kilkistPrynteriv(new File(s_Path_Printers)));
        l_KilkistVsihPrynteriv.setHorizontalAlignment(SwingConstants.CENTER);
        l_KilkistVsihPrynteriv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        l_KilkistVsihPrynteriv.setBounds(869, 187, 98, 14);
        getContentPane().add(l_KilkistVsihPrynteriv);
        
        l_textKilkistPraciyiychuhPrynteriv.setHorizontalAlignment(SwingConstants.CENTER);
        l_textKilkistPraciyiychuhPrynteriv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        l_textKilkistPraciyiychuhPrynteriv.setBounds(560, 225, 299, 14);        
        getContentPane().add(l_textKilkistPraciyiychuhPrynteriv);
        
        JLabel l_KilkistPraciyiychuhPrynteriv = new JLabel(kilkistPraciyiychuhPrynteriv());
        l_KilkistPraciyiychuhPrynteriv.setHorizontalAlignment(SwingConstants.CENTER);
        l_KilkistPraciyiychuhPrynteriv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        l_KilkistPraciyiychuhPrynteriv.setBounds(869, 225, 98, 14);
        
        getContentPane().add(l_KilkistPraciyiychuhPrynteriv);
        
        tF_poshukSN = new JTextField();
        tF_poshukSN.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		tF_poshukSN.setText(null);
        		tF_poshukSN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        		tF_poshukSN.setForeground(Color.DARK_GRAY);
        	}
        });
        tF_poshukSN.setForeground(Color.GRAY);
        tF_poshukSN.setText("\u0412\u0432\u0435\u0434\u0456\u0442\u044C \u0441\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440...");
        tF_poshukSN.setToolTipText("");
        tF_poshukSN.setHorizontalAlignment(SwingConstants.CENTER);
        tF_poshukSN.setFont(new Font("Sitka Text", Font.ITALIC, 12));
        tF_poshukSN.setColumns(10);
        tF_poshukSN.setBounds(293, 104, 227, 20);
        getContentPane().add(tF_poshukSN);
        
		JButton b_poshukSN = new JButton(
				"\u0412\u0438\u043A\u043E\u043D\u0430\u0442\u0438 \u043F\u043E\u0448\u0443\u043A");
		b_poshukSN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_poshukSN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tF_poshukSN.getText().equals("Введіть серійний номер...")) {
					tF_poshukSN.setText(null);
				}

				if (tF_poshukSN.getText().equals(null)
						|| tF_poshukSN.getText().equals("")
						|| tF_poshukSN.getText().equals(" ")
						|| tF_poshukSN.getText().equals("  ")
						|| tF_poshukSN.getText().equals("   ")) {
					JOptionPane.showMessageDialog(null,
							"Ви не ввели серійний номер");
				} else {
					poshukPruntera(tF_poshukSN.getText());
				}
				
				l_IN.setBounds(17, 379, 250, 14);
				tF_IN.setBounds(27, 404, 227, 20);
				l_IP_USB.setBounds(17, 440, 250, 14);
				tF_IP_USB.setBounds(27, 470, 227, 20);
				l_Stan.setBounds(283, 379, 250, 14);
				tF_Stan.setBounds(293, 404, 227, 20);
				l_MOL.setBounds(285, 440, 250, 14);
		        tF_MOL.setBounds(295, 470, 227, 20);
		        l_DodatkovaInfa.setBounds(561, 369, 407, 14);
		        tA_Koment.setBounds(561, 389, 407, 107);
		        b_Save.setBounds(27, 515, 941, 29);
		        p_RamkaMistce1.setBounds(17, 363, 963, 190);
			}
		});
		b_poshukSN.setBounds(293, 139, 227, 23);
		getContentPane().add(b_poshukSN);

		p_RamkaMistce1.setToolTipText("");
//		p_RamkaMistce1.setBounds(17, 363, 963, 190);
		getContentPane().add(p_RamkaMistce1);
		
		JLabel label = new JLabel("\u041F\u043E\u0448\u0443\u043A \u0437\u0430 \u0441\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440\u043E\u043C");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		label.setBounds(293, 51, 227, 14);
		getContentPane().add(label);
		
		@SuppressWarnings("serial")
		JPanel p_RamkaMistce = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Shape rect = new Rectangle(0, 0, 249, 285);
				g2.draw(rect);
			}
		};
		p_RamkaMistce.setToolTipText("");
		p_RamkaMistce.setBounds(17, 70, 250, 286);
		getContentPane().add(p_RamkaMistce);
		
		JLabel l_NazvaRamky = new JLabel("\u041F\u043E\u0448\u0443\u043A \u0437\u0430 \u043C\u0456\u0441\u0446\u0435\u043C");
		l_NazvaRamky.setHorizontalAlignment(SwingConstants.LEFT);
		l_NazvaRamky.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		l_NazvaRamky.setBounds(27, 51, 232, 14);
		getContentPane().add(l_NazvaRamky);
		
		l_PoshukSN.setHorizontalAlignment(SwingConstants.CENTER);
		l_PoshukSN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_PoshukSN.setBounds(293, 79, 227, 14);
		
		getContentPane().add(l_PoshukSN);
		p_RamkaSN.setToolTipText("");
		p_RamkaSN.setBounds(283, 70, 250, 107);		
		getContentPane().add(p_RamkaSN);
		b_Kartryji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((String) cB_Marka.getSelectedItem() == null || (String) cB_Model.getSelectedItem() == null){
					new Cartridges(s_NameProduct, "", "");
				}else{
					new Cartridges(s_NameProduct, (String) cB_Marka.getSelectedItem(), (String) cB_Model.getSelectedItem());
				}				
				setVisible(false);
			}
		});
		b_Kartryji.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_Kartryji.setBounds(663, 91, 227, 23);
		
		getContentPane().add(b_Kartryji);
		b_Remonty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Remonty(s_NameProduct);
				setVisible(false);
			}
		});
		b_Remonty.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_Remonty.setBounds(663, 131, 227, 23);
		
		getContentPane().add(b_Remonty);
		
		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);

        setVisible(true);
	}

	@SuppressWarnings("unused")
	private String kilkistPrynteriv(File file) {
		int i_kilkistPrynteriv = 0;
		String s_kilkistPrynteriv = "";
		for (File for_Mistce : file.listFiles()) {
			for (File for_Mistce1 : for_Mistce.listFiles()) {
				for (File for_Model : for_Mistce1.listFiles()) {
					for (File for_Marka : for_Model.listFiles()) {
						for (File for_SN : for_Marka.listFiles()) {
							i_kilkistPrynteriv++;
						}
					}
				}
			}
		}
		s_kilkistPrynteriv = s_kilkistPrynteriv + i_kilkistPrynteriv;
		return s_kilkistPrynteriv;
	}
	
	private void kilkistPraciyiychuhPrynteriv(boolean b_stan) {
		
		String s_k = null;
		int i_k;
		
		try {
			FileInputStream file_k = new FileInputStream(new File("C:/ZakK_Printer/Statistic/kilkistPraciyiychuhPrynteriv"));
			byte [] byte_file_k = new byte[file_k.available()];
			file_k.read(byte_file_k);
			file_k.close();
			
			String [] s_mas_k = new String (byte_file_k,"Cp1251").split("\n");
			
			for(String for_mas_k: s_mas_k){
//				s_IP = s_IP + for_mas_IP + "\n";
				s_k = for_mas_k;
			}
			
			i_k = Integer.parseInt(s_k);
			
			if(b_stan == true){
				System.out.println("i_k++ " + i_k);
				i_k++;
			}else{
				System.out.println("i_k-- " +i_k);
				i_k--;
			}
			
			s_k = "" + i_k;
			
			try {
				String s_PathSave = "C:/ZakK_Printer/Statistic/kilkistPraciyiychuhPrynteriv";
				formatter_kilkistPraciyiychuhPrynteriv = new Formatter(s_PathSave);
				formatter_kilkistPraciyiychuhPrynteriv.format(s_k);
				formatter_kilkistPraciyiychuhPrynteriv.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "");
			}
			
		} catch (Exception e1) {}	
	}

	private String kilkistPraciyiychuhPrynteriv() {
		
		String s_k = null;
		
		try {
			FileInputStream file_k = new FileInputStream(new File("C:/ZakK_Printer/Statistic/kilkistPraciyiychuhPrynteriv"));
			byte [] byte_file_k = new byte[file_k.available()];
			file_k.read(byte_file_k);
			file_k.close();
			
			String [] s_mas_k = new String (byte_file_k,"Cp1251").split("\n");
			
			for(String for_mas_k: s_mas_k){
//				s_IP = s_IP + for_mas_IP + "\n";
				s_k = for_mas_k;
			}

		} catch (Exception e1) {}
		return s_k;
	}
	
	void daniPoPrynteru (String s_Mistce, String s_Mistce1, String s_Marka, String s_Model, String s_SN){
				
		s_Inv = "";
		s_IP = "";
		s_Stan = "";
		s_Koment = "";
		s_MOL = "";

		tF_IP_USB.setText("");
		tF_IN.setText("");
		tF_Stan.setText("");
		tA_Koment.setText("");
		tF_MOL.setText("");
		
		// IP
		try {
			FileInputStream file_IP = new FileInputStream(new File(s_Path_Printers
					+ s_Mistce + "/"
					+ s_Mistce1 + "/"
					+ s_Marka + "/"
					+ s_Model + "/"
					+ s_SN)+ "/IP");
			byte [] byte_file_IP = new byte[file_IP.available()];
			file_IP.read(byte_file_IP);
			file_IP.close();
			
			String [] s_mas_IP = new String (byte_file_IP,"Cp1251").split("\n");
			
			for(String for_mas_IP: s_mas_IP){
//				s_IP = s_IP + for_mas_IP + "\n";
				s_IP = for_mas_IP;
			}
			
			tF_IP_USB.setText(s_IP);
			
		} catch (Exception e1) {}
		
		// Комент
		try {
			FileInputStream file_Koment = new FileInputStream(new File(s_Path_Printers
					+ s_Mistce + "/"
					+ s_Mistce1 + "/"
					+ s_Marka + "/"
					+ s_Model + "/"
					+ s_SN)+ "/Coment");
			byte [] byte_file_Koment = new byte[file_Koment.available()];
			file_Koment.read(byte_file_Koment);
			file_Koment.close();
			
			String [] s_mas_Koment = new String (byte_file_Koment,"Cp1251").split("\n");
			
			for(String for_mas_Koment: s_mas_Koment){
				s_Koment = s_Koment + for_mas_Koment + "\n";
			}
			
			tA_Koment.setText(s_Koment);
			
		} catch (Exception e1) {}
		
		// Інв
		try {
			FileInputStream file_Inv = new FileInputStream(new File(s_Path_Printers
					+ s_Mistce + "/"
					+ s_Mistce1 + "/"
					+ s_Marka + "/"
					+ s_Model + "/"
					+ s_SN)+ "/IN");
			byte [] byte_file_Inv = new byte[file_Inv.available()];
			file_Inv.read(byte_file_Inv);
			file_Inv.close();
			
			String [] s_mas_Inv = new String (byte_file_Inv,"Cp1251").split("\n");
			
			for(String for_mas_Inv: s_mas_Inv){
//				s_Inv = s_Inv + for_mas_Inv + "\n";
				s_Inv = for_mas_Inv;
			}
			
			tF_IN.setText(s_Inv);
			
		} catch (Exception e1) {}
		
		// Стан
		try {
			FileInputStream file_Stan = new FileInputStream(new File(s_Path_Printers
					+ s_Mistce + "/"
					+ s_Mistce1 + "/"
					+ s_Marka + "/"
					+ s_Model + "/"
					+ s_SN)+ "/Stan");
			byte [] byte_file_Stan = new byte[file_Stan.available()];
			file_Stan.read(byte_file_Stan);
			file_Stan.close();
			
			String [] s_mas_Stan = new String (byte_file_Stan,"Cp1251").split("\n");
			
			for(String for_mas_Stan: s_mas_Stan){
//				s_Stan = s_Stan + for_mas_Stan + "\n";
				s_Stan = for_mas_Stan;
			}
			
			tF_Stan.setText(s_Stan);
			
		} catch (Exception e1) {}
		
			// MOЛ
			try {
				FileInputStream file_MOL = new FileInputStream(new File(s_Path_Printers
						+ s_Mistce + "/"
						+ s_Mistce1 + "/"
						+ s_Marka + "/"
						+ s_Model + "/"
						+ s_SN)+ "/MOL");
				byte [] byte_file_MOL = new byte[file_MOL.available()];
				file_MOL.read(byte_file_MOL);
				file_MOL.close();
				
				String [] s_mas_MOL = new String (byte_file_MOL,"Cp1251").split("\n");
				
				for(String for_mas_MOL: s_mas_MOL){
//					s_MOL = s_MOL + for_mas_MOL + "\n";
					s_MOL = for_mas_MOL;
				}
				
				tF_MOL.setText(s_MOL);
			
		} catch (Exception e1) {}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void poshukPruntera (String s_SN_new){
		
		for (File for_Mistce : new File(s_Path_Printers).listFiles()) {      
			for (File for_Mistce1 : for_Mistce.listFiles()) {
				for (File for_Marka : for_Mistce1.listFiles()) {
					for (File for_Model : for_Marka.listFiles()) {
						for (File for_SN : for_Model.listFiles()) {									
								String s_for_Mistce = for_Mistce + "";
								String s_for_Mistce1 = for_Mistce1 + "";
								String s_for_Marka = for_Marka + "";
								String s_for_Model = for_Model + "";
								
								int i_for_Mistce = s_for_Mistce.length();
								int i_for_Mistce1 = s_for_Mistce1.length();
								int i_for_Marka = s_for_Marka.length();
								int i_for_Model = s_for_Model.length();
								
								String s_for_SN = "" + for_SN;

								String s_Mistce = s_for_SN.substring(30, i_for_Mistce);
								String s_Mistce1 = s_for_SN.substring(i_for_Mistce + 1, i_for_Mistce1);
								String s_Marka = s_for_SN.substring(i_for_Mistce1 + 1, i_for_Marka);
								String s_Model = s_for_SN.substring(i_for_Marka + 1, i_for_Model);										
								String s_SN = s_for_SN.substring(i_for_Model + 1, s_for_SN.length());
								
								al_Mistce.clear();
								al_Mistce1.clear();
								al_Marka.clear();
								al_Model.clear();
								al_SN.clear();
								
								al_Mistce.add(0, s_Mistce);  // добавляємо в початок списку
								s_mas_Mistce = al_Mistce.toArray(new String[al_Mistce
										.size()]);
								
								al_Mistce1.add(0,s_Mistce1);   // добавляємо в початок списку
								s_mas_Mistce1 = al_Mistce1.toArray(new String[al_Mistce1
										.size()]);


								al_Marka.add(0,s_Marka);   // добавляємо в початок списку
								s_mas_Marka = al_Marka.toArray(new String[al_Marka
										.size()]);
								
								al_Model.add(0,s_Model);   // добавляємо в початок списку
								s_mas_Model = al_Model.toArray(new String[al_Model
										.size()]);										

								al_SN.add(0,s_SN);   // добавляємо в початок списку
								s_mas_SN = al_SN.toArray(new String[al_SN
										.size()]);

								
								 if(s_SN_new.equals(s_SN)){
										 cB_Mistse.setModel(new DefaultComboBoxModel(s_mas_Mistce));
										 cB_Mistce1.setModel(new DefaultComboBoxModel(s_mas_Mistce1));
										 cB_Marka.setModel(new DefaultComboBoxModel(s_mas_Marka));
										 cB_Model.setModel(new DefaultComboBoxModel(s_mas_Model));
										 cB_SN.setModel(new DefaultComboBoxModel(s_mas_SN));
										 
										 daniPoPrynteru(s_Mistce, s_Mistce1, s_Marka, s_Model, s_SN);
								 }
							}
						}
					}
				}
			}		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void pisliaPeremishchenia(String s_Mistce, String s_Mistce1) {
		
		al_Mistce.clear();
		al_Mistce.add(s_Mistce);
		s_mas_Mistce = al_Mistce.toArray(new String[al_Mistce.size()]);
		
		al_Mistce1.clear();
		al_Mistce1.add(s_Mistce1);
		s_mas_Mistce1 = al_Mistce1.toArray(new String[al_Mistce1.size()]);
				
		cB_Mistse.setModel(new DefaultComboBoxModel(s_mas_Mistce));
		cB_Mistce1.setModel(new DefaultComboBoxModel(s_mas_Mistce1));
	}
}
