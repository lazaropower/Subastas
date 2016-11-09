package subastas;

public class Puja {
	
	private final Usuario usuario;
	private final double cantidad;
	
	public Puja(Usuario usuario, double cantidad){
		this.usuario = usuario;
		this.cantidad = cantidad; 
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
}
