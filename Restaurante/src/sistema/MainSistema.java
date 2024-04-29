package sistema;

public class MainSistema {

	public static void main(String[] args) {
		
		Funcionarios func = new Funcionarios();
		Cliente c = new Cliente();
		Pedidos p = new Pedidos();
		Mesas m = new Mesas();
		
		// Contrata um funcionário, inserindo o cargo, escala, nome, o que está fazendo no momento e o id dos pedidos
		func.contratarFunc("Cozinheiro", "200 horas mensais", "Jair", true, 0); 
		func.contratarFunc("Garçom", "200 horas mensais", "Robertinho", true, 0);
		func.contratarFunc("Garçom", "200 horas mensais", "Djenifer", true, 0);
		func.contratarFunc("Caixa", "200 horas mensais", "Junior", true, 0);
		//Coloca as mesas no estabelecimento
		m.adicionarMesa(true, 4, 0, null);
		m.adicionarMesa(true, 4, 1, null);
		m.adicionarMesa(true, 4, 2, null);
		//Verifica as informações das mesas postas
		m.consultaMesas();
		
		// ------ Gerenciamento de cliente -------
		System.out.println("\n| --Clientes-- |");
		//Começa a chegar os clientes
		c.inserirCliente("Robert", null, 0);
		c.inserirCliente("Pedro", null, 0);
		c.inserirCliente("Igor", null, 0);
		c.inserirCliente("Gian", null, 0);
		//Verifica as informações de todos os clientes que chegaram.
		c.consultaCliente();
		
		//Atualiza informações do cliente
		System.out.println("\n  | --Atualizando info do Cliente-- |");
		c.atualizarCliente("Gian", "Babaui", null);// Atualiza o cliente com tal nome e insere outro, caso esteja em uma mesa, também é possível altera-la se estiver disponível
		//Mostra as informações dos clientes após as informações serem trocadas
		System.out.println("\n | --Clientes após remoção e atualização-- |");	
		c.consultaCliente();
		
		// ---- Gerenciamento de Pedidos ------
		
		//Os garções levam os clientes até as mesas vagas.
		System.out.println("\n --Escolhendo mesas--  ");		
		m.escolherMesa(c, "Igor", false, 1, null, null, null);// Tem que inserir o nome do cliente que quer a mesa e dizer se ele está acompanhado ou não, caso esteja precisa informar com quantas pessoas incluindo ele mesmo.
		m.escolherMesa(c, "Pedro", true, 2, "Cleber", null, null);
		
		System.out.println("\n | -- Pedidos -- |\n");
		//Mostra o cardápio e os produtos a venda.
		p.cardapio();
		//O cliente faz um pedido caso cumpra os requisitos (Estar em uma mesa e ter um garçom disponível)
		p.fazerPedido(func, c, "Pedro", "Em preparação", 1);
		p.fazerPedido(func, c, "Igor", "Em preparação", 2);	
		//Mostra os pedidos que foram feitos até agora;
		p.consultaPedido();		
		
		
		
		
		
		
		
		//Exclui um pedido caso tenha sido feito por engano, deletando suas informações estatísticas também.
		p.deletarPedido(0, func);
		//Atualiza as informações do pedido, caso tenha sido cancelado, ou esteja em outra etapa de preparo.
		p.atualizarPedido(2, "Cancelado", func);// Inserir o número do pedido para localizar as informações, e em seguida inserir as informações atualizadas.
		//Demonstra os pedidos após modificações.
		System.out.println("\n  | --Pedidos após remoção e atualização-- |");
		p.consultaPedido();	
		
		System.out.println("\n | --Mesas-- |");
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
		c.deletarCliente(m, "Igor"); // Deleta o Cliente com tal nome.
		//Atualização de mesas após clientes sairem ou coisa do tipo
		System.out.println("\n  | --|Atualizando mesa-- |");
		m.atualizarMesa(2, 2, true, 4, null);//Atualiza as informações da mesa com o número inserido, (Num da mesa, disp da mesa, quantas cadeiras disp e cliente atualizado).
		m.consultaMesas();
		//Tabela de escalas de cada função
//		func.escalasFunc();
		
	}
}
