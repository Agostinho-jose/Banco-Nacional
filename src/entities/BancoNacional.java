package entities;

import java.time.LocalDate;

import exception.DominioExcecoes;

public abstract class BancoNacional {

	private static int contador;
	
	private LocalDate diaMovimento;
	private LocalDate hoje = LocalDate.now();
	private Double limite;
	private Integer numero;
    private Double saldo;

	public BancoNacional() {
		BancoNacional.contador = BancoNacional.contador + 1;
	}
	
	public BancoNacional(LocalDate diaMovimento, Double limite, Integer numero, Double saldo) {
		super();
		this.diaMovimento = diaMovimento;
		this.limite = limite;
		this.numero = numero;
		this.saldo = 1000.0;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
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
