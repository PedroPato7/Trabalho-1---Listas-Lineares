package sistema;

public class Nodo {	
	
	private Nodo prox;
	//Atributos de pedidos
	private String statsPedido;
	private Double valorPedido;
	private int numPedido;
	//Atributo de Cliente
	private String nome;
	
	public Nodo(String nome) {
		this.nome = nome;
		this.prox = null;
	}
	public Nodo(String stats, Double valor, int numPedido) {
		this.statsPedido = stats;
		this.valorPedido = valor;
		this.numPedido = numPedido;
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
}
