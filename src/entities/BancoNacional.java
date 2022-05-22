package entities;

import java.time.LocalDate;

public abstract class BancoNacional {

	private static int contador;
	

	private LocalDate hoje = LocalDate.now();
	private Integer numero;
    private Double saldo;
    private Double limite;
    private Integer agencia;

	public BancoNacional() {
		BancoNacional.contador = BancoNacional.contador + 1;
	}
	
	public BancoNacional(Integer numero, Double saldo, Double limite, Integer agencia) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	@Override
	public abstract String toString();
	
}
