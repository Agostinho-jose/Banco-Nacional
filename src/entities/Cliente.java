package entities;

public class Cliente {

	private String nome;
	private int numero;
	private String telefone;
	private Operacoes op;
	private Status status;

	public Cliente() {}
	
	public Cliente(String nome, int numero, String telefone, Operacoes op, Status status) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.telefone = telefone;
		this.op = op;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Operacoes getOp() {
		return op;
	}

	public void setOp(Operacoes op) {
		this.op = op;
	}

	public void imprimirInfo() {
		
		System.out.println("\nNome: " + this.getNome()
		+ "\nNúmero: " + this.getNumero()
		+ "\nTelefone: " + this.getTelefone()
		+ "\n" + this.getStatus());
		
        op.imprimirInfoOp();
	}
}
