package tutorialJava.examenes.examen_cap_7_antiguo_20230209.ejemploSingleton;

import java.awt.Canvas;

public class UnaClaseQueNoAccedeFacilmenteASpaceInvaders {

	public static void metodo() {
		Canvas c = SpaceInvaders.getInstance().getCanvas();
		System.out.println("Canvas con dimensiones " + c.getWidth() + 
				"x" + c.getHeight());		
	}
}
