package race;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
	  
	  JFrame frame = new JFrame("Corrida de quadrados");
	  frame.setSize(1200, 570);  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setLayout(null);
      frame.setVisible(true);
      
	  Color[] palette = {Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.orange, Color.GREEN, Color.PINK};
	  
	  RaceSquare rs = new RaceSquare(frame, palette, 80, 6);
	  
	  rs.showSquares();
	  rs.cronometro();
  }
}