package entities;

import exception.DominioExcecoes;

public class ContaCorrente extends BancoNacional implements Contas{
	
	public ContaCorrente() {
		super();
		
	}
	
	public ContaCorrente(Integer numero, Double saldo, Double limite, Integer agencia) {
		super(numero, saldo, limite, agencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sacar(double valor) {
		if(valor <= 0 || valor > this.getSaldo()) {
			throw new DominioExcecoes("Erro de saque: Valor indisponivel");
		} else {
			
			this.setSaldo( this.getSaldo() - valor);
	    }
	}
	
	@Override
	public void deposito(double valor) {
		if(valor <= 0) {
			throw new DominioExcecoes("Erro de deposito: Valor inválido");
		} else {
		
			this.setSaldo(this.getSaldo() + valor);
	    }
	}

	@Override
	public void transferir(BancoNacional conta, double valor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String info = "***Conta Corrente***\n"; 
	           info += "Saldo R$: " + String.format("%.2f", this.getSaldo()) + "\n";
	       return info;
	}
}