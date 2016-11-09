package subastas;

public class SubastaTemporal extends SubastaLimitada {
	
	private long tiempoInicio;
	private int tiempoTotal; //En horas

	public SubastaTemporal(String producto, Usuario usuario, int tiempoTotal){
		
		super(producto, usuario, tiempoTotal*2);
		this.tiempoInicio = System.currentTimeMillis();
		this.tiempoTotal = tiempoTotal;
	}
	
	public long getTiempoInicio(){
		return tiempoInicio;
	}
	
	public int getTiempoTotal(){
		return tiempoTotal;
	}
	
	public long getHorasRestantes(){ 
		return (tiempoTotal - ((System.currentTimeMillis() - tiempoInicio)/3600000));
	}
	
	@Override
	public boolean pujar(Usuario usuario, double cantidad){
		if (getHorasRestantes() > 0) return super.pujar(usuario, cantidad);
		else return false;		
	}
	
	@Override
	public boolean ejecutar(){
		if (getHorasRestantes() == 0) return super.ejecutar();
		else return false;
	}
	
}
