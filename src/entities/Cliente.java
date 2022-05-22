package entities;

import exception.DominioExcecoes;
import servicos.Autenticacao;

public class Cliente extends BancoNacional implements Autenticacao {

	private String nome;
	private String cpf;
	private String cpfCorreto;
	private Integer senha;

    private int soma = 0;
    private int primeiro_digito = 0, segundo_digito = 0;
    
	public Cliente() {
		super();
		this.senha = 8;//senha texte 
	}

	
	public Cliente(Integer numero, Double saldo, Double limite, Integer agencia, String nome, String cpf,
			Integer senha) {
		super(numero, saldo, limite, agencia);
		this.nome = nome;
		this.cpf = cpf;
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

	@Override
	public boolean autenticaSenhas(int senha) {
		if (this.getSenha().equals(senha)) {
			return true;
		}
		
		throw new DominioExcecoes("Erro: Senha inválida");
	}

	//verificação dos primeiros numeros do cpf
	@Override
	public void calc_primeiro_digito() {
		
		soma = 0;
        int i = 0, j = 10;
        while (i < 9){
            soma += (Integer.parseInt((cpf.charAt(i) + "")) * j);
            i++;
            j--;
        }

        primeiro_digito = (soma % 11);
        primeiro_digito = (11 - primeiro_digito);

        if(primeiro_digito > 9){
            primeiro_digito = 0;
        }

        cpfCorreto = cpf.substring(0, 9) + primeiro_digito;
		
	}

	//verificação dos dois ultimos numeros do cpf
	@Override
	public void cal_segundo_digito() {
		
		soma = 0;

        int i = 0, j = 11;
        while(i < 10){
            soma += (Integer.parseInt((cpfCorreto.charAt(i)) + "") * j);
            i++;
            j--;
        }

        segundo_digito = (soma % 11);
        segundo_digito = (11 - segundo_digito);

        if(segundo_digito > 9){
            segundo_digito = 0;
        }

        cpfCorreto += segundo_digito;
		
	}

	//verificação de cpf setado do usuario é igual cpf validado nos metodos 
	@Override
	public boolean verificadorCPF() {
		 if (cpf.equals(cpfCorreto)) {
	            return true;
	        } else {

	        	throw new DominioExcecoes("Erro: CPF inválido");
	        }
	}
	
	//mostra cpf na tela formatado
	public String mostra_cpf_correto(){

        String s = "";
               s += cpfCorreto.substring(0, 9) + "-" + cpfCorreto.substring(9, 11);
        return s;
    }
	
	
	@Override
	public String toString() {

		String info = "***Cliente***" + "\n";
		info += "Nome: " + this.getNome() + "\n";
		info += "cpf: " + mostra_cpf_correto() + "\n";
		info += "Número da conta: " + this.getNumero() + "\n";
		info += "Saldo: " + this.getSaldo() + "\n";
		
		return info;
	}
	
}
