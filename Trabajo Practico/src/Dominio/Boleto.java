package Dominio;

import java.time.LocalDate;

public class Boleto {

	static final double MONTO_POR_KM = 30;
	static int contador = 0;
	private int id;
	private double precio;
	private LocalDate fechaViaje;
	private Bus bus;
	private Linea linea;
	private Trayecto trayecto;

	public Boleto(Trayecto trayecto, Linea linea, Bus bus, LocalDate fechaViaje) {

		this.id = contador;
		this.linea = linea;
		this.bus = bus;
		this.fechaViaje = fechaViaje;
		this.precio = calcularPrecio(trayecto, linea);
		this.trayecto = trayecto;
		contador++;

	}

	private double calcularPrecio(Trayecto trayecto, Linea linea) {
		double longTotal = trayecto.stream().mapToDouble(Camino::getLongitud).sum();
		double agregadoLinea;

		if (linea instanceof Economica)
			agregadoLinea = 1 + Economica.COSTO_ECONOM;
		else { // la linea es superior
			if (((Superior) linea).getTipo().equals(TipoServicio.Wifi))
				agregadoLinea = 1 + Economica.COSTO_ECONOM + Superior.COSTO_WIFI;
			else if (((Superior) linea).getTipo().equals(TipoServicio.AirConditioner))
				agregadoLinea = 1 + Economica.COSTO_ECONOM + Superior.COSTO_AC;
			else
				agregadoLinea = 1 + Superior.COSTO_SUP;
		}

		return longTotal * MONTO_POR_KM * agregadoLinea;

	}

	public int getId() {
		return id;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public static double getMontoPorKm() {
		return MONTO_POR_KM;
	}

	public double getPrecio() {
		return precio;
	}

	public LocalDate getFechaViaje() {
		return fechaViaje;
	}

	public Bus getBus() {
		return bus;
	}

	public Linea getLinea() {
		return linea;
	}

	@Override
	public String toString() {
		return "Boleto [precio=" + precio + ", fechaViaje=" + fechaViaje + ", bus=" + bus + ", linea=" + linea + "]";
	}

}
