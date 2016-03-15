package jogo;

public class Jogador {
	private TipoJogador tipo;

	public TipoJogador getTipo() {
		return tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Jogador && tipo == ((Jogador)obj).getTipo();
	}
}
