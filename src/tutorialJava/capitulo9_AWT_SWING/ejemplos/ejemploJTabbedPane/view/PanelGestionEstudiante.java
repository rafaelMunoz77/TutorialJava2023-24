package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.view;

import javax.swing.JPanel;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller.ControladorEstudiante;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller.ControladorMateria;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Curso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Estudiante;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Materia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionEstudiante extends JPanel {
	
	PanelDatosPersonales datosPersonales = new PanelDatosPersonales();
	
	/**
	 * Create the panel.
	 */
	public PanelGestionEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0};
//		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión del estudiante");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(this.datosPersonales, gbc_lblNewLabel_1);

	}
	
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Estudiante o) {
		if (o != null) {
			this.datosPersonales.setId(o.getId());
			this.datosPersonales.setNombre(o.getNombre());
//			this.jtfAcronimo.setText(m.getAcronimo());			
		}		
	}

}
