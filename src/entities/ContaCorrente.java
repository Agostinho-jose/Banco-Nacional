package entities;

public class ContaCorrente {

	private String nomeBanco;
	
	private Cliente[] cliente;

	public ContaCorrente() {
	}


	public ContaCorrente(String nomeBanco) {
		super();
		this.nomeBanco = nomeBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}


	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}


	public Cliente[] getCliente() {
		return cliente;
	}

	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}
	
	public void ImprimirInfo() {
		
		System.out.println("#### " + this.getNomeBanco() + " ####");
		for(Cliente c : cliente) {
			c.imprimirInfo();
		}	
	}
}
