package sistema;

public class Mesas {
	
	private Nodo inicio;
	private int quantMesas;
		
	public boolean vazia() {//Verifica se a tem mesas no local.
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	// Função para colocar uma mesa no local.
	public void adicionarMesa(boolean disp, int cadeirasDisp, int numMesa, String cliente) {
		Nodo novoNodo = new Nodo(disp, cadeirasDisp, numMesa, cliente);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
		quantMesas++;		
	}
	
	//Função para mostrar informações das mesas
	public void consultaMesas() {
		if (vazia()) {
			System.out.println("Nenhuma mesa disponível.");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			if(aux.isDisponivel() == true) {
				System.out.println("Disponibilidade da mesa: Livre" + " | Número da mesa - " + aux.getNumMesa() + " | Cadeiras Disponíveis - " + aux.getCadeirasDisp());
			} else {
				System.out.println("Disponibilidade da mesa: Ocupada" + " | Número da mesa - " + aux.getNumMesa() + " | Cadeiras Disponíveis - " + aux.getCadeirasDisp() + " | Cliente na mesa - " + aux.getClienteNaMesa());
			}
			aux = aux.getProx();
		}		
	}
	
	//Função para atualizar Mesas
	public void atualizarMesa(int numMesa, int numAtualizado, boolean dispAtualizado, int cadeirasDispAtualizado, String clienteAtualizado) {
		if (vazia()) {
			System.out.println("Sem mesas atualmente.");
			return;
		}
		Nodo aux = inicio;
		int cont = 0;
		if (aux.getProx() != null) {
			if (aux.getNumMesa() == numMesa) {
				aux.setNumMesa(numMesa);
				aux.setDisponivel(dispAtualizado);
				aux.setCadeirasDisp(cadeirasDispAtualizado);
				aux.setClienteNaMesa(clienteAtualizado);
				return;
			}			
		}
		while (cont != quantMesas) {
			cont++;
			if (aux.getProx().getNumMesa() == numMesa) {
				aux.getProx().setNumMesa(numMesa);
				aux.getProx().setDisponivel(dispAtualizado);
				aux.getProx().setCadeirasDisp(cadeirasDispAtualizado);
				aux.setClienteNaMesa(clienteAtualizado);
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para retirar uma mesa específica
	public void retirarMesa(int numMesa) {
		if (vazia()) return;
		if (inicio.getNumMesa() == numMesa) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNumMesa() == numMesa) {				
				aux.setProx(aux.getProx().getProx());
				return;
			}		
			aux = aux.getProx();
		}
	}
	
	//Função para o cliente escolher uma mesa.
	public void escolherMesa(Cliente cli, String cliente, int quantClientes) {
		Nodo aux = inicio;
		//Verifica se existe cliente para solicitar mesas.		
		Nodo auxClient = cli.getInicio();
		if (auxClient == null) {
			System.out.println("Sem clientes para solicitar mesas");
			return;
		}
		
		//Caso não tenha nenhuma mesa.
		if (vazia()) {
			//Chama a função para criar uma mesa e já insere os dados corretos
			adicionarMesa(false, (4-quantClientes), 0, cliente);
			if (aux.getNome() == cliente) {
				cli.atualizarCliente(cliente, cliente, "0"); // --------------------- TÁ ERRADO, ALTERAR QUANDO ACHAR A SOLUÇÃO ------------------------
				return;
			}
			while (aux.getProx() != null) {
				if (aux.getProx().getNome() == cliente) {
					cli.atualizarCliente(cliente, cliente, "0");// --------------------- TÁ ERRADO, ALTERAR QUANDO ACHAR A SOLUÇÃO ------------------------
					return;
				}
				aux = aux.getProx();
			}
			return;
		}
		
		aux = inicio;
		auxClient = cli.getInicio();
		String conversor;// Variavel para converter o int do "numMesa" para String.
		
		//Caso já tenha mesas.
		if (auxClient.getNome() == cliente) {
			conversor = aux.getNumMesa() + "";
			
			//Salva o nodo de "Cliente" e procura o cliente que solicitou a mesa
			auxClient = cli.getInicio();
			//Caso seja o primeiro da lista
			if (auxClient.getNome() != null) {
				if (auxClient.getNome() == cliente) {
					auxClient.setNome(cliente);
					auxClient.setMesa(conversor);
					return;
				}			
			}
			//Caso esteja depois do primeiro da lista
			while (auxClient.getProx() != null) {
				if (auxClient.getProx().getNome() == cliente) {
					auxClient.setNome(cliente);
					auxClient.setMesa(conversor);
					return;
				} 
				auxClient = auxClient.getProx();
			}
			//Salva as informações na mesa do cliente novo
			aux.setCadeirasDisp(4-quantClientes);
			aux.setDisponivel(false);
			aux.setClienteNaMesa(cliente);
			return;
		}
		//Salva o nodo de "Cliente" e procura o cliente que solicitou a mesa
		auxClient = cli.getInicio();
		while (aux != null) {
			if(aux.isDisponivel() == true) {
				conversor = aux.getNumMesa() + "";
				
				//Caso seja o primeiro da lista
				if (auxClient.getNome() != null) {
					if (auxClient.getNome() == cliente) {
						auxClient.setNome(cliente);
						auxClient.setMesa(conversor);
						return;
					}			
				}
				//Caso esteja depois do primeiro da lista
				while (auxClient.getProx() != null) {
					if (auxClient.getProx().getNome() == cliente) {
						auxClient.setNome(cliente);
						auxClient.setMesa(conversor);
						return;
					} 
					auxClient = auxClient.getProx();
				}
				
				//Salva as informações na mesa do cliente novo
				aux.setClienteNaMesa(cliente);
				aux.setCadeirasDisp(4-quantClientes);
				aux.setDisponivel(false);
				System.out.println("Mesa escolhida: " + aux.getNumMesa());
				return;
			} else {
				System.out.println("Disponibilidade da mesa: Ocupada" + " | Número da mesa - " + aux.getNumMesa() + " | Cadeiras Disponíveis - " + aux.getCadeirasDisp());
			}
			aux = aux.getProx();
		}		
	}
}
