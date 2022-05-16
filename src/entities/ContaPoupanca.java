package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exception.DominioExcecoes;

public class ContaPoupanca extends BancoNacional{
 
	private static DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate dataPoupanca;
	private LocalDate dataAtual;

	public ContaPoupanca() {
		super();
		this.dataAtual = LocalDate.now();
	}

	public ContaPoupanca(LocalDate diaMovimento, Double limite, Integer numero, Double saldo, LocalDate dataPoupanca) {
		super(diaMovimento, limite, numero, saldo);
		this.dataPoupanca = dataPoupanca;
	}
	

	public LocalDate getDataAtual() {
		return dataAtual;
	}


	public LocalDate getDataPoupanca() {
		return dataPoupanca;
	}

	public void setDataPoupanca(LocalDate dataPoupanca) {
		this.dataPoupanca = dataPoupanca;
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
		
		if(saque > this.getSaldo() || saque < 0 || this.getLimite() < saque) {
			throw new DominioExcecoes("Erro de saque: Valor inválido");
		} else {
			this.setSaldo(getSaldo() - saque);
	    }
		
	}

	@Override
	public void transferir(BancoNacional destino, double valor) {
		
		this.setSaldo(getSaldo() - valor);;
		 destino.setSaldo(this.getSaldo() + valor );
		
	}
	
	public void calcularNovoSaldo(LocalDate data){
        double rendimento = this.getSaldo() * 0.02;
        if(data.equals(this.getDataAtual())){
            this.setSaldo(this.getSaldo() + rendimento);
        } else {
        	 this.getSaldo();
        }
    }

	@Override
	public String toString() {
		
		String info = "Data atual: " + this.getDataAtual().format(dataFormatada) + "\n";
		   info += "Data poupança: " + this.getDataPoupanca().format(dataFormatada) + "\n";    
		   info += "Conta Poupança:\n"; 
	       info += "Saldo: " + this.getSaldo() + "\n";
	      
	       return info;
	}
	
}
