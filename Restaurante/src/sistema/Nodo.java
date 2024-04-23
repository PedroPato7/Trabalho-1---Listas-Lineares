package sistema;

public class Nodo {	
	
	private Nodo prox;
	private String stats;
	private Double valor;
	private String nome;
	
	public Nodo(String nome) {
		this.nome = nome;
		this.prox = null;
	}
	public Nodo(String stats, Double valor) {
		this.stats = stats;
		this.valor = valor;
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
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
