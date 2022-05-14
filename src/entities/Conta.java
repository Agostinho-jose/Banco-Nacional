package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {

	private static int contador;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date diaMovimento;
	private double limite;
	private int numero;
    private double saldo;
    private Cliente titular;

	public Conta() {
		Conta.contador = Conta.contador + 1;
		this.limite = 2000;
	}
	
	public Conta(Date diaMovimento, int numero, double saldo, Cliente titular) {
		super();
		this.diaMovimento = diaMovimento;
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public static int getContador() {
		return contador;
	}

	public Date getDiaMovimento() {
		return diaMovimento;
	}

	public void setDiaMovimento(Date diaMovimento) {
		this.diaMovimento = diaMovimento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public boolean depositar(double deposito) {
		if(deposito < 0) {
			return false;
		} else {
			this.saldo += deposito;
			return true;
		}	
	}
	
	public boolean sacar(double saque ){
		if(saque > this.getSaldo() || saque < 0 || this.getLimite() < saque) {
			return false;
		} else {
			this.saldo -= saque;
			return true;
		}
	}
	
	public String imprimirInfo() {
	
		String info = "Data: " + sdf.format(diaMovimento) + "\n";
		
		       if(titular != null) {
			   info += "Nome: " + titular.getNome() + "\n"; 
	    	   info += "cpf: " + titular.mostra_cpf_correto() + "\n";
		}
		       info += "Número da conta: " + this.getNumero() + "\n";
		       info += "Saldo: " + this.getSaldo() + "\n";
		       info += "Limite: " + this.limite;
		       
		       return info;
	}

}
