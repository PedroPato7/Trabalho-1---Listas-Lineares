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

	public void contratarFunc(String cargo, String escala, String nomeFunc, boolean stats, int idPed) {
		Nodo novoNodo = new Nodo(cargo, nomeFunc, idFunc, stats, idPed);
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
			System.out.println("- Identidade: " + aux.getIdFunc() + " | Cargo: " + aux.getCargo() + " | Nome: " + aux.getNomeFunc());
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
	
	public void atualizarStatsFunc(int idPed) {
		Nodo auxFunc = inicio;
		while (auxFunc != null) {
			if (auxFunc.getNumeracaoPedido() == idPed) {
				auxFunc.setNumeracaoPedido(0);
				auxFunc.setStatsFunc(true);
			}
			auxFunc = auxFunc.getProx();
		}		
	}
	
	//Teste, ignora por enquanto.
	public void escalasFunc() {
		if (vazia()) return;	
		System.out.println("\n| Escala de cozinheiro | \n| Segunda - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Terça - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quarta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quinta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sexta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sábado - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Domingo - Folga | "
				+ "\n| Totalizando 60 horas de trabalho semanal \n");
		System.out.println("| Escala de garçom | \n| Segunda - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Terça - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quarta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quinta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sexta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sábado - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Domingo - Folga | "
				+ "\n| Totalizando 60 horas de trabalho semanal \n");	
		System.out.println("| Escala de Caixa | \n| Segunda - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Terça - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quarta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Quinta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sexta - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Sábado - 08:00am até 18:00pm (10 horas) | "
				+ "\n| Domingo - Folga | "
				+ "\n| Totalizando 60 horas de trabalho semanal \n");
	}
}
