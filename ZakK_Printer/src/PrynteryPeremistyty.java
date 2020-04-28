import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

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

public class PrynteryPeremistyty extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JLabel l_fon;

	public ArrayList<String> al_Mictce = new ArrayList<String>();
	public ArrayList<String> al_Mictce2 = new ArrayList<String>();
	
	String[] s_mas_Misctce = null;
	String[] s_mas_Misctce2 = null;

	String s_Path_Mictce = "C:/ZakK_Printer/baza/";
	private final JLabel l_Mistse2 = new JLabel(
			"\u0412\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");
	@SuppressWarnings("rawtypes")
	private JComboBox cB_Mistse2 = new JComboBox();

	private final JLabel l_Mistse = new JLabel(
			"\u041C\u0456\u0441\u0446\u0435 \u0440\u043E\u0437\u0442\u0430\u0448\u0443\u0432\u0430\u043D\u043D\u044F");
	@SuppressWarnings("rawtypes")
	private JComboBox cB_Mistse = new JComboBox();
	
	private JTextField tF_Mistce;
	private JTextField tF_Mistce2;

	JLabel l_SaveMisce = new JLabel("");
	JLabel l_SaveMisce2 = new JLabel("");

	JButton b_Misce = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u043C\u0456\u0441\u0446\u0435");
	JButton b_Misce2 = new JButton(
			"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u0438 \u0432\u0456\u0434\u0434\u0456\u043B / \u043A\u0430\u0431\u0456\u043D\u0435\u0442");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PrynteryPeremistyty(final String s_NameProduct, final String s_Mistce, 
			final String s_Mistce1, final String s_Marka, final String s_Model, final String s_SN) {
		super(s_NameProduct);
	
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true); // ���� �� ���� ��� ����
		setSize(527, 239);
		setResizable(false);
		setLocationRelativeTo(null);

		// ���� (� ���) �� ����� �����
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				new File("res/ZakK.png").toString()));

		{ // ��������� ����������� ̳��� 1 ����
			al_Mictce.add(""); // ���������� ����� ���� �� �������
			for (String path : Menu.fileInDirect(s_Path_Mictce)) {
				al_Mictce.add(path); // �������� ������ ��� ����
				// System.out.println(al_Mictce);
			}

			// ���������� ArrayList �� ���� ������ � ��������� �����, ���
			// ���� ���� �������� � �������
			s_mas_Misctce = al_Mictce.toArray(new String[al_Mictce.size()]);

			// �������� / ���������� �����
			// System.out.println(Arrays.toString(s_mas_Misctce));
		}

		cB_Mistse = new JComboBox(s_mas_Misctce);
		cB_Mistse.setBounds(27, 68, 227, 20);
		getContentPane().setLayout(null);

		cB_Mistse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ��������� ������
				s_mas_Misctce2 = null;
				al_Mictce2.clear();

				al_Mictce2.add("");

				for (String path : Menu.fileInDirect(s_Path_Mictce
						+ (String) cB_Mistse.getSelectedItem())) {
					al_Mictce2.add(path);
				}

				// ���������� ArrayList �� ���� ������ � ��������� �����,
				// ��� ���� ���� �������� � �������
				s_mas_Misctce2 = al_Mictce2.toArray(new String[al_Mictce2
						.size()]);

				// �������� / ���������� �����
				// System.out.println(Arrays.toString(s_mas_Misctce2));

				// ��������� �������������� ��� ��������
				cB_Mistse2.setModel(new DefaultComboBoxModel(s_mas_Misctce2));

				revalidate();
			}
		});
		

		label_Shapka = new JLabel(
				"\u041F\u0435\u0440\u0435\u043C\u0456\u0449\u0435\u043D\u043D\u044F  \u043F\u0440\u0438\u043D\u0442\u0435\u0440\u0430");
		label_Shapka.setBounds(17, 5, 483, 29);
		label_Shapka.setBackground(new Color(165, 42, 42));
		label_Shapka.setHorizontalAlignment(SwingConstants.CENTER);
		label_Shapka.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(label_Shapka);
		
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
		
		JButton b_Save = new JButton(
				"\u041F\u0435\u0440\u0435\u043C\u0456\u0441\u0442\u0438\u0442\u0438");
		b_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(s_Mistce.equals((String) cB_Mistse.getSelectedItem())&&
						s_Mistce1.equals((String) cB_Mistse2.getSelectedItem())){
					komentar("�� ����� ����� ���� �����������");
				}else{
					if((boolean) cB_Mistse.getSelectedItem().equals("")||
							(boolean) cB_Mistse2.getSelectedItem().equals("")){
						komentar("�� �������� ����");
					} else {

						String s_out = s_Path_Mictce + s_Mistce + "/"
								+ s_Mistce1 + "/" + s_Marka + "/" + s_Model
								+ "/" + s_SN;
						String s_in = s_Path_Mictce
								+ cB_Mistse.getSelectedItem() + "/"
								+ cB_Mistse2.getSelectedItem();

						File f_out;
						File f_in = new File(s_in);

						s_in = s_in + "/" + s_Marka;
						f_in = new File(s_in);

						if (f_in.exists()) { // Marka
//							System.out.println("���� Marka ����");
							s_in = s_in + "/" + s_Model;
							f_in = new File(s_in);
							if (f_in.exists()) { // Model
//								System.out.println("���� Model ����");
								s_in = s_in + "/" + s_SN;
							} else {
//								System.out.println("���� Model �� ����");
								// ��������� ������� ������ � ������� �����
								f_in = new File(s_in);
								f_in.mkdir();
								s_in = s_in + "/" + s_SN;
							}
						} else {
//							System.out.println("���� �� ����");
							// ��������� ������� �����
							f_in = new File(s_in);
							f_in.mkdir();
							// ��������� ������� ������ � ������� �����
							s_in = s_in + "/" + s_Model;
							f_in = new File(s_in);
							f_in.mkdir();
							s_in = s_in + "/" + s_SN;
						}
						// ��������� ������� SN � ������� �����						
						f_in = new File(s_in);
						f_in.mkdir();

						try {
							for (String path_dani : Menu.fileInDirect(s_out)) {
								f_out = new File(s_out + "/" + path_dani);
								f_in = new File(s_in + "/" + path_dani);
								copyFile(f_out, f_in);
								delete(f_out);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						File f_outDeleteSN = new File(s_out);
						delete(f_outDeleteSN);
						
						komentar("������� ���������");
						setVisible(false);						
						
						Pryntery.pisliaPeremishchenia((String) cB_Mistse.getSelectedItem(), (String) cB_Mistse2.getSelectedItem());
					}
				}
			}
		});
		b_Save.setBounds(27, 175, 473, 29);
		getContentPane().add(b_Save);
		
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
		b_Misce2.setBounds(273, 123, 227, 20);
		getContentPane().add(b_Misce2);
		
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
					komentar("�� �� ����� ����� ���� ������������");
				} else {

					if (al_Mictce.get(0) == "") {
						al_Mictce.remove(0); // ������ ����� �������� � �����,
							// �� ������� �� ���� ���� � ������
					}

					int i_KatalogaNema = 0;

					for (int i = 0; i < al_Mictce.size(); i++) {
						if (tF_Mistce.getText().equals(al_Mictce.get(i))) {
							komentar("���� ����� ��� ����");
							i_KatalogaNema = 1;
						}
					}

					if (i_KatalogaNema == 0) {
						// ��������� ����� ������� ��� ������� � ���
						// ����������
						File file = new File(s_Path_Mictce
								+ tF_Mistce.getText());
						file.mkdir();

						komentar("̳��� ���������");

						// ���������� ���� ���� � ������ �� ������
						al_Mictce.add(0,tF_Mistce.getText());   // ���������� � ������� ������
						s_mas_Misctce = al_Mictce.toArray(new String[al_Mictce
								.size()]);
						cB_Mistse.setModel(new DefaultComboBoxModel(
								s_mas_Misctce));

						al_Mictce2.add("");
					}
				}
			}
		});

		l_SaveMisce.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMisce);

		tF_Mistce2 = new JTextField();
		tF_Mistce2.setHorizontalAlignment(SwingConstants.CENTER);
		tF_Mistce2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		getContentPane().add(tF_Mistce2);
		l_SaveMisce2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tF_Mistce2.getText().equals(null)
						|| tF_Mistce2.getText().equals("")
						|| tF_Mistce2.getText().equals(" ")
						|| tF_Mistce2.getText().equals("  ")
						|| tF_Mistce2.getText().equals("   ")) {
					komentar("�� �� ����� ����� ���� ������������");
				} else {
					
					// ������ ����� �������� � �����, �� �������
					// �� ���� ���� � ������
					if (al_Mictce2.get(0) == "") {
						al_Mictce2.remove(0);
					}

					int i_KatalogaNema = 0;

					for (int i = 0; i < al_Mictce2.size(); i++) {
						if (tF_Mistce2.getText().equals(al_Mictce2.get(i))) {
							komentar("���� ����� ��� ����");
							i_KatalogaNema = 1;
						}
					}

					if (i_KatalogaNema == 0) {
						// ��������� ����� ������� ��� ������� � ���
						// ����������
						
						File file = new File(s_Path_Mictce 
								+ (String) cB_Mistse.getSelectedItem()+ "/"
										+ tF_Mistce2.getText());
						file.mkdir();

						komentar("̳��� ���������");

						// ���������� ���� ���� � ������ �� ������
						al_Mictce2.add(0,tF_Mistce2.getText());   // ���������� � ������� ������
						s_mas_Misctce2 = al_Mictce2.toArray(new String[al_Mictce2
								.size()]);
						cB_Mistse2.setModel(new DefaultComboBoxModel(
								s_mas_Misctce2));
						
//						al_Marka.add("");
					}
				}
			}
		});

		l_SaveMisce2.setIcon(new ImageIcon("res/icon_save.png"));
		getContentPane().add(l_SaveMisce2);

		

		// l_fon = new JLabel("");
		// l_fon.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		// // l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
		// l_fon.setBounds(-1, 0, 995, 565);
		// getContentPane().add(l_fon);
		
		setVisible(true);
	}
	
	void komentar(String text) {
		// ������� ���� , �� � ������ ��� �����
		setAlwaysOnTop(false); 
		JOptionPane.showMessageDialog(null, text);
		setAlwaysOnTop(true);
	}
	
	// ������� � ������� ����� ����������� ����� � Java 7
	private static void copyFile(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}
	
	private void delete(final File file) {
//		System.out.println("��a��em �a��: " + file.getAbsolutePath());
		if(file.isDirectory()) {
			String[] files = file.list();
			if((null == files) || (files.length == 0)) {
				file.delete();
				} else {
					for(final String filename: files) {
						delete(new File(file.getAbsolutePath() + File.separator
								+ filename)); 
						}
					file.delete();
					}
			} else {
				file.delete();
				}
	}

}
