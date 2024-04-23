package sistema;

public class Pedidos {
	
	private Nodo inicio;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	// Função para inserir no inicio.
	public void inserirPedidoInicio(String stats, Double valor) {
		Nodo novoNodo = new Nodo(stats, valor);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	// Função para inserir no final.
	public void inserirPedidoFinal(String stats, Double valor) {
		if (vazia()) {
			inserirPedidoInicio(stats, valor);
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		Nodo novoNodo = new Nodo(stats, valor);
		aux.setProx(novoNodo);
	}
	
	//Função para mostrar lista
	public void consultaPedido() {
		if (vazia()) {
			System.out.println("Sem clientes na fila.");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			System.out.println("- Status: " + aux.getStats() + " | Preço - " + aux.getValor());
			aux = aux.getProx();
		}		
	}
	
	public void atualizarPedido(String stats, String atualizarStats, Double atualizarValor) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux.getStats() != null) {
			if (aux.getStats() == stats) {
				aux.setStats(atualizarStats);
				aux.setValor(atualizarValor);
				return;
			}			
		}
		while (aux.getProx() != null) {
			if (aux.getProx().getStats() == stats) {
				aux.getProx().setStats(atualizarStats);
				aux.getProx().setValor(atualizarValor);
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar número específico
	public void deletarPedido(String stats) {
		if (vazia()) return;
		if (inicio.getStats() == stats) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getStats() == stats) {				
				aux.setProx(aux.getProx().getProx());
				return;
			}		
			aux = aux.getProx();
		}
	}
}
