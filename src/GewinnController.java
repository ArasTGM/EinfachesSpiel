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
            }
        }
    }
}