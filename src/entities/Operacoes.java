package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operacoes {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date diaMovimento;
	private double deposito;
	private double saque;
	private double limite;

	public Operacoes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Operacoes(Date diaMovimento, double deposito, double saque) {
	
		this.diaMovimento = diaMovimento;
		this.deposito = deposito;
		this.saque = saque;
		this.limite = 1000;
	}
	
	
	public Date getDiaMovimento() {
		return diaMovimento;
	}
	public void setDiaMovimento(Date diaMovimento) {
		this.diaMovimento = diaMovimento;
	}
	public double getDeposito() {
		return deposito;
	}
	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}
	public double getSaque() {
		return saque;
	}
	public void setSaque(double saque) {
		this.saque = saque;
	}

	
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}


	public double depositando(double deposito) {
		this.deposito += deposito;
		return this.getDeposito();
	}
	
	public double sacando(double saque) {
		if(saque > this.getLimite()) {
			System.out.println("Operação Indisponivel");
		}else if(saque > this.getDeposito()) {
			this.deposito-= saque;
			System.out.println("Cheque Especial");
		} else {
			this.deposito -= saque;
		}
		
		return this.getDeposito();
	}
	
      public void imprimirInfoOp() {
		
		System.out.println( "Data da movimentação: ("+ sdf.format(diaMovimento) + ")" 
		+ "\nValor do deposito: " + this.getDeposito()
		+ "\nValor do saque: " + this.getSaque()
		+ "\nValor do saldo: " + (this.sacando(saque))
		+ "\nLimite: " + this.getLimite() + "\n");
	}
}
