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

public class CartridgesAddPrinters extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JLabel l_fon;

	public ArrayList<String> al_Model = new ArrayList<String>();
	public ArrayList<String> al_Marka = new ArrayList<String>();

	String[] s_mas_Model = null;
	String[] s_mas_Marka = null;

	String s_Path_Mictce = "C:/ZakK_Printer/baza/";

	@SuppressWarnings("rawtypes")
	JComboBox cB_Marka = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cB_Model = new JComboBox();

	private JTextField tF_Marka;
	private JTextField tF_Model;

	JLabel l_SaveMarka = new JLabel("");

	JButton b_Marka = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u0430\u0440\u043A\u0443");
	JButton b_Model = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u043E\u0434\u0435\u043B\u044C");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CartridgesAddPrinters(final String s_NameProduct) {
		super(s_NameProduct);
	
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true); // вікно по верх всіх вікон
		setSize(527, 335);
		setResizable(false);
		setLocationRelativeTo(null);

		// лого (в треї) на панелі задач
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				new File("res/ZakK.png").toString()));
		getContentPane().setLayout(null);

		label_Shapka = new JLabel(
				"\u0414\u043E\u0434\u0430\u0432\u0430\u043D\u043D\u044F \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0456\u0432");
		label_Shapka.setBounds(17, 5, 483, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);

		JLabel l_Marka = new JLabel(
				"\u041C\u0430\u0440\u043A\u0430 \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Marka.setBounds(17, 42, 250, 14);
		l_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		l_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Marka);

		JLabel l_Model = new JLabel(
				"\u041C\u043E\u0434\u0435\u043B\u044C \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		l_Model.setBounds(17, 98, 250, 14);
		l_Model.setHorizontalAlignment(SwingConstants.CENTER);
		l_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(l_Model);
		
		
		cB_Marka.setBounds(27, 67, 227, 20);
		getContentPane().add(cB_Marka);
		cB_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});


		cB_Model.setBounds(27, 123, 227, 20);
		getContentPane().add(cB_Model);
		cB_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});

				
		JButton b_Save = new JButton(
				"\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438");
		b_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//						// МОЛ
//						try {
//							String s_Path_MOL = s_Path_Mictce
//									+ (String) cB_Mistse.getSelectedItem()
//									+ "/"
//									+ (String) cB_Mistse2.getSelectedItem()
//									+ "/" + (String) cB_Marka.getSelectedItem()
//									+ "/" + (String) cB_Model.getSelectedItem()
//									+ "/" + tF_SN.getText() + "/MOL";
//							formatter_MOL = new Formatter(s_Path_MOL);
//							formatter_MOL.format(tF_MOL.getText());
//							formatter_MOL.close();
//						} catch (Exception e) {
//							komentar("Не вдалось зберегти МОЛ");
//						}
//
//						komentar("Інформацію збережено");
					
				// обнуляємо масиви
				s_mas_Marka = null;
				al_Marka.clear();
				s_mas_Model = null;
				al_Model.clear();

			}
		});
		b_Save.setBounds(27, 269, 473, 29);
		getContentPane().add(b_Save);
				
		b_Marka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tF_Marka.setBounds(273, 207, 196, 20);
				l_SaveMarka.setBounds(473, 203, 25, 25);
			}
		});
		b_Marka.setBounds(273, 66, 227, 20);
		getContentPane().add(b_Marka);
		
		b_Model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				tF_Model.setBounds(273, 263, 196, 20);
				l_SaveModel.setBounds(473, 258, 25, 25);
			}
		});
		b_Model.setBounds(273, 123, 227, 20);
		getContentPane().add(b_Model);
	
		tF_Marka = new JTextField();
		tF_Marka.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Marka.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Marka);
		
		

		tF_Model = new JTextField();
		tF_Model.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Model.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Model);
		
		
		tF_Marka.setBounds(273, 94, 196, 20);    //////////
		l_SaveMarka.setBounds(473, 90, 25, 25);  /////////
		tF_Model.setBounds(273, 150, 196, 20); 	////////
		
		
		l_SaveMarka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tF_Marka.getText().equals(null)
						|| tF_Marka.getText().equals("")
						|| tF_Marka.getText().equals(" ")
						|| tF_Marka.getText().equals("  ")
						|| tF_Marka.getText().equals("   ")) {
					komentar("Ви не ввели назву місця розташування");
				} else {
					
					// удаляю перше значення у масиві, що відповідає
					// за пусе поле в списку
					if (al_Marka.get(0) == "") {
						al_Marka.remove(0);
					}

					int i_KatalogaNema = 0;

					for (int i = 0; i < al_Marka.size(); i++) {
						if (tF_Marka.getText().equals(al_Marka.get(i))) {
							komentar("Така назва уже існує");
							i_KatalogaNema = 1;
						}
					}

					if (i_KatalogaNema == 0) {
						// створюємо новий каталог для вміщення в собі
						// підкаталогів
						
						File file = new File(s_Path_Mictce 
								+ (String) cB_Mistse.getSelectedItem()+ "/"
										+ (String) cB_Mistse2.getSelectedItem()+ "/"
												+ tF_Marka.getText());
						file.mkdir();

						komentar("Місце добавлено");

						// добавляємо нове місце в список до старих
						al_Marka.add(0,tF_Marka.getText());   // добавляємо в початок списку
						s_mas_Marka = al_Marka.toArray(new String[al_Marka
								.size()]);
						cB_Marka.setModel(new DefaultComboBoxModel(
								s_mas_Marka));
						
						al_Model.add("");
					}
				}
			}
		});

		l_SaveMarka.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMarka);
		
		
		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);
		
		setVisible(true);
	}

	void komentar(String text) {
		// змінюємо вікно , що є поверх всіх інших
		setAlwaysOnTop(false); 
		JOptionPane.showMessageDialog(null, text);
		setAlwaysOnTop(true);
	}
}
