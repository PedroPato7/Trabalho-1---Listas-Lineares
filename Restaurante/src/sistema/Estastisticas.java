package sistema;

public class Estastisticas {
	
	private Nodo inicio;

	public boolean vazia() {
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	//Cria o nodo de estastisticas
	public void criarEst() {
		Nodo novoNodo = new Nodo(0, 0, 0, 0, 0);
		novoNodo.setProx(inicio);
		inicio = novoNodo;	
	}	
	// Função que adiciona e outra que remove da fila, quantas pessoas estão na fila para almoçar (Encontrar uma mesa).
	public void adFilaAlmosando(int quant) {
		inicio.setFilaAlmo(inicio.getFilaAlmo() + quant);
	}
	public void remFilaAlmosando(int quant) {
		inicio.setFilaAlmo(inicio.getFilaAlmo() - quant);
	}
	// Função que adiciona e outra que remove da fila, quantas pessoas estão na fila do caixa.
	public void adFilaCaixa(int quant) {
		inicio.setFilaCaixa(inicio.getFilaCaixa() + quant);
	}
	public void remFilaCaixa(int quant) {
		inicio.setFilaCaixa(inicio.getFilaCaixa() - quant);
	}
	// Função que adiciona e outra que remove da fila, quantas pessoas estão comendo.
	public void adQuantComendo(int quant) {
		inicio.setQuantComendo(inicio.getQuantComendo() + quant);
	}
	public void remQuantComendo(int quant) {
		inicio.setQuantComendo(inicio.getQuantComendo() - quant);
	}
	// Função que adiciona e outra que remove da fila, quantas pessoas estão esperando serem atendidas.
	public void adQuantEsperandoPed(int quant) {
		inicio.setQuantEsperandoPed(inicio.getQuantEsperandoPed() + quant);
	}
	public void remQuantEsperandoPed(int quant) {
		inicio.setQuantEsperandoPed(inicio.getQuantEsperandoPed() - quant);
	}	
	// Função que adiciona e outra que remove da fila, quantas mesas estão disponíveis.
	public void adQuantMesasDisp(int quant) {
		inicio.setQuantMesas(inicio.getQuantMesas() + quant);
	}
	public void remQuantMesasDisp(int quant) {
		inicio.setQuantMesas(inicio.getQuantMesas() - quant);
	}	
	public void mostrarEstastisticas() {
		System.out.print("|---------------------------------|\n");
		System.out.print("| ---      Estastísticas      --- |\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("| Quantos esperando uma mesa - " + inicio.getFilaAlmo() + "  |\n");
        System.out.print("| Quantos na fila do caixa   - " + inicio.getFilaCaixa() + "  |\n");
        System.out.print("| Quantos clientes comendo   - " + inicio.getQuantComendo() + "  |\n");
        System.out.print("| Quantos esperando pedido   - " + inicio.getQuantEsperandoPed() + "  |\n");
        System.out.print("| Quantas mesas disponíveis  - " + inicio.getQuantMesas() + "  |\n");
        System.out.print("|---------------------------------|\n");
        return;
	}
}
