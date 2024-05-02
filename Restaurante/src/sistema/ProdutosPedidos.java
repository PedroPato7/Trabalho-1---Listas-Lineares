package sistema;

public class ProdutosPedidos {
	
	private Nodo inicio;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}	
	// Função para inserir no inicio.
		public void criarComanda(int idComanda, String descProd) {//Salva o id da comanda para se ligar ao cliente
			Nodo novoNodo = new Nodo(idComanda, descProd);
			novoNodo.setProx(inicio);
			inicio = novoNodo;
		}
	// Função para marcar o produto pedido na comanda.
		public void marcarNaComanda(int idComanda, String descProd) {//Primeiro o id do cliente será passado para achar qual a comanda certa.
			if (vazia()) {//Verifica se foi feita uma comanda ou não.
				System.out.println("Sem comandas feitas.");
				return;
			}
			Nodo auxComanda = inicio;
			while (auxComanda != null) {
				if (auxComanda.getIdComanda() == idComanda) {
					if (auxComanda.getDescProd().contains("Nenhum pedido ainda.")) {
						auxComanda.setDescProd(descProd);
						return;
					} else {
						criarComanda(idComanda, descProd);
						return;
					}
				}
				auxComanda = auxComanda.getProx();
			}
		}
		
		//Função para mostrar a comanda e os pedidos feitos até agora.
		public void verComanda(int idComandaCliente, Cliente cli) {
			if (vazia()) {//Verifica se foi feita uma comanda ou não.
				System.out.println("Sem comandas feitas.");
				return;
			}
			Nodo auxCli = cli.getInicio();
			Nodo auxComanda = inicio;
			System.out.print("|---------------------------------|\n");
			System.out.print("|       ---  Comanda  ---         |\n");
	        System.out.print("|---------------------------------|\n");
	        while (auxComanda != null) {
	        	if ( auxComanda.getIdComanda() == idComandaCliente) {
	        		System.out.print("| 1x - " + auxComanda.getDescProd() + "                   |\n");
	        	}
	        	auxComanda = auxComanda.getProx();
	        }    
	        System.out.print("|                                 |\n");
	        while (auxCli != null) {
	        	if (auxCli.getIdComandaCliente() == idComandaCliente) {
	    	        System.out.print("|---------------------------------|\n");
	    	        System.out.print("| Valor total a pagar: " + auxCli.getValorComanda() + "       |\n");
	        	}
	        	auxCli = auxCli.getProx();
	        }
	        System.out.print("|---------------------------------------------------------------|\n");
	        System.out.print("|Obs:. Não fazemos devolução se o seu pedido foi para a cozinha.|\n");
	        System.out.print("|---------------------------------------------------------------|\n");
	        
		}
		
		public void deletarComanda(int idComandaCliente, Cliente cli) {
			Nodo auxComanda = inicio;
			Nodo auxCli = cli.getInicio();
			if (vazia()) return;
			if (inicio.getIdComanda() == idComandaCliente) {//Acha a comanda do cliente
				while(auxCli != null) {//Acha o cliente da comanda
					if (auxCli.getIdComandaCliente() == idComandaCliente) {
						if (auxCli.getValorComanda() <= 0) {
							inicio = inicio.getProx();
							return;
						} else {
							switch (auxComanda.getDescProd()) {// Verifica qual item foi comprado na comanda
                            case "Spagethi":
                                auxCli.setValorComanda(auxCli.getValorComanda() - 17.50);
                                break;
                            case "Porção mista":
                                auxCli.setValorComanda(auxCli.getValorComanda() - 15.75);
                                break;
                            case "Batata Frita":
                                auxCli.setValorComanda(auxCli.getValorComanda() - 11.00);
                                break;
                            case "Soupa":
                                auxCli.setValorComanda(auxCli.getValorComanda() - 10.99);
                                break;
                            case "Suco Natural":
                                auxCli.setValorComanda(auxCli.getValorComanda() - 3.50);
                                break;
                            default:
							}
							inicio = inicio.getProx();
							return;
						}
					}
					auxCli = auxCli.getProx();
				}
			}
			while (auxComanda.getProx() != null) {
				if (auxComanda.getProx().getIdComanda() == idComandaCliente) {
					while(auxCli != null) {//Acha o cliente da comanda
						if (auxCli.getIdComandaCliente() == idComandaCliente) {
							if (auxCli.getValorComanda() <= 0) {
								auxComanda.setProx(auxComanda.getProx().getProx());
								return;
							} else {
								switch (auxComanda.getDescProd()) {// Verifica qual item foi comprado na comanda
	                            case "Spagethi":
	                                auxCli.setValorComanda(auxCli.getValorComanda() - 17.50);
	                                break;
	                            case "Porção mista":
	                                auxCli.setValorComanda(auxCli.getValorComanda() - 15.75);
	                                break;
	                            case "Batata Frita":
	                                auxCli.setValorComanda(auxCli.getValorComanda() - 11.00);
	                                break;
	                            case "Soupa":
	                                auxCli.setValorComanda(auxCli.getValorComanda() - 10.99);
	                                break;
	                            case "Suco Natural":
	                                auxCli.setValorComanda(auxCli.getValorComanda() - 3.50);
	                                break;
	                            default:
								}
								auxComanda.setProx(auxComanda.getProx().getProx());
								return;
							}
						}
						auxCli = auxCli.getProx();
					}
					auxComanda.setProx(auxComanda.getProx().getProx());
					return;
				}
				auxComanda = auxComanda.getProx();
		}
	}
}