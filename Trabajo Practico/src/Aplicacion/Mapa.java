package Aplicacion;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Mapa extends JPanel{

	Grafo g;
	
	public Mapa() {

		this.setBackground(Color.decode("#DEDEDE"));
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		JLabel Etiqueta1 = new JLabel("Ciudad de Santa Fe");
		this.add(Etiqueta1, new GBC(0, 0).setWeight(0.01, 0.01).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL));
		g = new Grafo();
		//g.Inicializar();
		this.add(g, new GBC(1, 1).setWeight(1, 1).setFill(GBC.BOTH));
		JPanel p = new JPanel();
		p.setBackground(Color.CYAN);
		this.add(p, new GBC(0, 1).setWeight(0.1, 0.6).setFill(GBC.BOTH));
		
	}
	
	public void AgregarParada() {
		
		g.pintarGrafo(getGraphics(), 0, 0);;
		g.revalidate();
	}
	
	
}
