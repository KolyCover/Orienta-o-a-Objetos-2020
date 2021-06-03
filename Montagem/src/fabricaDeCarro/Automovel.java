package fabricaDeCarro;

public class Automovel {
    Pneu pneu;
    Motor motor;
    Estrutura estrutura;
    Opcionais opcional;
    
    public Automovel () {
        
    }
    
    public String toString(){
        return "\nHp Motor: " + this.motor.hp +
                "\nPotencia Motor: " + this.motor.potencia + 
                "\nCombustível Motor: " + this.motor.combustivel + 
                "\nMarca Pneu: " + this.pneu.marca +
                "\nRaio Pneu: " + this.pneu.raio +
                "\nLargura Pneu: " + this.pneu.largura +
                "\nAir Bag: " + this.opcional.airBag + 
                "\nBanco de couro: " + this.opcional.bcCoro +
                "\nAr Condicionado: " + this.opcional.arCond + 
                "\nVidro Elétrico: " + this.opcional.vidroEletrico +
                "\nQuatro Portas: " + this.opcional.qPortas;
    }
}
