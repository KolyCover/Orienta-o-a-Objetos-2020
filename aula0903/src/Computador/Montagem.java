package Computador;

public class Montagem {
    
    public static Computador criarComp () {
        Computador c = new Computador();
        return c;
    }
    
    public Monitor criarMoni () {
        Monitor m = new Monitor();
        m.marca = "Hp";
        m.Polegadas = 2;
        m.tipo = "LED";
        return m;
    }
    
    public Teclado criarTec () {
        Teclado t = new Teclado();
        t.marca = "Hyperx";
        t.tipo = "Mecânico";
        t.cor = "Preta";
        t.idioma = "Inglês";
        return t;
    }
    
    public Mouse criarMouse () {
        Mouse m = new Mouse();
        m.DPI = 12000;
        m.bluetooth = true;
        m.marca = "Hp";
        return m;
    }
    
    public Processador criarProcess () {
        Processador p = new Processador();
        p.marca = "Intel";
        p.modelo = "I5";
        p.qtdNucleos = 4;
        return p;
    }
    
    public static void main (String[] args) {
        Computador c = criarComp();
    }
}
