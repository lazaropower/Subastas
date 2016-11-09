package subastas;

import java.util.LinkedList;

public class Usuario {
	
	private final String nombre; 
	private double credito;
	private LinkedList<Subasta> subastas;
	
	public Usuario(String nombre, double credito){
		this.nombre = nombre;
		this.credito = credito;
		subastas = new LinkedList<>();
	}
	
	public Usuario(String nombre){
		this(nombre, 0);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getCredito() {
		return credito;
	}
	
	public LinkedList<Subasta> getSubastas() {
		return subastas;
	}
	public void incrementar(double cantidad){
		this.credito += cantidad;
	}
	
	public void decrementar(double cantidad){
		this.credito -= cantidad;
	}

	public void addSubasta(Subasta subasta) {
		subastas.addLast(subasta);
		
	}
	
}
