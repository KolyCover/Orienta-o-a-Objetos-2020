package canhao;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ExemploTiro extends JFrame implements KeyListener{
	Icon projetil, canhao;
	JLabel lbProjetil,lbCanhao;
	JPanel alvo;
	
	Container c;
	Timer timer;
	char dir = 'd'; //d -> desça, s -> suba 
	int y = 0, px, py;
	boolean status = false; //canhão está carregado ou não
	
     public void instanciar() {
   		 projetil = new ImageIcon(getClass().getResource("bala.png"));
   		 lbProjetil = new JLabel("", projetil, JLabel.CENTER);
   		 
    	 canhao = new ImageIcon(getClass().getResource("canhao.jpg")); 
    	 lbCanhao = new JLabel("", canhao, JLabel.CENTER);
    	 
    	 alvo = new JPanel();
    	 timer= new Timer();
    }
     
     public void atribuir() {
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setSize(800,600);
    	 c  = getContentPane(); //atribui o gerenciador de conteúdo do frame para o atributo c
    	 c.setBackground(Color.WHITE);
    	 c.setLayout(null);
    	 lbCanhao.setBounds(10,200, 120,100);
    	 alvo.setBackground(Color.RED);
    	 addKeyListener(this);
      }
     
     public void montar() {
    	c.add(lbCanhao);
    	c.add(alvo);
    	c.add(lbProjetil);
    	setVisible(true);
     }
     
     public void moveAlvo() {
    	 if(dir == 'd') {
    		 alvo.setBounds(700, y += 15 , 30, 100); 
    	 } else if(dir == 's')
    		 alvo.setBounds(700, y -= 15, 30, 100); 
     }
     
     public void cronometro() {
    	    timer.scheduleAtFixedRate(
    	    		new TimerTask() {
    	    			public void run() {
    	    				moveAlvo(); 
    	    				if(y >= 500) dir='s';
    	    				if(y < 0) dir='d';
    	    				if(status) disparo();
    	    				verificaColisao();
    	    			}
    	    		}, 0, 200 ); //objeto, tempo até começar, delay
    	    }
     
     public void verificaColisao() {
    	 int p2ProjetilX = lbProjetil.getX() + lbProjetil.getWidth();
    	 int p2ProjetilY = lbProjetil.getY();
    	 int p3ProjetilY = lbProjetil.getY() + lbProjetil.getHeight();
    	 int p1AlvoY = alvo.getY();
    	 int p1AlvoX = alvo.getX();
    	 int p4AlvoY = p1AlvoY + alvo.getHeight();
    	 
    	 if(p2ProjetilX > p1AlvoX &&
    		p3ProjetilY > p1AlvoY &&
    		p2ProjetilY < p4AlvoY)
    		System.out.println("pow");
     }
     
     public void carregar() {
    	 px = lbCanhao.getX() + 130;
    	 py = lbCanhao.getY() - 10;
    	 lbProjetil.setBounds(px,py,40,40);
    	 status = true;
     }
     
     public void disparo() {
    	  lbProjetil.setBounds(px ,py ,40 ,40);
    	  px += 40;
    	  py += (px > 400)? 20:-20;
    	  
     	  if(px > 800) {
    		  status = false;
    		  lbProjetil.setBounds(-40, -40, 40, 40);
    	  }
    	
    	  
     }
     
    @Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//32 espaço; 40 seta para cima; 38 seta para baixo
		switch (e.getKeyCode()) {		
		case 32: {
			carregar();
		}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		ExemploTiro ex = new ExemploTiro();
		ex.instanciar();
		ex.atribuir();
		ex.montar();
		ex.cronometro();
	}
}
