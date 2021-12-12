package entities;

public class Cliente {

	private String nome;
	private int numero;
	private int telefone;
	private int senha;
	private double deposito;
	private double saque;
	private double saldo;
	private double Limite;

	public Cliente() {
		
	}

	public Cliente(String nome, int numero, int telefone, double deposito, double saque) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.telefone = telefone;
		this.senha = senha;
		this.deposito = deposito;
		this.saque = saque;
		this.saldo = saldo;
		this.Limite = 1000;
	}


	public double getLimite() {
		return Limite;
	}

	public void setLimite(double limite) {
		Limite = limite;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public double getSaque() {
		return saque;
	}

	public void setSaque(double saque) {
		this.saque = saque;
	}
	
	public double Depositando(double deposito) {
		double dep = deposito;
		
			this.setSaldo(dep); 
			return this.saldo;
		
	}
	
	public double conferiSaque(double saque) {
        
        if (saque >= this.getLimite()) {

       	 System.out.println("Operação não realizada");
			 
			
		} else if (saque > this.getSaldo()) {
			
			this.saldo -= saque;
			System.out.println("Cheque especial");

		} else {

			this.saldo -= saque;
	
		}
        
        return this.saque;
	}

	public void imprimirInfo() {
		
		System.out.println("Nome: " + this.getNome()
		+ "\nNúmero: " + this.getNumero()
		+ "\nTelefone: " + this.getTelefone()
		+ "\nValor do deposito: " + this.getDeposito()
		+ "\nValor do saque: " + this.getSaque()
		+ "\nValor do saldo: " + (this.Depositando(deposito) - this.conferiSaque(saque))
		+ "\nLimite: " + this.getLimite() + "\n"
		);
	}
}
