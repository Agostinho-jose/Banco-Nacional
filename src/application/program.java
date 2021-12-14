package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import entities.Cliente;
import entities.ContaCorrente;
import entities.Operacoes;

public class program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		
		ContaCorrente cc = new ContaCorrente(new Date(), "Banco Nacional");
		System.out.print(cc.imprimir());
		
		System.out.print("Date (DD/MM/YYYT): ");
		Date horaOperacao = sdf.parse(scan.next());
        scan.nextLine();
		
		Cliente[] cliente = new Cliente[2];
	
		 for(int i = 0; i < cliente.length; i++) {
			 
			System.out.print("Digite nome: ");
			String nome = scan.nextLine();
			
			System.out.print("Digite numero da conta: ");
		    int num = scan.nextInt();
		    scan.nextLine();
			System.out.print("Telefone: ");
			String tel = scan.nextLine();
			
			System.out.print("Digite valor do deposito: ");
			double deposito = scan.nextDouble();
		
			System.out.print("Digite valor do saque: ");
			double saque = scan.nextDouble();
			
			scan.nextLine();
			Operacoes op = new Operacoes(horaOperacao, deposito, saque);
			Cliente c = new Cliente(nome, num, tel, op);
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
