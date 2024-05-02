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
	//Contrata um funcionário para trabalhar no restaurante.
	public void contratarFunc(String cargo, String nomeFunc, boolean stats, int idPed) {
		Nodo novoNodo = new Nodo(cargo, nomeFunc, idFunc, stats, idPed);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
		idFunc++;
	}
	//Mostra os funcionários do restaurante e suas informações.
	public void mostraFunc() {
		if (vazia()) {
			System.out.println("Sem funcionários contratados.");
			return;
		}
		Nodo aux = inicio;
		while(aux != null) {
			if (aux.isStatsFunc()) {
				System.out.println("- Id: " + aux.getIdFunc() + " | Cargo: " + aux.getCargo() + " | Nome: " + aux.getNomeFunc() + " | Stats: Disponível");
			} else {
				System.out.println("- Id: " + aux.getIdFunc() + " | Cargo: " + aux.getCargo() + " | Nome: " + aux.getNomeFunc() + " | Stats: Ocupado");
			}
			aux = aux.getProx();
			}
		}
	//Função para pagar as contas no caixa
	public void pagarComanda(String nomeCliente, ProdutosPedidos pd, Cliente cli, String formaPag, Double valorPago) {
		Nodo auxCli = cli.getInicio();
		Nodo auxFunc = inicio;
		while (auxCli != null) {
			if (auxCli.getNome() == nomeCliente) {
				if (auxCli.getStatsCliente().contains("No caixa")) {
					if (formaPag == "Cartão") {
						
					}
				} else {
					System.out.println("O cliente ainda não está sendo atendido pelo caixa.");
				}
			}
			auxCli = auxCli.getProx();
		}
	}	
	//Dispensa um funcionário do restaurante.
	public void dispensarFunc(int id) {
		if (vazia()) return;
		if (inicio.getIdFunc() == id) {
			if (inicio.isStatsFunc()) {
				inicio = inicio.getProx();
				return;
			} else {
				System.out.println("Este funcionário ainda tem deveres para terminar, espere-o acabar.");
				return;
			}
			
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if(aux.getProx().getIdFunc() == id) {
				if (aux.isStatsFunc()) {//Verifica se ele está atendendo ou não
					aux.setProx(aux.getProx().getProx());
					return;
				} else {
					System.out.println("Este funcionário ainda tem deveres para terminar, espere-o acabar.");
					return;
				}
			}
			aux = aux.getProx();
		}	
	}
	//Função usada para mudar o stats do funcionário para disponivel.
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
	
	//A escala de horas de cada cargo de funcionário.
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
