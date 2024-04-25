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
	
	// --------- Função para colocar uma mesa no local.
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
	
	// ------------ Função para atualizar Mesas
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
				System.out.println("Mesa " + numMesa + " atualizada com sucesso.");
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
				System.out.println("Mesa " + numMesa + " atualizada com sucesso.");
			} 
			aux = aux.getProx();
		}
	}
	
	// ------------ Função para retirar uma mesa específica
	public void retirarMesa(int numMesa) {
		
		if (vazia()) return;
		if (inicio.getNumMesa() == numMesa) {
			if(inicio.isDisponivel() == true) {
				inicio = inicio.getProx();
				System.out.println("Mesa " + numMesa + " removida com sucesso.");
				return;
			} else {
				System.out.println("Ainda há clientes na mesa " + numMesa + ", espere-os sair primeiro.");
				return;
			}						
		}		
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNumMesa() == numMesa) {	
				if (aux.getProx().isDisponivel() == true) {
					aux.setProx(aux.getProx().getProx());
					System.out.println("Mesa " + numMesa + " removida com sucesso.");
					return;
				} else {
					System.out.println("Ainda há clientes na mesa " + numMesa + ", espere-os sair primeiro.");
					return;
				}
			}		
			aux = aux.getProx();
		}		
	}	
	
	// --------------- Função para o cliente escolher uma mesa.
	public void escolherMesa(Cliente cli, String cliente, boolean acompanhado, int quantClientes, String acompanhante1, String acompanhante2, String acompanhante3) {
		
		Nodo aux = inicio;
		//Verifica se existe cliente para solicitar mesas.		
		Nodo auxClient = cli.getInicio();
		if (auxClient == null) {
			System.out.println("Sem clientes para solicitar mesas");
			return;
		}
		//Caso não tenha nenhuma mesa.
		if (vazia()) {
			System.out.println("Estamos sem mesas no momento, volte outra hora por favor");
			return;
		}		
		if (acompanhado == false) { // Verifica se o cliente veio acompanhado e se a quantia de acompanhante ultrapassa 4 ou não.
			
			String conversor;// Variavel para converter o int do "numMesa" para String.
			
			//Caso tenha mesas		
			while (aux != null) {
				if(aux.isDisponivel() == true) {
					//Salva as informações na mesa do cliente novo
					aux.setClienteNaMesa(cliente);// Define um cliente predominante para a mesa.
					aux.setCadeirasDisp(4-quantClientes);
					aux.setDisponivel(false);
					conversor = aux.getNumMesa() + "";
					System.out.println(cliente + " escolheu a mesa: " + aux.getNumMesa());
					cli.atualizarCliente(cliente, cliente, conversor);
					return;
				} else {
					System.out.println(cliente + " tentou pegar a mesa n°" + aux.getNumMesa() + ", mas ela está ocupada.");
				}
				aux = aux.getProx();
			}		
		} else {
			if (quantClientes > 4) {
				System.out.println(" Sobre o cliente " + cliente + ", lamentamos informar, mas não temos lugares o suficiente para essa quantia de gente, suportamos no máximo 4 clientes em uma mesa e não podemos juntar as mesas e nem pegar cadeiras disponíveis.");
			} else {
				String conversor;// Variavel para converter o int do "numMesa" para String.
				
				//Caso tenha mesas		
				while (aux != null) {
					if(aux.isDisponivel() == true) {
						//Salva as informações na mesa do cliente novo
						aux.setClienteNaMesa(cliente);// Define um cliente predominante para a mesa.
						aux.setCadeirasDisp(4-quantClientes);
						aux.setDisponivel(false);
						conversor = aux.getNumMesa() + "";
						System.out.println(cliente + " escolheu a mesa: " + aux.getNumMesa());
						//Verifica se o cliente predominante está acompanhado
						if (quantClientes == 2) {
							cli.inserirClienteFinal(acompanhante1, conversor);
						} else if (quantClientes == 3) {
							cli.inserirClienteFinal(acompanhante2, conversor);
						} else if (quantClientes == 4) {
							cli.inserirClienteFinal(acompanhante3, conversor);
						}							
						cli.atualizarCliente(cliente, cliente, conversor);
						return;
					} else {
						System.out.println(cliente + " e seus acompanhantes tentaram pegar a mesa n°" + aux.getNumMesa() + ", mas ela está ocupada.");
					}
					aux = aux.getProx();
				}					
			}
		}
	}
}
