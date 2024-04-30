package sistema;

public class Nodo {	
	
	private Nodo prox;
	
	//Atributos de pedidos
	private String statsPedido;
	/*
	 - Anotado
	 - Na cozinha
	 - Pronto
	 - Entregue
	 - Cancelado
	*/
	private Double valorPedido;
	private int numPedido;
	
	//Atributo de Cliente
	private String nome;
	private String mesa;
	private int numeroDoPedido;
	private int idComandaCliente;//Id para conectar com o cliente
	private String statsCliente;
	/*
	 - Esperando uma mesa
	 - Esperando um garçom
	 - Esperando pedido
	 - Comendo
	 - Na fila do caixa
	 - No caixa
	 - Foi embora
	 */
	// private double comandaCliente; ---------- Ideia de fazer a comanda de produtos pedidos pelo cliente, cobrando pelo produto de qualquer maneira se ele estiver com o status "Na cozinha", antes disso, pode ser cancelado sem cobrança.
	
	//Atributos de Mesas
	private boolean disponivel;
	private int cadeirasDisp;
	private int numMesa;
	private String clienteNaMesa;
	
	//Atributos de Funcionarios
	private String cargo;
	private String nomeFunc;
	private int idFunc;
	private boolean statsFunc;
	private int numeracaoPedido;
	//Atributos de Pagamento
	private int idComanda;//Id para conectar com o cliente
	private double comanda;
	private String[] produtosPedidos;
	
	//Função dos Clientes
	public Nodo(String nome, String mesa, int numeroPed, String stats, int idComand) {
		this.nome = nome;
		this.mesa = mesa;
		this.numeroDoPedido = numeroPed;
		this.statsCliente = stats;
		this.idComandaCliente = idComand;
		this.prox = null;
	}
	//Função dos pedidos
	public Nodo(String stats, Double valor, int numPedido) {
		this.statsPedido = stats;
		this.valorPedido = valor;
		this.numPedido = numPedido;
		this.prox = null;
	}
	//Função das mesas
	public Nodo(boolean disp, int cadeiraDisp, int numMesa, String cliente) {
		this.disponivel = disp;
		this.cadeirasDisp = cadeiraDisp;
		this.numMesa = numMesa;
		this.clienteNaMesa = cliente;
		this.prox = null;
	}
	//Função dos Funcionarios
	public Nodo(String cargo, String nome, int id, boolean statusFunc, int numPed) {
		this.cargo = cargo;
		this.nomeFunc = nome;
		this.idFunc = id;
		this.statsFunc = statusFunc;
		this.numeracaoPedido = numPed;
		this.prox = null;
	}
	public Nodo getProx() {
		return prox;
	}
	public void setProx(Nodo prox) {
		this.prox = prox;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getStatsCliente() {
		return statsCliente;
	}
	public void setStatsCliente(String statsCliente) {
		this.statsCliente = statsCliente;
	}
	public int getNumeroDoPedido() {
		return numeroDoPedido;
	}
	public void setNumeroDoPedido(int numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}
	public String getStatsPedido() {
		return statsPedido;
	}
	public void setStatsPedido(String statsPedido) {
		this.statsPedido = statsPedido;
	}
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public int getCadeirasDisp() {
		return cadeirasDisp;
	}
	public void setCadeirasDisp(int cadeirasDisp) {
		this.cadeirasDisp = cadeirasDisp;
	}
	public int getNumMesa() {
		return numMesa;
	}
	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}
	public String getClienteNaMesa() {
		return clienteNaMesa;
	}
	public void setClienteNaMesa(String clienteNaMesa) {
		this.clienteNaMesa = clienteNaMesa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int id) {
		this.idFunc = id;
	}
	public boolean isStatsFunc() {
		return statsFunc;
	}
	public void setStatsFunc(boolean statsFunc) {
		this.statsFunc = statsFunc;
	}
	public int getNumeracaoPedido() {
		return numeracaoPedido;
	}
	public void setNumeracaoPedido(int numeracaoPedido) {
		this.numeracaoPedido = numeracaoPedido;
	}
}
