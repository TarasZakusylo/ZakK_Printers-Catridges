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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

/**
 * 
 */

public class Cartridges extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JButton b_Menu;
	private JLabel l_fon;
	
	public ArrayList<String> al_Model = new ArrayList<String>();
	public ArrayList<String> al_Marka = new ArrayList<String>();

	String[] s_mas_Model = null;
	String[] s_mas_Marka = null;
	
	static String s_Path_Cartridges = Settings.puthBazy() + "/Cartridges/";
	
	@SuppressWarnings({ "rawtypes" })
	JComboBox cB_Marka;
	@SuppressWarnings("rawtypes")
	JComboBox cB_Model = new JComboBox();
	
	private final JLabel l_textKilkistPraciyiychuhKartrydjiv = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u0432\u0441\u0456\u0445 \u0437\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0438\u0445 \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0456\u0432:");
	
	@SuppressWarnings("serial")
	private final JPanel p_Sklad = new JPanel() {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Shape rect = new Rectangle(0, 0, 249, 219);
			g2.drawLine(0, 150, 249, 150);
			g2.draw(rect);
		}
	};

	private JLabel l_textKilkistVsihKartrydjiv;
	private JLabel l_KilkistVsihKartrydjiv;
	private final JButton b_Pryntary = new JButton("\u041F\u0435\u0440\u0435\u0439\u0442\u0438 \u0434\u043E \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432");
	private final JButton b_Korystuvachi = new JButton("\u041F\u0435\u0440\u0435\u0439\u0442\u0438 \u0434\u043E \u043A\u043E\u0440\u0438\u0441\u0442\u0443\u0432\u0430\u0447\u0456\u0432");
	private JCheckBox cB_toner;
	private JCheckBox cB_tonerTyp;
	private JCheckBox cB_farba;
	private JCheckBox cB_baraban;
	private JTextField tF_kilkitNaSkladi;
	private JLabel l_Zapravleni;
	private JTextField tF_zapravleni;
	private JLabel l_Zarezervovano;
	private JTextField tF_Zarezervovano;
	private JLabel l_NaZapravci;
	private JTextField tF_naZapravci;
	private JLabel l_SaveKilkistNaSkladi;
	private JLabel l_SaveZapravleno;
	private JLabel l_SaveNaZapravci;
	private JLabel l_nova;
	private JTextField tF_novi;
	private JLabel l_NaZapravci1;
	private JLabel l_SNPryntera;
	private JTextField tF_SNPryntera;
	private JLabel l_NomerZaiavky;
	private JTextField tF_NomerZaiavky;
	private JCheckBox cB_Zarezervovano;
	private JCheckBox cB_Vydano;
	private JLabel l_Vydav;
	private JLabel l_KHtoVydav;
	private JLabel l_KolyVydanoData;
	private JLabel l_KolyVydano;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd    HH:mm:ss");
	private JComboBox cB_Kurier;
	private JLabel l_Kurier;
	
	int i_novi = 0;
	int i_zapravleni = 0;
	int i_naZapravci = 0;
	
	private Formatter formatter_SaveSklad;

	int i_kilkistNatystutyhCheckBox = 0;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Cartridges(final String s_NameProduct, String s_Marka, String s_Model) {
		super(s_NameProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(new File("res/ZakK.png").toString()));

		{
			// виконувати відразу після запуску
			s_mas_Marka = null;
			al_Marka.clear();
			s_mas_Model = null;
			al_Model.clear();
			
			if(s_Marka.equals("") || s_Marka.equals(null)){
				
			}else{
				if(s_Model.equals("") || s_Model.equals(null)){
					
				}else{
					al_Marka.add(s_Marka);
					al_Model.add(s_Marka);
				}
			}

			// початкове відображення Місця 1 рівня
			al_Marka.add(""); // добавляємо пусте поле на початку
			for (String path : Menu.fileInDirect(s_Path_Cartridges)) {
				al_Marka.add(path); // отримуємо список всіх місць
				// System.out.println(al_Mictce);
			}

			// переписуємо ArrayList із всіма місцями в стрінговий масив, щоб
			// потім його записати в ЧекБокс
			s_mas_Marka = al_Marka.toArray(new String[al_Marka.size()]);

			// виводимо / перевіряємо масив
			// System.out.println(Arrays.toString(s_mas_Misctce));

		}
		
		b_Menu = new JButton("\u041C\u0435\u043D\u044E");
		b_Menu.setBounds(875, 11, 109, 23);
		b_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu(s_NameProduct);
				setVisible(false);
			}
		});
		getContentPane().setLayout(null);
		b_Menu.setForeground(new Color(0, 0, 0));
		b_Menu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(b_Menu);

		label_Shapka = new JLabel(
				"\u041E\u0431\u043B\u0456\u043A \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0456\u0432");
		label_Shapka.setBounds(17, 11, 967, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);

		JLabel l_Marka = new JLabel(
				"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u043C\u0430\u0440\u043A\u0443 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Marka.setBounds(17, 79, 250, 14);
		l_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		l_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Marka);

		JLabel l_Model = new JLabel(
				"\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u043C\u043E\u0434\u0435\u043B\u044C \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Model.setBounds(17, 135, 250, 14);
		l_Model.setHorizontalAlignment(SwingConstants.CENTER);
		l_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Model);
		
		cB_Marka = new JComboBox(s_mas_Marka);
		cB_Marka.setBounds(27, 104, 227, 20);
		cB_Marka.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		getContentPane().add(cB_Marka);
		cB_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// обнуляємо масиви

				s_mas_Model = null;
				al_Model.clear();					

				cB_Model.setModel(new DefaultComboBoxModel());
				
				al_Model.add("");
				
				cB_toner.setSelected(false);
				cB_tonerTyp.setSelected(false);
				cB_baraban.setSelected(false);
				cB_farba.setSelected(false);
				
				for (String path : Menu.fileInDirect(s_Path_Cartridges
						+ (String) cB_Marka.getSelectedItem())) {
					al_Model.add(path);
				}
				
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Model = al_Model.toArray(new String[al_Model
						.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_Model.setModel(new DefaultComboBoxModel(s_mas_Model));

				if(cB_Marka.getSelectedItem().equals("")){
					blockJCheckBox();
					cB_Model.setModel(new DefaultComboBoxModel());
				}
				
				revalidate();
			}
		});
		
		cB_Model.setBounds(27, 160, 227, 20);
		cB_Model.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		getContentPane().add(cB_Model);
		cB_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Тип заправки (блокування непотрібних полів)

				cB_toner.setSelected(false);
				cB_tonerTyp.setSelected(false);
				cB_baraban.setSelected(false);
				cB_farba.setSelected(false);
		
				blockJCheckBox();
				
				try {
					String[][] s_mas_TypZapravky = new String[4][1];

					@SuppressWarnings("resource")
					Scanner scn = new Scanner(new File(s_Path_Cartridges
							+ (String) cB_Marka.getSelectedItem() + "/"
							+ (String) cB_Model.getSelectedItem()
							+ "/TypZapravky"));

					while (scn.hasNext()) {
						for (int r = 0; r < s_mas_TypZapravky.length; r++) {
							for (int c = 0; c < s_mas_TypZapravky[r].length; c++) {
								s_mas_TypZapravky[r][c] = scn.next();
							}
						}
					}
					
					if (s_mas_TypZapravky[0][0].equals("1")) {
						cB_toner.setEnabled(true);
					}
					if (s_mas_TypZapravky[1][0].equals("1")) {
						cB_tonerTyp.setEnabled(true);
					}
					if (s_mas_TypZapravky[2][0].equals("1")) {
						cB_baraban.setEnabled(true);
					}
					if (s_mas_TypZapravky[3][0].equals("1")) {
						cB_farba.setEnabled(true);
					}

				} catch (Exception e1) {
					blockJCheckBox();
				}
			}
		});
        
        JLabel l_kilkitNaSkladiBlock = new JLabel("");
        l_kilkitNaSkladiBlock.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	}
        });
        l_kilkitNaSkladiBlock.setBounds(445, 77, 70, 20);
        getContentPane().add(l_kilkitNaSkladiBlock);
        
        JLabel l_Zarezervovano_Block = new JLabel("");
        l_Zarezervovano_Block.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	}
        });
        l_Zarezervovano_Block.setBounds(444, 189, 70, 20);
        getContentPane().add(l_Zarezervovano_Block);
		
        l_textKilkistVsihKartrydjiv = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u0432\u0441\u0456\u0445 \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0456\u0432:");
        l_textKilkistVsihKartrydjiv.setBounds(54, 479, 299, 14);
        l_textKilkistVsihKartrydjiv.setHorizontalAlignment(SwingConstants.CENTER);
        l_textKilkistVsihKartrydjiv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        getContentPane().add(l_textKilkistVsihKartrydjiv);
        
        l_KilkistVsihKartrydjiv = new JLabel("-");
        l_KilkistVsihKartrydjiv.setBounds(363, 479, 98, 14);
        l_KilkistVsihKartrydjiv.setHorizontalAlignment(SwingConstants.CENTER);
        l_KilkistVsihKartrydjiv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        getContentPane().add(l_KilkistVsihKartrydjiv);
        l_textKilkistPraciyiychuhKartrydjiv.setBounds(54, 517, 299, 14);
        
        l_textKilkistPraciyiychuhKartrydjiv.setHorizontalAlignment(SwingConstants.CENTER);
        l_textKilkistPraciyiychuhKartrydjiv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        getContentPane().add(l_textKilkistPraciyiychuhKartrydjiv);
        
        JLabel l_KilkistPraciyiychuhKartrydjiv = new JLabel("-");
        l_KilkistPraciyiychuhKartrydjiv.setBounds(363, 517, 98, 14);
        l_KilkistPraciyiychuhKartrydjiv.setHorizontalAlignment(SwingConstants.CENTER);
        l_KilkistPraciyiychuhKartrydjiv.setFont(new Font("Sitka Text", Font.PLAIN, 15));
        getContentPane().add(l_KilkistPraciyiychuhKartrydjiv);
		
		JLabel l_Sklad = new JLabel("\u0421\u043A\u043B\u0430\u0434");
		l_Sklad.setBounds(288, 48, 227, 14);
		l_Sklad.setHorizontalAlignment(SwingConstants.LEFT);
		l_Sklad.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		getContentPane().add(l_Sklad);
		
		JLabel l_ParametryPoshuku = new JLabel("\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u0438 \u043F\u043E\u0448\u0443\u043A\u0443");
		l_ParametryPoshuku.setBounds(27, 51, 240, 14);
		l_ParametryPoshuku.setHorizontalAlignment(SwingConstants.LEFT);
		l_ParametryPoshuku.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		getContentPane().add(l_ParametryPoshuku);
		b_Pryntary.setBounds(744, 499, 227, 23);
		b_Pryntary.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				// перевірка чи не пустий файл із базою
				int i_k_File = 0;
				for (String path : Menu.fileInDirect(s_Path_Cartridges)) {
//					System.out.println(path);
					i_k_File++;
				}
				if (i_k_File != 0) {						
					new Pryntery(s_NameProduct);
					setVisible(false);
				}
			}
		});
		b_Pryntary.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		getContentPane().add(b_Pryntary);
		b_Korystuvachi.setBounds(744, 537, 227, 23);
		b_Korystuvachi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new People(s_NameProduct);
				setVisible(false);
			}
		});
		b_Korystuvachi.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		getContentPane().add(b_Korystuvachi);
		
		cB_toner = new JCheckBox("\u0422\u043E\u043D\u0435\u0440");
		cB_toner.setEnabled(false);
		cB_toner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cB_tonerTyp.setSelected(false);
			}
		});
		cB_toner.setForeground(Color.BLACK);
		cB_toner.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_toner.setBounds(27, 187, 110, 23);
		getContentPane().add(cB_toner);
		
		cB_tonerTyp = new JCheckBox("\u0422\u0438\u043F (\u0447\u0456\u043F, \u041C)");
		cB_tonerTyp.setEnabled(false);
		cB_tonerTyp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cB_toner.setSelected(false);
			}
		});
		cB_tonerTyp.setForeground(Color.BLACK);
		cB_tonerTyp.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_tonerTyp.setBounds(139, 187, 115, 23);
		getContentPane().add(cB_tonerTyp);
		
		cB_baraban = new JCheckBox("\u0411\u0430\u0440\u0430\u0431\u0430\u043D");
		cB_baraban.setEnabled(false);
		cB_baraban.setForeground(Color.BLACK);
		cB_baraban.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_baraban.setBounds(27, 220, 151, 23);
		getContentPane().add(cB_baraban);
		
		cB_farba = new JCheckBox("\u041A\u043E\u043C\u043F\u043B\u0435\u043A\u0442 \u0444\u0430\u0440\u0431\u0438");
		cB_farba.setEnabled(false);
		cB_farba.setForeground(Color.BLACK);
		cB_farba.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_farba.setBounds(27, 254, 151, 23);
		getContentPane().add(cB_farba);
		
		JLabel l_StrilkaVpravo = new JLabel("");
		l_StrilkaVpravo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (cB_toner.isSelected() == true) {
					i_kilkistNatystutyhCheckBox++;
				}
				if (cB_tonerTyp.isSelected() == true) {
					i_kilkistNatystutyhCheckBox++;
				}
				if (cB_baraban.isSelected() == true) {
					i_kilkistNatystutyhCheckBox++;
				}
				if (cB_farba.isSelected() == true) {
					i_kilkistNatystutyhCheckBox++;
				}
				if (i_kilkistNatystutyhCheckBox != 0) {
					if (cB_toner.isSelected() == true
							&& cB_tonerTyp.isSelected() == true) {
						JOptionPane.showMessageDialog(null, 
								"Обрано одночасно і тонер, і альтернативний тип картриджу.");
					} else {

						i_novi = 0;
						i_zapravleni = 0;
						i_naZapravci = 0;

						String s_Path = s_Path_Cartridges
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem();

						if (cB_toner.isSelected() == true) {
							i_novi = i_novi + Integer.parseInt(skladOutPut(s_Path + "/SkladToner", 0));
							i_zapravleni = i_zapravleni + Integer.parseInt(skladOutPut(s_Path + "/SkladToner", 1));
							i_naZapravci = i_naZapravci + Integer.parseInt(skladOutPut(s_Path + "/SkladToner", 2));
						}

						if (cB_tonerTyp.isSelected() == true) {
							i_novi = i_novi + Integer.parseInt(skladOutPut(s_Path + "/SkladTonerTyp", 0));
							i_zapravleni = i_zapravleni + Integer.parseInt(skladOutPut(s_Path + "/SkladTonerTyp", 1));
							i_naZapravci = i_naZapravci + Integer.parseInt(skladOutPut(s_Path + "/SkladTonerTyp", 2));
						}
						if (cB_baraban.isSelected() == true) {
							i_novi = i_novi + Integer.parseInt(skladOutPut(s_Path + "/SkladBaraban", 0));
							i_zapravleni = i_zapravleni + Integer.parseInt(skladOutPut(s_Path + "/SkladBaraban", 1));
							i_naZapravci = i_naZapravci + Integer.parseInt(skladOutPut(s_Path + "/SkladBaraban", 2));
						}
						if (cB_farba.isSelected() == true) {
							i_novi = i_novi + Integer.parseInt(skladOutPut(s_Path + "/SkladFarba", 0));
							i_zapravleni = i_zapravleni + Integer.parseInt(skladOutPut(s_Path + "/SkladFarba", 1));
							i_naZapravci = i_naZapravci + Integer.parseInt(skladOutPut(s_Path + "/SkladFarba", 2));
						}

						tF_novi.setText(i_novi + "");
						tF_zapravleni.setText(i_zapravleni + "");
						tF_naZapravci.setText(i_naZapravci + "");

						tF_kilkitNaSkladi.setText(Integer.parseInt(tF_novi.getText())
								+ Integer.parseInt(tF_zapravleni.getText())	+ "");
					}
					i_kilkistNatystutyhCheckBox = 0;
				}else{
					JOptionPane.showMessageDialog(null, "Вкажіть дані для бронювання");
				}
			}
		});
		l_StrilkaVpravo.setIcon(new ImageIcon("res/StrilkaVptavo.png"));
		l_StrilkaVpravo.setBounds(184, 220, 70, 57);
		getContentPane().add(l_StrilkaVpravo);
		
		@SuppressWarnings("serial")
		JPanel p_ParametryPoshuku = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Shape rect = new Rectangle(0, 0, 249, 219);
				g2.draw(rect);
			}
		};
		p_ParametryPoshuku.setBounds(17, 67, 250, 220);
		p_ParametryPoshuku.setToolTipText("");
		getContentPane().add(p_ParametryPoshuku);
		
		tF_kilkitNaSkladi = new JTextField();
		tF_kilkitNaSkladi.setToolTipText("");
		tF_kilkitNaSkladi.setHorizontalAlignment(SwingConstants.CENTER);
		tF_kilkitNaSkladi.setForeground(Color.GRAY);
		tF_kilkitNaSkladi.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_kilkitNaSkladi.setColumns(10);
		tF_kilkitNaSkladi.setBounds(445, 77, 70, 20);
		getContentPane().add(tF_kilkitNaSkladi);
		
		JLabel l_kilkitNaSkladi = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u043D\u0430 \u0441\u043A\u043B\u0430\u0434\u0456");
		l_kilkitNaSkladi.setHorizontalAlignment(SwingConstants.CENTER);
		l_kilkitNaSkladi.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_kilkitNaSkladi.setBounds(288, 79, 151, 14);
		getContentPane().add(l_kilkitNaSkladi);
		
		l_Zapravleni = new JLabel("\u0417\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0456 (\u0411\\\u0423)");
		l_Zapravleni.setHorizontalAlignment(SwingConstants.CENTER);
		l_Zapravleni.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Zapravleni.setBounds(287, 136, 151, 14);
		getContentPane().add(l_Zapravleni);
		
		tF_zapravleni = new JTextField();
		tF_zapravleni.setToolTipText("");
		tF_zapravleni.setHorizontalAlignment(SwingConstants.CENTER);
		tF_zapravleni.setForeground(Color.BLACK);
		tF_zapravleni.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_zapravleni.setColumns(10);
		tF_zapravleni.setBounds(444, 132, 36, 20);
		getContentPane().add(tF_zapravleni);
		
		l_Zarezervovano = new JLabel("\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u043E\u0432\u0430\u043D\u043E");
		l_Zarezervovano.setHorizontalAlignment(SwingConstants.CENTER);
		l_Zarezervovano.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Zarezervovano.setBounds(287, 192, 151, 14);
		getContentPane().add(l_Zarezervovano);
		
		tF_Zarezervovano = new JTextField();
		tF_Zarezervovano.setToolTipText("");
		tF_Zarezervovano.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Zarezervovano.setForeground(Color.GRAY);
		tF_Zarezervovano.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_Zarezervovano.setColumns(10);
		tF_Zarezervovano.setBounds(444, 189, 70, 20);
		getContentPane().add(tF_Zarezervovano);
		
		l_NaZapravci = new JLabel("\u041D\u0430 \u0437\u0430\u043F\u0440\u0430\u0432\u0446\u0456");
		l_NaZapravci.setHorizontalAlignment(SwingConstants.CENTER);
		l_NaZapravci.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_NaZapravci.setBounds(287, 163, 151, 14);
		getContentPane().add(l_NaZapravci);
		
		tF_naZapravci = new JTextField();
		tF_naZapravci.setToolTipText("");
		tF_naZapravci.setHorizontalAlignment(SwingConstants.CENTER);
		tF_naZapravci.setForeground(Color.BLACK);
		tF_naZapravci.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_naZapravci.setColumns(10);
		tF_naZapravci.setBounds(444, 161, 36, 20);
		getContentPane().add(tF_naZapravci);
		
		l_SaveKilkistNaSkladi = new JLabel("");
		l_SaveKilkistNaSkladi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				skladSave(0);
				tF_kilkitNaSkladi.setText(Integer.parseInt(tF_novi.getText())
						+ Integer.parseInt(tF_zapravleni.getText())	+ "");
			}
		});
		l_SaveKilkistNaSkladi.setIcon(new ImageIcon("res/icon_save.png"));
		l_SaveKilkistNaSkladi.setBounds(489, 99, 25, 25);
		getContentPane().add(l_SaveKilkistNaSkladi);
		
		l_SaveZapravleno = new JLabel("");
		l_SaveZapravleno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				skladSave(1);
				tF_kilkitNaSkladi.setText(Integer.parseInt(tF_novi.getText())
						+ Integer.parseInt(tF_zapravleni.getText())	+ "");
			}
		});
		l_SaveZapravleno.setIcon(new ImageIcon("res/icon_save.png"));
		l_SaveZapravleno.setBounds(489, 127, 25, 25);
		getContentPane().add(l_SaveZapravleno);
		
		l_SaveNaZapravci = new JLabel("");
		l_SaveNaZapravci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				skladSave(2);
			}
		});
		l_SaveNaZapravci.setIcon(new ImageIcon("res/icon_save.png"));
		l_SaveNaZapravci.setBounds(490, 156, 25, 25);
		getContentPane().add(l_SaveNaZapravci);
		
		l_nova = new JLabel("\u041D\u043E\u0432\u0456");
		l_nova.setHorizontalAlignment(SwingConstants.CENTER);
		l_nova.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_nova.setBounds(288, 108, 151, 14);
		getContentPane().add(l_nova);
		
		tF_novi = new JTextField();
		tF_novi.setToolTipText("");
		tF_novi.setHorizontalAlignment(SwingConstants.CENTER);
		tF_novi.setForeground(Color.BLACK);
		tF_novi.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_novi.setColumns(10);
		tF_novi.setBounds(445, 105, 36, 20);
		getContentPane().add(tF_novi);
		
		l_NaZapravci1 = new JLabel("");
		l_NaZapravci1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (tF_naZapravci.getText().equals("")) {
					} else {
						if (tF_zapravleni.getText().equals("")) {
							tF_zapravleni.setText(Integer
									.parseInt(tF_naZapravci.getText()) + "");
							tF_naZapravci.setText("");
						} else {
							tF_zapravleni.setText(Integer
									.parseInt(tF_zapravleni.getText())
									+ Integer.parseInt(tF_naZapravci.getText())
									+ "");
							tF_naZapravci.setText("");
						}
					}
				} catch (Exception e1) {}
				
				tF_kilkitNaSkladi.setText(Integer.parseInt(tF_novi.getText())
						+ Integer.parseInt(tF_zapravleni.getText())	+ "");
			}
		});
		l_NaZapravci1.setIcon(new ImageIcon("res/l_NaZapravci1.png"));
		l_NaZapravci1.setBounds(480, 170, 10, 10);
		getContentPane().add(l_NaZapravci1);
		
		@SuppressWarnings("serial")
		JPanel p_Rezervuvanna = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Shape rect = new Rectangle(0, 0, 249, 405);
				g2.draw(rect);
			}
		};
		p_Rezervuvanna.setToolTipText("");
		p_Rezervuvanna.setBounds(536, 67, 250, 406);
		getContentPane().add(p_Rezervuvanna);
		p_Rezervuvanna.setLayout(null);
		
		l_SNPryntera = new JLabel("SN \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_SNPryntera.setBounds(34, 5, 181, 20);
		p_Rezervuvanna.add(l_SNPryntera);
		l_SNPryntera.setHorizontalAlignment(SwingConstants.CENTER);
		l_SNPryntera.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		tF_SNPryntera = new JTextField();
		tF_SNPryntera.setToolTipText("");
		tF_SNPryntera.setHorizontalAlignment(SwingConstants.CENTER);
		tF_SNPryntera.setForeground(Color.BLACK);
		tF_SNPryntera.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_SNPryntera.setColumns(10);
		tF_SNPryntera.setBounds(10, 36, 230, 20);
		p_Rezervuvanna.add(tF_SNPryntera);
		
		l_NomerZaiavky = new JLabel("\u2116 \u0437\u0430\u044F\u0432\u043A\u0438");
		l_NomerZaiavky.setHorizontalAlignment(SwingConstants.CENTER);
		l_NomerZaiavky.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_NomerZaiavky.setBounds(34, 67, 181, 20);
		p_Rezervuvanna.add(l_NomerZaiavky);
		
		tF_NomerZaiavky = new JTextField();
		tF_NomerZaiavky.setToolTipText("");
		tF_NomerZaiavky.setHorizontalAlignment(SwingConstants.CENTER);
		tF_NomerZaiavky.setForeground(Color.BLACK);
		tF_NomerZaiavky.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		tF_NomerZaiavky.setColumns(10);
		tF_NomerZaiavky.setBounds(10, 98, 230, 20);
		p_Rezervuvanna.add(tF_NomerZaiavky);
		
		cB_Zarezervovano = new JCheckBox("\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u043E\u0432\u0430\u043D\u043E");
		cB_Zarezervovano.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_Zarezervovano.setBounds(32, 125, 208, 23);
		p_Rezervuvanna.add(cB_Zarezervovano);
		
		cB_Vydano = new JCheckBox("\u0412\u0438\u0434\u0430\u043D\u043E");
		cB_Vydano.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		cB_Vydano.setBounds(32, 158, 208, 23);
		p_Rezervuvanna.add(cB_Vydano);
		
		l_Vydav = new JLabel("\u041A\u0430\u0440\u0442\u0440\u0438\u0434\u0436 \u0432\u0438\u0434\u0430\u0432:");
		l_Vydav.setHorizontalAlignment(SwingConstants.CENTER);
		l_Vydav.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Vydav.setBounds(34, 188, 181, 20);
		p_Rezervuvanna.add(l_Vydav);
		
		l_KHtoVydav = new JLabel(System.getProperty("user.name"));
		l_KHtoVydav.setHorizontalAlignment(SwingConstants.CENTER);
		l_KHtoVydav.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_KHtoVydav.setBounds(34, 219, 181, 20);
		p_Rezervuvanna.add(l_KHtoVydav);
		
		Date date = new Date();
//	    System.out.println(sdf.format(date));
		l_KolyVydanoData = new JLabel(sdf.format(date));
		l_KolyVydanoData.setHorizontalAlignment(SwingConstants.CENTER);
		l_KolyVydanoData.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_KolyVydanoData.setBounds(34, 281, 181, 20);
		p_Rezervuvanna.add(l_KolyVydanoData);
		
		
		l_KolyVydano = new JLabel("\u041A\u043E\u043B\u0438 \u0432\u0438\u0434\u0430\u043D\u043E:");
		l_KolyVydano.setHorizontalAlignment(SwingConstants.CENTER);
		l_KolyVydano.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_KolyVydano.setBounds(34, 250, 181, 20);
		p_Rezervuvanna.add(l_KolyVydano);
		
		cB_Kurier = new JComboBox();
		cB_Kurier.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		cB_Kurier.setBounds(10, 343, 230, 20);
		p_Rezervuvanna.add(cB_Kurier);
		
		l_Kurier = new JLabel("\u041A\u0443\u0440'\u0454\u0440:");
		l_Kurier.setHorizontalAlignment(SwingConstants.CENTER);
		l_Kurier.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Kurier.setBounds(34, 312, 181, 20);
		p_Rezervuvanna.add(l_Kurier);
		
		JButton b_Save = new JButton("\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438");
		b_Save.setBounds(10, 374, 230, 23);
		p_Rezervuvanna.add(b_Save);
		b_Save.setForeground(Color.BLACK);
		b_Save.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		JLabel l_Rezervuvanna = new JLabel("\u0420\u0435\u0437\u0435\u0440\u0432\u0443\u0432\u0430\u043D\u043D\u044F");
		l_Rezervuvanna.setHorizontalAlignment(SwingConstants.LEFT);
		l_Rezervuvanna.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		l_Rezervuvanna.setBounds(547, 48, 227, 14);
		getContentPane().add(l_Rezervuvanna);
		
		JButton b_History = new JButton("\u0406\u0441\u0442\u043E\u0440\u0456\u044F \u0431\u0440\u043E\u043D\u044E\u0432\u0430\u043D\u044C");
		b_History.setForeground(Color.BLACK);
		b_History.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_History.setBounds(796, 99, 188, 23);
		getContentPane().add(b_History);
		
		JButton b_Poshyk = new JButton("\u041F\u043E\u0448\u0443\u043A \u043F\u043E \u2116 \u0437\u0430\u044F\u0432\u043A\u0438");
		b_Poshyk.setForeground(Color.BLACK);
		b_Poshyk.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_Poshyk.setBounds(796, 160, 188, 23);
		getContentPane().add(b_Poshyk);
		
		JButton b_PrinterInCrtridgeAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043F\u0440\u0438\u043D\u0442\u0435\u0440");
		b_PrinterInCrtridgeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CartridgesAddPrinters(s_NameProduct);
			}
		});
		b_PrinterInCrtridgeAdd.setForeground(Color.BLACK);
		b_PrinterInCrtridgeAdd.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		b_PrinterInCrtridgeAdd.setBounds(288, 225, 227, 23);
		getContentPane().add(b_PrinterInCrtridgeAdd);
		
		JLabel l_delete = new JLabel("* \u0432\u0438\u0434\u0430\u043B\u0435\u043D\u043D\u044F \u0432\u0456\u0434\u0431\u0443\u0432\u0430\u0454\u0442\u044C\u0441\u044F \u0430\u0432\u0442\u043E\u043C\u0430\u0442\u0438\u0447\u043D\u043E,");
		l_delete.setHorizontalAlignment(SwingConstants.CENTER);
		l_delete.setFont(new Font("Sitka Text", Font.PLAIN, 10));
		l_delete.setBounds(288, 248, 227, 14);
		getContentPane().add(l_delete);
		
		JLabel l_delete1 = new JLabel("\u044F\u043A\u0449\u043E \u0432 \u0431\u0430\u0437\u0456 \u043D\u0435\u043C\u0430\u0454 \u0436\u043E\u0434\u043D\u043E\u0433\u043E \u043A\u0430\u0440\u0442\u0440\u0438\u0434\u0436\u0443");
		l_delete1.setHorizontalAlignment(SwingConstants.CENTER);
		l_delete1.setFont(new Font("Sitka Text", Font.PLAIN, 10));
		l_delete1.setBounds(288, 263, 227, 14);
		getContentPane().add(l_delete1);
		
		p_Sklad.setBounds(277, 67, 250, 220);
		p_Sklad.setToolTipText("");
		getContentPane().add(p_Sklad);
		
		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);

        setVisible(true);
	}

	void blockJCheckBox() {
		cB_toner.setEnabled(false);
		cB_tonerTyp.setEnabled(false);
		cB_baraban.setEnabled(false);
		cB_farba.setEnabled(false);
	}

	String skladOutPut(String s_Path, int i_NomerStroky) {
		try {
			String[][] s_mas_Sklad = new String[3][1];

			@SuppressWarnings("resource")
			Scanner scn = new Scanner(new File(s_Path));

			while (scn.hasNext()) {
				for (int r = 0; r < s_mas_Sklad.length; r++) {
					for (int c = 0; c < s_mas_Sklad[r].length; c++) {
						s_mas_Sklad[r][c] = scn.next();
					}
				}
			}

			if (i_NomerStroky == 0) {
				return s_mas_Sklad[0][0];
			}
			if (i_NomerStroky == 1) {
				return s_mas_Sklad[1][0];
			}
			if (i_NomerStroky == 2) {
				return s_mas_Sklad[2][0];
			}

		} catch (Exception e1) {}
		return null;
	}
	
	void skladSaveFiles(String s_Path, int i_NomerStroky, int i_dani) {
		try {
			String[][] s_mas_Sklad = new String[3][1];

			@SuppressWarnings("resource")
			Scanner scn = new Scanner(new File(s_Path));

			while (scn.hasNext()) {
				for (int r = 0; r < s_mas_Sklad.length; r++) {
					for (int c = 0; c < s_mas_Sklad[r].length; c++) {
						s_mas_Sklad[r][c] = scn.next();
					}
				}
			}
			
			if (i_NomerStroky == 0) {
				s_mas_Sklad[0][0] = i_dani + "";
			}
			if (i_NomerStroky == 1) {
				s_mas_Sklad[1][0] = i_dani + "";
			}
			if (i_NomerStroky == 2) {
				s_mas_Sklad[2][0] = i_dani + "";
			}

			String s_dani = s_mas_Sklad[0][0] + " " +
					s_mas_Sklad[1][0] + " " + s_mas_Sklad[2][0];
			
			formatter_SaveSklad = new Formatter(s_Path);
			formatter_SaveSklad.format(s_dani);
			formatter_SaveSklad.close();

			JOptionPane.showMessageDialog(null, "Збережено");
			
		} catch (Exception e1) {}
	}
	
	void skladSave (int i_shchoZberihaiemo){

		if (cB_toner.isSelected() == true) {
			i_kilkistNatystutyhCheckBox++;
		}
		if (cB_tonerTyp.isSelected() == true) {
			i_kilkistNatystutyhCheckBox++;
		}
		if (cB_baraban.isSelected() == true) {
			i_kilkistNatystutyhCheckBox++;
		}
		if (cB_farba.isSelected() == true) {
			i_kilkistNatystutyhCheckBox++;
		}
		if (i_kilkistNatystutyhCheckBox != 1) {
			JOptionPane.showMessageDialog(null, "Для збереження даних необхідно обрати всього один картридж !");					
		}else{
			// Підтвердження  на основі додаткового вікна JOptionPane.showOptionDialog
			Object[] options_Save = { "Так", "Ні" };
			int i_Save = JOptionPane.showOptionDialog(null,
					"Зберегти зміни ?", "Підтвердження",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options_Save, null);
			if (i_Save == JOptionPane.YES_OPTION) {
				String s_Path = s_Path_Cartridges + (String) cB_Marka.getSelectedItem() + "/"
					+ (String) cB_Model.getSelectedItem();
				
					if(i_shchoZberihaiemo == 0){
						if(cB_toner.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladToner", i_shchoZberihaiemo, Integer.parseInt(tF_novi.getText()));
						}
						if(cB_tonerTyp.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladTonerTyp", i_shchoZberihaiemo, Integer.parseInt(tF_novi.getText()));
						}
						if(cB_baraban.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladBaraban", i_shchoZberihaiemo, Integer.parseInt(tF_novi.getText()));
						}
						if(cB_farba.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladFarba", i_shchoZberihaiemo, Integer.parseInt(tF_novi.getText()));
						}
					}
					if(i_shchoZberihaiemo == 1){
						if(cB_toner.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladToner", i_shchoZberihaiemo, Integer.parseInt(tF_zapravleni.getText()));
						}
						if(cB_tonerTyp.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladTonerTyp", i_shchoZberihaiemo, Integer.parseInt(tF_zapravleni.getText()));
						}
						if(cB_baraban.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladBaraban", i_shchoZberihaiemo, Integer.parseInt(tF_zapravleni.getText()));
						}
						if(cB_farba.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladFarba", i_shchoZberihaiemo, Integer.parseInt(tF_zapravleni.getText()));
						}
					}
					if(i_shchoZberihaiemo == 2){
						if(cB_toner.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladToner", i_shchoZberihaiemo, Integer.parseInt(tF_naZapravci.getText()));
						}
						if(cB_tonerTyp.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladTonerTyp", i_shchoZberihaiemo, Integer.parseInt(tF_naZapravci.getText()));
						}
						if(cB_baraban.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladBaraban", i_shchoZberihaiemo, Integer.parseInt(tF_naZapravci.getText()));
						}
						if(cB_farba.isSelected() == true){
							skladSaveFiles(s_Path + "/SkladFarba", i_shchoZberihaiemo, Integer.parseInt(tF_naZapravci.getText()));
						}
					}			
										
			}
		}
		i_kilkistNatystutyhCheckBox = 0;
	}
}
