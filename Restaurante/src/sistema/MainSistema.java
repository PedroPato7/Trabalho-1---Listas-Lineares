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
		System.out.println("\n | --Clientes após remoção e atualização-- |");		
		c.deletarCliente("Robert");
		c.atualizarCliente("Gian", "Babaui");
		c.consultaCliente();
		
		// Gerenciamento de Pedidos
		
		System.out.println("\n | --Pedidos-- |");
		
		Pedidos p = new Pedidos();		
		p.inserirPedidoInicio("Em preparação", 5.00);
		p.inserirPedidoFinal("Pronto", 17.99);
		p.inserirPedidoInicio("Na fila", 7.50);		
		p.consultaPedido();		
		p.deletarPedido("Pronto");
		p.atualizarPedido("Na fila", "Cancelado", 0.00);
		System.out.println("\n  | --Pedidos após remoção e atualização-- |");
		p.consultaPedido();		
	}
}
