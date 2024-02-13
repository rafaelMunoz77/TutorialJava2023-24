package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploGestionGraficaFabricante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class VentanaFabricante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfCif;
	private JTextField jtfNombre;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFabricante frame = new VentanaFabricante();
					frame.setVisible(true);
					frame.cargarPrimero();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestión de fabricantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CIF:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		contentPane.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnNewButton.setIcon(new ImageIcon(VentanaFabricante.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(VentanaFabricante.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(VentanaFabricante.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = ConnectionManager.getConexion();
					Fabricante f = GestionFabricante.getUltimo(conn);
					cargaFabricanteEnPantalla(f);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(VentanaFabricante.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		panel.add(btnNewButton_3);
	}
	
	/**
	 * 
	 */
	private void cargarPrimero () {
		try {
			Connection conn = ConnectionManager.getConexion();
			Fabricante f = GestionFabricante.getPrimero(conn);
			cargaFabricanteEnPantalla(f);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param f
	 */
	private void cargaFabricanteEnPantalla(Fabricante f) {
		if (f != null) {
			jtfId.setText("" + f.getId());
			jtfCif.setText(f.getCif());
			jtfNombre.setText(f.getNombre());
		}
	}

}




