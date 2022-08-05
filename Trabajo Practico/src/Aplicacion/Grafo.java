package Aplicacion;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Grafo extends JPanel{
	
	private ArrayList<Punto> listaP;
	//private ArrayList<Camino> listaC; 
	public Grafo() {
		this.setVisible(true);
		this.setBackground(Color.decode("#FFFB86"));
		this.setBounds(10,10,500,500);
		this.listaP = new ArrayList<Punto>();
	}
	
	public void AgregarNodo() {
		// cambiar de color a un nodo
	}
	// MODIFICAR COMO PINTA EL GRAFO
	public void pintarGrafo(Graphics g, int a, int b) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.black);
		Punto p = new Punto(a,b);
		g2.fill(p);
		listaP.add(p);
	}
	
	public void pintarLinea(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Punto p = new Punto(0,0);
		listaP.add(p);
		g2.fillOval(0,0, 20, 20);
		g2.setColor(Color.black);
		g2.draw(p);
		
	}
	
	
}
