package tutorialJava.capitulo7_Recursos.ejemploNumeroImparListener;

public class NumeroImparEvent {
	private int numeroIntroducido;

	/**
	 * @param numeroIntroducido
	 */
	public NumeroImparEvent(int numeroIntroducido) {
		super();
		this.numeroIntroducido = numeroIntroducido;
	}

	public int getNumeroIntroducido() {
		return numeroIntroducido;
	}

	public void setNumeroIntroducido(int numeroIntroducido) {
		this.numeroIntroducido = numeroIntroducido;
	}
	
	
}
