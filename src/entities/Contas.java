package entities;

public interface Contas {

	public abstract void sacar(double valor);
	public abstract void deposito(double valor);
	void transferir(BancoNacional conta, double valor);
}
