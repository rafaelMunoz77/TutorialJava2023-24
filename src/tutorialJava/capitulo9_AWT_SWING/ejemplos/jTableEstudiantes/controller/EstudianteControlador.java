package tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.jTableEstudiantes.model.Est;



public class EstudianteControlador {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CentroEducativo");
	
	
	public static List<Est> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Est.class);
		List<Est> l = (List<Est>) q.getResultList();
		
		em.close();
		return l;
	}
	
	

}
