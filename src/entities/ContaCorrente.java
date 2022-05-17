package entities;

import exception.DominioExcecoes;

public class ContaCorrente extends BancoNacional {

	
	public ContaCorrente() {
		super();
		
	}

	public ContaCorrente(Integer numero, Double saldo) {
		super(numero, saldo);
		
	}

	@Override
	public void depositar(double deposito) {
		if(deposito < 0) {
			throw new DominioExcecoes("Erro de deposito: Valor inválido");
		} else {
			this.setSaldo(this.getSaldo() + deposito);
	    }
		
	}

	@Override
	public void sacar(double saque) {
		if(saque < 0) {
			throw new DominioExcecoes("Erro de deposito: Valor inválido");
		} else {
			this.setSaldo(getSaldo() - saque);
	    } 	
	}

	@Override
	public void transferir(BancoNacional destino, double valor) {	
		
	}

	@Override
	public String toString() {
		
		String info = "Conta Corrente:\n"; 
	       info += "Saldo: " + this.getSaldo() + "\n";
	       return info;
	}

}
