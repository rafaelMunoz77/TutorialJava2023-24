package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.vista.PanelCurso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.vista.PanelEstudiante;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.vista.PanelMateria;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.vista.PanelValoracionMateriaOpcion1;
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
		PanelMateria panelMateria = new PanelMateria();
		
		JTabbedPane panelTabbed = new JTabbedPane();
		panelTabbed.addTab("Cursos", panelCurso);
		panelTabbed.addTab("Materias", panelMateria);
		panelTabbed.addTab("Estudiantes", new PanelEstudiante());
		panelTabbed.addTab("Valoración Materia", new PanelValoracionMateriaOpcion1());
		panelTabbed.setSelectedIndex(0);
		
		this.getContentPane().add(panelTabbed);
	}
	

	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}

}
