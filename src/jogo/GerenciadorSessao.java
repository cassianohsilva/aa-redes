package jogo;

public class GerenciadorSessao {

	Jogador jogadores[];

	private static GerenciadorSessao gerenciadorSessao;

	public static GerenciadorSessao getInstance() {
		if (gerenciadorSessao == null) {
			gerenciadorSessao = new GerenciadorSessao();
		}
		return gerenciadorSessao;
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}
}
