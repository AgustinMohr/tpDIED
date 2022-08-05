package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AppPruebas {

	public static void main(String[] args) {

		Gestor g = new Gestor();

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

		Camino c1 = new Camino(p1, p2, 2);
		Camino c2 = new Camino(p1, p5, 5);
		Camino c3 = new Camino(p2, p3, 4);
		Camino c4 = new Camino(p2, p4, 1);
		Camino c5 = new Camino(p3, p7, 7);
		Camino c6 = new Camino(p3, p9, 5);
		Camino c7 = new Camino(p4, p1, 3);
		Camino c8 = new Camino(p4, p7, 4);
		Camino c9 = new Camino(p4, p12, 6);
		Camino c10 = new Camino(p5, p4, 2);
		Camino c11 = new Camino(p5, p11, 15);
		Camino c12 = new Camino(p6, p4, 3);
		Camino c13 = new Camino(p6, p5, 2);
		Camino c14 = new Camino(p7, p8, 10);
		Camino c15 = new Camino(p7, p6, 9);
		Camino c16 = new Camino(p7, p10, 8);
		Camino c17 = new Camino(p8, p5, 8);
		Camino c18 = new Camino(p9, p10, 12);
		Camino c19 = new Camino(p9, p1, 21);
		Camino c20 = new Camino(p10, p3, 6);
		Camino c21 = new Camino(p11, p7, 9);
		Camino c22 = new Camino(p12, p8, 20);

		Bus b1 = new Bus(p1, p11, 1);
		Bus b2 = new Bus(p9, p5, 2);
		Bus b3 = new Bus(p11, p3, 3);

		Economica e1 = new Economica("Economica 1", "Rojo", 30, 0.2, b1);
		Superior s1 = new Superior("Superior 1", "Azul", 40, TipoServicio.Wifi, b2);
		s1.agregarBus(b3);

		g.agregarLinea(s1);
		g.agregarLinea(e1);

		g.agregarParada(p1);
		g.agregarParada(p2);
		g.agregarParada(p3);
		g.agregarParada(p4);
		g.agregarParada(p5);
		g.agregarParada(p6);
		g.agregarParada(p7);
		g.agregarParada(p8);
		g.agregarParada(p9);
		g.agregarParada(p10);
		g.agregarParada(p11);
		g.agregarParada(p12);

		g.agregarCamino(c1);
		g.agregarCamino(c2);
		g.agregarCamino(c3);
		g.agregarCamino(c4);
		g.agregarCamino(c5);
		g.agregarCamino(c6);
		g.agregarCamino(c7);
		g.agregarCamino(c8);
		g.agregarCamino(c9);
		g.agregarCamino(c10);
		g.agregarCamino(c11);
		g.agregarCamino(c12);
		g.agregarCamino(c13);
		g.agregarCamino(c14);
		g.agregarCamino(c15);
		g.agregarCamino(c16);
		g.agregarCamino(c17);
		g.agregarCamino(c18);
		g.agregarCamino(c19);
		g.agregarCamino(c20);
		g.agregarCamino(c21);
		g.agregarCamino(c22);

		// g.agregarIncidente(LocalDate.now(), LocalDate.now().plusDays(2), "", p12);

		// OK
//		System.out.println(g.getAdyacentes(p1));
//		System.out.println(g.getAdyacentes(p7));
//		
//		//OK
//		System.out.println(g.getDistancia(p1, p2));
//		System.out.println(g.getDistancia(p1, p5));

		// OK
//		g.buscarCaminos(p1, p2).forEach(c -> c.Imprimir());
//		g.buscarCaminos(p9, p2).forEach(c -> c.Imprimir());

		// OK
		g.agregarIncidente(LocalDate.now().minusMonths(4), LocalDate.now().plusDays(1), "", p5); // 4 meses. 1
		g.agregarIncidente(LocalDate.now(), LocalDate.now().plusDays(6), "Grave", p3); // 6 dias. 4
		g.agregarIncidente(LocalDate.now().minusDays(8), null, "Mala", p1); // 8 dias. 3
		g.agregarIncidente(LocalDate.now().minusDays(5), null, "Mala2", p2); // 5 dias. 5
		g.agregarIncidente(LocalDate.now(), LocalDate.now().plusDays(4), "Bien", p8);// 4 dias. 6
		g.agregarIncidente(LocalDate.now(), LocalDate.now().plusMonths(1), "Bien", p10); // 1 mes. 2
		g.agregarIncidente(LocalDate.now().minusMonths(7), LocalDate.now().plusDays(1), "", p6); // 4 meses. 1
		g.agregarIncidente(LocalDate.now(), LocalDate.now().minusDays(1), "", p12);

//		ReporteIncidencias reporte = g.generarReporte();
//
//		System.out.println(reporte.vaciar());

	}

}
