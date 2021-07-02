package race;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RaceSquare {
	JFrame frame;
	Color[] palette;
	int measure;
	int qtySquares;
	ArrayList<JPanel> squares = new ArrayList<JPanel>();
	
    int delay = 0;   // tempo de espera antes da 1ª execução da tarefa.
    int interval = 1000;  // intervalo no qual a tarefa será executada.
    int x = 10, y = 0;
    
    public RaceSquare(JFrame frame, Color[] palette, int measure, int qtySquares) {
    	this.frame = frame;
		this.palette = palette;
		this.measure = measure;
		this.qtySquares = qtySquares;
	}
    
    public void createSquares(){
    	for(int i = 0; i < qtySquares; i++) {
	    	JPanel square = new JPanel();
	    	square.setBackground(this.palette[i]);
	    	squares.add(square);
    	}
    }
    
    public void showSquares() {
    	createSquares();
    	
    	for (JPanel square : squares) {
    		square.setBounds(x += 5, y, measure, measure);
	    	y += measure + 10;
			frame.add(square);
		}
    	
    	y = 0;
    }

    public void cronometro() {
        Timer timer = new Timer();
    	timer.scheduleAtFixedRate(
    		new TimerTask() {
    			public void run() {
    				showSquares(); 	
    			}
    		}, delay, interval);
    }
}
