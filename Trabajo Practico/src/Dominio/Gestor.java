package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import Exceptions.FechaIncidenteException;

public class Gestor {

	private ArrayList<Linea> listaLineas;
	private Trayecto listaCaminos; // aristas
	private ArrayList<Parada> listaParadas; // nodos
	private ArrayList<Incidente> listaIncidentes;

	public Gestor() {
		this.listaLineas = new ArrayList<Linea>();
		this.listaCaminos = new Trayecto();
		this.listaParadas = new ArrayList<Parada>();
		this.listaIncidentes = new ArrayList<Incidente>();
	}

	public void agregarLinea(Linea l) {
		this.listaLineas.add(l);
	}

	public void agregarParada(Parada p) {
		this.listaParadas.add(p);
	}

	public void agregarCamino(Parada p1, Parada p2, double longitud) {
		this.listaCaminos.add(new Camino(p1, p2, longitud));
		// this.listaCaminos.add(new Camino(longitud, p2, p1)); NO SE SI HACERLO IDA Y
		// VUELTA, evaluar
	}

	public void agregarCamino(Camino c) {
		this.listaCaminos.add(c);
	}

	public void agregarIncidente(String i, String f, String s, Parada p) throws IllegalArgumentException {
		LocalDate inicio = LocalDate.parse(i);
//		try {			
//			if (!(inicio.equals(LocalDate.now()))) 
//				throw new Exception("La fecha de inicio debe ser anterior a la fecha de fin");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			if(f != null && LocalDate.parse(f).isBefore(inicio)) throw new FechaIncidenteException("La fecha de inicio debe ser anterior a la fecha de fin");
		} catch (FechaIncidenteException e) {
			e.printStackTrace();
		}
		this.listaIncidentes.add(new Incidente(inicio, LocalDate.parse(f), s, p));
		for (Parada j : listaParadas) {
			if (j.equals(p))
				j.setEstado(false);
		}
		calcularParadas(p);
	}

	public void agregarIncidente(LocalDate inicio, LocalDate fin, String s, Parada p) {
		
//		try {
//			if (!(inicio.equals(LocalDate.now()))) throw new Exception("La fecha de inicio debe ser la actual");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			if(fin != null && fin.isBefore(inicio)) throw new FechaIncidenteException("La fecha de inicio debe ser anterior a la fecha de fin");
		} catch (FechaIncidenteException e) {
			e.printStackTrace();
		}
		
		this.listaIncidentes.add(new Incidente(inicio, fin, s, p));
		for (Parada j : listaParadas) {
			if (j.equals(p))
				j.setEstado(false);
		}
		calcularParadas(p);
	}

	public void terminarIncidente(Incidente i) {
		Parada p;
		p = i.getParada();
		for (Parada j : listaParadas) {
			if (j.equals(p))
				j.setEstado(true);
		}
		listaIncidentes.remove(i);
	}

	// OK
	public ArrayList<Parada> getAdyacentes(Parada p) {
		return listaCaminos.stream() // si es true es q esta activo
				.filter(e -> e.getInicial().equals(p) && e.getFin().isEstado()).map(e -> e.getFin())
				.collect(Collectors.toCollection(ArrayList::new));

	}

	// OK
	public double getDistancia(Parada p1, Parada p2) { // solo puedo tener 1 calle entre 2 nodos, no tendria sentido lo
														// contrario
		for (Camino c : listaCaminos) {
			if (c.getInicial().equals(p1) && c.getFin().equals(p2))
				return c.getLongitud();
		}
		return 0;
	}

	// OK
	public Camino distanciaEntreDosParadas(List<Parada> p, Parada ini, Parada fin) { // retorna la distancia total entre
																						// 2 paradas
		if (!p.isEmpty()) {
			Parada Actual = p.get(0);
			double suma = 0;
			for (Parada i : p) {
				if (!i.equals(Actual)) {
					suma += this.getDistancia(Actual, i);
				}
				Actual = i;
			}
			return new Camino(ini, fin, suma);
		} else {
			return null;
		}
	}

	public Trayecto buscarCaminos(Parada p1, Parada p2) { // Retorna todos los caminos desde p1 a p2 pero solo difieren
															// sus distancias
		ArrayList<List<Parada>> salida = new ArrayList<List<Parada>>();
		List<Parada> marcados = new ArrayList<Parada>();
		marcados.add(p1);
		buscarCaminosAux(p1, p2, marcados, salida);
		return salida.stream().map(e -> this.distanciaEntreDosParadas(e, p1, p2))
				.collect(Collectors.toCollection(Trayecto::new));
	}

	// OK
	private void buscarCaminosAux(Parada p1, Parada p2, List<Parada> marcados, List<List<Parada>> todos) { // retorna
																											// todas las
																											// combinaciones
																											// de calles
																											// entre 2
																											// paradas
																											// tambien
																											// una lista
																											// con todas
																											// las
																											// paradas
																											// intermedias
		List<Parada> adyacentes = this.getAdyacentes(p1);
		List<Parada> copiaMarcados = null;
		for (Parada ady : adyacentes) {
			copiaMarcados = marcados.stream().collect(Collectors.toList());

			if (ady.equals(p2)) {
				copiaMarcados.add(p2);
				todos.add(new ArrayList<Parada>(copiaMarcados));
			} else {
				if (!copiaMarcados.contains(ady)) {
					copiaMarcados.add(ady);
					this.buscarCaminosAux(ady, p2, copiaMarcados, todos);
				}
			}
		}
	}

	// OK
	public Trayecto trayectoDeUnaLinea(Linea l) {
		// Agregar duracion
		Trayecto aux = new Trayecto();

		l.getBuses().stream()
				.map(b -> (b.getFin().isEstado()) ? this.buscarCaminos(b.getInicio(), b.getFin())
						: this.buscarCaminos(b.getInicio(), b.getFin()))
				.flatMap(c -> c.stream()).forEach(new Consumer<Camino>() {
					@Override
					public void accept(Camino c) {
						aux.add(c);
					}
				});
		return aux;
	}

	// Propone parada nueva
	private boolean calcularParadas(Parada p) {

		if (getAdyacentes(p).isEmpty())
			return false;

		Parada aux = this.getAdyacentes(p).stream().min(Comparator.comparingDouble(e -> this.getDistancia(p, e))).get();

		// setea la parada propuesta como auxiliar a los buses de todas las lineas
		listaLineas.stream().flatMap(l -> l.getBuses().stream()).forEach(new Consumer<Bus>() {
			@Override
			public void accept(Bus b) {
				b.setAuxilia(aux);
			}
		});
		return true;
	}

	public Boleto comprarBoleto(Trayecto trayecto, Linea linea, Bus bus, LocalDate fechaViaje) {
		return new Boleto(trayecto, linea, bus, fechaViaje);
	}

	public ReporteIncidencias generarReporte() {
		
		ReporteIncidencias reporte = new ReporteIncidencias();
		reporte.insertar(listaIncidentes);
		return reporte;

	}

	public ArrayList<Incidente> getIncidencias() {

		return listaIncidentes;
	}

	public ArrayList<Linea> getListaLineas() {
		return listaLineas;
	}

	public void setListaLineas(ArrayList<Linea> listaLineas) {
		this.listaLineas = listaLineas;
	}

	public Trayecto getListaCaminos() {
		return listaCaminos;
	}

	public void setListaCaminos(Trayecto listaCaminos) {
		this.listaCaminos = listaCaminos;
	}

	public ArrayList<Parada> getListaParadas() {
		return listaParadas;
	}

	public void setListaParadas(ArrayList<Parada> listaParadas) {
		this.listaParadas = listaParadas;
	}
	
	

}
