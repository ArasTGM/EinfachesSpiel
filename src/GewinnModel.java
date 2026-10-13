public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    public GewinnModel() {
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

    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        this.computerZahl = (int) (Math.random() * 9) + 1;// eine zufällige Zahl von 1 bis 9 (obwohl es gar nicht wirklich zufällig ist, der algorithmus hängt von dem Start(30) und viel mehr ab(soweit ich weiß))
        if (spielerZahl > computerZahl) {
            this.rundenErgebnis = 20;
        } else if (spielerZahl == computerZahl) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }
    public boolean hatGewonnen(){
        return this.gesamtPunkte >= 100;
    }
    public boolean hatVerloren(){
        return this.gesamtPunkte <= 0;
    }
}