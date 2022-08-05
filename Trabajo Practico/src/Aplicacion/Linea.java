package Aplicacion;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Linea extends JPanel {
	
	public Linea() {
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setBackground(Color.decode("#DEDEDE"));
		
		this.add(new JLabel("Linea"), new GBC(0,1).setWeight(0, 0.1).setAnchor(GBC.NORTHWEST).setFill(GBC.HORIZONTAL).setInsets(5,5,5,5));
		this.add(new JButton("Nuevo"), new GBC(0,1).setWeight(0, 0.9).setFill(GBC.HORIZONTAL).setInsets(5,5,5,5));
		this.add(new JButton("Modificar"), new GBC(1,1).setInsets(5,5,5,5));
		this.add(new JButton("Eliminar"), new GBC(2,1).setInsets(5,5,5,5));
	}
	
}
