package race;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/*
	1- Atribuir movimentação aleatória aos objetos JPanel
2- Verificar qual objeto atingiu primeiro o lado direito do JFrame
Simular uma corrida
*/

/*
 	public void cronometro() {
 		timer.scheduleAtFixedRate(
 			new Timer Task() {
 				public void run() {
 					mostraQuadrado();
 				}
 			}, delay, interval);
 	}
 */

public class RaceSquare {
	Color[] palette;
	int measure;
	int qtySquares;
	
	Random random = new Random();
	
	public RaceSquare(Color[] palette, int measure, int qtySquares) {
		this.palette = palette;
		this.measure = measure;
		this.qtySquares = qtySquares;
	}
	
	
	
	public ArrayList<JPanel> createSquares(int x) {
		ArrayList<JPanel> squares = new ArrayList<JPanel>();
		
		int y = 0;
		
		for (int i = 0; i < this.qtySquares; i++) {
			JPanel square = new JPanel();
			square.setBounds(x, y, measure, measure);
			square.setBackground(palette[i]);

			squares.add(square);
			
			y += square.getHeight() + 10;
		}
		
		return squares;
	}
	
}
