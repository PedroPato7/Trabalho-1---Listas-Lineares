package sistema;

public class Pedidos {
	
	private Nodo inicio;
	private int countId = 1;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	// Função para adicionar um pedido.
	public void fazerPedido(Funcionarios func, Cliente cli, String nomeCliente, String stats, int produtoNum) {
	    double valor;
	    Nodo auxFunc = func.getInicio();
	    Nodo auxCli = cli.getInicio();
	    
	    if (func.vazia()) {
	        System.out.println("Sem funcionários no momento.");
	        return;
	    }
	    
	    if (cli.vazia()) {
	        System.out.println("Sem clientes para fazer pedidos no momento.");
	        return;
	    }
	    
	    while (auxCli != null) {
	        if (auxCli.getNome().equals(nomeCliente)) {
	            if (auxCli.getMesa() != null) {
	                while (auxFunc != null) {
	                	if (auxFunc.getCargo().contains("Garçom")) {
	                		if (auxFunc.isStatsFunc()) {
		                        switch (produtoNum) {
		                            case 1:
		                                valor = 17.50;
		                                break;
		                            case 2:
		                                valor = 15.75;
		                                break;
		                            case 3:
		                                valor = 11.00;
		                                break;
		                            case 4:
		                                valor = 10.99;
		                                break;
		                            case 5:
		                                valor = 3.50;
		                                break;
		                            default:
		                                System.out.println("Não temos esse pedido, caso ainda queira pedir algo, tente fazer o pedido novamente.");
		                                return;
		                        }
		                        
		                        Nodo novoNodo = new Nodo(stats, valor, countId);
		                        novoNodo.setProx(inicio);
		                        inicio = novoNodo;
		                        System.out.println("Pedido " + countId + " feito com sucesso, aguarde a preparação");
		                        auxFunc.setNumeracaoPedido(countId);
		                        auxFunc.setStatsFunc(false);
		                        auxCli.setNumeroDoPedido(countId);
		                        countId++;		                	
		                        return;
		                    } 
	                	}	   
	                	auxFunc = auxFunc.getProx();  	
	                }
	                
	            } else {
	                System.out.println("O cliente não está sentado em uma mesa.");
	                return;
	            }
	        }
	        auxCli = auxCli.getProx();
	    }
	    System.out.println("Cliente não encontrado.");
	}
	
	//Função para mostrar lista de pedidos
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
	
	//Função para atualizar o restaurante e mostrar informações gerais
	public void atualizarRestaurant() {
		
	}
	
	//Função para atualizar pedidos
	public void atualizarPedido(int numPedido, String atualizarStats, Funcionarios func) {
		if (vazia()) {
			System.out.println("Sem pedidos para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux.getProx() != null) {
			if (aux.getNumPedido() == numPedido) {
				aux.setStatsPedido(atualizarStats);
				if(atualizarStats.contains("Cancelado")) {
					func.atualizarStatsFunc(numPedido);
				}				
				return;
			}			
		}
		while (aux.getProx() != null) {
			if (aux.getProx().getNumPedido() == numPedido) {
				aux.getProx().setStatsPedido(atualizarStats);
				if(atualizarStats.contains("Cancelado")) {
					func.atualizarStatsFunc(numPedido);
				}
				return;				
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar um pedido específico
	public void deletarPedido(int numPedido, Funcionarios func) {
		if (vazia()) return;
		if (inicio.getNumPedido() == numPedido) {
			func.atualizarStatsFunc(numPedido);
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNumPedido() == numPedido) {
				func.atualizarStatsFunc(numPedido);
				aux.setProx(aux.getProx().getProx());
				return;
			}		
			aux = aux.getProx();
		}
	}
	
	//Função que mostra o cardápio 
	public void cardapio() {
        System.out.print("|---------------------------------|\n");
		System.out.print("| ---  Cardápio Patolístico  ---  |\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("| 1 - Spagethi     | R$ 17,50     |\n");
        System.out.print("| 2 - Porção mista | R$ 15,75     |\n");
        System.out.print("| 3 - Batata frita | R$ 11,00     |\n");
        System.out.print("| 4 - Refri 2L 	   | R$ 10,99     |\n");
        System.out.print("| 5 - Suco Natural | R$ 3,50      |\n");
        System.out.print("|--------------------------------------------------------|\n");
        System.out.print("|Obs:. Informe o número do pedido ao garçom para faze-lo.|\n");
        System.out.print("|--------------------------------------------------------|\n");
	}
}
