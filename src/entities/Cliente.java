package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exception.DominioExcecoes;

public class Cliente extends BancoNacional {

	private static DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String nome;
	private String cpf;
	private String cpfCorreto;
	private Integer senha;

	private Integer soma = 0;
	private Integer primeiro_digito = 0, segundo_digito = 0;

	public Cliente() {
		this.senha = 7;
		this.setSaldo(0.0);
	}

	public Cliente(String nome, String cpf, String cpfCorreto, Integer senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cpfCorreto = cpfCorreto;
		this.senha = senha;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public String getCpfCorreto() {
		return cpfCorreto;
	}

	public void setCpfCorreto(String cpfCorreto) {
		this.cpfCorreto = cpfCorreto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void calc_primeiro_digito() {
		soma = 0;
		int i = 0, j = 10;
		while (i < 9) {
			soma += (Integer.parseInt((cpf.charAt(i) + "")) * j);
			i++;
			j--;
		}

		primeiro_digito = (soma % 11);
		primeiro_digito = (11 - primeiro_digito);

		if (primeiro_digito > 9) {
			primeiro_digito = 0;
		}

		cpfCorreto = cpf.substring(0, 9) + primeiro_digito;
	}

	public void cal_segundo_digito() {
		soma = 0;

		int i = 0, j = 11;
		while (i < 10) {
			soma += (Integer.parseInt((cpfCorreto.charAt(i)) + "") * j);
			i++;
			j--;
		}

		segundo_digito = (soma % 11);
		segundo_digito = (11 - segundo_digito);

		if (segundo_digito > 9) {
			segundo_digito = 0;
		}

		cpfCorreto += segundo_digito;
	}

	public boolean verificadorCPF() {

		if (cpf.equals(cpfCorreto)) {
			return true;
		} else {

			return false;
		}
	}

	public String mostra_cpf_correto() {

		String s = "";
		s += cpfCorreto.substring(0, 9) + "-" + cpfCorreto.substring(9, 11);
		return s;
	}

	public boolean senha(int senha) {
		if (this.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	@Override
	public void depositar(double deposito) {
		if (deposito < 0) {
			throw new DominioExcecoes("Erro de deposito: O valor inválido");
		} else {
			this.setSaldo(this.getSaldo() + deposito);
		}
	}

	@Override
	public void sacar(double saque) {
		if (saque > this.getSaldo() || saque < 0) {
			throw new DominioExcecoes("Erro de saque: O valor inválido");
		} else {
			this.setSaldo(getSaldo() - saque);
		}
	}

	@Override
	public void transferir(BancoNacional destino, double valor) {

		this.setSaldo(getSaldo() - valor);
		;
		destino.setSaldo(this.getSaldo() + valor);

	}

	@Override
	public String toString() {

		String info = "Nome: " + "\n";
		info += "cpf: " + mostra_cpf_correto() + "\n";
		info += "Número da conta: " + this.getNumero() + "\n";
		info += "Saldo: " + this.getSaldo() + "\n";
		

		return info;
	}
}
