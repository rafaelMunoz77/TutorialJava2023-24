package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades;

public class ValoracionMateria {

	private int id;
	private int idProfesor;
	private int idMateria;
	private int idEstudiante;
	private float valoracion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idMateria=" + idMateria
				+ ", idEstudiante=" + idEstudiante + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
}
