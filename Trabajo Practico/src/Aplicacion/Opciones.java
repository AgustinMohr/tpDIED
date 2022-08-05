package Aplicacion;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Opciones extends JTabbedPane{
	
	public Opciones(Mapa Mapa) {
		
		this.setBackground(Color.decode("#FFFFFF"));
		this.setVisible(true);
		
		Parada p = new Parada(Mapa);
		this.add(p, "Paradas");
		
		Linea l = new Linea();
		this.add(l, "Lineas");
		
		Incidentes i = new Incidentes();
		this.add(i, "Incidentes");
		
	}
	
	
}
