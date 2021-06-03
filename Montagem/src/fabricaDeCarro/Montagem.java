package fabricaDeCarro;

public class Montagem {
    
    public Automovel criarAut () {
        Automovel aut =  new Automovel();
        return aut;
    }
    
    public Motor criarMotor () {
        Motor m = new Motor();
        m.combustivel = "Gasolina";
        m.hp = 2000;
        m.potencia = 2;
        
        return m;
    }
    
    public Pneu criarPneu () {
        Pneu p = new Pneu();
        p.raio = 17;
        p.marca = "Michel";
        p.largura = 7;
        return p;
    }
    
    public Opcionais criarOpcionais() {
        Opcionais op = new Opcionais();
        op.airBag = true;
        op.arCond = true;
        return op;
    }   
    
    public void mostrarAut (Automovel a) {
        System.out.println(a);
    }
    
    public static void main (String[] args) {
        Montagem m = new Montagem();
        Automovel a = m.criarAut();
        a.motor = m.criarMotor();
        a.pneu = m.criarPneu();
        a.opcional = m.criarOpcionais();
        m.mostrarAut(a);
    }
}
