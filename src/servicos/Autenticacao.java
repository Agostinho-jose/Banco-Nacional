package servicos;

public interface Autenticacao {

	public abstract void calc_primeiro_digito();
	public abstract void cal_segundo_digito();
	public abstract boolean verificadorCPF();
	public abstract String mostra_cpf_correto();
	public abstract boolean autenticaSenhas(int senha);
}
