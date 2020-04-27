import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 */

public class People extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label_Shapka;
	private JButton b_Pryntery;
	private JLabel l_fon;

	public People(final String s_NameProduct) {
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

		b_Pryntery = new JButton("\u041F\u0440\u0438\u043D\u0442\u0435\u0440\u0438");
		b_Pryntery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new People(s_NameProduct);
			}
		});
		b_Pryntery.setForeground(new Color(0, 0, 0));

		b_Pryntery.setFont(new Font("Impact", Font.PLAIN, 25));
		b_Pryntery.setBounds(62, 83, 215, 36);
		getContentPane().add(b_Pryntery);


		
				l_fon = new JLabel("");
				//		l_fon.setIcon(new ImageIcon("res/fon/fon_Avtoruzacia.jpg"));
						l_fon.setBounds(-1, 0, 995, 565);
						getContentPane().add(l_fon);

		setVisible(true);
	}
}
