package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import exception.DominioExcecoes;

public class Conta {

	private static int contador;
	
	private static DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate diaMovimento;
	private LocalDate hoje = LocalDate.now();
	private double limite;
	private int numero;
    private double saldo;
    private Cliente titular;

	public Conta() {
		Conta.contador = Conta.contador + 1;
		this.limite = 2000;
	}
	
	public Conta(LocalDate diaMovimento, int numero, double saldo, Cliente titular) {
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

	public LocalDate getDiaMovimento() {
		return diaMovimento;
	}

	public void setDiaMovimento(LocalDate diaMovimento) {
		if(diaMovimento.isAfter(hoje)) {
			throw new DominioExcecoes("Erro na data: posterior data atual");
		}
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

	public void depositar(double deposito) {
		if(deposito < 0) {
			throw new DominioExcecoes("Erro de deposito: O valor inválido");
		} else {
			this.saldo += deposito;
			
		}	
	}
	
	public void sacar(double saque ){
		if(saque > this.getSaldo() || saque < 0 || this.getLimite() < saque) {
			throw new DominioExcecoes("Erro de saque: O valor inválido");
		} else {
			this.saldo -= saque;
		}
	}
	
	public String imprimirInfo() {
	
		String info = "Data: " + diaMovimento.format(dataFormatada) + "\n";
		
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
