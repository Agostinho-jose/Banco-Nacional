package entities;

import exception.DominioExcecoes;

public class ContaEspecial extends BancoNacional {

	public ContaEspecial() {
		super();	
	  
	}

	public boolean textarLimite(double valor) {
		 
		this.setLimite(this.getSaldo()+this.getLimite());
		
		if(valor > this.getSaldo() && valor < this.getLimite()) {
			return true;
		}
		
		    return false;	   
	}
	
	
	public void sacar(double valor) {
		if(valor <= 0 && valor > this.getLimite()) {
			throw new DominioExcecoes("Erro de saque: Valor indisponivel");
		} else {
			this.setSaldo( this.getSaldo() - valor);
	    }
		
	}

	@Override
	public String toString() {
	String info = "**Conta Especial***\n"; 
	       info += "Saldo R$: " + String.format("%.2f", this.getSaldo()) + "\n";
	       info += "Limite R$: " + String.format("%.2f", (this.getLimite() - this.getSaldo())) + "\n";
	       return info;
	}

}

