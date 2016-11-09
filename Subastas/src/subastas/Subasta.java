package subastas;

import java.util.LinkedList;


public class Subasta {
	
	private final String producto;
	private final Usuario usuario;
	private boolean estado;
	private LinkedList<Puja> pujasRealizadas;
		
	public Subasta(String producto, Usuario usuario){
		this.producto = producto;
		this.usuario = usuario;
		estado = true;
		pujasRealizadas = new LinkedList<Puja>();
		this.usuario.addSubasta(this);
	}
	
	public String getProducto() {
		return producto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isAbierta() {
		return estado;
	}
	
	protected void setCerrada(){
		this.estado = false;
	}
	
	public LinkedList<Puja> getPujasRealizadas() {
		return new LinkedList<Puja>(pujasRealizadas);
	}
	
	public Puja getPujaMayor() {	
		if (pujasRealizadas.isEmpty()) return null;
		else return pujasRealizadas.getLast();
	}
	
	public boolean pujar(Usuario usuario, double cantidad){
		if (pujasRealizadas.isEmpty()){
			Puja nueva = new Puja(usuario, cantidad);
			pujasRealizadas.addLast(nueva);
			return true;
		}
		else{ 
			if (isAbierta() && usuario.getCredito() >= cantidad && this.usuario != usuario
					&& cantidad > getPujaMayor().getCantidad()){
				Puja nueva = new Puja(usuario, cantidad);
				pujasRealizadas.addLast(nueva);
				return true;
			}
		}
		return false;
	}
		
	public void pujar(Usuario usuario){
		if (getPujaMayor() != null) pujar(usuario, 1);
		else pujar(usuario, getPujaMayor().getCantidad() + 1);					
	}
	
	public boolean ejecutar(){	
		if(isAbierta() && getPujaMayor() != null){
			usuario.incrementar(getPujaMayor().getCantidad());
			getPujaMayor().getUsuario().decrementar(getPujaMayor().getCantidad());
			this.estado = false;
			return true;			
		}
		return false;
	}
	
}
