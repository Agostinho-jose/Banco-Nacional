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

			
			ContaEspecial ce = new ContaEspecial();
			ce.setLimite(1000.0);
			
			ContaPoupanca cp = new ContaPoupanca();
			ContaCorrente cc = new ContaCorrente();
		
			Cliente cliente = new Cliente();
			cliente.setSaldo(1000.0);
			cliente.setAgencia(2387);
			cliente.setNumero(33468375);
			cliente.setNome("Fabricio Neto");
			cliente.setCpf("04999474603");
			cliente.calc_primeiro_digito();
			cliente.cal_segundo_digito();

			if (cliente.verificadorCPF()) {
				System.out.print("Entre com senha: ");
				int senha = scan.nextInt();

				if (cliente.autenticaSenhas(senha)) {

					System.out.print("Conta Poupança: [1] ; Conta Conta Corrente: [2]: ");
					int tipo = scan.nextInt();
					scan.nextLine();
					System.out.println(cliente);
					
					switch (tipo) {
					case 1:
						cp.setSaldo(cliente.getSaldo());
						LocalDate dataPoupanca = LocalDate.parse("20/05/2022", dataFormatada);
						cp.setDataPoupanca(dataPoupanca);
						System.out.println("Valor da porcentagem ao mes: ");
						double porcentagem = scan.nextDouble();
						cp.setRendimentoMes(porcentagem);
						cp.calcularNovoSaldo();
						System.out.println(cp);
						break;

					case 2:
						
						System.out.println("CONTA CORRENTE");
						cc.setSaldo(cliente.getSaldo());
                        
						
						System.out.println("Valor deposito conta corrente: ");
						double deposito = scan.nextDouble();
						cc.deposito(deposito);
						
						System.out.println("Valor saque conta corrente: ");
					    double saque = scan.nextDouble();
						
						ce.setSaldo(cc.getSaldo());
						
						//texte de saldo após deposito
                        System.out.println("Saldo ce: " + ce.getSaldo());
                        System.out.println("Saldo cc: " + cc.getSaldo());
						
                        if (ce.textarLimite(saque) == true) {
							ce.sacar(saque);
							System.out.println(ce);
						} else {
							cc.sacar(saque);
							System.out.println(cc);
						}
                        
					    break;
						default:
							System.out.println("Opção indisponível");
					}
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
			