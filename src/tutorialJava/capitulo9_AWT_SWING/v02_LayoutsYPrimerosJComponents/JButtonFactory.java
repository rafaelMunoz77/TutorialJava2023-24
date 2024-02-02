package tutorialJava.capitulo9_AWT_SWING.v02_LayoutsYPrimerosJComponents;

import javax.swing.JButton;
import tutorialJava.capitulo9_AWT_SWING.utils.CacheImagenes;

public class JButtonFactory {

	/**
	 * 
	 * @return
	 */
	public static JButton instance () {
		return instance ("JButton");
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	public static JButton instance (String texto) {
		JButton jbt = new JButton(texto);
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono("duke1-32x32.png"));
		return jbt;
	}

}
