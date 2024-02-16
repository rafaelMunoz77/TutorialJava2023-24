package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploCentroEducativo;

import javax.swing.JFrame;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploCentroEducativo.vista.PanelCurso;
import tutorialJava.capitulo9_AWT_SWING.utils.Apariencia;

public class Principal extends JFrame {
	
	// Establecer la apariencia típica de Windows
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	
	public Principal() {
		super("Gestión de centro educativo");
		
		this.setBounds(0, 0, 800, 600);
		
		PanelCurso panelCurso = new PanelCurso();
		this.getContentPane().add(panelCurso);
	}
	

	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}

}
