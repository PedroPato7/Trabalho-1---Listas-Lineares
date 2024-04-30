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
}
