public class Model {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    public Model() {
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }
    public int getComputerZahl() {
        return this.computerZahl;
    }
    public int getRundenErgebnis(){
        return this.rundenErgebnis;
    }
    public void berechneComputerZahl(){
        this.computerZahl = (int)(Math.random()*9)+1;
    }

    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        if (spielerZahl > computerZahl) {
            this.rundenErgebnis = 20;
        }
        else if (spielerZahl == computerZahl) {
            this.rundenErgebnis = 5;
        }
        else {
            this.rundenErgebnis = -10;
        }
    }
    public boolean hatGewonnen(){
        return this.gesamtPunkte >= 100;
    }
    public boolean hatVerloren(){
        return this.gesamtPunkte <= 0;
    }
}
