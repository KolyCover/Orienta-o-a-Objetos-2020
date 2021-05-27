import javax.swing.JOptionPane;

public class Main {

	public void showInformation(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int ShowOptions(String titulo, String mensagem, String[] opcs) {
		int opc = JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs, opcs[0]);

		return opc;
	}
	
	public String showInput(String title, String message) {
		String input = JOptionPane.showInputDialog(null, title, message, JOptionPane.QUESTION_MESSAGE);
		
		return input;
	}
	
	public void game() {
		String name = showInput("Bem vindo(a)", "Como podemos te chamar?");
		
		Player player = new Player(name);
		Player bot = new Player("Bot");
		
		Game game = new Game(player, bot);
		
		game.createCards();
		game.dealCards();
		
		int indexRounds = 0;
		
		
		while(player.getCards().size() > 0 && bot.getCards().size() > 0) {
			//ShowOptions("Rodada " + indexRounds, "Selecione uma carta para jogar", );
			indexRounds++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
