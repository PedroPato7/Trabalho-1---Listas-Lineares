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
	public void inserirPedidoInicio(String nome) {
		Nodo novoNodo = new Nodo(nome);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	// Função para inserir no final.
	public void inserirPedidoFinal(String nome) {
		if (vazia()) {
			inserirPedidoInicio(nome);
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		Nodo novoNodo = new Nodo(nome);
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
			System.out.println("- " + aux.getNome() + " ");
			aux = aux.getProx();
		}		
	}
	
	public void atualizarPedido(String nome, String atualizar) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux.getNome() != null) {
			if (aux.getNome() == nome) {
				aux.setNome(atualizar);
				return;
			}			
		}
		while (aux.getProx() != null) {
			if (aux.getProx().getNome() == nome) {
				aux.getProx().setNome(atualizar);
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar número específico
	public void deletarPedido(String nome) {
		if (vazia()) return;
		if (inicio.getNome() == nome) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNome() == nome) {
				aux.setProx(aux.getProx().getProx());
			}
			aux = aux.getProx();
		}
	}
}
