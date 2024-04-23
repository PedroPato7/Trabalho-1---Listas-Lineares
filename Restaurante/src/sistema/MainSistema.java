package sistema;

public class MainSistema {

	public static void main(String[] args) {
		
		//Gerenciamento de cliente
		Cliente c = new Cliente(null);

		c.inserirClienteFinal("Robert");
		c.inserirClienteInicio("Pedro");
		c.inserirClienteInicio("Igor");
		c.inserirClienteFinal("Gian");

		c.consultaCliente();
		
		System.out.println("Clientes após remoção e atualização");
		
		c.deletarCliente("Robert");
		c.atualizarCliente("Gian", "Babaui");
		c.consultaCliente();
		
		
		
	}
}
