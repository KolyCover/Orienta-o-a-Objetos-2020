package Computador;
import java.util.Random;

public class Computador{
        String marca, modelo;
        int ano;
        double memoria, processador, armazenamento;
 
    //método construtor
    public Computador(){
        Random random = new Random();
        this.marca = "Hp";
        this.modelo = "Hewlett-Packard";
        /*int aleatorio = random.nextInt(20) + 2000;
        c1.ano = aleatorio > 2020?2020:aleatorio;*/
        this.ano =  random.nextInt(20) + 2000;
        this.memoria = random.nextInt(3) + 6;
        this.processador = random.nextDouble() + 2.5;
        this.armazenamento = random.nextInt(2) + 1;
    }
    
    public static Computador criarObj ( ) {
  
    	Computador c = new Computador();
    	
    	return c;
    }
    public void mostrarAtributos (int i) {
    	System.out.println("Computador " + (i + 1));
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("Memória: " + this.memoria);
        System.out.println("Processador: " + this.processador);
        System.out.println("Ano: " + this.ano);
        System.out.println("\n-----------\n");
    }
       
   
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
	        criarObj().mostrarAtributos(i);
        }
    }
}