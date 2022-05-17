package entities;

import exception.DominioExcecoes;

public class ContaEspecial extends BancoNacional{

	private Double limite;
	
	public ContaEspecial() {
		super();
		this.limite = 1000.0;
		
	}

	public ContaEspecial(Integer numero, Double saldo, Double limite) {
		super(numero, saldo);
		
	}

	public Double getLimite() {
		return limite + this.getSaldo() ;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	@Override
	public void depositar(double deposito) {
		if(deposito < 0) {
			throw new DominioExcecoes("Erro de deposito: O valor inválido");
		} else {
			this.setSaldo(this.getSaldo() + deposito);
	    }
	}

	@Override
	public void sacar(double saque) {
		if( saque < 0 || saque > this.getLimite() ) {
			throw new DominioExcecoes("Erro de saque: Valor do saque: $" + saque + "\n"
					+ "Limite: $" + this.getLimite());
		} else {
			this.setSaldo(this.getSaldo() - saque);
	    }
	}
	
	public boolean textLimite(double valor) {
		
      //double limite = this.getSaldo() + this.getLimite();
		
		if(valor > this.getLimite()){
			return true;
		} 
		
		//throw new DominioExcecoes("Conta sem limite: " + this.getLimite());
	     return false;   
	}

	@Override
	public void transferir(BancoNacional destino, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
	String info = "Conta Especial:\n"; 
		   info += "Limite: " + this.getLimite() + "\n";
	       info += "Saldo: " + this.getSaldo() + "\n";
	       return info;
	}
	
}
