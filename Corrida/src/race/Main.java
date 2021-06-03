package race;

import java.awt.Color;

import javax.swing.*;

/*
 	1- Atribuir movimentação aleatória aos objetos JPanel
	2- Verificar qual objeto atingiu primeiro o lado direito do JFrame
	Simular uma corrida
 */

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Corrida de quadrados");
		
		Color[] palette = {Color.CYAN, Color.MAGENTA, Color.GRAY, Color.orange, Color.GREEN, Color.PINK};
		
		int y = 0;
		
        for (int i = 0; i < 6; i++) {
			JPanel square = new JPanel();
			square.setBounds(0, y, 80, 80);
			square.setBackground(palette[i]);

			frame.add(square);
			
			y += square.getHeight() + 10;
		}
        
		frame.setSize(600, 569);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLayout(null);
        frame.setVisible(true);
    }
}