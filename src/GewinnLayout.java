import javax.swing.*;
import java.awt.*;

public class GewinnLayout extends JPanel {

    private JLabel rundenergebnisLabel;
    private JLabel gesamtpunkteLabel;

    private JTextField spielerZahlFeld;
    private JTextField computerZahlFeld;

    private JButton nochMalBtn;

    public GewinnLayout(GewinnController controller) {

        setLayout(new BorderLayout());

        JPanel oben = new JPanel(new GridLayout(3, 2));
        JPanel mitte = new JPanel(new GridLayout(1, 2, 10, 0));

        oben.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        oben.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        rundenergebnisLabel = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        gesamtpunkteLabel = new JLabel("30", SwingConstants.CENTER);

        oben.add(rundenergebnisLabel);
        oben.add(gesamtpunkteLabel);

        oben.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        oben.add(new JLabel("Computer:", SwingConstants.CENTER));

        spielerZahlFeld = new JTextField();
        computerZahlFeld = new JTextField();
        computerZahlFeld.setEditable(false);

        spielerZahlFeld.setFont(new Font("Arial", Font.BOLD, 50));
        computerZahlFeld.setFont(new Font("Arial", Font.BOLD, 50));

        rundenergebnisLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gesamtpunkteLabel.setFont(new Font("Arial", Font.BOLD, 30));

        nochMalBtn = new JButton("Noch einmal!");

        mitte.add(spielerZahlFeld);
        mitte.add(computerZahlFeld);

        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);
        add(nochMalBtn, BorderLayout.SOUTH);

        spielerZahlFeld.addActionListener(controller::action);
        nochMalBtn.addActionListener(controller::action);
    }

    public JTextField getSpielerZahlFeld() {
        return spielerZahlFeld;
    }

    public JTextField getComputerZahlFeld() {
        return computerZahlFeld;
    }

    public JLabel getRundenergebnisLabel() {
        return rundenergebnisLabel;
    }

    public JLabel getGesamtpunkteLabel() {
        return gesamtpunkteLabel;
    }

    public JButton getNochMalBtn() {
        return nochMalBtn;
    }
}