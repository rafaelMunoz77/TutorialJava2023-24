package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Cursos", new PanelGestionCurso());
		tabedPane.add("Materia", new PanelGestionMateria());
		tabedPane.add("Estudiante", new PanelGestionEstudiante());
		this.setMinimumSize(new Dimension(800, 600));

		this.setContentPane(tabedPane);
		this.setJMenuBar(new MyJMenuBar(tabedPane));
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
