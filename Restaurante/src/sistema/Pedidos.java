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
	public void fazerPedido(Funcionarios func, Cliente cli, String nomeCliente, int produtoNum) {
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
		                        Nodo novoNodo = new Nodo("Anotado", valor, countId);
		                        novoNodo.setProx(inicio);
		                        inicio = novoNodo;
		                        System.out.println("Pedido " + countId + " feito com sucesso, aguarde a preparação");
		                        auxFunc.setNumeracaoPedido(countId);
		                        auxFunc.setStatsFunc(false);
		                        auxCli.setNumeroDoPedido(countId);
		                        auxCli.setStatsCliente("Esperando pedido");
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
	
	//Função para atualizar o restaurante em tempo real, mudar os status dos pedidos, funcionários etc.
	public void atualizarRestaurant(Cliente cli, Funcionarios func, Mesas mesa) {
		Nodo auxCli = cli.getInicio();
		Nodo auxFunc = func.getInicio();
		Nodo auxMesa = mesa.getInicio();
		Nodo auxPed = inicio;
		
		if (func.vazia()) {
	        System.out.println("Sem funcionários no momento.");
	        return;
	    }
	    if (cli.vazia()) {
	        System.out.println("Sem clientes para fazer pedidos no momento.");
	        return;
	    }
	    if (vazia()) {
	        System.out.println("Sem pedidos no momento.");
	        return;
	    }
		
	    while (auxPed != null) {//Roda a lista de pedidos e altera todos os status, como se um tempo tivesse se passado e pedidos ficassem prontos e etc.
	    	
	    	while (auxCli != null) {
	    		if (auxCli.getStatsCliente().equals("Comendo")) {
	    			while (auxMesa != null) {//Verifica se tem mais de uma pessoa na mesa, e muda as informações dos clientes e da mesa para que possa ser usada de novo.
	    				String conversor = auxMesa.getNumMesa() + "";
	    				if (conversor.equals(auxCli.getMesa())) {
	    					if(auxMesa.getCadeirasDisp() < 3) {
	    						System.out.println("Ainda ha clientes na mesa, ela vai continuar ocupada ainda");
	    						auxMesa.setCadeirasDisp((auxMesa.getCadeirasDisp() + 1));
	    						auxCli.setMesa("Saiu");
	    					} else {
	    						System.out.println("O cliente " + auxCli.getNome() + " saiu da mesa e foi pagar aconta.");
	    						mesa.atualizarMesa(auxMesa.getNumMesa(), auxMesa.getNumMesa(), true, 4, "Vazio");
	    						auxCli.setMesa("Saiu");	    							    						
	    					}
	    					
	    				}
	    				auxMesa = auxMesa.getProx();
	    			}
		    		while (auxFunc != null) {//Muda o status do cliente para ir pagar a conta no caixa caso esteja disponivel
		    			if(auxFunc.getCargo().contains("Caixa")) {
		    				if(auxFunc.isStatsFunc()) {// Verifica se o caixa está ocupado
		    					auxCli.setStatsCliente("No caixa");
		    					auxFunc.setStatsFunc(false);;
		    					System.out.println("Cliente " + auxCli.getNome() + " no caixa para pagamento.");
		    				} else {
		    					auxCli.setStatsCliente("Na fila do caixa");
		    				}
		    			} else System.out.println("Estamos sem caixas por agora, logo tentaremos resolver esta situação.");
		    			auxFunc = auxFunc.getProx();
		    		}
		    	}	    		
	    		auxCli = auxCli.getProx();
	    	}
	    	
	    	
	    	auxCli = cli.getInicio();
	    	auxFunc = func.getInicio();
	    	
	    	if (auxPed.getStatsPedido().equals("Pronto")) {//Faz a mudança de status dos pedidos com status: "Pronto".
	    		while (auxFunc != null) {
	    			if (auxFunc.getCargo().contains("Garçom")) {//Procura os funcionarios com o cargo de Garçom.
	    				if(auxFunc.isStatsFunc()) {
	    					auxPed.setStatsPedido("Entregue");//Muda o status do pedido.
	    					while(auxCli != null) {
	    						if(auxCli.getNumeroDoPedido() == auxPed.getNumPedido()) {
	    							auxCli.setStatsCliente("Comendo");
	    							System.out.println("Pedido N.°" + auxPed.getNumPedido() + " do cliente " + auxCli.getNome() + " pronto.");
	    						}
	    						auxCli = auxCli.getProx();
	    					}	    					
	    				} else System.out.println("Os garçons estão ocupados no momento, espere mais um pouco.");
	    			}
	    			auxFunc = auxFunc.getProx();
	    		}
	    	}
	    	
	    	auxFunc = func.getInicio();
	    	
	    	if (auxPed.getStatsPedido().equals("Na cozinha")) {//Faz a mudança de status dos pedidos com status: "Na cozinha".
	    		while (auxFunc != null) {
	    			if(auxFunc.getCargo().contains("Cozinheiro")) {// Procura os funcionários com o cargo de cozinheiro.
	    				if (auxFunc.getNumeracaoPedido() == auxPed.getNumPedido()) {
	    					func.atualizarStatsFunc(auxPed.getNumPedido());
	    					auxPed.setStatsPedido("Pronto");// Muda o status do pedido. para que um garçom venha pegar e servir o cliente.
	    					System.out.println("Pedido N.°" + auxPed.getNumPedido() + " pronto, esperando um garçom vir pegar.");
	    				}
	    			}
	    			auxFunc = auxFunc.getProx();
	    		}
	    	}
	    	
	    	auxFunc = func.getInicio();//Reinicia a fila de funcionários para a próxima verificação.
	    	
	        if (auxPed.getStatsPedido().equals("Anotado")) {//Faz a mudança de status dos pedidos com status: "Anotados".
	        	while (auxFunc != null) {
	        		if (auxFunc.getCargo().contains("Cozinheiro")) {
	                	if (auxFunc.isStatsFunc()) {
		                        auxFunc.setStatsFunc(false);//Atualiza o status do Funcionário Cozinheiro para ocupado.
		                        auxFunc.setNumeracaoPedido(auxPed.getNumPedido());// Atualiza o número do pedido que o funcionário está trabalhando no momento.
		                        auxFunc = func.getInicio();//Reinicia a fila de funcionários
		                        while (auxFunc != null) {//Procura o Garçom que tem o número do pedido salvo e deixa ele livre para fazer/entregar pedidos.
		                        	if ( auxFunc.getCargo().contains("Garçom")) {
		                        		if(auxFunc.getNumeracaoPedido() == auxPed.getNumPedido()) {
				                        	func.atualizarStatsFunc(auxFunc.getIdFunc());
			                        	}
		                        	}
		                        	auxFunc = auxFunc.getProx();
		                        }
		                        auxPed.setStatsPedido("Na cozinha");  
		                        System.out.println("Pedido n.°" + auxPed.getNumPedido() + " enviado para a cozinha, aguarde ele ficar pronto.");
	                	} else System.out.println("A cozinha está cheia, espere um tempo para o seu pedido ficar pronto.");
	        		} 
	        		if (auxFunc != null) {
	        			auxFunc = auxFunc.getProx();
	        		}	        		
	        	}
	        }
	        auxPed = auxPed.getProx();
	    }
	}
	
	//Função para atualizar pedidos
	public void atualizarPedido(int numPedido, String atualizarStats, Funcionarios func) {
		if (vazia()) {
			System.out.println("Sem pedidos para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux != null) {
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
        System.out.print("| 4 - Soupa   	   | R$ 10,99     |\n");
        System.out.print("| 5 - Suco Natural | R$ 3,50      |\n");
        System.out.print("|--------------------------------------------------------|\n");
        System.out.print("|Obs:. Informe o número do pedido ao garçom para faze-lo.|\n");
        System.out.print("|--------------------------------------------------------|\n");
	}
}
