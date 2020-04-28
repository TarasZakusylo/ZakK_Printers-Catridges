/**
 * @author Taras.Zakusylo
 *	Програма для моніторингу стану та кількості принтерів,
 *  а також для резервування картриджів.
 *  v1.1.1
 */

/**
 * Це стартовий клас із входом в програму. Його задача запустити програму та
 * перенаправити в меню чи вікно авторизації
 */

public class App {

	final static String s_NameProduct = "Облік принтерів та картриджів";

	public static void main(String[] args) {
//		new Avtoryzacia(s_NameProduct);
		new Menu(s_NameProduct);
	}
}
