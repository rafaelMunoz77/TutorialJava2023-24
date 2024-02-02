package tutorialJava.capitulo9_AWT_SWING.v04_GestionEntidadManejadaPorJPA;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import tutorialJava.capitulo9_AWT_SWING.utils.CacheImagenes;

public class JTabbedPaneGestion extends JTabbedPane {


	/**
	 * 
	 * @return
	 */
	public JTabbedPaneGestion (){
	
		ImageIcon icono = CacheImagenes.getCacheImagenes().getIcono("duke1-32x32.png");
		
		this.addTab("Concesionario", icono, new PanelGestionConcesionario(), "Concesionario");
		this.setSelectedIndex(0);  
	}	
}
