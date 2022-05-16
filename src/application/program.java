package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;

import entities.ContaPoupanca;
import exception.DominioExcecoes;

public class program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {

			//System.out.print("Entre com número da conta: ");
			//int numero = scan.nextInt();

			/*
			 * System.out.print("Entre com CPF: "); String cpf = scan.nextLine();
			 */
			Cliente cliente = new Cliente();
             cliente.setNumero(379);
			// validação cpf
			cliente.setCpf("04999474603");
			cliente.calc_primeiro_digito();
			cliente.cal_segundo_digito();

			if (cliente.verificadorCPF()) {

				System.out.print("Entre com senha: ");
				int senha = scan.nextInt();

				if (cliente.senha(senha)) {
					// System.out.print("Entre com data: ");
					LocalDate data = LocalDate.parse("12/12/2021", dataFormatada);
					cliente.setDiaMovimento(data);

					// System.out.print("Entre com o numero da conta: ");
					// int numero = scan.nextInt();
				

					System.out.print("Digite valor deposito: ");
					double deposito = scan.nextDouble();
					cliente.setLimite(1000.0);
					cliente.setSaldo(deposito);
					cliente.depositar(deposito);

					// System.out.print("Digite valor saque cliente: ");
					// double saque = scan.nextDouble();
					//cliente.sacar(102.0);

					ContaPoupanca cp = new ContaPoupanca();
					cp.setSaldo(cliente.getSaldo());
					//cp.depositar(100.0);
					// System.out.print("Entre com data: ");
					LocalDate dataPoupanca = LocalDate.parse("15/05/2022", dataFormatada);
                    cp.setDataPoupanca(dataPoupanca);
					cp.calcularNovoSaldo(dataPoupanca);
					System.out.println("Dados Conta Cliente: ");
					System.out.println(cliente);

					System.out.println("Dados Conta Poupança: ");
					System.out.println(cp);
				}
			}
		} 
		catch (DominioExcecoes e) {
			System.out.println(e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Valor inválido");
		}

		scan.close();
	}
}