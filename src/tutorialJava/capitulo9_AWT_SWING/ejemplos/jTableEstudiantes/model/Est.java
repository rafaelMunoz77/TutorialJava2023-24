package tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@Table(name="estudiante")
@NamedQuery(name="Est.findAll", query="SELECT e FROM Est e")
public class Est implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String direccion;

	private String dni;

	private String email;

	private int idTipologiaSexo;

	@Lob
	private byte[] imagen;

	private String nombre;

	private String telefono;

	public Est() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdTipologiaSexo() {
		return this.idTipologiaSexo;
	}

	public void setIdTipologiaSexo(int idTipologiaSexo) {
		this.idTipologiaSexo = idTipologiaSexo;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}