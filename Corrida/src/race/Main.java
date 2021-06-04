package race;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Main {
	static ArrayList<JPanel> squares;
	
	public void cronometro() {
		Timer timer = new Timer();
		
 		timer.scheduleAtFixedRate(
 			new TimerTask() {
 				public void run() {
 					
 				}
 			}, 100 , 1000);
 	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Corrida de quadrados");
		
		Color[] palette = {Color.CYAN, Color.MAGENTA, Color.GRAY, Color.orange, Color.GREEN, Color.PINK};
		
		RaceSquare rs = new RaceSquare(palette, 80, 6);
		squares = rs.createSquares(0);
		
		for(JPanel square : squares) {
			frame.add(square);
		}
        
		frame.setSize(1200, 570);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}