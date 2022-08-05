package Dominio;

import java.util.ArrayList;

public class Economica extends Linea{
	
	@SuppressWarnings("unused")
	private double porcentaje; // debe ser menor o igual a 0.4;
	static final double COSTO_ECONOM = 0.02;
	
	public Economica(String n, String c, int cantidad, double p, ArrayList<Bus> buses) {
		super();
		this.nombre = n;
		this.capacidad = cantidad;
		this.color = c;
		this.porcentaje = p;
		this.buses = buses;
	}
	
	public Economica(String n, String c, int cantidad, double p, Bus bus) {
		super();
		this.nombre = n;
		this.capacidad = cantidad;
		this.color = c;
		this.porcentaje = p;
		this.buses.add(bus);
	}
	
}
