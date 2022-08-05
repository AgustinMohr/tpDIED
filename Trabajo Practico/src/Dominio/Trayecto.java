package Dominio;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Trayecto extends ArrayList<Camino> {

	private static final double TIEMPO_POR_KM = 5;
	private double tiempo; // en min
	private final int id;
	static int contador;
	private Parada pInicial;
	private Parada pFinal;
	private double distancia; // en km
	private int cantidadParadas; // contando inicial y final

	public Trayecto() {
		this.id = contador;
		contador++;
	}

	public Trayecto(ArrayList<Camino> aux) {
		super();
		this.addAll(aux);
		setDistancia(aux);
		setTiempo(aux);
		setInicialFinal(aux);
		this.cantidadParadas = aux.size() + 1;
		this.id = contador;
		contador++;
	}

	public String getDescripcion() {
		return "TrayectoID: " + id + "\nTiempo: " + tiempo + "\nParada inicial: " + pInicial + "\nParada final: "
				+ pFinal + "\nDistancia: " + distancia + "\nCantidad de paradas: " + cantidadParadas;
	}

	public void agregarCamino(Camino c) {
		if (contains(c))
			return;
		else {
			add(c);
			this.cantidadParadas += 1;
			this.tiempo += c.getLongitud() * TIEMPO_POR_KM;
			this.distancia += c.getLongitud();
			this.pFinal = c.getFin();
			if (this.pInicial == null)
				this.pInicial = c.getInicial();
		}

	}
	
	private void setDistancia(ArrayList<Camino> aux) {
		this.distancia = aux.stream().mapToDouble(Camino::getLongitud).sum();
	}

	private void setTiempo(ArrayList<Camino> aux) {
		double tiempo = 0;

		for (Camino c : aux) {
			tiempo += c.getLongitud() * TIEMPO_POR_KM;
		}

		this.tiempo = tiempo;

	}

	private void setInicialFinal(ArrayList<Camino> aux) {
		this.pFinal = aux.get(aux.size() - 1).getFin();
		this.pInicial = aux.get(0).getInicial();
	}

	public int getCantidadParadas() {
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

	public int getId() {
		return id;
	}

}
