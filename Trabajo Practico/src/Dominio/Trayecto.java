package Dominio;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class Trayecto extends ArrayList<Camino> {

	private double tiempo; // en min
	private final int id;
	static int contador;
	private Parada pInicial;
	private Parada pFinal;
	private double distancia; // en km
	private int cantidadParadas; // contando inicial y final

	public Trayecto(double tiempo, double distancia, Parada pInicial, Parada pFinal) {
		super();
		this.tiempo = tiempo;
		this.id = contador;
		this.pInicial = pInicial;
		this.pFinal = pFinal;
		this.distancia = distancia;
		contador++;

	}
	
	public Trayecto() {
		this.id=contador;
		contador++;
	}

	public Trayecto(Collection<Camino> aux) {
		super();
		this.addAll(aux);
		this.id = contador;
		contador++;
	}
	
	public String descripcion() {
		return "TrayectoID: " + id + "\nTiempo: " + tiempo + "\nParada inicial: " + pInicial
				+ "\nParada final: " + pFinal + "\nDistancia: " + distancia + "\nCantidad de paradas: " + cantidadParadas;
	}
	
	public void agregarCamino(Camino c) {
		if (contains(c)) 
			return;
		else 
			add(c);
	}
	
	public int getCantidadParadas(){
		return cantidadParadas;
	}
	
	public int setCantidadParadas() {

		return cantidadParadas;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public Parada getpInicial() {
		return pInicial;
	}

	public void setpInicial(Parada pInicial) {
		this.pInicial = pInicial;
	}

	public Parada getpFinal() {
		return pFinal;
	}

	public void setpFinal(Parada pFinal) {
		this.pFinal = pFinal;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getId() {
		return id;
	}

}
