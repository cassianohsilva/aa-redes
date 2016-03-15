package jogo;

public class Casa {
	private Jogador valor;

	public Casa() {
		valor = null;
	}

	public void jogar(Jogador valor) throws ValorNaoModificavelException {
		if (valor == null) {
			this.valor = valor;
		} else {
			throw new ValorNaoModificavelException();
		}
	}

	public Jogador getValor() {
		return valor;
	}
}
