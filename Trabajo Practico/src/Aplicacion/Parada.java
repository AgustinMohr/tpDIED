package Aplicacion;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Parada extends JPanel {
	
	public Mapa MapaAux;
	JButton b1,b2,b3,b4;
	
	public Parada(Mapa m) {
		this.MapaAux = m;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(Color.decode("#DEDEDE"));
		
		b1 = new JButton("Nuevo");
		this.add(b1);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		b2 = new JButton("Modificar");
		b2.setEnabled(false);
		this.add(b2);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		b3 = new JButton("Eliminar");
		b3.setEnabled(false);
		this.add(b3);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		b4 = new JButton("Buscar");
		this.add(b4);
		this.add(Box.createRigidArea(new Dimension(0,5)));	
	
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Nuevo(b1);
                Modificar(b2);
                Eliminar(b3);
                Buscar(b4);
            }
        });
	}

	private void Nuevo(JButton b) {
		
		b.addActionListener(e -> {
			JFrame Temporal = new JFrame("Nueva Parada");
			Temporal.setVisible(true);
			Temporal.setLayout(new GridLayout(3,2, 10, 10));
			Temporal.setSize(400,150);
			Temporal.setResizable(false);
			
			Temporal.add(new JLabel("Ingrese un nombre: "));
			Temporal.add(new JTextField());
			Temporal.add(new JLabel("Ingrese un número: "));
			Temporal.add(new JTextField());
			JButton Cancelar = new JButton("Cancelar");
			Temporal.add(Cancelar);
			JButton Aceptar = new JButton("Aceptar");
			Temporal.add(Aceptar);
			
			Aceptar.addActionListener(i -> {
				if(Aceptar.isEnabled()) {
					MapaAux.AgregarParada();
					Temporal.dispose();
				}
			});
			
			Cancelar.addActionListener(i -> {
				if(Cancelar.isEnabled()) {
					// modificar parada
					Temporal.dispose();
				}
			});
		});
	}
	
	private void Modificar(JButton b) {
		
		// HACER QUE CUANDO SE SELECIONE UNO ESTE SE ACTIVE
		
		b.addActionListener(e -> {
			JFrame Temporal = new JFrame("Modificar Parada");
			Temporal.setVisible(true);
			Temporal.setLayout(new GridLayout(3,2, 10, 10));
			Temporal.setSize(400,150);
			Temporal.setResizable(false);
			
			Temporal.add(new JLabel("Ingrese un nombre nuevo: "));
			Temporal.add(new JTextField());
			Temporal.add(new JLabel("Ingrese un número nuevo: "));
			Temporal.add(new JTextField());
			JButton Cancelar = new JButton("Cancelar");
			Temporal.add(Cancelar);
			JButton Aceptar = new JButton("Aceptar");
			Temporal.add(Aceptar);
			// FALTA CAPTURAR EL TEXTO
			Aceptar.addActionListener(i -> {
				if(Aceptar.isEnabled()) {
					// modificar parada
					b.setEnabled(false);
					b3.setEnabled(false);
					Temporal.dispose();
				}
			});
			
			Cancelar.addActionListener(i -> {
				if(Cancelar.isEnabled()) {
					Temporal.dispose();
				}
			});
			
		});
	}
	
	private void Eliminar(JButton b) {
		
		// HACER QUE CUANDO SE SELECIONE UNO ESTE SE ACTIVE
		
		b.addActionListener(e -> {
			JFrame Temporal = new JFrame("Eliminar Parada");
			Temporal.setVisible(true);
			Temporal.setLayout(new GridLayout(2,1, 10, 10));
			Temporal.setSize(300,100);
			Temporal.setResizable(false);
			
			Temporal.add(new JLabel("¿Quiere eliminar esta parada?"));
			JButton Aceptar = new JButton("Aceptar");
			Temporal.add(Aceptar);
			
			Aceptar.addActionListener(i -> {
				if(Aceptar.isEnabled()) {
					// eliminar parada
					b.setEnabled(false);
					b2.setEnabled(false);
					Temporal.dispose();
				}
			});
		});
	}
	
	private void Buscar(JButton b) {
		
	// HACER QUE CUANDO SE SELECIONE UNO ESTE SE ACTIVE
		
		b.addActionListener(e -> {
			JFrame Temporal = new JFrame("Buscar Parada");
			Temporal.setVisible(true);
			Temporal.setLayout(new GridLayout(3,2, 10, 10));
			Temporal.setSize(400,150);
			Temporal.setResizable(false);
			
			Temporal.add(new JLabel("Ingrese un nombre: "));
			Temporal.add(new JTextField());
			Temporal.add(new JLabel("Ingrese un número: "));
			Temporal.add(new JTextField());
			JButton Cancelar = new JButton("Cancelar");
			Temporal.add(Cancelar);
			JButton Aceptar = new JButton("Aceptar");
			Temporal.add(Aceptar);
			
			Aceptar.addActionListener(i -> {
				if(Aceptar.isEnabled()) {
					// buscar parada
					// si se encuentra activar Eliminar y Modificar
					b2.setEnabled(true);
					b3.setEnabled(true);
					Temporal.dispose();
				}
			});
				
		Cancelar.addActionListener(i -> {
				if(Cancelar.isEnabled()) 
					Temporal.dispose();
			});
				
		});
	}
	
}
