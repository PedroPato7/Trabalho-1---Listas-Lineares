package sistema;

public class Funcionarios {
	
	private Nodo inicio;
	private int idFunc = 0;
	
	public boolean vazia() {//Verifica se a tem funcionarios.
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}

	public void contratarFunc(String cargo, String escala, String nomeFunc) {
		Nodo novoNodo = new Nodo(cargo, escala, nomeFunc, idFunc);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
		idFunc++;
	}
	
	public void mostraFunc() {
		if (vazia()) {
			System.out.println("Sem funcionários contratados.");
			return;
		}
		Nodo aux = inicio;
		while(aux != null) {
			System.out.println("- Identidade: " + aux.getIdFunc() + " | Cargo: " + aux.getCargo() + " | Nome: " + aux.getNomeFunc() + " | Escala: " + aux.getEscala());
			aux = aux.getProx();
			}
		}
	
	public void dispensarFunc(int id) {
		if (vazia()) return;
		if (inicio.getIdFunc() == id) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if(aux.getProx().getIdFunc() == id) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}	
	}
}
