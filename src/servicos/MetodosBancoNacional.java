package servicos;

import entities.BancoNacional;

public interface MetodosBancoNacional {

	public abstract boolean texteLimite(double valor);
	public abstract void transferir(BancoNacional destino, double valor);
}
