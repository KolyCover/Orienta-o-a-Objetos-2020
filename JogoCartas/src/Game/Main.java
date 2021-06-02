package Game;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

	public static void showInformation(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int ShowOptions(String titulo, String mensagem, String[] opcs) {
		int opc = JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs, opcs[0]);

		return opc;
	}
	
	public static String showInput(String title, String message) {
		String input = JOptionPane.showInputDialog(null, title, message, JOptionPane.QUESTION_MESSAGE);
		
		return input;
	}
	
	public static void game() {
		Random r = new Random();
		String name = showInput("Bem vindo(a)", "Como podemos te chamar?");
		
		Player player = new Player(name);
		Player bot = new Player("Bot");
		
		Game game = new Game(player, bot);
		
		game.createCards();
		game.dealCards();
		
		int indexRounds = 1;
		
		while(player.getCards().size() > 0 && bot.getCards().size() > 0) {
			int indexTurned = r.nextInt(game.getDeck().size());
			Card turned = game.getDeck().get(indexTurned);
			
			showInformation("Rodada" + indexRounds, "O vira dessa rodada é o " + turned.getValue());
			
			int indexCardPlayer = ShowOptions("Rodada " + indexRounds, "Selecione uma carta para jogar", player.getCardsNames());
			int indexCardBot = r.nextInt(bot.getCards().size());
			
			Card cardPlayer = player.getCards().get(indexCardPlayer);
			Card cardBot = bot.getCards().get(indexCardBot);
			
			int winner = game.play(cardPlayer, cardBot, turned);
			
			if(winner == 1) {
				showInformation("Rodada " + indexRounds, "Você ganhou essa rodada!\nSua carta: " + cardPlayer.getName() + "\nCarta do Bot: " + cardBot.getName());
			}else {
				showInformation("Rodada " + indexRounds, "Você perdeu essa rodada!\nSua carta: " + cardPlayer.getName() + "\nCarta do Bot: " + cardBot.getName());
			}
			
			indexRounds++;
		}
		
		if(bot.getCards().size() == 0) {
			showInformation("Fim", "Parabéns " + player.getName() + "! Você ganhou o jogo.");
		} else {
			showInformation("Fim", "Que pena " + player.getName() + ", você perdeu o jogo! Te");
		}
	}
	
	public static void main(String[] args) {
		game();
	}

}
