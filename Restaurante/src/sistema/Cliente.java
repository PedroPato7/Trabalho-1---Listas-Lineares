package sistema;

public class Cliente{

	private Nodo inicio;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	// Função para inserir no inicio.
	public void inserirClienteInicio(String nome, String mesa) {
		Nodo novoNodo = new Nodo(nome, mesa);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	// Função para inserir no final.
	public void inserirClienteFinal(String nome, String mesa) {
		if (vazia()) {
			inserirClienteInicio(nome, mesa);
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		Nodo novoNodo = new Nodo(nome, mesa);
		aux.setProx(novoNodo);
	}
	
	//Função para mostrar lista
	public void consultaCliente() {
		if (vazia()) {
			System.out.println("Sem clientes na fila.");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			if(aux.getMesa() != null) {
				System.out.println("- " + aux.getNome() + " | Número da mesa - " + aux.getMesa());
			} else {
				System.out.println("- " + aux.getNome() + " | Nenhuma mesa escolhida ainda.");
			}
			aux = aux.getProx();
		}		
	}
	
	//Função para atualizar dados do cliente
	public void atualizarCliente(String nome, String nomeAtual, String mesaAtual) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux.getNome() != null) {
			if (aux.getNome() == nome) {
				aux.setNome(nomeAtual);
				aux.setMesa(mesaAtual);
				System.out.println("Informações do cliente " + nome + " atualizadas.");
				return;
			}			
		}
		while (aux.getProx() != null) {
			if (aux.getProx().getNome() == nome) {
				aux = aux.getProx();
				System.out.println("Informações do cliente " + nome + " atualizadas.");
				aux.setNome(nomeAtual);
				aux.setMesa(mesaAtual);
				return;
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar um cliente específico
	public void deletarCliente(Mesas mesa, String nome) {
		if (vazia()) return;
		if (inicio.getNome() == nome) {
			System.out.println("Cliente " + nome + " removido com sucesso.");
			int numTable = Integer.parseInt(inicio.getMesa());
			mesa.atualizarMesa(numTable, 0, true, 4, null);
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNome() == nome) {
				System.out.println("Cliente " + nome + " removido com sucesso.");
				int numTable = Integer.parseInt(aux.getProx().getMesa());
				mesa.atualizarMesa(numTable, 0, true, 4, null);
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}
	
}
