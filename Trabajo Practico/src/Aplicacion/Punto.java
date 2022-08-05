package Aplicacion;

import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Punto extends Ellipse2D.Double{
	
	public static int contador = 0;
	//private int id;
	
	public Punto(int x, int y) {
		//this.id = contador;
		this.x = x;
		this.y = y;
		this.height=10;
		this.width=10;
		contador++;
	}

}
