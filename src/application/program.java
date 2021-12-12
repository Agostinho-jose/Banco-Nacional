package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ContaCorrente;

public class program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		ContaCorrente cc = new ContaCorrente("Banco Nacional");
		
		Cliente[] cliente = new Cliente[2];
        
		 for(int i = 0; i < cliente.length; i++) {
			System.out.println(cc.getNomeBanco());
			System.out.print("Digite nome: ");
			String nome = scan.nextLine();
			
			System.out.print("Digite numero da conta: ");
		    int num = scan.nextInt();
		 
			System.out.print("Telefone: ");
			int tel = scan.nextInt();
			
			System.out.print("Digite valor do deposito: ");
			double deposito = scan.nextDouble();
		
			System.out.print("Digite valor do saque: ");
			double saque = scan.nextDouble();
			
			scan.nextLine();
			Cliente c = new Cliente(nome, num, tel, deposito, saque);
		    cliente[i] = c;
		   
			}
			cc.setCliente(cliente);
			/*System.out.print("Digite valor do deposito: ");
			double deposito = scan.nextDouble();
			cc.setSaldo(deposito);
			cc.conferiDeposito(deposito);
			System.out.print("Digite valor do saque: ");
			double saque = scan.nextDouble();
			cc.conferiSaque(saque);
			scan.nextLine();
			*/
		
		cc.ImprimirInfo();
		
	}

}
