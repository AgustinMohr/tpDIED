package Aplicacion;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Programa extends JFrame{

	public Programa(String s) {
		
		this.setTitle(s);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		
		Mapa m = new Mapa();
		this.add(m, new GBC(1,0).setWeight(0.9, 0.9).setFill(GBC.BOTH).setInsets(5,5,5,5));
		
		Opciones op = new Opciones(m);
		this.add(op, new GBC(0,0).setWeight(0.1, 0.1).setFill(GBC.BOTH).setInsets(5,5,5,5));
		
		this.pack();
		this.setSize(1000,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
