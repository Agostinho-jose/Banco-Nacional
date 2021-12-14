package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date momento;
	private String nomeBanco;
	private Cliente[] cliente;
	
	public ContaCorrente() {}
	

	public ContaCorrente(Date momento, String nomeBanco) {
		super();
		this.momento = momento;
		this.nomeBanco = nomeBanco;
		
	}


	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}
	
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public Cliente[] getCliente() {
		return cliente;
	}

	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}

	public String imprimir() {
		return "Data: ("+ sdf.format(momento) + ")" + "\nBanco: " + this.getNomeBanco() + "\n";
	}
	public void ImprimirInfo() {
		
		System.out.println();
		System.out.println("#### " + this.getNomeBanco() + " ####");
		for(Cliente c : cliente) {
			c.imprimirInfo();
		}	
	}
}
