package tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.controller.EstudianteControlador;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.model.Est;

import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.util.List;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private PanelGestionEstudiante panelGestionEstudiante = new PanelGestionEstudiante();
	private Tabla tabla = new Tabla();

	private static VentanaPrincipal singleton = null;
	
	/**
	 * 
	 * @return
	 */
	public static VentanaPrincipal getInstance() {
		if (singleton == null) {
			singleton = new VentanaPrincipal();
		}
		return singleton;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		
		EstudianteControlador.findAll();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal.getInstance().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);

		tabla.setMinimumSize(new Dimension(100, 100));
		splitPane.setLeftComponent(tabla);
//		splitPane.setDividerLocation(0.7);

		splitPane.setRightComponent(panelGestionEstudiante);
		
	}


	public PanelGestionEstudiante getPanelGestionEstudiante() {
		return panelGestionEstudiante;
	}

	
	
}
