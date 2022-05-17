package entities;

import java.time.LocalDate;

public abstract class BancoNacional {

	private static int contador;
	

	private LocalDate hoje = LocalDate.now();
	private Integer numero;
    private Double saldo;

	public BancoNacional() {
		BancoNacional.contador = BancoNacional.contador + 1;
	}
	
	public BancoNacional(Integer numero, Double saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}

	public static int getContador() {
		return contador;
	}

	public Integer getNumero() {
		return numero;
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

	public abstract void depositar(double deposito);
	
	public abstract void sacar(double saque );
	
	public abstract void transferir(BancoNacional destino, double valor);
	
	@Override
	public abstract String toString();
	
}
