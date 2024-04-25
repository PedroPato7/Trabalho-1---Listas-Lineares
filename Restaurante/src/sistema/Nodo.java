package sistema;

public class Nodo {	
	
	private Nodo prox;
	//Atributos de pedidos
	private String statsPedido;
	private Double valorPedido;
	private int numPedido;
	//Atributo de Cliente
	private String nome;
	private String mesa;
	//Atributos de Mesas
	private boolean disponivel;
	private int cadeirasDisp;
	private int numMesa;
	private String clienteNaMesa;
	//Atributos de Funcionarios
	private String cargo;
	private String escala;
	private String nomeFunc;
	private int idFunc;
	
	//Função dos Clientes
	public Nodo(String nome, String mesa) {
		this.nome = nome;
		this.mesa = mesa;
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
	public Nodo(String cargo, String escala, String nome, int id) {
		this.cargo = cargo;
		this.escala = escala;
		this.nome = nome;
		this.idFunc = id;
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
	public String getEscala() {
		return escala;
	}
	public void setEscala(String escala) {
		this.escala = escala;
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
}
