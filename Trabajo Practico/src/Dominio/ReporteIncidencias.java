package Dominio;

import java.util.ArrayList;

public class ReporteIncidencias {

	/* ELIMINAR
public static void main(String[] args) {

		Parada p1 = new Parada(1, "Parada 1");
		Parada p2 = new Parada(2, "Parada 2");
		Parada p3 = new Parada(3, "Parada 3");
		Parada p4 = new Parada(4, "Parada 4");
		Parada p5 = new Parada(5, "Parada 5");
		Parada p6 = new Parada(6, "Parada 6");
		Parada p7 = new Parada(7, "Parada 7");
		Parada p8 = new Parada(8, "Parada 8");
		Parada p9 = new Parada(9, "Parada 9");
		Parada p10 = new Parada(10, "Parada 10");
		Parada p11 = new Parada(11, "Parada 11");
		Parada p12 = new Parada(12, "Parada 12");

		Incidente i1 = new Incidente(LocalDate.now().minusMonths(2), LocalDate.now().plusDays(1), "", p5);
		Incidente i2 = new Incidente(LocalDate.now(), LocalDate.now().plusDays(6), "Grave", p3);
		Incidente i3 = new Incidente(LocalDate.now().minusDays(8), null, "Mala", p1);
		Incidente i4 = new Incidente(LocalDate.now().minusDays(5), null, "Mala2", p2);
		Incidente i5 = new Incidente(LocalDate.now(), LocalDate.now().plusDays(4), "Bien", p8);
		Incidente i6 = new Incidente(LocalDate.now(), LocalDate.now().plusMonths(1), "Bien", p10);
//		Incidente i7 = new Incidente(LocalDate.now().plusMonths(1), LocalDate.now(), "", p12);

		System.out.println(i1.getDuracionEnDias().get());
		System.out.println(i2.getDuracionEnDias().get());
		System.out.println(i3.getDuracionAux());
		System.out.println(i4.getDuracionAux());
		System.out.println(i5.getDuracionEnDias().get());
		System.out.println(i6.getDuracionEnDias().get());

		System.out.println(i1.compareTo(i6));
		System.out.println(i2.compareTo(i3));
		System.out.println(i3.compareTo(i4));
		System.out.println(i3.compareTo(i5));
		System.out.println(i3.compareTo(i6));
		
		ReporteIncidencias report2 = new ReporteIncidencias();
		report2.insertar(i1);
		report2.insertar(i2);
		report2.insertar(i3);
		report2.insertar(i4);
		report2.insertar(i5);
		report2.insertar(i6);
		
		System.out.println(report2.vaciar());
		
		

	} */

	static final int TAMINI = 20;
	private int numElementos;
	private Incidente[] vector;

	public ReporteIncidencias() {
		numElementos = 0;
		vector = new Incidente[TAMINI];
	}

	public void insertar(Incidente inc) {
		if (monticuloLleno())
			ampliar();
		vector[numElementos] = inc;
		flotar(numElementos);
		numElementos++;
	}

	public void insertar(ArrayList<Incidente> incidentes) {
		for (Incidente i : incidentes)
			insertar(i);

	}

	public Incidente getMinimo() throws Exception {
		if (esVacio())
			throw new Exception("Acceso a montículo vacío");
		return vector[0];
	}

	// retorna la cima de monticulo, la elimina y luego acomoda
	public Incidente eliminarCima() throws Exception {
		if (esVacio())
			throw new Exception("Acceso a monticulo vacio");
		Incidente menor = vector[0];
		vector[0] = vector[numElementos - 1];
		hundir(0);
		numElementos--;
		return menor;
	}
	
	private void flotar(int i) {
		Incidente nuevaClave = vector[i];
		while ((i > 0) && (vector[padre(i)].menorQue(nuevaClave))) {
			vector[i] = vector[padre(i)]; // baja el padre al hueco
			i = padre(i); // sube un nivel en el arbol
		}
		vector[i] = nuevaClave; // situa la clave en su posicion
	}

	private void ampliar() {
		Incidente[] anteriorV = vector;
		vector = new Incidente[numElementos + TAMINI];
		for (int j = 0; j < numElementos; j++)
			vector[j] = anteriorV[j];
	}

	// hundir raiz si corresponde
	public void hundir(int raiz) {
		boolean esMonticulo = false;
		int hijo;
		while ((raiz < numElementos / 2) && !esMonticulo) {
			// determina el indice del hijo mayor
			if (hijoIzq(raiz) == (numElementos - 1)) // unico descendiente
				hijo = hijoIzq(raiz);
			else {
				if (vector[hijoIzq(raiz)].mayorQue(vector[hijoDer(raiz)]))
					hijo = hijoIzq(raiz);
				else
					hijo = hijoDer(raiz);
			}
			
			if (vector[hijo].mayorQue(vector[raiz])) {
				Incidente temp = vector[raiz];
				vector[raiz] = vector[hijo];
				vector[hijo] = temp;
				raiz = hijo; // continua por la rama de claves maximas
			} else
				esMonticulo = true;
		}
	}	

	// devuelve el elemento de la cima del monticulo (raiz)
	public Incidente getCima() throws Exception {
		if (esVacio())
			throw new Exception("Acceso a monticulo vacio");
		return vector[0];
	}

	public ArrayList<Incidente> vaciar() {
		ArrayList<Incidente> resultado = new ArrayList<Incidente>();
		while (!(esVacio())) {
			try {
				resultado.add(eliminarCima());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return resultado;

	}

	private int padre(int pos) {
		return ((pos - 1) / 2);
	}

	private int hijoIzq(int pos) {
		return (2 * pos) + 1;
	}

	private int hijoDer(int pos) {
		return (2 * pos) + 2;
	}

	public boolean monticuloLleno() {
		return numElementos == vector.length;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public boolean esVacio() {
		return numElementos == 0;
	}
}
