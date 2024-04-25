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
			System.out.println("Sem pedidos.");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			System.out.println("Número do Pedido - " + aux.getNumPedido() + " | Status: " + aux.getStatsPedido() + " | Preço - " + aux.getValorPedido());
			aux = aux.getProx();
		}		
	}
	
	//Função para atualizar pedidos
	public void atualizarPedido(int numPedido, int numAtualizado, String atualizarStats, Double atualizarValor) {
		if (vazia()) {
			System.out.println("Sem pedidos para atualizar.");
			return;
		}
		Nodo aux = inicio;
		int cont = 0;
		if (aux.getStatsPedido() != null) {
			if (aux.getNumPedido() == numPedido) {
				aux.setStatsPedido(atualizarStats);
				aux.setValorPedido(atualizarValor);
				aux.setNumPedido(numAtualizado);
				return;
			}			
		}
		while (cont != quantPedidos) {
			cont++;
			if (aux.getProx().getNumPedido() == numPedido) {
				aux.getProx().setStatsPedido(atualizarStats);
				aux.getProx().setValorPedido(atualizarValor);
				aux.getProx().setNumPedido(numAtualizado);
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar um pedido específico
	public void deletarPedido(int numPedido) {
		if (vazia()) return;
		if (inicio.getNumPedido() == numPedido) {
			inicio = inicio.getProx();
			quantPedidos--;
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNumPedido() == numPedido) {				
				aux.setProx(aux.getProx().getProx());
				return;
			}		
			aux = aux.getProx();
		}
	}
}
