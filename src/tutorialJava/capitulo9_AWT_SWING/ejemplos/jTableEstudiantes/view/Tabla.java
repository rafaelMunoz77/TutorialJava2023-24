package tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.controller.EstudianteControlador;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.model.Est;

public class Tabla extends JPanel {

	List<Est> estudiantes = new ArrayList<Est>();
	JTable table = null;
	
	/**
	 * 
	 */
	public Tabla () {
		//Creo un objeto JTable con el constructor m�s sencillo del que dispone
		table = new JTable(getDatosDeTabla(), 
				new String[] {"Id", "Nombre", "Primer apellido", "Segundo apellido"});
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		
		// Accedo a los clics realizados sobre la tabla
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getButton() == MouseEvent.BUTTON1) {
					VentanaPrincipal.getInstance().getPanelGestionEstudiante()
					.setEstudiante(estudiantes.get(table.getSelectedRow()));
				}
			}
		});
		
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Object[][] getDatosDeTabla() {
		estudiantes = EstudianteControlador.findAll();
		
		Object[][] matrizDatos = new Object[estudiantes.size()][4];
		
		for (int i = 0; i < estudiantes.size(); i++) {
			matrizDatos[i][0] = estudiantes.get(i).getId();
			matrizDatos[i][1] = estudiantes.get(i).getNombre();
			matrizDatos[i][2] = estudiantes.get(i).getApellido1();
			matrizDatos[i][3] = estudiantes.get(i).getApellido2();
		}
		
		return matrizDatos;
	}
}
