package tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class MiJRadioButtonKk extends JRadioButton {
	
	int idDisciplina;

	public MiJRadioButtonKk() {
	}

	public MiJRadioButtonKk(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public MiJRadioButtonKk(Icon icon) {
		super(icon);
	}

	public MiJRadioButtonKk(Action a) {
		super(a);
	}

	public MiJRadioButtonKk(String text) {
		super(text);
	}

	public MiJRadioButtonKk(Icon icon, boolean selected) {
		super(icon, selected);
	}

	public MiJRadioButtonKk(String text, boolean selected) {
		super(text, selected);
	}

	public MiJRadioButtonKk(String text, Icon icon) {
		super(text, icon);
	}

	public MiJRadioButtonKk(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	
	
}
