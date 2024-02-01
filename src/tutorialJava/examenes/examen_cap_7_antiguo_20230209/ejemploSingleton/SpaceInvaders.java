package tutorialJava.examenes.examen_cap_7_antiguo_20230209.ejemploSingleton;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


/**
 * Clase principal, que crea los monstruos
 *
 */
public class SpaceInvaders {

	private JFrame ventana = null;
	private Canvas canvas = null;
	
	private static SpaceInvaders instance = null; 
	
	public static SpaceInvaders getInstance() {
		if (instance == null) {
			instance = new SpaceInvaders();
		}
		return instance;
	}
	
	
	/**
	 * Constructor
	 */
	public SpaceInvaders () {
		ventana = new JFrame("Space Invaders");
		ventana.setBounds(0, 0, 800, 600);
		
		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		// Envío los eventos de movimientos de ratón al jugador
		canvas.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				UnaClaseQueNoAccedeFacilmenteASpaceInvaders.metodo();
			}
			
		});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		ventana.setVisible(true);
				
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Comienzo un bucle, que consistirá en el juego completo.
		SpaceInvaders.getInstance();
	}


	public Canvas getCanvas() {
		return canvas;
	}
		
}






