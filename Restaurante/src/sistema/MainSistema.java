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
		
//		c.deletarCliente("Robert");
//		c.atualizarCliente("Gian", "Babaui", null);
		
//		System.out.println("\n | --Clientes após remoção e atualização-- |");	
//		c.consultaCliente();
		
		// Gerenciamento de Pedidos
		
//		System.out.println("\n | --Pedidos-- |");
//		Pedidos p = new Pedidos();		
//		
//		p.inserirPedidoInicio("Em preparação", 5.00, 0);
//		p.inserirPedidoFinal("Pronto", 17.99, 1);
//		p.inserirPedidoInicio("Na fila", 7.50, 2);		
//		p.consultaPedido();		
//		
//		p.deletarPedido(0);
//		p.atualizarPedido(2, 3, "Cancelado", 0.00);// Inserir o número do pedido para localizar as informações, e em seguida inserir as informações atualizadas.
//		
//		System.out.println("\n  | --Pedidos após remoção e atualização-- |");
//		p.consultaPedido();	
		
		// Gerenciamento de mesas
		
		System.out.println("\n | --Mesas-- |");
		Mesas m = new Mesas();
		
		m.adicionarMesa(true, 4, 0, null);
		m.adicionarMesa(true, 4, 1, null);
		m.adicionarMesa(true, 2, 3, null);
		m.consultaMesas();
		
		m.escolherMesa(c, "Pedro", 1);
		c.consultaCliente();
		m.consultaMesas();

//		m.retirarMesa(0);
//		m.atualizarMesa(3, 3, true, 4);//Atualiza as informações da mesa com o número inserido, (Num da mesa, disp da mesa e quantas cadeiras disp).
		
//		System.out.println("\n  | --|Mesas após remoção e atualização-- |");
//		m.consultaMesas();
//		
		
		
	}
}
