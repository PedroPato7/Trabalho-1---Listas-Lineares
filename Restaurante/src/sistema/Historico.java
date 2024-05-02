package sistema;

public class Historico {
	private Nodo inicio;
	
	public boolean vazia() {//Verifica se a tem mesas no local.
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	int idHist = 1;//Faz o id de cada histórico
	
	public void adicionarHistorico(String nomeCli, Double valorPag, Double troco, String formPag) {
		Nodo novoNodo = new Nodo(idHist, nomeCli, valorPag, formPag, troco);
		novoNodo.setProx(inicio);
		inicio = novoNodo;		
		idHist++;
	}	
	public void mostrarHistorico() {
		Nodo aux = inicio;
		System.out.print("|---------------------------------|\n");
		System.out.print("|  ---HISTÓRICO DE PAGAMENTOS---  |\n");
        System.out.print("|---------------------------------|\n");
        while (aux != null) {
        	System.out.print("| ID - " + aux.getIdHistorico() + " | Nome: " + aux.getNomeClienteHist() + " | Valor pago: " + aux.getValorPagoHist() + " | Troco: " + aux.getTroco() + " | Forma de pagamento: " + aux.getFormPagHist() + "           |\n");
        	aux = aux.getProx();
        }
        System.out.print("|---------------------------------|\n");
        return;
	}	
	public void emitirComprovante(String nomeCli, Double valorPago, Double valorDevido, String formPag, Double troco) {
		Nodo auxHist = inicio;
		System.out.print("|---------------------------------|\n");
		System.out.print("| ---COMPROVANTE DE PAGAMENTOS--- |\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("| Cliente            - " + nomeCli + "       \n");
        System.out.print("| Valor a pagar      - R$ " + valorDevido + "\n");
        System.out.print("| Valor pago         - R$ " + valorPago + "  \n");
        System.out.print("| Forma de pagamento - " + formPag + "       \n");
        System.out.print("| Troco              - R$ " + troco + "      \n");
        System.out.print("|---------------------------------|\n");
        return;
	}
}
