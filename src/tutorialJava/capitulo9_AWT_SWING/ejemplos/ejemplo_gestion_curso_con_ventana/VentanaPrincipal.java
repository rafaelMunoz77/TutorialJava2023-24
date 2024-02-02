package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo_gestion_curso_con_ventana;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setContentPane(getPanelPrincipal());
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelPrincipal() {
		JPanel jpn = new JPanel();
		jpn.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 10, 10, 10);
		c.weighty = 0;
		
		JLabel lbl = new JLabel("Soy un jlabel:");
		jpn.add(lbl, c);
		
		c = new GridBagConstraints();
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.weightx = 1;
		
		JTextField jtf = new JTextField("Este es mi valor");
		jpn.add(jtf, c);
		
		c = new GridBagConstraints();
		c.gridy = 0;
		c.gridx = 2;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		
		JButton jbt = new JButton("Esto es un botón");
		jpn.add(jbt, c);
		
		c = new GridBagConstraints();
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.EAST;
		c.weighty = 0;
		
		JLabel lbl2 = new JLabel("Segundo JLabel:");
		jpn.add(lbl2, c);
		
		c = new GridBagConstraints();
		c.gridy = 2;
		c.gridx = 0;
		c.weightx = 0;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		
		JPanel jpn2 = new JPanel();
//		jpn2.setBackground(Color.RED);
		jpn.add(jpn2, c);
		
		
		return jpn;
	}
}
