package Dominio;

public class Parada {
	
	private static int contador = 1;
	
	private int nroParada;
	private int numeroCalle;
	private String calle;
	private boolean estado; //si hay incidente en la parada el estado es falso
	
	public Parada(int numero, String calle) {
		super();
		this.nroParada = contador;
		this.numeroCalle = numero;
		this.calle = calle;
		this.estado=true;
		contador++;
	}

	public Parada() {
		super();
		this.nroParada = contador;
		contador++;
	}

	public boolean equals(Parada p) {
		if(p.getNroParada() == this.nroParada)
			return true;
		else
			return false;
	}
	
	public int getNroParada() {
		return nroParada;
	}
	public void setNroParada(int nroParada) {
		this.nroParada = nroParada;
	}
	public int getNumero() {
		return numeroCalle;
	}
	public void setNumero(int numero) {
		this.numeroCalle = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Parada [nroParada=" + nroParada + ", numeroCalle=" + numeroCalle + ", calle=" + calle + ", estado="
				+ estado + "]";
	}
	
}
