package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller.ControladorTipologiaSexo;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.TipologiaSexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JLabel lblNewLabel_3;
	private JComboBox<TipologiaSexo> jcbSexo;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 2;
		add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 0, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 3;
		add(jcbSexo, gbc_jcbSexo);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		btnNewButton = new JButton("Elegir imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		
		
		cargarTipologiasSexo();
//		this.setIdTipologiaSexo(2);
		TipologiaSexo t = ControladorTipologiaSexo.findById(2);
		this.setTipologiaSexo(t);
	}

	/**
	 * 
	 */
	private void cargarTipologiasSexo() {
		for (TipologiaSexo t : ControladorTipologiaSexo.findAll()) {
			this.jcbSexo.addItem(t);
		}		
	}
	
	/**
	 * 
	 */
	private void elegirImagen() {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					byte[] contenidoImagen = Files.readAllBytes(fichero.toPath());
					ImageIcon icono = new ImageIcon(contenidoImagen);
					JLabel lblIcono = new JLabel(icono);
					scrollPane.setViewportView(lblIcono);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId (int id) {
		this.jtfId.setText("" + id);
	}
	
	public void setNombre (String nombre) {
		this.jtfNombre.setText(nombre);
	}
	
//	public void setIdTipologiaSexo (int idTipo) {
//		for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
//			if (this.jcbSexo.getItemAt(i).getId() == idTipo) {
//				this.jcbSexo.setSelectedIndex(i);
//			}
//		}
//	}
	
	
	public void setTipologiaSexo(TipologiaSexo t) {
		this.jcbSexo.setSelectedItem(t);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId () {
		return Integer.parseInt(this.jtfId.getText());
	}
	
	public String getNombre() {
		return this.jtfNombre.getText();
	}
	
	public int getIdTipologiaSexo() {
//		TipologiaSexo t = (TipologiaSexo) this.jcbSexo.getSelectedItem();
//		return t.getId();
		return ((TipologiaSexo) this.jcbSexo.getSelectedItem()).getId();
	}
}
