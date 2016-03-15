package jogo;

public class ValorNaoModificavelException extends Exception {

	@Override
	public String getMessage() {
		return "A casa já foi jogada";
	}
}
