package tutorialJava.capitulo9_AWT_SWING.v02_LayoutsYPrimerosJComponents.ejemplo01BorderLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

import tutorialJava.capitulo9_AWT_SWING.utils.Apariencia;

public class VentanaPrincipal extends JFrame {

	static {
		try {
			Apariencia.setApariencia(Apariencia.WINDOWS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		this.setBounds(0, 0, 800, 600);
		
		this.setContentPane(getPanelPrincipal());
	}
	
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelPrincipal() {
		JPanel pnl = new JPanel();

		pnl.setLayout(new BorderLayout());
		
		JProgressBar jpb = new JProgressBar (0, 100);
		jpb.setValue(50);
		jpb.setStringPainted(true);
		pnl.add(jpb, BorderLayout.NORTH);

		JButton jbtBoton = new JButton("Es un botón");
		pnl.add(jbtBoton, BorderLayout.SOUTH);
		
		JSlider js = new JSlider (JSlider.VERTICAL, 0, 100, 50);
		js.setMajorTickSpacing(10);
		js.setMinorTickSpacing(1);
		js.setPaintTicks(true);
		js.setPaintLabels(true);
		pnl.add(js, BorderLayout.WEST);

		
		return pnl;
	}
	
	
	
	public static void main(String[] args) {
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);
	}

}
