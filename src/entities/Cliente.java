package entities;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String cpfCorreto;
	private String email;
	
	private int soma = 0;
	private int primeiro_digito = 0, segundo_digito = 0;
	
	public Cliente() {
	
	}
	
	public Cliente(String nome, String cpf, String cpfCorreto, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cpfCorreto = cpfCorreto;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	 public void calc_primeiro_digito(){
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

	    public void cal_segundo_digito(){
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

	    public boolean verificadorCPF() {

	        if (cpf.equals(cpfCorreto)) {
	            return true;
	        } else {

	            return false;
	        }
	    }
	    
	    public String mostra_cpf_correto(){

	        String s = "";
	               s += cpfCorreto.substring(0, 9) + "-" + cpfCorreto.substring(9, 11);
	        return s;
	    }
}
