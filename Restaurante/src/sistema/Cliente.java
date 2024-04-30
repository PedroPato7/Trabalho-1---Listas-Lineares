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
	public void inserirCliente(String nome, String mesa, int numPed, String stats) {
		Nodo novoNodo = new Nodo(nome, mesa, numPed, stats);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
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
				System.out.println("- " + aux.getNome() + " | Mesa - " + aux.getMesa() + " | Stats: " + aux.getStatsCliente());
			} else {
				System.out.println("- " + aux.getNome() + " | Nenhuma mesa escolhida ainda " + "| Stats: " + aux.getStatsCliente());
			}
			aux = aux.getProx();
		}		
	}
	
	//Função para atualizar dados do cliente
	public void atualizarCliente(String nome, String nomeAtual, String mesaAtual, String stats) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux != null) {
			if (aux.getNome() == nome) {
				aux.setNome(nomeAtual);
				aux.setMesa(mesaAtual);
				aux.setStatsCliente(stats);
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
				aux.setStatsCliente(stats);
				return;
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar um cliente específico
	public void deletarCliente(Mesas mesa, String nome) {// ---------FAZER VERIFICAÇÃO SE O PEDIDO FOI ENTREGUE ANTES OU NÃO
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
