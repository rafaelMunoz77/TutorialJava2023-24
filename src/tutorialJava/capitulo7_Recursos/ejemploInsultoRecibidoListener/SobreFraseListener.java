package tutorialJava.capitulo7_Recursos.ejemploInsultoRecibidoListener;

public interface SobreFraseListener {

	public void insultoRecibido(SobreFraseEvent e);
	
	public void fraseVacia();
	
	public void fraseDemasiadoCorta(SobreFraseEvent e);

}
