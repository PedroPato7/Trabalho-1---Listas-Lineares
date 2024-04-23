package sistema;

public class Nodo {	
	
	private Nodo prox;
	
	public void NodoCliente(String nome) {
		
		this.prox = null;
	}
	public Nodo getProx() {
		return prox;
	}
	public void setProx(Nodo prox) {
		this.prox = prox;
	}
}
