import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GewinnController {

    private GewinnView view;
    private GewinnModel model;

    public GewinnController() {
        model = new GewinnModel();
        view = new GewinnView(this);
    }

    public void action(ActionEvent e) {
        GewinnLayout layout = view.getGewinnLayout();
        if (e.getSource() == layout.getSpielerZahlFeld()) {//wenn man enter drückt...
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
                    layout.getRundenergebnisLabel().setBackground(Color.GREEN);
                    layout.getGesamtpunkteLabel().setBackground(Color.GREEN);
                } else {
                    layout.getRundenergebnisLabel().setBackground(Color.RED);
                    layout.getGesamtpunkteLabel().setBackground(Color.RED);
                    layout.getRundenergebnisLabel().setText(String.valueOf(ergebnis));
                }
                layout.getGesamtpunkteLabel().setText(String.valueOf(model.getGesamtPunkte()));
                if (model.hatGewonnen()) { // Prüft ob das Spiel gewonnen oder verloren hat
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
        if (e.getSource() == layout.getNochMalBtn()) {//ein reset halt
            layout.getSpielerZahlFeld().setText("");
            layout.getComputerZahlFeld().setText("");
            layout.getRundenergebnisLabel().setText("");
            layout.getRundenergebnisLabel().setBackground(Color.WHITE);
            layout.getGesamtpunkteLabel().setBackground(Color.WHITE);
        }
    }
}