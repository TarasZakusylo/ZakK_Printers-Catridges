import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 */

public class PrynteryAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
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

	String s_Path_Mictce = "C:/ZakK_Printer/baza/";

	@SuppressWarnings("rawtypes")
	JComboBox cB_Marka = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cB_Model = new JComboBox();

	private final JLabel l_SN = new JLabel(
			"\u0421\u0435\u0440\u0456\u0439\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440");
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
	private final JLabel l_DodatkovaInfa = new JLabel(
			"\u0414\u043E\u0434\u0430\u0442\u043A\u043E\u0432\u0430 \u0456\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0456\u044F:");
	private TextArea tA_Koment = new TextArea();
	private final JLabel l_Stan = new JLabel(
			"\u0421\u0442\u0430\u043D \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
	private final JTextField tF_Stan = new JTextField();

	Formatter formatter_IP;
	Formatter formatter_Inv;
	Formatter formatter_Koment;
	Formatter formatter_Stan;
	Formatter formatter_MOL;
	
	private JTextField tF_Mistce;
	private JTextField tF_Mistce2;
	private JTextField tF_Marka;
	private JTextField tF_Model;
	private JTextField tF_SN;

	JLabel l_SaveMisce = new JLabel("");
	JLabel l_SaveMisce2 = new JLabel("");
	JLabel l_SaveMarka = new JLabel("");
	JLabel l_SaveModel = new JLabel("");
	private JTextField tF_MOL;

	JButton b_Misce = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u0456\u0441\u0446\u0435");
	JButton b_Misce2 = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u0432\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");
	JButton b_Marka = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u0430\u0440\u043A\u0443");
	JButton b_Model = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u043E\u0434\u0435\u043B\u044C");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PrynteryAdd(final String s_NameProduct) {
		super(s_NameProduct);
	
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true); // вікно по верх всіх вікон
		setSize(527, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				new File("res/ZakK.png").toString()));

		{ // початкове відображення Місця 1 рівня
			al_Mictce.add(""); // добавляємо пусте поле на початку
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
		cB_Mistse.setBounds(27, 68, 227, 20);
		getContentPane().setLayout(null);

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

				cB_Marka.setModel(new DefaultComboBoxModel());
				cB_Model.setModel(new DefaultComboBoxModel());

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

				b_Misce2.setBounds(273, 123, 227, 20);

				revalidate();
			}
		});

		label_Shapka = new JLabel(
				"\u0414\u043E\u0434\u0430\u0432\u0430\u043D\u043D\u044F \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432");
		label_Shapka.setBounds(17, 5, 483, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);

		JLabel l_Marka = new JLabel(
				"\u041C\u0430\u0440\u043A\u0430 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Marka.setBounds(17, 155, 250, 14);
		l_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		l_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Marka);

		JLabel l_Model = new JLabel(
				"\u041C\u043E\u0434\u0435\u043B\u044C \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Model.setBounds(17, 211, 250, 14);
		l_Model.setHorizontalAlignment(SwingConstants.CENTER);
		l_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Model);
		
		l_SN.setBounds(17, 267, 250, 14);
		l_SN.setHorizontalAlignment(SwingConstants.CENTER);
		l_SN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_SN);
		
		l_Mistse2.setBounds(17, 99, 250, 14);
		l_Mistse2.setHorizontalAlignment(SwingConstants.CENTER);
		l_Mistse2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		l_Mistse.setBounds(17, 43, 250, 14);
		l_Mistse.setHorizontalAlignment(SwingConstants.CENTER);
		l_Mistse.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Mistse);

		getContentPane().add(cB_Mistse);
		getContentPane().add(cB_Mistse);

		getContentPane().add(l_Mistse2);
		cB_Mistse2.setBounds(27, 124, 227, 20);
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

				cB_Model.setModel(new DefaultComboBoxModel());

				al_Marka.add("");

				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem() + "/"
						+ (String) cB_Mistse2.getSelectedItem())) {
					al_Marka.add(path);
				}

				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Marka = al_Marka.toArray(new String[al_Marka.size()]);

				// виводимо / перевіряємо масив
				// System.out.println("s_mas_Marka "+Arrays.toString(s_mas_Marka));

				// Полностью переопределяем все элементы
				cB_Marka.setModel(new DefaultComboBoxModel(s_mas_Marka));

				b_Marka.setBounds(273, 179, 227, 20);

				revalidate();
			}
		});

		cB_Marka.setBounds(27, 180, 227, 20);
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

				al_Model.add("");

				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem() + "/"
						+ (String) cB_Mistse2.getSelectedItem() + "/"
						+ (String) cB_Marka.getSelectedItem())) {
					al_Model.add(path);
				}
				// переписуємо ArrayList із всіма містами в стрінговий масив,
				// щоб потім його записати в ЧекБокс
				s_mas_Model = al_Model.toArray(new String[al_Model.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				cB_Model.setModel(new DefaultComboBoxModel(s_mas_Model));

				b_Model.setBounds(273, 236, 227, 20);

				revalidate();
			}
		});

		cB_Model.setBounds(27, 236, 227, 20);
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

				al_SN.add("");

				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem() + "/"
						+ (String) cB_Mistse2.getSelectedItem() + "/"
						+ (String) cB_Marka.getSelectedItem() + "/"
						+ (String) cB_Model.getSelectedItem())) {
					al_SN.add(path);
				}

				// переписуємо ArrayList
				// щоб потім його записати в ЧекБокс
				s_mas_SN = al_SN.toArray(new String[al_SN.size()]);

				// виводимо / перевіряємо масив
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// Полностью переопределяем все элементы
				// cB_SN.setModel(new DefaultComboBoxModel(s_mas_SN));

				revalidate();
			}
		});

		tF_IP_USB = new JTextField();
		tF_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
		tF_IP_USB.setBounds(27, 398, 227, 20);
		getContentPane().add(tF_IP_USB);
		tF_IP_USB.setColumns(10);

		JLabel l_IN = new JLabel(
				"\u0406\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u0438\u0439 \u043D\u043E\u043C\u0435\u0440");
		l_IN.setBounds(17, 323, 250, 14);
		l_IN.setHorizontalAlignment(SwingConstants.CENTER);
		l_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IN);

		tF_IN = new JTextField();
		tF_IN.setBounds(27, 343, 227, 20);
		tF_IN.setHorizontalAlignment(SwingConstants.CENTER);
		tF_IN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_IN);

		JLabel l_IP_USB = new JLabel("IP / USB");
		l_IP_USB.setBounds(17, 373, 250, 14);
		l_IP_USB.setHorizontalAlignment(SwingConstants.CENTER);
		l_IP_USB.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_IP_USB);

		l_DodatkovaInfa.setBounds(264, 298, 250, 14);
		l_DodatkovaInfa.setHorizontalAlignment(SwingConstants.CENTER);
		l_DodatkovaInfa.setFont(new Font("Sitka Text", Font.PLAIN, 15));

		getContentPane().add(l_DodatkovaInfa);

		tA_Koment.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tA_Koment.setBounds(273, 323, 227, 194);
		getContentPane().add(tA_Koment);
		
		JButton b_Save = new JButton(
				"\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438");
		b_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Підтвердження на основі додаткового вікна
				// JOptionPane.showOptionDialog
				Object[] options_Save = { "Так", "Ні" };
				int i_Save = JOptionPane.showOptionDialog(null,
						"Зберегти зміни ?", "Подтверждение",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options_Save, null);
				if (i_Save == JOptionPane.YES_OPTION) {

					// IP
					try {
						String s_Path_IP = s_Path_Mictce
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistse2.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) tF_SN.getText() + "/IP";
						formatter_IP = new Formatter(s_Path_IP);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти ІР");
					}
					formatter_IP.format(tF_IP_USB.getText());
					formatter_IP.close();

					// Інв
					try {
						String s_Path_Inv = s_Path_Mictce
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistse2.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) tF_SN.getText() + "/Інв";
						formatter_Inv = new Formatter(s_Path_Inv);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Інвентарний");
					}
					formatter_Inv.format(tF_IN.getText());
					formatter_Inv.close();

					// Стан
					try {
						String s_Path_Stan = s_Path_Mictce
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistse2.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) tF_SN.getText() + "/Стан";
						formatter_Stan = new Formatter(s_Path_Stan);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Стан");
					}
					formatter_Stan.format(tF_Stan.getText());
					formatter_Stan.close();

					// Koment
					try {
						String s_Path_Koment = s_Path_Mictce
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistse2.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) tF_SN.getText() + "/Комент";
						formatter_Koment = new Formatter(s_Path_Koment);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти Додаткову інформацію");
					}
					formatter_Koment.format(tA_Koment.getText());
					formatter_Koment.close();

					// МОЛ
					try {
						String s_Path_MOL = s_Path_Mictce
								+ (String) cB_Mistse.getSelectedItem() + "/"
								+ (String) cB_Mistse2.getSelectedItem() + "/"
								+ (String) cB_Marka.getSelectedItem() + "/"
								+ (String) cB_Model.getSelectedItem() + "/"
								+ (String) tF_SN.getText() + "/МОЛ";
						formatter_MOL = new Formatter(s_Path_MOL);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Не вдалось зберегти МОЛ");
					}
					formatter_MOL.format(tF_MOL.getText());
					formatter_MOL.close();
					
					JOptionPane.showMessageDialog(null, "Інформацію збережено");
				}
			}
		});
		b_Save.setBounds(27, 531, 473, 29);
		getContentPane().add(b_Save);
		l_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		l_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_Stan.setBounds(17, 429, 250, 14);

		getContentPane().add(l_Stan);
		tF_Stan.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Stan.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_Stan.setColumns(10);
		tF_Stan.setBounds(27, 449, 227, 20);
		getContentPane().add(tF_Stan);

		// @SuppressWarnings("serial") // малюємо прямокутник
		// JPanel p_Ramka = new JPanel() {
		// @Override
		// public void paintComponent(Graphics g) {
		// Graphics2D g2 = (Graphics2D) g;
		// Shape rect = new Rectangle(0, 0, 489, 195);
		// g2.draw(rect);
		// }
		// };
		// p_Ramka.setBounds(17, 329, 490, 197);
		// getContentPane().add(p_Ramka);

		b_Misce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tF_Mistce.setBounds(273, 96, 196, 20);
				l_SaveMisce.setBounds(473, 91, 25, 25);
			}
		});
		b_Misce.setBounds(273, 68, 227, 20);
		getContentPane().add(b_Misce);

		b_Misce2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tF_Mistce2.setBounds(273, 151, 196, 20);
				l_SaveMisce2.setBounds(473, 146, 25, 25);
			}
		});
		// b_Misce2.setBounds(273, 123, 227, 20);
		getContentPane().add(b_Misce2);

		b_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tF_Marka.setBounds(273, 207, 196, 20);
				l_SaveMarka.setBounds(473, 203, 25, 25);
			}
		});
		// b_Marka.setBounds(273, 179, 227, 20);
		getContentPane().add(b_Marka);

		b_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tF_Model.setBounds(273, 263, 196, 20);
				l_SaveModel.setBounds(473, 258, 25, 25);
			}
		});
		// b_Model.setBounds(273, 236, 227, 20);
		getContentPane().add(b_Model);

		tF_Mistce = new JTextField();
		tF_Mistce.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Mistce.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Mistce);

		l_SaveMisce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (tF_Mistce.getText().equals(null)
						|| tF_Mistce.getText().equals("")
						|| tF_Mistce.getText().equals(" ")
						|| tF_Mistce.getText().equals("  ")
						|| tF_Mistce.getText().equals("   ")) {
					
					setAlwaysOnTop(false);  // змінюємо вікно , що є поверх всіх інших
					JOptionPane.showMessageDialog(null, "Ви не ввели назву місця розташування");
					setAlwaysOnTop(true);
					
				} else {

					if(al_Mictce.get(0) == ""){
						al_Mictce.remove(0);  // удаляю перше значення у масиві, що відповідає за пусе поле в списку
					}

					int i_MistciaNema = 0;
					
					for (int i = 0; i < al_Mictce.size(); i++) {
//						System.out.println(al_Mictce.get(i));
						if (tF_Mistce.getText().equals(al_Mictce.get(i))) {
							setAlwaysOnTop(false);  // змінюємо вікно , що є поверх всіх інших
							JOptionPane.showMessageDialog(null, "Така назва уже існує");
							setAlwaysOnTop(true);
						}else{
							i_MistciaNema = 1;
						}
					}
					
					if(i_MistciaNema == 1){
						// створюємо новий каталог для вміщення в собі підкаталогів
						File file = new File(s_Path_Mictce + "/" + tF_Mistce.getText());
				        file.mkdir();
				        
				        setAlwaysOnTop(false);  // змінюємо вікно , що є поверх всіх інших
						JOptionPane.showMessageDialog(null, "Місце добавлено");
						setAlwaysOnTop(true);
						
						//добавляємо нове місце в список до старих
						al_Mictce.add(tF_Mistce.getText());					
						s_mas_Misctce = al_Mictce.toArray(new String[al_Mictce
								.size()]);
						cB_Mistse.setModel(new DefaultComboBoxModel(s_mas_Misctce));						
					}
										
				}
			}
		});

		l_SaveMisce.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMisce);

		// удалить
		tF_Mistce.setBounds(273, 96, 196, 20);
		l_SaveMisce.setBounds(473, 91, 25, 25);
		//

		tF_Mistce2 = new JTextField();
		tF_Mistce2.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Mistce2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Mistce2);

		l_SaveMisce2.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMisce2);

		tF_Marka = new JTextField();
		tF_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Marka);

		tF_Model = new JTextField();
		tF_Model.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Model);

		l_SaveMarka.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMarka);

		l_SaveModel.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveModel);

		tF_SN = new JTextField();
		tF_SN.setHorizontalAlignment(SwingConstants.CENTER);
		tF_SN.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_SN.setBounds(27, 292, 227, 20);
		getContentPane().add(tF_SN);

		JLabel l_MOL = new JLabel(
				"\u041C\u0430\u0442\u0435\u0440\u0456\u0430\u043B\u044C\u043D\u043E \u0432\u0456\u0434\u043F\u043E\u0432\u0456\u0434\u0430\u043B\u044C\u043D\u0430 \u043E\u0441\u043E\u0431\u0430");
		l_MOL.setHorizontalAlignment(SwingConstants.CENTER);
		l_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		l_MOL.setBounds(17, 480, 250, 14);
		getContentPane().add(l_MOL);

		tF_MOL = new JTextField();
		tF_MOL.setHorizontalAlignment(SwingConstants.CENTER);
		tF_MOL.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		tF_MOL.setColumns(10);
		tF_MOL.setBounds(27, 500, 227, 20);
		getContentPane().add(tF_MOL);

		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);
		
		setVisible(true);

	}
}
