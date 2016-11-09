package pruebas;

import java.util.LinkedList;

import subastas.Subasta;
import subastas.SubastaLimitada;
import subastas.SubastaMinima;
import subastas.SubastaTemporal;
import subastas.Usuario;

public class PruebaSubasta {
	public static void main(String[] args) {
		/* Crea tres usuarios con nombre "Juan", "Pedro" y "Enrique" con un credito inicial
		de 100, 150 y 300 euros, respectivamente. */
		Usuario usuario1 = new Usuario("Juan", 100);
		Usuario usuario2 = new Usuario("Pedro", 150);
		Usuario usuario3 = new Usuario("Enrique", 300);
		
		/*Crea una subasta del producto "Telefono Movil" cuyo propietario sea el usuario
		Juan. */
		Subasta subasta1 = new Subasta("Telefono Movil", usuario1);
		
		//El usuario Pedro puja por esa subasta 100 euros. 
		subasta1.pujar(usuario2, 100);
		
		/* Muestra en la consola la puja mayor de la subasta (nombre del usuario y
		cantidad). */
		System.out.println("Puja mayor:\n - "+subasta1.getPujaMayor().getUsuario().getNombre()+"\n - "
				+subasta1.getPujaMayor().getCantidad());
		
		// El usuario Enrique puja por esa subasta 50 euros.
		subasta1.pujar(usuario3, 50);
		
		/* Muestra en la consola la puja mayor. Comprueba que esta segunda puja no ha
		sido acepta, ya que es menor que la primera. */
		System.out.println("Puja mayor:\n -"+subasta1.getPujaMayor().getUsuario().getNombre()+"\n - "
				+subasta1.getPujaMayor().getCantidad());
		
		// Ejecuta la subasta.
		subasta1.ejecutar();
		
		/* El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba
		que no es aceptada, ya que la subasta ha sido cerrada. */ 
		subasta1.pujar(usuario3, 200);
		System.out.println("Puja mayor:\n -"+subasta1.getPujaMayor().getUsuario().getNombre()+"\n - "
				+subasta1.getPujaMayor().getCantidad());

		/* Muestra por la consola los creditos de los tres usuarios. Observa que los
		creditos de Juan y Pedro han cambiado. */
		System.out.println("Crédito usuario1: "+usuario1.getCredito());
		System.out.println("Crédito usuario2: "+usuario2.getCredito());
		System.out.println("Crédito usuario3: "+usuario3.getCredito());
	
		// Muestra las subastas de las que son propietarios los tres usuarios.
		System.out.println("Subastas usuario1: " +usuario1.getSubastas());
		System.out.println("Subastas usuario2: " +usuario2.getSubastas());
		System.out.println("Subastas usuario3: " +usuario3.getSubastas());

		// SESIÓN 5 //
		System.out.println("-----------------------------------------------");
		/* Declara la variable local subastas de tipo lista (java.util.LinkedList) de
		subastas. Asigna a la variable una lista vacía. */
		LinkedList<Subasta> subastas = new LinkedList<Subasta>();
		
		//Crea los usuarios juan y enrique con créditos 100 y 500 respectivamente. 
		Usuario usuario4 = new Usuario("Juan", 100);
		Usuario usuario5 = new Usuario("Enrique", 500);
		
		/* Declara la variable local subasta2 de tipo Subasta y asigna una subasta limitada
		que sólo permita 1 puja. El producto que ofrece es “Disco duro multimedia” y el
		usuario propietario es juan. */
		Subasta subasta2 = new SubastaLimitada("Disco duro multimedia", usuario4, 1);
		
		/* Declara la variable local subasta3 de tipo Subasta y asigna una subasta mínima
		con un precio mínimo de 100 euros. El producto que ofrece es “Impresora Láser” y el
		usuario propietario es Juan. */
		Subasta subasta3 = new SubastaMinima("Impresora Láser", usuario4, 100);
		
		/* Añade las subastas que referencian las variables subasta1 y subasta2 a la lista de
		subastas. */
		subastas.addLast(subasta2);
		subastas.addLast(subasta3);
		
		/* Declara la variable local temporal1 de tipo SubastaTemporal con un tiempo de
		subasta de 3 horas. El producto que ofrece es “Teclado” y el usuario propietario es
		juan. */
		SubastaTemporal temporal1 = new SubastaTemporal("Teclado", usuario4,  3);
		
		//Añade la subasta que referencia la variable temporal1 a la lista de subastas. 
		subastas.addLast(temporal1);
		
		/* Recorre la lista de subastas: para cada subasta, el usuario enrique puja por 10
		euros. */
		for (Subasta subasta: subastas){
			subasta.pujar(usuario5, 10);
		}
		
		/*Recorre la lista de subastas: si la subasta es limitada, se mostrarán las pujas
		pendientes. Además, para cada subasta el usuario enrique vuelve a pujar por 20
		euros. */
		for (Subasta subasta: subastas){
			subasta.pujar(usuario5, 20);
			if (subasta instanceof SubastaLimitada)
				System.out.println("Pujas pendientes: "+((SubastaLimitada) subasta).getPujasPendientes());
		}
		
		/* Recorre la lista de subastas: si la subasta es temporal y aún queda tiempo para
		hacer pujas, pujará sin cantidad (versión sobrecargada de pujar). */
		for (Subasta subasta: subastas){
			if (subasta instanceof SubastaTemporal)
				((SubastaTemporal) subasta).pujar(usuario5);
		}
		
		/* Recorre la lista de subastas: si la subasta no está cerrada, entonces se ejecuta; en
		caso contrario, se muestra un mensaje por la consola indicando la situación. */
		for (Subasta subasta: subastas){
			if (subasta.isAbierta()) subasta.ejecutar();	
			else System.out.println("La subasta "+subasta.getProducto()+" estaba cerrada");		
		}
		
		// Muestra por la consola el crédito de los dos usuarios.
		System.out.println("Crédito usuario4: "+usuario4.getCredito());
		System.out.println("Crédito usuario5: "+usuario5.getCredito());


	}
}
