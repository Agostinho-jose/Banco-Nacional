package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exception.DominioExcecoes;

public class ContaPoupanca extends BancoNacional implements Contas{
 
	private static DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate dataPoupanca;
	private LocalDate dataAtual;
	private Double rendimentoMes;

	public ContaPoupanca() {
		super();
		this.dataAtual = LocalDate.now();
	}
	
	public ContaPoupanca(Integer numero, Double saldo, Double limite, Integer agencia, LocalDate dataPoupanca,
			Double rendimentoMes) {
		super(numero, saldo, limite, agencia);
		this.dataPoupanca = dataPoupanca;
		this.rendimentoMes = rendimentoMes;
	}


	public Double getRendimentoMes() {
		return rendimentoMes;
	}


	public void setRendimentoMes(Double rendimentoMes) {
		this.rendimentoMes = rendimentoMes;
	}


	public LocalDate getDataAtual() {
		return dataAtual;
	}


	public LocalDate getDataPoupanca() {
		return dataPoupanca;
	}

	public void setDataPoupanca(LocalDate dataPoupanca) {
		if(dataPoupanca.isAfter(dataAtual)) {
			throw new DominioExcecoes("Erro na data: posterior data atual");
		}
		this.dataPoupanca = dataPoupanca;
	}

	public void calcularNovoSaldo(){
        double rendimento = this.getSaldo() * this.getRendimentoMes();
        if(this.getDataPoupanca().equals(this.getDataAtual())){
            this.setSaldo(this.getSaldo() + rendimento);
        } else {
        	 this.getSaldo();
        }
    }
	
	@Override
	public void sacar(double valor) {
		if(valor < 0) {
			throw new DominioExcecoes("Erro de saque: Valor indisponivel");
		} else {
			this.setSaldo( this.getLimite() - valor);
	    }	
	}


	@Override
	public void deposito(double valor) {
		if(valor < 0) {
			throw new DominioExcecoes("Erro de deposito: Valor inválido");
		} else {
			this.setSaldo(this.getLimite() + valor);
	    }	
	}


	@Override
	public void transferir(BancoNacional conta, double valor) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public String toString() {
		
	String info = "***Conta Poupança***" + "\n";
	       info += "Data atual: " + this.getDataAtual().format(dataFormatada) + "\n";
		   info += "Data de rendimentos da poupança: " + this.getDataPoupanca().format(dataFormatada) + "\n";    
		   info += "Saldo R$: " + String.format("%.2f", this.getSaldo()) + "\n";
	      
	       return info;
	}
	
}
