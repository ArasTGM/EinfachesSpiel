import java.awt.event.*;

public class GewinnController {

    private GewinnView view;
    private GewinnModel model;

    public GewinnController() {
        model = new GewinnModel();
        view = new GewinnView(this);
    }

    public void action(ActionEvent e) {
        GewinnLayout layout = view.getGewinnLayout();

        if (e.getSource() == layout.getSpielerZahlFeld()) {
            try {
                int spielerZahl = Integer.parseInt(layout.getSpielerZahlFeld().getText());

                if (spielerZahl < 1 || spielerZahl > 9) {
                    layout.getSpielerZahlFeld().setText("");
                    return;
                }

                model.berechneComputerZahl();
                model.berechneRunde(spielerZahl);

                layout.getComputerZahlFeld().setText("" + model.getComputerZahl());

                int ergebnis = model.getRundenErgebnis();

                if (ergebnis > 0)
                    layout.getRundenergebnisLabel().setText("+" + ergebnis);
                else
                    layout.getRundenergebnisLabel().setText("" + ergebnis);

                layout.getGesamtpunkteLabel().setText("" + model.getGesamtPunkte());

            } catch (NumberFormatException ex) {
                layout.getSpielerZahlFeld().setText("");
            }
        }

        if (e.getSource() == layout.getNochMalBtn()) {
            layout.getSpielerZahlFeld().setText("");
            layout.getComputerZahlFeld().setText("");
            layout.getRundenergebnisLabel().setText("Tippe eine Zahl von 1 bis 9");
        }
    }
}