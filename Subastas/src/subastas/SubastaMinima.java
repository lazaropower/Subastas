package subastas;

public class SubastaMinima extends Subasta {
	
	private double cantidadMin;
	
	public SubastaMinima(String producto, Usuario usuario, double cantidadMin){
		super(producto, usuario);
		this.cantidadMin = cantidadMin;
	}
	
	public double getCantidadMin(){
		return cantidadMin;
	}
	
	public void setCantidadMin(double cantidadMin){
		this.cantidadMin = cantidadMin;
	}
	
	
	@Override
	public boolean ejecutar(){
		if (getPujaMayor().getCantidad() >= cantidadMin) return ejecutar();
		else return false;
	}
	
}
