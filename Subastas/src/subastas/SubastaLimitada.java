package subastas;

public class SubastaLimitada extends Subasta {
	
	private final int pujasMax;
	
	public SubastaLimitada(String producto, Usuario usuario, int pujasMax){
		super(producto, usuario);
		this.pujasMax = pujasMax;
	}
	
	public int getPujasMax(){
		return pujasMax;
	}
	
	public int getPujasCont(){
		return super.getPujasRealizadas().size();
	}
	
	public int getPujasPendientes(){
		return pujasMax - getPujasCont();
	}
	
	@Override
	public boolean pujar(Usuario usuario, double cantidad){
		if (getPujasPendientes() > 0) return super.pujar(usuario, cantidad);
		return false;
	}
	
}
