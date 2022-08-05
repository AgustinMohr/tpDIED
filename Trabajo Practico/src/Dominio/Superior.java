package Dominio;

import java.util.ArrayList;

public class Superior extends Linea{
	
	private TipoServicio tipo;
	static final double COSTO_WIFI = 0.5;
	static final double COSTO_AC = 0.5;
	static final double COSTO_SUP = 0.1;

	public Superior(String n, String c, int cantidad, TipoServicio t, ArrayList<Bus> buses) {
		super();
		this.nombre = n;
		this.capacidad = cantidad;
		this.color = c;
		this.tipo = t;
		this.buses = buses;
	}
	
	public Superior(String n, String c, int cantidad, TipoServicio t, Bus bus) {
		super();
		this.nombre = n;
		this.capacidad = cantidad;
		this.color = c;
		this.tipo = t;
		this.buses.add(bus);
	}
	
	public TipoServicio getTipo() {
		return tipo;
	}
	
}
