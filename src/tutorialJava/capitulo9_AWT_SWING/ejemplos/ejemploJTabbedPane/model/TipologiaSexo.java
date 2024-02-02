package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model;

public class TipologiaSexo {
	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return descripcion;
	}
	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof TipologiaSexo) {
//			TipologiaSexo t = (TipologiaSexo) obj;
//			if (this.id == t.getId()) {
//				return true;
//			}
//		} 
//		else {
//			return false;
//		}
//		return false;
//	}
//	
	public boolean equals(Object obj) {
		return this.id == ((TipologiaSexo) obj).getId();
	}
	
	
}
