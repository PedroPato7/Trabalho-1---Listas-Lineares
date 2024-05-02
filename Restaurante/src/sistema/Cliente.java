package sistema;

public class Cliente{

	private Nodo inicio;
	
	public boolean vazia() {//Verifica se a fila está vazia
		return inicio == null;
	}
	public Nodo getInicio() {
		return inicio;
	}
	
	int idComanda = 1; //Da o id das comandas todas diferentes, pois aumenta cada vez que um cliente novo chega.
	
	// Função para inserir no inicio.
	public void inserirCliente(String nome, String mesa, int numPed, String stats, ProdutosPedidos pd) {
		Nodo novoNodo = new Nodo(nome, mesa, numPed, stats, idComanda, 0.00);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
		pd.criarComanda(idComanda, "Nenhum pedido ainda.");
		idComanda++;
	}
	
	//Função para mostrar lista
	public void consultaCliente() {
		if (vazia()) {
			System.out.println("Sem clientes na fila.");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			if(aux.getMesa() != null) {
				System.out.println("- " + aux.getNome() + " | Mesa - " + aux.getMesa() + " | Stats: " + aux.getStatsCliente() + " | Comanda ID: " + aux.getIdComandaCliente());
			} else {
				System.out.println("- " + aux.getNome() + " | Nenhuma mesa escolhida ainda " + "| Stats: " + aux.getStatsCliente());
			}
			aux = aux.getProx();
		}		
	}	
	//Função para atualizar dados do cliente
	public void atualizarCliente(String nome, String nomeAtual, String mesaAtual, String stats) {
		if (vazia()) {
			System.out.println("Sem clientes para atualizar.");
			return;
		}
		Nodo aux = inicio;
		if (aux != null) {
			if (aux.getNome().equals(nome)) {
				aux.setNome(nomeAtual);
				aux.setMesa(mesaAtual);
				aux.setStatsCliente(stats);
				System.out.println("Informações do cliente " + nome + " atualizadas.");
				return;
			}			
		}
		while (aux.getProx() != null) {
			if (aux.getProx().getNome().equals(nome)) {
				aux = aux.getProx();
				System.out.println("Informações do cliente " + nome + " atualizadas.");
				aux.setNome(nomeAtual);
				aux.setMesa(mesaAtual);
				aux.setStatsCliente(stats);
				return;
			} 
			aux = aux.getProx();
		}
	}
	
	//Função para deletar um cliente específico
	public void deletarCliente(Mesas mesa, String nome, Estastisticas est) {// ---------FAZER VERIFICAÇÃO SE O PEDIDO FOI ENTREGUE ANTES OU NÃO
		if (vazia()) return;
		if (inicio.getNome().equals(nome)) {
			System.out.println("Cliente " + nome + " removido com sucesso.");
			
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getNome().equals(nome)) {
				System.out.println("Cliente " + nome + " removido com sucesso.");
				if (aux.getStatsCliente().equals("Esperando uma mesa"))	{
					est.remFilaAlmosando(1);
				} else if (aux.getStatsCliente().equals("Esperando garçom")) {
					est.remQuantEsperandoPed(1);
				} else if (aux.getStatsCliente().equals("Comendo")) {
					est.remQuantComendo(1);
				} else if (aux.getStatsCliente().equals("No caixa") || aux.getStatsCliente().equals("Na fila do caixa")) {
					est.remFilaCaixa(1);
				}
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}	
	
	//Função que leva o cliente ao caixa quando ele quiser ir
	public void irPagar(Mesas mesa, Funcionarios func, String nomeCliente, Estastisticas est) {
		Nodo auxCli = inicio;
		Nodo auxFunc = func.getInicio();
		Nodo auxMesa = mesa.getInicio();
		while (auxCli != null) {
			if (auxCli.getNome().equals(nomeCliente)) {
				if (auxCli.getStatsCliente().equals("Comendo") || auxCli.getStatsCliente().equals("Na fila do caixa")) {//Verifica quais stats podem ir pro caixa
	    			while (auxMesa != null) {//Verifica se tem mais de uma pessoa na mesa, e muda as informações dos clientes e da mesa para que possa ser usada de novo.
	    				String conversor = auxMesa.getNumMesa() + "";//Converte para poder fazer a comparação
	    				if (conversor.equals(auxCli.getMesa())) {
	    					if(auxMesa.getCadeirasDisp() < 3) {//Verifica se a mesa está vazia ou não
	    						System.out.println("Ainda ha clientes na mesa, ela vai continuar ocupada ainda");
	    						auxMesa.setCadeirasDisp((auxMesa.getCadeirasDisp() + 1));// Deixa uma cadeira vaga quando sai
	    						auxCli.setMesa("Saiu");
	    					} else {
	    						System.out.println("O cliente " + auxCli.getNome() + " saiu da mesa e foi pagar aconta.");
	    						mesa.atualizarMesa(auxMesa.getNumMesa(), true, 4, "Vazio");
	    						auxCli.setMesa("Saiu");	    
	    						est.adQuantMesasDisp(1);
	    					}
	    					
	    				}
	    				auxMesa = auxMesa.getProx();
	    			}
		    		while (auxFunc != null) {//Muda o status do cliente para ir pagar a conta no caixa caso esteja disponivel
		    			if(auxFunc.getCargo().contains("Caixa")) {
		    				if(auxFunc.isStatsFunc()) {// Verifica se o caixa está ocupado
		    					auxCli.setStatsCliente("No caixa");
		    					auxFunc.setStatsFunc(false);;
		    					System.out.println("Cliente " + auxCli.getNome() + " no caixa para pagamento.");
		    				} else {
		    					auxCli.setStatsCliente("Na fila do caixa");
	    						est.adQuantMesasDisp(1);
		    				}
		    			}
		    			auxFunc = auxFunc.getProx();
		    		}
		    	}	 
			}    		   		
    		auxCli = auxCli.getProx();
    	}
	}
}
