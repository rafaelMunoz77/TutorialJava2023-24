package tutorialJava.capitulo9_AWT_SWING.v07_CreacionPanelesGestionAutomaticosConReflexionYJPA;

import java.awt.Component;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;

/**
 * En la clase PanelGestionEntidadJPA se hizo un esfuerzo de generalizaci�n pero, a�n as�, la cantidad de c�digo generada por 
 * el programador cuando desea utilizarlo sigue siendo alta. En una gran cantidad de ocasiones el programador desea crear paneles
 * de gesti�n muy parecidos. Por todo esto se ha creado este Panel de gesti�n de una entidad JPA MEJORADO. 
 * En este panel lo �nico que hay que hacer es crear una instancia del mismo y �l s�lo se ajusta.
 * 
 * B�sicamente, este panel extiende del PanelGestionEntidadJPA, implementando sus m�todos abstractos a trav�s del uso de la 
 * Reflexi�n de Java, ubicada en el paquete java.lang.reflect. Personalmente me encanta el uso que le podemos dar a ese paquete, ya
 * que permite automatizar much�simas tareas muy tediosas para los programadores.
 * 
 * Para que todo funcione s�lo necesitamos los siguientes requisitos
 *    - Nos deben proporcionar una clase, correspondiente al tipo de entidad JPA que se desa gestionar
 *    - Nos deben proporcionar un controlador, subtipo de Controlador y que corresponda con el tipo de entidad JPA gestionada
 *    - Opcionalmente, en otro constructor, se puede introducir un array de etiquetas para visualizar, por si las autom�ticas no 
 *        son del agrado del programador, ya que corresponden con los nombres de los campos de entidad JPA.
 * @author R
 *
 */

public class PanelGestionEntidadJPAConReflexion extends PanelGestionEntidadJPA {

	// Variables internas a utilizar: la entidad JPA gestionada, la clase de esta entidad y el controlador JPA
	private Entidad entidadGestionada = null;
	private Class claseDeEntidadGestionada = null;
	private Controlador controladorDeEntidad = null;
	// Clase del supertipo de todos los controladores JPA
	private Class claseSuperTipoControladoresJPA = null;
	
	// Los componentes visuales generados autom�ticamente se incorporan en dos lugares: por un lado se incorporan
	// a una HashMap, de manera que cada componete visual (JTextField, JComboBox, etc.) se convierte en el objeto guardado en la
	// misma, y como "key" para localizarla se utiliza el nombre del campo de la entidad JPA gestionada. 
	// Por otra parte, tambi�n se guardan los componentes en una List, para poder guardar un determinado orden con ellos.
	// El orden en el que se crean corresponde con el orden que tienen en su declaraci�n de la entidad JPA, es decir, el orden que
	// tienen dentro del c�digo de la clase de la entidad JPA correspondiente.
	private HashMap<String, Component> hmComponentesVisuales = new HashMap<String, Component>();
	private List<Component> listComponentesVisuales = new ArrayList<Component>();
	// Para mostrar los componentes en pantalla, tambi�n usamos unas etiquetas, obtenidas de los nombres de los campos de la entidad
	// JPA. Esos nombres se capitalizan (se pone en may�scula su primera letra).
	private List<String> listEtiquetasComponentesVisuales = new ArrayList<String>();
	
	// Array con los tipos de datos permitidos en este panel. Con el tiempo esta lista deber�a ir creciendo.
	// Adem�s de estos tipos de datos, tambi�n se gestionan todos los tipos de datos que extienden de "Entidad"
	private Class tiposDeDatosPermitidos[] = new Class[] {String.class, int.class, float.class};
	
	/**
	 * 
	 * @param clase
	 * @param controlador
	 */
	public PanelGestionEntidadJPAConReflexion(Class clase, Controlador controlador) {
		super();
		this.controladorDeEntidad = controlador;
		this.claseDeEntidadGestionada = clase;
		try {
			// Construyo una entidad gestionada a partir de la clase que me han especificado en el constructor
			this.entidadGestionada = this.construirEntidadAPartirDeClase(this.claseDeEntidadGestionada);
			
			// Localizo el supertipo de todos los controladores JPA de este proyecto
			this.claseSuperTipoControladoresJPA = Controlador.class;
			
			// Recorro los campos que nos interesan de la entidad gestionada
			for (Field field : getFieldsAGestionarEnPanel()) {
				// Obtengo un nombre capitalizado del campo, me ser� de utilidad para: 
				//    - La etiqueta del campo.
				// 	  - La "key" con la que guardar� en la HashMap el componente visual (JTextField, JComboBox, et.) que me dispongo a crear ahora.
				String nombreFieldCapitalizado = capitalizar(field.getName());
				// Creo un componente visual gen�rico
				Component componenteVisual = null;
				// Si el Field que estoy navegando es un String, o un int, o un float, creo un nuevo componente de tipo JTextField
				if (field.getType() == String.class || field.getType() == int.class || field.getType() == float.class) {
					JTextField jtf = new JTextField(40);
					// En el caso de que el campo sea identificador, deshabilito el componente para la edici�n
					if (nombreFieldCapitalizado.equals("Id")) {
						jtf.setEnabled(false);
					}
					componenteVisual = jtf;
				}
				// Si el Field es de tipo Entidad, debo crear un JComboBox y rellenarlo con una lista de todas las entidades del tipo correspondiente
				if (esSubtipoDeEntidad(field.getType())) {
					// Creo un JComboBox para representar este campo
					JComboBox<Entidad> jcb = new JComboBox<Entidad>();
					componenteVisual = jcb;
					// Ahora debo a�adir items al JComboBox
					// Busco un controlador para el tipo del Field
					Controlador controladorDelField = getIntanciaDeControladorAsociadoAUnaEntidadJPA(field.getType());
					// Ya tengo una instancia del controlador cuyo tipo gestionado es el mismo que el del Field
					// Ahora llamo a su m�todo para encontrar a todos los registros de la BBDD
					Method metodoFindAll = this.claseSuperTipoControladoresJPA.getDeclaredMethod("findAll");
					// Una vez localizado el m�todo "findAll", lo invoco
					List<Entidad> entidades = (List<Entidad>) metodoFindAll.invoke(controladorDelField);
					// Del listado de entidades que obtengo, hago un bucle para a�adir elementos al JComboBox
					for (Entidad entidad : entidades) {
						jcb.addItem(entidad);
					}
				}
				
				// Si se ha creado correctamente el componente visual (JTextField, JComboBox, etc.), lo incluyo en la HashMap y Listas correspondientes
				if (componenteVisual != null) {
					// En la HashMap, el nombre del Field (capitalizado), servir� como "key" del componente visual
					hmComponentesVisuales.put(nombreFieldCapitalizado, componenteVisual);
					// Una vez creado el componente en la HashMap, tambi�n los guardo en una lista, para que
					// se puedan construir en el orden correcto sobre la pantalla
					listComponentesVisuales.add(componenteVisual);
					// Creo una etiqueta por defecto para el nombre campo. Esta etiqueta saldr� en la pantalla.
					listEtiquetasComponentesVisuales.add(nombreFieldCapitalizado);
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Maqueto el panel, para que todos los componentes se sit�en en su lugar
		this.maquetarPanel();
	}
	
	
	/**
	 * Obtiene una lista de los campos "Fields" de la entidad JPA que deseamos gestionar.
	 * Son campos que no pueden ser est�ticos.
	 * @return
	 */
	private List<Field> getFieldsAGestionarEnPanel () {
		List<Field> fields = new ArrayList<Field>();
		// Voy a navegar para descubrir los campos dentro de la entidad instanciada
		// Para poder acceder a campos "private" necesito el m�todo "getDeclaredFields()"
		for (Field field : this.claseDeEntidadGestionada.getDeclaredFields()) {
			// S�lo me interesan los campos no est�ticos
			if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				// Detecto si el tipo del Field es alguno de los permitidos
				for (Class tipoPermitido : this.tiposDeDatosPermitidos) {
					if (field.getType() == tipoPermitido) {
						fields.add(field);
					}
				}
				// Una vez vistos los tipos de datos "normales", investigo tambi�n si el tipo
				// del Field es un subtipo de la clase Entidad.
				if (this.esSubtipoDeEntidad(field.getType())) {
					fields.add(field);
				}
			}
		}
		// Devuelvo la lista de Fields que nos interesa gestionar
		return fields;
	}
	
	/**
	 * Comprueba si el tipo pasado como argumento es un subtipo de la clase Entidad
	 * @param tipo
	 * @return
	 */
	private boolean esSubtipoDeEntidad (Class tipo) {
		return (Entidad.class.isAssignableFrom(tipo));
	}
	
	/**
	 * 
	 * @param tipo
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private Entidad construirEntidadAPartirDeClase (Class tipo) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// Obtengo el constructor por defecto para el tipo suministrado com argumento de entrada
		Constructor<Entidad> constructor = tipo.getConstructor();
		// Instancio la entidad
		Entidad nuevaEntidadInstanciada = constructor.newInstance();
		return nuevaEntidadInstanciada;
	}
	
	/**
	 * 
	 * @param tipoDeEntidadJPA
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private Controlador getIntanciaDeControladorAsociadoAUnaEntidadJPA (Class tipoDeEntidadJPA) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// A partir del Controlador suministrado a este panel, obtengo la carpeta en la que se guardan todos los controladores.
		String paqueteDeControladores = this.controladorDeEntidad.getClass().getPackage().getName();
		// A partir del paquete anterior y del nombre de la entidad JPA en la que estamos interesados, localizo la clase del
		// controlador que necesitamos
		Class claseControladoraDeEntidadJPA = Class.forName(paqueteDeControladores + "." + tipoDeEntidadJPA.getSimpleName() + "Controlador");
		// Para obtener una instancia, obtengo el m�todo "getInstancia", sin argumentos
		Method metodoGetInstancia = claseControladoraDeEntidadJPA.getDeclaredMethod("getInstancia");
		// Invoco al m�todo, recojo el Object como resultado de la invocaci�n y lo casteo a "Controlador".
		Controlador controladorDeEntidadJPA = (Controlador) metodoGetInstancia.invoke(null);
		// Devuelvo la instancia del controlador
		return controladorDeEntidadJPA;
	}
	
	/**
	 * Capitalizar un string significa poner en may�scula su primera letra
	 * @param str
	 * @return
	 */
	private String capitalizar(final String str) {
		   return Character.toUpperCase(str.charAt(0)) + str.substring(1);
		}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 */
	@Override
	public Entidad getEntidadActualReflejadaEnPanel() {
		return this.entidadGestionada;
	}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 */
	@Override
	protected void setEntidadActualReflejadaEnPanel(Entidad e) {
		this.entidadGestionada = e;
	}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 */
	@Override
	protected Controlador getControladorJPA() {
		return this.controladorDeEntidad;
	}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 * 
	 * Tenemos en esta clase una List de String que sirve como etiquetas del panel, en este m�todo simplemente se
	 * transforman en un array de Strings
	 */
	@Override
	protected String[] getEtiquetasComponentesVisuales() {
		String[] etiquetas = new String[this.listEtiquetasComponentesVisuales.size()];
		for (int i = 0; i < etiquetas.length; i++) {
			etiquetas[i] = this.listEtiquetasComponentesVisuales.get(i).toString();
		}
		return etiquetas;
	}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 *
	 * Tenemos en esta clase una List de Component que sirve como etiquetas del panel, en este m�todo simplemente se
	 * transforman en un array de Component. El "Component" es el supertipo de todos los componentes visuales en Java
	 */
	@Override
	protected Component[] getComponentesVisuales() {
		Component[] componentes = new Component[this.listComponentesVisuales.size()];
		for (int i = 0; i < componentes.length; i++) {
			componentes[i] = (Component) this.listComponentesVisuales.get(i);
		}
		return componentes;
	}

	
	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 * 
	 * Este es uno de los m�todos principales de esta clase. Se dedica a cargar la informaci�n correcta dentro
	 * de cada JTextField, JComboBox, etc.
	 * 
	 * Para llevar a cabo su cometido, esta clase recorre todos los componentes visuales que se han creado
	 * (en el constructor de esta clase) y se han almacenado en la HashMap hmComponentesVisuales.
	 * Por cada componente visual (JTextField, JComboBox, etc.) se buscara un m�todo getter en la entidad JPA
	 * gestionada por este panel. A partir de la invocaci�n a ese m�todo getter obtenemos el valor que debemos
	 * establecer en el componente visual.
	 */
	@Override
	protected void cargarEntidadActualEnComponentesVisuales() {
		// Recorro el conjunto de componentes de la HashMap para llamar a sus m�todos correspondientes con respecto
		// a la entidad gestionada de este panel
		Iterator<String> itNombresCampos = this.hmComponentesVisuales.keySet().iterator();
		while (itNombresCampos.hasNext()) {
			try {
				// Hay que recordar que los componentes visuales se han almacenado en la HashMap con un "key" igual
				// al nombre del campo de la entidad JPA (nombre capitalizado). Por ejemplo, el JTextField que 
				// muesta el campo "id" de la entidad se ha guardado en la HashMap con el "key" "Id". Otro ejemplo:
				// si la entidad tiene un campo String llamado "nombre", se ha guardado en la HashMap un JTextField
				// con el "key" "Nombre". Todo esto nos permite tomar ese nombre y acceder a los m�todos "getter" de
				// la entidad. Por ejemplo, para obtener el m�todo "getNombre()" combinaremos la palabra "get" con el
				// nombre del campo, ya capitalizado.
				String nombreCampo = itNombresCampos.next();
				Component componenteVisual = this.hmComponentesVisuales.get(nombreCampo);
				// Compruebo el tipo de componente visual
				// Si el componente es un JTextField
				if (componenteVisual instanceof JTextField) { 
					JTextField jtf = (JTextField) componenteVisual;
					// Obtengo el m�todo getter
					Method metodoGetter = this.claseDeEntidadGestionada.getDeclaredMethod("get" + nombreCampo);
					if (metodoGetter != null) {
						// Invoco al m�todo y obtengo el object devuelto por �l para comprobar su tipo
						Object respuestaDelMetodo = metodoGetter.invoke(this.entidadGestionada);
						// El objeto devuelto por el m�todo puede ser de diferentes tipo. Para cada tipo debo
						// tratarlo correctamente.
						if (respuestaDelMetodo instanceof String) {
							jtf.setText(respuestaDelMetodo.toString());
						}
						else if (respuestaDelMetodo instanceof Integer) {
							jtf.setText("" + ((Integer)respuestaDelMetodo).intValue());
						}
						else if (respuestaDelMetodo instanceof Float) {
							jtf.setText("" + ((Float)respuestaDelMetodo).floatValue());
						}
					}
				}
				// Si el componente visual es un JComboBox, se debe a que el m�todo "getter" nos va a devolver un
				// objeto que, de alg�n modo, es un subtipo de la clase Entidad. Debo tomar ese objeto y compararlo
				// con los objetos del JComboBox, de esa manera podr� establecer el valor correcto dentro de ese
				// JComboBox
				if (componenteVisual instanceof JComboBox) { 
					JComboBox<Entidad> jcb = (JComboBox<Entidad>) componenteVisual;
					// Obtengo el m�todo getter
					Method metodoGetter = this.claseDeEntidadGestionada.getDeclaredMethod("get" + nombreCampo);
					if (metodoGetter != null) {
						// Invoco al m�todo y obtengo el object devuelto por �l para comprobar su tipo
						Object respuestaDelMetodo = metodoGetter.invoke(this.entidadGestionada);
						if (respuestaDelMetodo instanceof Entidad) {
							Entidad entidadDevueltaMetodoGetter = (Entidad) respuestaDelMetodo;
							// Recorro los objetos del JComboBox, buscando a cu�l igualar con la respuesta del m�todo
							for (int i = 0; i< jcb.getItemCount(); i++) {
								// Si los identificadores son iguales, asumo que es el mismo objeto.
								if (jcb.getItemAt(i).getId() == entidadDevueltaMetodoGetter.getId()) {
									jcb.setSelectedIndex(i);
								}
							}
						}
					}
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * M�todo abstracto implementado, para m�s informaci�n se debe consultar la clase PanelGestionEntidadJPA
	 * 
	 * Este m�todo tiene la finalidad de recoger la informaci�n expuesta en los componentes visuales del panel y
	 * crear una entidad JPA que recoja toda esa informaci�n.
	 * 
	 * Para llevar a cabo esta tarea, recorrer� los campos de la entidad JPA, me quedar� con los que me interesan,
	 * localizar� el m�todo "setter" que corresponda a cada campo y el componente visual en el que se muestra la 
	 * informaci�n. Con todo eso podr� cargar la informaci�n en la nueva entidad
	 */
	@Override
	protected Entidad construirEntidadDesdeComponentesVisuales() {
		Entidad nuevaEntidad = null;
		try {
			// Construyo una nueva Entidad JPA, de la misma clase que la entidad JPA gestionada en este panel
			nuevaEntidad = this.construirEntidadAPartirDeClase(this.claseDeEntidadGestionada);
			
			// Recorro los campos que nos interesan de la entidad gestionada
			for (Field field : getFieldsAGestionarEnPanel()) {
				String nombreCampoCapitalizado = capitalizar(field.getName());
				// Si el Field que estoy navegando es un String, obtengo el componente JTextField correspondiente
				if (field.getType() == String.class) {
					// Obtengo el JTextField asociado a este campo
					JTextField jtf = (JTextField) this.hmComponentesVisuales.get(nombreCampoCapitalizado);
					if (jtf != null) {
						// Localizo el m�todo "setter" correspondiente y lo invoco
						Method metodoSetter = this.claseDeEntidadGestionada.getDeclaredMethod("set" + nombreCampoCapitalizado, String.class);
						metodoSetter.invoke(nuevaEntidad, jtf.getText());
					}
				}
				// Si el Field es un int necesito hacer una conversion
				if (field.getType() == int.class) {
					JTextField jtf = (JTextField) this.hmComponentesVisuales.get(nombreCampoCapitalizado);
					if (jtf != null) {
						// Localizo el m�todo "setter" correspondiente y lo invoco
						Method metodoSetter = this.claseDeEntidadGestionada.getDeclaredMethod("set" + nombreCampoCapitalizado, int.class);
						// Tengo que convertir el texto a un n�mero
						int valorEntero;
						if (jtf.getText().trim().equals("")) {
							valorEntero = 0;
						}
						else {
							valorEntero = Integer.parseInt(jtf.getText());
						}
						// Finalmente con el valor entero elegido invoco al setter
						metodoSetter.invoke(nuevaEntidad, valorEntero);
					}
				}
				// Si el Field es un float necesito hacer una conversion
				if (field.getType() == float.class) {
					JTextField jtf = (JTextField) this.hmComponentesVisuales.get(nombreCampoCapitalizado);
					if (jtf != null) {
						Method metodoSetter = this.claseDeEntidadGestionada.getDeclaredMethod("set" + nombreCampoCapitalizado, float.class);
						// Tengo que convertir el texto a un n�mero flotante
						float valorFlotante;
						if (jtf.getText().trim().equals("")) {
							valorFlotante = 0;
						}
						else {
							valorFlotante = Float.parseFloat(jtf.getText());
						}
						// Finalmente con el valor flotante elegido invoco al setter
						metodoSetter.invoke(nuevaEntidad, valorFlotante);
					}
				}
				// Si el Field es de un subtipo de la clase Entidad, su componente visual asociado es un JComboBox
				// Debo obtener el objeto guardado dentro del mismo.
				if (esSubtipoDeEntidad(field.getType())) {
					JComboBox<Entidad> jcb = (JComboBox<Entidad>) this.hmComponentesVisuales.get(nombreCampoCapitalizado);
					if (jcb != null) {
						// Localizo el m�todo setter y lo invoco
						Method metodoSetter = this.claseDeEntidadGestionada.getDeclaredMethod("set" + nombreCampoCapitalizado, field.getType());
						metodoSetter.invoke(nuevaEntidad, jcb.getItemAt(jcb.getSelectedIndex()));
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nuevaEntidad;
	}
	
}
