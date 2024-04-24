package sistema;

public class MainSistema {

	public static void main(String[] args) {
		
		//Gerenciamento de cliente

		System.out.println("| --Clientes-- |");
		
		Cliente c = new Cliente();
		c.inserirClienteFinal("Robert");
		c.inserirClienteInicio("Pedro");
		c.inserirClienteInicio("Igor");
		c.inserirClienteFinal("Gian");
		c.consultaCliente();
		
		c.deletarCliente("Robert");
		c.atualizarCliente("Gian", "Babaui");
		
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
		
		
	}
}
