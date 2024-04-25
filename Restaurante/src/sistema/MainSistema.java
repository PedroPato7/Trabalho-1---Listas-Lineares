package sistema;

public class MainSistema {

	public static void main(String[] args) {
		
		//Gerenciamento de cliente
		System.out.println("| --Clientes-- |");
		
		Cliente c = new Cliente();
		c.inserirClienteFinal("Robert", null);
		c.inserirClienteInicio("Pedro", null);
		c.inserirClienteInicio("Igor", null);
		c.inserirClienteFinal("Gian", null);
		c.consultaCliente();
		
		System.out.println("\n  | --Atualizando info do Cliente-- |");
		c.atualizarCliente("Gian", "Babaui", null);// Atualiza o cliente com tal nome e insere outro, caso esteja em uma mesa, também é possível altera-la se estiver disponível
		
		System.out.println("\n | --Clientes após remoção e atualização-- |");	
		c.consultaCliente();
		
		// Gerenciamento de Pedidos
		
		System.out.println("\n | --Pedidos-- |");
		Pedidos p = new Pedidos();		
		
		p.inserirPedidoInicio("Em preparação", 5.00, 0);
		p.inserirPedidoFinal("Pronto", 17.99, 1);
		p.inserirPedidoInicio("Na fila", 7.50, 2);		
		p.consultaPedido();		
		
		p.deletarPedido(0);
		p.atualizarPedido(2, 3, "Cancelado", 0.00);// Inserir o número do pedido para localizar as informações, e em seguida inserir as informações atualizadas.
		
		System.out.println("\n  | --Pedidos após remoção e atualização-- |");
		p.consultaPedido();	
		
		// Gerenciamento de mesas
		
		System.out.println("\n | --Mesas-- |");
		Mesas m = new Mesas();
		
		m.adicionarMesa(true, 4, 0, null);
		m.adicionarMesa(true, 4, 1, null);
		m.adicionarMesa(true, 4, 2, null);
		m.consultaMesas();
		
		System.out.println("\n --Escolhendo mesas--  ");		
		m.escolherMesa(c, "Igor", false, 1, null, null, null);// Tem que inserir o nome do cliente que quer a mesa e dizer se ele está acompanhado ou não, caso esteja precisa informar com quantas pessoas incluindo ele mesmo.
		System.out.println("\n");
		m.escolherMesa(c, "Pedro", true, 2, "Cleber", null, null);
		System.out.println("\n");
		
		System.out.println("| -- Consulta dos Clientes -- |");
		c.consultaCliente();
		System.out.println("\n | -- Consulta das Mesas -- |");
		m.consultaMesas();
		
		System.out.println("\n  | --Retirando mesa-- |");
		m.retirarMesa(2);
		
		System.out.println("\n  | --Removendo Cliente-- |");
		c.deletarCliente(m, "Igor"); // Deleta o Cliente com tal nome.
		
//		System.out.println("\n  | --|Atualizando mesa-- |");
//		m.atualizarMesa(3, 3, true, 4, null);//Atualiza as informações da mesa com o número inserido, (Num da mesa, disp da mesa, quantas cadeiras disp e cliente atualizado).
		
		m.consultaMesas();
		
		
		
	}
}
