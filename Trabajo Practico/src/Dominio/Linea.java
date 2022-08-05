package Dominio;

import java.util.ArrayList;

public abstract class Linea {
		
	protected ArrayList<Bus> buses;
	protected String color;  // Posible modificaci�n  en un futuro
	protected String nombre;
	protected int capacidad;
	
	public Linea() {
		this.buses = new ArrayList<Bus>();
	}
	
	ArrayList<Bus> getBuses() {
		return buses;
	}
	public void agregarBus(Bus bus) {
		this.buses.add(bus);
	}
	public String getColor() {
		return color;
	}
	public int getCapacidad() {
		return capacidad;
	}
	
}
