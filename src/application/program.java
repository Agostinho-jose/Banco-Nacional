package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaEspecial;
import entities.ContaPoupanca;
import exception.DominioExcecoes;

public class program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {

			// System.out.print("Entre com número da conta: ");
			// int numero = scan.nextInt();

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

					// System.out.print("Entre com o numero da conta: ");
					// int numero = scan.nextInt();

					System.out.print("Digite valor deposito: ");
					double deposito = scan.nextDouble();
				
					
					cliente.depositar(deposito);
					System.out.println("Dados Conta Cliente: ");
					System.out.println(cliente);

					System.out.print("Conta Poupança: [1] ; Conta Conta Corrente: [2]: ");
					int tipo = scan.nextInt();

					switch (tipo) {
					case 1:
						ContaPoupanca cp = new ContaPoupanca();
						cp.setSaldo(cliente.getSaldo());
						LocalDate dataPoupanca = LocalDate.parse("17/05/2022", dataFormatada);
						cp.setDataPoupanca(dataPoupanca);
						cp.calcularNovoSaldo(dataPoupanca);
						System.out.println("Dados Conta Poupança: ");
						System.out.println(cp);
						break;
					
					case 2:
						
						ContaEspecial ce = new ContaEspecial();
						ce.setSaldo(cliente.getSaldo());
						double l = ce.getLimite();
						if (ce.textLimite()) {// se saque maior q saldo e menor q limite true entra cheque especial;
							System.out.println("CONTA CORRENTE");
							ContaCorrente cc = new ContaCorrente();
							cc.setSaldo(cliente.getSaldo());
							System.out.println("Valor deposito conta corrente: ");
							double depositoCC = scan.nextDouble();
						    cc.depositar(depositoCC);
							
						    System.out.println("Valor saque conta corrente: ");
							double sacarCC = scan.nextDouble();
							cc.sacar(sacarCC);
							System.out.println(cc);
								
						} else {
							System.out.println("Valor deposito conta especial: ");
							double depositoCE = scan.nextDouble();
						    ce.depositar(depositoCE);
							System.out.println("Valor saque conta especial: ");
							double sacarEP = scan.nextDouble();
							ce.sacar(sacarEP);
							System.out.println(ce);
						}

						break;
					 default:
						 System.out.println("OPERAÇÃO INEXISTENTE");
					}
				}
			}
		} catch (DominioExcecoes e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Valor inválido");
		}

		scan.close();
	}
}