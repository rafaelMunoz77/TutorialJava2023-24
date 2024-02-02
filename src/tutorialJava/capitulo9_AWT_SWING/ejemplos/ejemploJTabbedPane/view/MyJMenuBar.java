package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class MyJMenuBar extends JMenuBar {

	JTabbedPane tabPane = null;
	
	
	public MyJMenuBar (JTabbedPane tabPane) {
		this.tabPane = tabPane;
		
		JMenu abrir = new JMenu("Abrir");
		this.add(abrir);
		
		JMenuItem abrirTab1 = new JMenuItem("Cursos");
		abrirTab1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabPane.setSelectedIndex(0);
			}
		});		
		abrir.add(abrirTab1);

		JMenuItem abrirTab2 = new JMenuItem("Materia");
		abrirTab2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabPane.setSelectedIndex(1);
			}
		});		
		abrir.add(abrirTab2);
	
		JMenuItem abrirTab3 = new JMenuItem("Estudiante");
		abrirTab3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabPane.setSelectedIndex(2);
			}
		});		
		abrir.add(abrirTab3);
	
	}
}
