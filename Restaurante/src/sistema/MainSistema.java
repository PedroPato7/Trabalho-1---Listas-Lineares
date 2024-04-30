package sistema;

import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {
		
		Funcionarios func = new Funcionarios();
		Cliente c = new Cliente();
		Pedidos p = new Pedidos();
		Mesas m = new Mesas();
		ProdutosPedidos pd = new ProdutosPedidos();
		
		// Contrata um funcionário, inserindo o cargo, escala, nome, o que está fazendo no momento e o id dos pedidos
		func.contratarFunc("Cozinheiro", "Jair", true, 0); 
		func.contratarFunc("Garçom", "Robertinho", true, 0);
		func.contratarFunc("Garçom", "Djenifer", true, 0);
		func.contratarFunc("Caixa", "Junior", true, 0);
		//Coloca as mesas no estabelecimento
		m.adicionarMesa(true, 4, 0, null);
		m.adicionarMesa(true, 4, 1, null);
		m.adicionarMesa(true, 4, 2, null);
		//Verifica as informações das mesas postas
		m.consultaMesas();
		
		boolean sistema = true;
		System.out.println("Bem vindo ao sistema de gerenciamento do restaurante Patolístico!");
		System.out.println("Selecione a numeração das opções para usar o sistema.");

		Scanner resposta = new Scanner(System.in);
		Scanner respostaString = new Scanner(System.in);

		int respostaNum;
		String respostaText;
		
		while (sistema == true) {
			//Menu do sistema
	        System.out.print("\n|---Qual aréa deseja administrar?---|\n");
			System.out.println("| 1 | Funcionários                  |");
			System.out.println("| 2 | Clientes                      |");
			System.out.println("| 3 | Pedidos                       |");
			System.out.println("| 4 | Mesas                         |");
	        System.out.print("|-----------------------------------|\n");		
	        //Utilizado para obter a resposta do usuario, dependendo do digitado, faz tal coisa.
			respostaNum = resposta.nextInt();
			
			while (respostaNum == 1) { // ---- Gerenciamento de Funcionários ----
				System.out.print("\n|---                Funcionários                  ---|\n");
				System.out.println("| 1 | Consultar informações dos funcionários         |");
				System.out.println("| 2 | Mostrar escala de trabalho                     |");
				System.out.println("| 3 | Contratar Funcionário                          |");
				System.out.println("| 4 | Dispensar Funcionário (Precisa do ID)          |");
				System.out.println("| 5 | Voltar ao Início                               |");
				System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				if (respostaNum == 1) {//Consultar info func
					func.mostraFunc();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
				} else if (respostaNum == 2){//Escala func
					func.escalasFunc();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();									
				} else if (respostaNum == 3) {//Contratar func
					String nome;
					System.out.println("|--- Insira as informações do funcionário ---|\n");
					System.out.println("| Nome   |" );
					nome = respostaString.nextLine();
					System.out.println("| Cargo  |");
					System.out.println("| 1 - Cozinheiro  |");
					System.out.println("| 2 - Garçom      |");
					System.out.println("| 3 - Caixa       |");
					respostaNum = resposta.nextInt();
					if (respostaNum == 1) {
						func.contratarFunc("Cozinheiro", nome, true, 0);
					} else if (respostaNum == 2) {
						func.contratarFunc("Garçom", nome, true, 0);
					} else if (respostaNum == 3) {
						func.contratarFunc("Caixa", nome, true, 0);
					} else {
						System.out.println("Número invalido tente de novo.");
					}											

				} else if (respostaNum == 4){//Dispensar Func
					System.out.println("|--- Insira o ID do funcionário ---|\n");
					resposta.nextInt();
					func.dispensarFunc(respostaNum);
					
				} else if (respostaNum == 5){//Voltar pro começo
					respostaNum = 0;					
				} else {
					System.out.println("Opção inválida, insira de novo.");
				}
				if (respostaNum != 0) {
					respostaNum = 1;
				}				
			}
			while (respostaNum == 2) {// ---- Gerenciamento de Clientes -----
				System.out.print("\n|---                 Clientes                     ---|\n");
				System.out.println("| 1 | Adicionar Cliente                              |");
				System.out.println("| 2 | Mostrar Clientes                               |");
				System.out.println("| 3 | Atualizar info Cliente                         |");
				System.out.println("| 4 | Exclcuir cliente                               |");
				System.out.println("| 5 | Ir pagar no caixa                              |");
				System.out.println("| 6 | Voltar ao início                               |");
		        System.out.println("|----------------------------------------------------|\n");
				respostaNum = resposta.nextInt();//Pega a resposta do usuário
				
				if (respostaNum == 1) {//Adicionar novo cliente
					System.out.println("|--- Insira o nome completo do Cliente ---|\n");
					String nome = resposta.nextLine();
					c.inserirCliente(nome, null, 0, "Esperando uma mesa", pd);
					System.out.println("|Cliente adicionado com sucesso|");
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();
				} else if (respostaNum == 2){//Mostrar todos os clientes
					c.consultaCliente();
					System.out.print("|---------------|\n");
					System.out.println("| 1 | Continuar |");
					System.out.println("|---------------|\n");
					resposta.nextInt();									
				} else if (respostaNum == 3) {// Atualiza info de clientes
					System.out.println("|--- Insira o nome completo do Cliente ---|\n");
					String nomeOriginal = resposta.nextLine();
					System.out.println("|--- Insira o nome atualizado do Cliente ---|\n");
					String nomeAtual = resposta.nextLine();
					c.atualizarCliente(nomeOriginal, nomeAtual, null, "Esperando uma mesa");
				} else if (respostaNum == 4) {
					
				} else if (respostaNum == 5) {
					
				} else if (respostaNum == 6) {
					respostaNum = 0;
				} else {
					System.out.println("| Opção inválida, tente novamente.");
				}
				
				
				
				if (respostaNum != 0) {
					respostaNum = 2;
				}	
			}

			// ------ Gerenciamento de cliente -------
			System.out.println("\n| --Clientes-- |");
			//Começa a chegar os clientes
			c.inserirCliente("Robert", null, 0, "Esperando uma mesa", pd);
			c.inserirCliente("Pedro", null, 0, "Esperando uma mesa", pd);
			c.inserirCliente("Igor", null, 0, "Esperando uma mesa", pd);
			c.inserirCliente("Gian", null, 0, "Esperando uma mesa", pd);
			//Verifica as informações de todos os clientes que chegaram.
			c.consultaCliente();
			
			//Atualiza informações do cliente
			System.out.println("\n  | --Atualizando info do Cliente-- |");
			c.atualizarCliente("Gian", "Roberta", null, "Esperando uma mesa");// Atualiza o cliente com tal nome e insere outro, caso esteja em uma mesa, também é possível altera-la se estiver disponível
			//Mostra as informações dos clientes após as informações serem trocadas
			System.out.println("\n | --Clientes após remoção e atualização-- |");	
			c.consultaCliente();
			
			// ---- Gerenciamento de Pedidos ------
			
			//Os garções levam os clientes até as mesas vagas.
			System.out.println("\n --Escolhendo mesas--  ");		
			m.escolherMesa(c, "Igor", false, 1, null, null, null, pd);// Tem que inserir o nome do cliente que quer a mesa e dizer se ele está acompanhado ou não, caso esteja precisa informar com quantas pessoas incluindo ele mesmo.
			m.escolherMesa(c, "Pedro", true, 2, "Cleber", null, null, pd);
			
			System.out.println("\n | -- Pedidos -- |\n");
			//Mostra o cardápio e os produtos a venda.
			p.cardapio();
			//O cliente faz um pedido caso cumpra os requisitos (Estar em uma mesa e ter um garçom disponível)
			p.fazerPedido(func, c, "Pedro", 1, pd);
			p.fazerPedido(func, c, "Igor", 2, pd);	
			//Mostra os pedidos que foram feitos até agora;
			p.consultaPedido();		
					
			
			
//			Exclui um pedido caso tenha sido feito por engano, deletando suas informações estatísticas também.
			p.deletarPedido(1, func);
			//Atualiza as informações do pedido, caso tenha sido cancelado, ou esteja em outra etapa de preparo.
			p.atualizarPedido(2, "Cancelado", func);// Inserir o número do pedido para localizar as informações, e em seguida inserir as informações atualizadas.
//			Demonstra os pedidos após modificações.
			System.out.println("\n  | --Pedidos após remoção e atualização-- |");
			p.consultaPedido();	
			
			//Demonstra os clientes e em quais mesas então
			System.out.println("| -- Consulta dos Clientes -- |");
			c.consultaCliente();
			//Demonstra as informações das mesas
			System.out.println("\n | -- Consulta das Mesas -- |");
			m.consultaMesas();
			//Tira uma mesa específica do estabelecimento
			System.out.println("\n  | --Retirando mesa-- |");
			m.retirarMesa(2);
			//Após terminar de comer e pagar, o cliente sai do restaurante
			System.out.println("\n  | --Removendo Cliente-- |");
//			c.deletarCliente(m, "Igor"); // Deleta o Cliente com tal nome.
			//Atualização de mesas após clientes sairem ou coisa do tipo
			System.out.println("\n  | --|Atualizando mesa-- |");
			m.consultaMesas();
			
			System.out.println("| --- Após alguns minutos --- |");
			p.atualizarRestaurant(c, func);
			p.atualizarRestaurant(c, func);
			p.atualizarRestaurant(c, func);
			p.atualizarRestaurant(c, func);
			p.atualizarRestaurant(c, func);
			c.irPagar(m, func, "Igor");
			
			p.consultaPedido();
			c.consultaCliente();
			
			func.mostraFunc();
			m.consultaMesas();
			pd.verComanda(2, c);
			//Tabela de escalas de cada função
//			func.escalasFunc();
		}
		
		resposta.close();
	}
}
