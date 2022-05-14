package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;

import exception.DominioExcecoes;

public class program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Conta c = new Conta();
		Cliente cliente = new Cliente();

		try {
			System.out.print("Entre com titular: ");
			String nome = scan.nextLine();
			cliente.setNome(nome);

			System.out.print("Entre com CPF: ");
			String cpf = scan.nextLine();
			cliente.setCpf(cpf);
			cliente.calc_primeiro_digito();
			cliente.cal_segundo_digito();

			c.setTitular(cliente);
			if (cliente.verificadorCPF() == true) {

				System.out.print("Entre com data: ");

				LocalDate data = LocalDate.parse(scan.next(), dataFormatada);
				c.setDiaMovimento(data);

				System.out.print("Entre com o numero da conta: ");
				int numero = scan.nextInt();
				c.setNumero(numero);

				System.out.print("Digite valor deposito: ");
				double deposito = scan.nextDouble();
				c.depositar(deposito);

				System.out.print("Digite valor saque: ");
				double saque = scan.nextDouble();
				c.sacar(saque);

				System.out.println("Dados conta 1: ");
				System.out.println(c);
			}

			scan.close();
		} catch (DominioExcecoes e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Valor inválido");
		}
	}
}