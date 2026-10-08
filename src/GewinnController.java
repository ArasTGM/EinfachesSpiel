import java.awt.*;
import java.awt.event.*;

public class GewinnController implements ActionListener {

    private GewinnView view;
    private GewinnModel model;

    public GewinnController() {
        model = new GewinnModel();
        view = new GewinnView(this);
    }

    public void actionPerformed(ActionEvent e) {
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

                layout.getSpielerZahlFeld().setEditable(false);
                layout.getNochMalBtn().setEnabled(true);

                if (ergebnis > 0) {
                    layout.getRundenergebnisLabel().setBackground(Color.GREEN);
                    layout.getGesamtpunkteLabel().setBackground(Color.GREEN);
                } else {
                    layout.getRundenergebnisLabel().setBackground(Color.RED);
                    layout.getGesamtpunkteLabel().setBackground(Color.RED);
                }

            } catch (NumberFormatException ex) {
                layout.getSpielerZahlFeld().setText("");
            }
        }
    }
}