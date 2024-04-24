package sistema;

public class Pedidos {
	
	private Nodo inicio;
	private int quantPedidos = -1;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	// Função para inserir no inicio.
	public void inserirPedidoInicio(String stats, Double valor, int idPedido) {
		Nodo novoNodo = new Nodo(stats, valor, idPedido);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
		quantPedidos++;
	}
	
	// Função para inserir no final.
	public void inserirPedidoFinal(String stats, Double valor, int idPedido) {
		if (vazia()) {
			inserirPedidoInicio(stats, valor, idPedido);
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		Nodo novoNodo = new Nodo(stats, valor, idPedido);
		quantPedidos++;
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
			System.out.println("Número do Pedido - " + aux.getNumPedido() + " | Status: " + aux.getStatsPedido() + " | Preço - " + aux.getValorPedido());
			aux = aux.getProx();
		}		
	}
	
	public void atualizarPedido(String stats, String atualizarStats, Double atualizarValor, int numPedido) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		int cont = 0;
		if (aux.getStatsPedido() != null) {
			if (aux.getNumPedido() == numPedido) {
				aux.setStatsPedido(atualizarStats);
				aux.setValorPedido(atualizarValor);
				aux.setNumPedido(numPedido);
				return;
			}			
		}
		//AJEITAR A CONDIÇÃO PARA QUE SEJA COM O CONT
		while (cont != quantPedidos) {
			if (aux.getProx().getStatsPedido() == stats) {
				aux.getProx().setStatsPedido(atualizarStats);
				aux.getProx().setValorPedido(atualizarValor);
			} 
			cont++;
			aux = aux.getProx();
		}
	}
	
	//Função para deletar número específico
	public void deletarPedido(String stats) {
		if (vazia()) return;
		if (inicio.getStatsPedido() == stats) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getStatsPedido() == stats) {				
				aux.setProx(aux.getProx().getProx());
				return;
			}		
			aux = aux.getProx();
		}
	}
}
