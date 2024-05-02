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
	private Double valorComanda;
	private String statsCliente;
	/*
	 - Esperando uma mesa
	 - Esperando um garçom
	 - Esperando pedido
	 - Comendo
	 - Na fila do caixa
	 - No caixa
	 - Saiu do restaurante
	 */
	
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
	//Atributos de ProdutosPedidos
	private int idComanda;//Id para conectar com o cliente
	private String descProd;//Descrição do produto que foi pedido
	//Atributos de Histórico de pagamentos de clientes
	private int idHistorico;
	private String nomeClienteHist;
	private Double valorPagoHist;
	private String formPagHist;
	private Double troco;
	// Atributos de Estastísticas
	private int filaAlmo; // Num de pessoas na fila para almoçar
	private int filaCaixa;// Num de pessoas na fila do caixa
	private int quantComendo; // Num de pessoas comendo
	private int quantEsperandoPed; // Num de pessoas esperando pedido
	private int quantMesas; // Num de mesas disponíveis
	
	//Função dos Clientes
	public Nodo(String nome, String mesa, int numeroPed, String stats, int idComand, Double valorComanda) {
		this.nome = nome;
		this.mesa = mesa;
		this.numeroDoPedido = numeroPed;
		this.statsCliente = stats;
		this.idComandaCliente = idComand;
		this.valorComanda = valorComanda;
		this.prox = null;
	}
	//Função de ProdutosPedidos
	public Nodo(int idComanda, String descProd) {
		this.idComanda = idComanda;
		this.descProd = descProd;
		this.prox = null;
	}
	//Função do histórico
	public Nodo(int idHist, String nomeCli, Double valorPag, String formPag, Double troco) {
		this.idHistorico = idHist;
		this.nomeClienteHist = nomeCli;
		this.valorPagoHist = valorPag;
		this.formPagHist = formPag;
		this.troco = troco;
		this.prox = null;
	}
	//Função Estastísticas
	public Nodo(int filaAlmo, int filaCaixa, int quantComendo, int quantEsperandoPed, int quantMesas) {
		this.filaAlmo = filaAlmo;
		this.filaCaixa = filaCaixa;
		this.quantComendo = quantComendo;
		this.quantEsperandoPed = quantEsperandoPed;
		this.quantMesas = quantMesas;
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
	public int getIdComandaCliente() {
		return idComandaCliente;
	}
	public void setIdComandaCliente(int idComandaCliente) {
		this.idComandaCliente = idComandaCliente;
	}
	public Double getValorComanda() {
		return valorComanda;
	}
	public void setValorComanda(Double valorComanda) {
		this.valorComanda = valorComanda;
	}
	public int getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public String getDescProd() {
		return descProd;
	}
	public int getFilaAlmo() {
		return filaAlmo;
	}
	public void setFilaAlmo(int filaAlmo) {
		this.filaAlmo = filaAlmo;
	}
	public int getFilaCaixa() {
		return filaCaixa;
	}
	public void setFilaCaixa(int filaCaixa) {
		this.filaCaixa = filaCaixa;
	}
	public int getQuantComendo() {
		return quantComendo;
	}
	public void setQuantComendo(int quantComendo) {
		this.quantComendo = quantComendo;
	}
	public int getQuantEsperandoPed() {
		return quantEsperandoPed;
	}
	public void setQuantEsperandoPed(int quantEsperandoPed) {
		this.quantEsperandoPed = quantEsperandoPed;
	}
	public int getQuantMesas() {
		return quantMesas;
	}
	public void setQuantMesas(int quantMesas) {
		this.quantMesas = quantMesas;
	}
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	public Double getTroco() {
		return troco;
	}
	public void setTroco(Double troco) {
		this.troco = troco;
	}
	public int getIdHistorico() {
		return idHistorico;
	}
	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}
	public String getNomeClienteHist() {
		return nomeClienteHist;
	}
	public void setNomeClienteHist(String nomeClienteHist) {
		this.nomeClienteHist = nomeClienteHist;
	}
	public Double getValorPagoHist() {
		return valorPagoHist;
	}
	public void setValorPagoHist(Double valorPagoHist) {
		this.valorPagoHist = valorPagoHist;
	}
	public String getFormPagHist() {
		return formPagHist;
	}
	public void setFormPagHist(String formPagHist) {
		this.formPagHist = formPagHist;
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