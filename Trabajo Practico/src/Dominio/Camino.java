package Dominio;

public class Camino {
	
	private double longitud;
	private Parada inicial;
	private Parada fin;
	
	public Camino(Parada i, Parada f, double l) {
		this.longitud = l;
		this.inicial = i;
		this.fin = f;
	}
	
	public double getLongitud() {
		return longitud;
	}
	public Parada getInicial() {
		return inicial;
	}
	public Parada getFin() {
		return fin;
	}
	public void Imprimir() {
        System.out.println("Empieza en: "+ inicial.getNumero() + " termina en : " + fin.getNumero() + " Total recorrido = " + longitud);
    }

	@Override
	public String toString() {
		return "Camino [longitud=" + longitud + ", inicial=" + inicial + ", fin=" + fin + "]";
	}
	
	
}
