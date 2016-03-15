package jogo;

import java.util.ArrayList;

public class Tabuleiro {

	private static final int[][] vetores = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };

	private int numeroJogadas;
	private int[] ultimaJogada;

	private final int altura = 8;
	private final int largura = 8;

	private Casa[][] tabuleiro;

	public Tabuleiro() {
		numeroJogadas = 0;
		ultimaJogada = new int[2];
		tabuleiro = new Casa[altura][largura];

		reset();
	}

	private void reset() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = new Casa();
			}
		}
	}

	public void realizarJogada(Jogador jogador, int linha, int coluna) {
		try {
			tabuleiro[linha][coluna].jogar(jogador);

			ultimaJogada[0] = linha;
			ultimaJogada[1] = coluna;

			numeroJogadas++;
		} catch (ValorNaoModificavelException e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean verificarLimite(int linha, int coluna) {
		return linha >= 0 && linha < tabuleiro.length && coluna >= 0 && coluna < tabuleiro[0].length;
	}

	public Jogador[] verificarGanhadores() {
		ArrayList<Casa> casas = new ArrayList<>();

		boolean jogoGanho = false;
//		boolean finalVerificacao = false;

		Jogador ganhadores[] = null;

		int linhaAtual = ultimaJogada[0];
		int colunaAtual = ultimaJogada[1];

		for (int[] vetor : vetores) {
			casas.add(tabuleiro[linhaAtual][colunaAtual]);

			linhaAtual += vetor[0];
			colunaAtual += vetor[1];

			while (tabuleiro[linhaAtual][colunaAtual].getValor().equals(casas.get(0))
					&& verificarLimite(linhaAtual, colunaAtual)) {
				casas.add(tabuleiro[linhaAtual][colunaAtual]);

				linhaAtual += vetor[0];
				colunaAtual += vetor[1];
			}

			linhaAtual = ultimaJogada[0] - vetor[0];
			colunaAtual = ultimaJogada[1] - vetor[1];

			while (tabuleiro[linhaAtual][colunaAtual].getValor().equals(casas.get(0))
					&& verificarLimite(linhaAtual, colunaAtual)) {
				casas.add(tabuleiro[linhaAtual][colunaAtual]);

				linhaAtual -= vetor[0];
				colunaAtual -= vetor[1];
			}

			if (casas.size() >= 5) {
				jogoGanho = true;
				ganhadores = new Jogador[] { casas.get(0).getValor() };
			}
		}
		
		if(!jogoGanho && (numeroJogadas == altura*largura)) {
			ganhadores = GerenciadorSessao.getInstance().getJogadores();
		}

		return ganhadores;
	}
}
