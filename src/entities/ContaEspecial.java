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
		return limite;
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
		if( saque < 0) {
			throw new DominioExcecoes("Erro de saque: Valor inválido");
		} else {
			this.setSaldo(getSaldo() - saque);
	    }
	}
	
	public boolean textLimite() {
		
      //double limite = this.getSaldo() + this.getLimite();
		
		if(this.getSaldo() < this.getLimite()){
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
