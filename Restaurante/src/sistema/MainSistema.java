package sistema;

import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {
		
		Funcionarios func = new Funcionarios();
		Cliente c = new Cliente();
		Pedidos p = new Pedidos();
		Mesas m = new Mesas();
		ProdutosPedidos pd = new ProdutosPedidos();
		Historico h = new Historico();
		Estastisticas est = new Estastisticas();
		est.criarEst();
		
		// Contrata um funcionário, inserindo o cargo, escala, nome, o que está fazendo no momento e o id dos pedidos
		func.contratarFunc("Cozinheiro", "Carlos", true, 0); 
		func.contratarFunc("Garçom", "Roberta Farias", true, 0);
//		func.contratarFunc("Garçom", "Djenifer", true, 0);
		func.contratarFunc("Caixa", "Julio Marcos", true, 0);
		//Coloca as mesas no estabelecimento
		m.adicionarMesa(true, 4, null, est);
//		m.adicionarMesa(true, 4, null);
//		m.adicionarMesa(true, 4, null);		
		c.inserirCliente("Igor Cadore", null, 0, null, pd);
		m.escolherMesa(c, "Igor Cadore", false, 1, null, null, null, pd);
		p.fazerPedido(func, c, "Igor Cadore", 1, pd);
		p.atualizarRestaurant(c, func, est);
		p.atualizarRestaurant(c, func, est);
		
		boolean sistema = true;
		System.out.println("Bem vindo ao sistema de gerenciamento do restaurante Patolístico!");
		System.out.println("Selecione a numeração das opções para usar o sistema.");

		Scanner resposta = new Scanner(System.in);
		Scanner respostaString = new Scanner(System.in);
		Scanner respostaDouble = new Scanner(System.in);
		
		int respostaNum;
		
		while (sistema == true) {
			// ===========  Menu do sistema =========== 
	        System.out.print("\n|---Qual área deseja administrar?---|\n");
			System.out.println("| 1 | Funcionários                  |");
			System.out.println("| 2 | Clientes                      |");
			System.out.println("| 3 | Pedidos                       |");
			System.out.println("| 4 | Mesas                         |");
			System.out.println("| 5 | Esperar uns minutos           |");// Faz o "mundo" avançar um pouco, mudando e atualizando o stats dos pedidos e funcionários.
			System.out.println("| 6 | Estastísticas                 |");
			System.out.println("| 7 | Emitir Histórico              |");
			System.out.println("| 8 | Encerrar Sistema              |");
	        System.out.print("|-----------------------------------|\n");		
	        //Utilizado para obter a resposta do usuario, dependendo do digitado, faz tal coisa.
			respostaNum = resposta.nextInt();
			
			// =================  RESPOSTA 1 =============

			while (respostaNum == 1) { // ---- Gerenciamento de Funcionários ----
				
				System.out.print("\n|---                Funcionários                  ---|\n");
				System.out.println("| 1 | Consultar informações dos funcionários         |");
				System.out.println("| 2 | Mostrar escala de trabalho                     |");
				System.out.println("| 3 | Contratar Funcionário                          |");
				System.out.println("| 4 | Dispensar Funcionário (Precisa do ID)          |");
				System.out.println("| 5 | Voltar ao Início                               |");
				System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				if (respostaNum == 1) {// =========== Consultar info func =========== 
					func.mostraFunc();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
					
				} else if (respostaNum == 2){// =========== Escala func =========== 
					
					func.escalasFunc();
					
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					
					resposta.nextInt();	
					
				} else if (respostaNum == 3) {// =========== Contratar func =========== 
					
					String nome;
					System.out.println("|--- Insira as informações do funcionário ---|\n");
					System.out.println("| Nome   |" );
					
					nome = respostaString.nextLine();
					
					System.out.println("| Cargo  |");
					System.out.println("| 1 - Cozinheiro  |");
					System.out.println("| 2 - Garçom      |");
					System.out.println("| 3 - Caixa       |");
					
					respostaNum = resposta.nextInt();
					
					if (respostaNum == 1) { // =========== Escolhe o cargo =========== 
						func.contratarFunc("Cozinheiro", nome, true, 0);
					} else if (respostaNum == 2) {
						func.contratarFunc("Garçom", nome, true, 0);
					} else if (respostaNum == 3) {
						func.contratarFunc("Caixa", nome, true, 0);
					} else {
						System.out.println("Número invalido tente de novo.");
					}											

				} else if (respostaNum == 4){// =========== Dispensar Func =========== 
					System.out.println("|--- Insira o ID do funcionário ---|\n");
					resposta.nextInt();
					func.dispensarFunc(respostaNum);
					
				} else if (respostaNum == 5){// =========== Voltar pro começo =========== 
					respostaNum = 0;		
					
				} else {
					System.out.println("Opção inválida, insira de novo.");
				}
				
				if (respostaNum != 0) {
					respostaNum = 1;
				}				
			}
			// =================  RESPOSTA 2 =============
			
			while (respostaNum == 2) {// ---- Gerenciamento de Clientes -----
				System.out.print("\n|---                 Clientes                     ---|\n");
				System.out.println("| 1 | Adicionar Cliente                              |");
				System.out.println("| 2 | Mostrar Clientes                               |");
				System.out.println("| 3 | Escolher mesa                                  |");
				System.out.println("| 4 | Atualizar info Cliente                         |");
				System.out.println("| 5 | Excluir cliente                                |");
				System.out.println("| 6 | Ir pagar no caixa                              |");
				System.out.println("| 7 | Forma de pagar/Emissão da nota                 |");
				System.out.println("| 8 | Voltar ao início                               |");
		        System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				
				if (respostaNum == 1) {// =========== Adicionar novo cliente =========== 
					System.out.println("|--- Insira o nome completo do Cliente ---|\n");
					String nome = respostaString.nextLine();
					c.inserirCliente(nome, null, 0, "Esperando uma mesa", pd);
					est.adFilaAlmosando(1);
					System.out.println("|Cliente adicionado com sucesso|");
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
					
				} else if (respostaNum == 2){// ====== Mostrar todos os clientes =======
					c.consultaCliente();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();		
					
				} else if (respostaNum == 3){// ====== Escolhe uma mesa para um cliente =======
					System.out.println("|Insira o nome do cliente tentando pegar uma mesa|");
					String nome = respostaString.nextLine();
					System.out.println("|Este cliente está acompanhado?|");
					String respostaText = respostaString.nextLine();
					boolean acompanhado = false;
					if (respostaText.equals("Sim") || respostaText.equals("sim")) {
						acompanhado = true;
						System.out.println("|Quantos acompanhantes? (Aceitamos no máximo 4 pessoas em uma mesa!)|");
						respostaNum = resposta.nextInt();
						// cria variaveis para os acompanhantes
						String acomp1 = null;
						String acomp2 = null;
						String acomp3 = null;
						switch (respostaNum) {// Anota o nome dos acompanhantes
	                        case 1:
	    					System.out.println("|Insira o nome do acompanhante: |");
	    					acomp1 = respostaString.nextLine(); 
	                           break;
	                        case 2:
	                       	System.out.println("|Insira o nome do 1° acompanhante: |");
	    					acomp1 = respostaString.nextLine();  
	    					System.out.println("|Insira o nome do 2° acompanhante: |");
	    					acomp2 = respostaString.nextLine(); 
	                           break;
	                        case 3:
	                       	System.out.println("|Insira o nome do 1° acompanhante: |");
	    					acomp1 = respostaString.nextLine();  
	    					System.out.println("|Insira o nome do 2° acompanhante: |");
	    					acomp2 = respostaString.nextLine(); 
	    					System.out.println("|Insira o nome do 3° acompanhante: |");
	    					acomp3 = respostaString.nextLine(); 
	                           break;
	                       default:
	                           System.out.println("Não suportamos essa quantidade de pessoas.");
	                    }
						m.escolherMesa(c, nome, acompanhado, (respostaNum + 1), acomp1, acomp2, acomp3, pd);
						est.adQuantEsperandoPed(respostaNum+1);
						est.remFilaAlmosando(1);
						est.remQuantMesasDisp(1);
					} else {
						est.adQuantEsperandoPed(1);
						est.remFilaAlmosando(1);
						est.remQuantMesasDisp(1);
						m.escolherMesa(c, nome, acompanhado, 1, null, null, null, pd);// Insere as informações do cliente na mesa, se tem acompanhante
					}
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
				} else if (respostaNum == 4) { // =========== Atualiza info de clientes ========
				    System.out.println("|--- Insira o nome completo do Cliente ---|\n");
				    String nomeOriginal = respostaString.nextLine();
				    
				    System.out.println("|--- Insira o ID do pedido ---|\n");
				    String nomeNovo = respostaString.nextLine();
				    
				    c.atualizarCliente(nomeOriginal, nomeNovo, null, "Esperando uma mesa");
				    
				} else if (respostaNum == 5) { // =========== DELETA UM CLIENTE =========== 
					
					System.out.println("|--- Insira o nome completo do Cliente que deseja excluir ---|\n");
				    String nome = respostaString.nextLine();
				    c.deletarCliente(m, nome, est);
				    
				} else if (respostaNum == 6) { // =========== Faz tal cliente ir ao caixa pagar a comanda =========== 
					
					System.out.println("|--- Insira o nome do cliente que vai levantar para ir pro caixa ---|\n");
				    String nome = respostaString.nextLine();
				    c.irPagar(m, func, nome, est);
				    est.remQuantComendo(1);
				    est.adFilaCaixa(1);
				    
				    
				} else if (respostaNum == 7) { // =========== PEDE A FORMA DE PAGAMENTO, MOSTRA O QUE DEVE E FAZ O TROCO SE PRECISAR =========== 
					
					System.out.println("|--- Insira o nome do cliente que está no caixa ---|\n");// Pede o nome do cliente que estiver no caixa para pagar.
				    String nome = respostaString.nextLine();
				    c.consultaCliente();//Mostra os clientes para ficar mais fácil de responder.
				    
					System.out.println("|--- Qual o ID da comanda? ---|\n");
					int idComand = resposta.nextInt();
					
					System.out.println("|--- Sua Comanda: ---|\n");
					pd.verComanda(idComand, c);// Mostra os pedidos feitos e quanto deve
					Double valorDevido = 0.0;
					Nodo auxCli = c.getInicio();//procura o cliente da comanda para poder pegar o valor que deve.
					while (auxCli != null) {
						if (auxCli.getIdComandaCliente() == idComand) {
							valorDevido = auxCli.getValorComanda();
						}
						auxCli = auxCli.getProx();
					}
					System.out.println("|--- De acordo com a comanda, você deve um total de R$ " + valorDevido + " ---|\n");
					
					System.out.println("|--- Escolha a forma de pagamento ---|\n");
					System.out.println("|--- 1 - Cartão   ---|\n");
					System.out.println("|--- 2 - Dinheiro ---|");
					int opcaoPag = resposta.nextInt();
					if (opcaoPag == 1) {
				        System.out.print("| Insira o valor devido - R$ " + valorDevido + " |\n");
				        Double valorPago = respostaDouble.nextDouble();
				        if (valorPago < valorDevido) {
				        	System.out.println("| O valor devido ainda não foi pago, reinicie a operação para continuar. |");
				        } else if (valorPago > valorDevido) {
				            System.out.print("| O valor pago excedeu o necessário, um troco será reembolsado ao senhor(a). |");
				            Double troco = valorPago - valorDevido;
				            String formPagamento = "Cartão";
				            h.adicionarHistorico(nome, valorPago, troco, formPagamento);
				            System.out.print("| O seu comprovante de pagamento, obrigado! Tenha um ótimo dia. |");
				            h.emitirComprovante(nome, valorPago, valorDevido, formPagamento, troco);
				            auxCli = c.getInicio();
				            while (auxCli != null) {
				            	if (auxCli.getNome() == nome) {
				            		auxCli.setStatsCliente("Saiu do restaurante");
				            		c.deletarCliente(m, nome, est);
				            	}
				            	auxCli = auxCli.getProx();
				            }
				            est.remFilaCaixa(1);
				        } else {
				        	Double troco = 0.0; // Cria uma var para anotar o troco do cliente se precisar
				            String formPagamento = "Cartão"; // Pega a forma de pagamento
				            h.adicionarHistorico(nome, valorPago, troco, formPagamento); // adiciona no histórico do restaurante o pedido, cliente e valor
				            System.out.print("| O seu comprovante de pagamento, obrigado! Tenha um ótimo dia. |");
				            h.emitirComprovante(nome, valorPago, valorDevido, formPagamento, troco); // Emite o comprovante de pagamento do cliente.
				            auxCli = c.getInicio();// acha o cliente que pagou a conta e remove do sistema.
				            while (auxCli != null) {
				            	if (auxCli.getNome().equals(nome)) {
				            		c.deletarCliente(m, nome, est);
				            	}
				            	auxCli = auxCli.getProx();
				            }
				            est.remFilaCaixa(1);
				        } 						
					} else if( opcaoPag == 2 ) {
						System.out.print("| Insira o valor devido - R$ " + valorDevido + " |\n");
				        Double valorPago = respostaDouble.nextDouble();
				        if (valorPago < valorDevido) {
				        	System.out.println("| O valor devido ainda não foi pago, reinicie a operação para continuar. |");
				        } else if (valorPago > valorDevido) {
				            System.out.print("| O valor pago excedeu o necessário, um troco será reembolsado ao senhor(a). |");
				            Double troco = valorPago - valorDevido;
				            String formPagamento = "Dinheiro";
				            h.adicionarHistorico(nome, valorPago, troco, formPagamento);
				            System.out.print("| O seu comprovante de pagamento, obrigado! Tenha um ótimo dia. |");
				            h.emitirComprovante(nome, valorPago, valorDevido, formPagamento, troco);
				            auxCli = c.getInicio();
				            while (auxCli != null) {
				            	if (auxCli.getNome() == nome) {
				            		auxCli.setStatsCliente("Saiu do restaurante");
				            		c.deletarCliente(m, nome, est);
				            	}
				            	auxCli = auxCli.getProx();
				            }
				            est.remFilaCaixa(1);
				        } else {
				        	Double troco = 0.0;
				            String formPagamento = "Dinheiro";
				            h.adicionarHistorico(nome, valorPago, troco, formPagamento);
				            System.out.print("| O seu comprovante de pagamento, obrigado! Tenha um ótimo dia. |");
				            h.emitirComprovante(nome, valorPago, valorDevido, formPagamento, troco);
				            auxCli = c.getInicio();
				            while (auxCli != null) {
				            	if (auxCli.getNome() == nome) {
				            		auxCli.setStatsCliente("Saiu do restaurante");
				            		c.deletarCliente(m, nome, est);
				            	}
				            	auxCli = auxCli.getProx();
				            }
				            est.remFilaCaixa(1); 
				        } 
					} else {
				        System.out.print("| Opção inválida, tente novamente |\n");
					}
				    
				} else if (respostaNum == 8) {// ============ ENCERRA O GERENCIAMENTO DE CLIENTES ================
					respostaNum = 0;
				} else {
					System.out.println("| Opção inválida, tente novamente.");
				}			
				if (respostaNum != 0) {
					respostaNum = 2;
				}	
			}
			
			// =================  RESPOSTA 3 =============

			while(respostaNum == 3) {
				System.out.print("\n|---                 Pedidos                      ---|\n");
				System.out.println("| 1 | Mostrar cardápio                               |");
				System.out.println("| 2 | Fazer Pedido                                   |");
				System.out.println("| 3 | Atualizar Pedido   (Precisa do ID)             |");
				System.out.println("| 4 | Cancelar pedido                                |");
				System.out.println("| 5 | Ver pedidos                                    |");
				System.out.println("| 6 | Voltar ao início                               |");
		        System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				
				if (respostaNum == 1) {// =========== MOSTRA O CARDÁPIO =========== 
					p.cardapio();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
					
				} else if (respostaNum == 2){// ====== Faz um novo pedido =======
					System.out.println("|--- Insira o nome do cliente que está fazendo o pedido ---|\n");
					String nome = respostaString.nextLine();
					
					p.cardapio();
					System.out.println("|--- Insira o pedido que você deseja ---|\n");
					respostaNum = resposta.nextInt();
					p.fazerPedido(func, c, nome, respostaNum, pd);
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();		
					
				} else if (respostaNum == 3) { // =========== Atualiza info do pedido ========
				    System.out.println("|--- Insira o nome do cliente ---|\n");
				    String nome = respostaString.nextLine();
				    
				    System.out.println("|--- Insira o nome atualizado do Cliente ---|\n");
				    String nomeNovo = respostaString.nextLine();
				    
				    c.atualizarCliente(nome, nomeNovo, null, "Esperando uma mesa");
				    
				} else if (respostaNum == 4) { // =========== DELETA UM PEDIDO =========== 
					p.consultaPedido();
					System.out.println("|--- Insira o ID do pedido que deseja excluir ---|\n");
				    respostaNum = resposta.nextInt();
				    p.deletarPedido(respostaNum, func, c, pd);
				    
				} else if (respostaNum == 5) { // =========== MOSTRA OS PEDIDOS =========== 
				    p.consultaPedido();
				    System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();	
				    
				} else if (respostaNum == 6) {
					respostaNum = 0;
				} else {
					System.out.println("| Opção inválida, tente novamente.");
				}
				
				if (respostaNum != 0) {//Confirma que vai continuar neste loop até o usuario mudar de ideia
					respostaNum = 3;
				}
			}
			
			// =================  RESPOSTA 4 =============

			while (respostaNum == 4) {
				
				System.out.print("\n|---                   Mesas                      ---|\n");
				System.out.println("| 1 | Consultar Mesas                                |");
				System.out.println("| 2 | Adicionar Mesa                                 |");
				System.out.println("| 3 | Atualizar Mesa   (Precisa do ID)               |");
				System.out.println("| 4 | Remover Mesa     (Precisa do ID)               |");
				System.out.println("| 5 | Voltar ao início                               |");
		        System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				
				if (respostaNum == 1) {// =========== MOSTRA AS MESAS =========== 
					m.consultaMesas();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
					
				} else if (respostaNum == 2){// ====== ADICIONA UMA NOVA MESA =======
					System.out.println("|--- Mesa adicionada ---|\n");
					m.adicionarMesa(true, 4, null, est);
					est.adQuantMesasDisp(1);
					
				} else if (respostaNum == 3) { // =========== ATUALIZA UMA MESA ========
					m.consultaMesas();
					System.out.println("|--- Insira o ID da mesa que deseja atualizar ---|\n");
				    int idMesa = resposta.nextInt();
					System.out.println("|--- Agora envie as informações para botar na mesa ---|\n");
					System.out.println("|--- Tem clientes nela?:  (Sim ou Não)---|\n");
					String respostaCli = respostaString.nextLine();
					Nodo auxMesa = m.getInicio();
					while (auxMesa.getNumMesa() != idMesa) {
						auxMesa = auxMesa.getProx();
					}
					if (auxMesa.isDisponivel()) {
						System.out.println("|--- Quantidade de cadeiras disponíveis: (max 4)---|\n");
						int cadeiras = resposta.nextInt();
						System.out.println("|--- Está disponível:  (Sim ou Não)---|\n");
						String respostaText = respostaString.nextLine();
						boolean ocupada = false;
						if (respostaText.equals("Sim") || respostaText.equals("sim")) {
							ocupada = true;
							m.atualizarMesa(idMesa, ocupada, cadeiras, null);
							System.out.println("Mesa atualizada com sucesso.");
							est.remQuantMesasDisp(1);
						} else {
							m.atualizarMesa(idMesa, ocupada, cadeiras, null);
							System.out.println("Mesa atualizada com sucesso.");
						}
					} else {
						System.out.println("Ainda há clientes na mesa, altere as informações depois.");
					}
				    
				} else if (respostaNum == 4) { // =========== REMOVE UMA MESA =========== 
					m.consultaMesas();
					System.out.println("|--- Insira o ID da mesa que deseja remover ---|\n");
				    respostaNum = resposta.nextInt();
				    m.retirarMesa(respostaNum);
				    est.remQuantMesasDisp(1);
				    
				} else if (respostaNum == 5) {
					respostaNum = 0;
				} else {
					System.out.println("| Opção inválida, tente novamente.");
				}
				if (respostaNum != 0) {//Confirma que vai continuar neste loop até o usuario mudar de ideia
					respostaNum = 4;
				}
			}
			
			// ==========================================  RESPOSTA 5 =============================================
			
			if (respostaNum == 5) {
				p.atualizarRestaurant(c, func, est);
			}
			
			// ==========================================  RESPOSTA 6 =============================================
			
			if (respostaNum == 6) {				
				est.mostrarEstastisticas();//Mostra as informações do recindo
				System.out.print("|---------------|\n");
				System.out.println("| 1 | Continuar |");
				System.out.println("|---------------|\n");
				resposta.nextInt();
			}
			
			// ==========================================  RESPOSTA 7 =============================================
			
			if (respostaNum == 7) {
					h.mostrarHistorico();
				}
			// ==========================================  RESPOSTA 8 =============================================

			if (respostaNum == 8) {
				sistema = false;
			}
			// =================  FIM DAS RESPOSTAS =============
		}
		respostaString.close();
		resposta.close();
	}
}