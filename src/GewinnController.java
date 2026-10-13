import javax.swing.*;
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

                model.berechneRunde(spielerZahl);
                layout.getComputerZahlFeld().setText(String.valueOf(model.getComputerZahl()));
                int ergebnis = model.getRundenErgebnis();
                if (ergebnis > 0) {
                    layout.getRundenergebnisLabel().setText("+" + ergebnis);
                } else {
                    layout.getRundenergebnisLabel().setText(String.valueOf(ergebnis));
                }
                layout.getGesamtpunkteLabel().setText(String.valueOf(model.getGesamtPunkte()));
                layout.getSpielerZahlFeld().setEditable(false);
                layout.getNochMalBtn().setEnabled(true);
                if (model.hatGewonnen()) {
                    JOptionPane.showMessageDialog(view, "Gewonnen! 100+ Punkte erreicht.");
                    layout.getSpielerZahlFeld().setEnabled(false);
                } else if (model.hatVerloren()) {
                    JOptionPane.showMessageDialog(view, "Verloren! Keine Punkte mehr übrig.");
                    layout.getSpielerZahlFeld().setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                layout.getSpielerZahlFeld().setText("");
            }
        }
        if (e.getSource() == layout.getNochMalBtn()) {
            layout.getSpielerZahlFeld().setText("");
            layout.getComputerZahlFeld().setText("");
            layout.getRundenergebnisLabel().setText("");
            layout.getSpielerZahlFeld().setEditable(true);
            layout.getNochMalBtn().setEnabled(false);
        }
    }
}