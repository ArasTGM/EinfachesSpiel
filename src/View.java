import javax.swing.*;

public class GewinnView extends JFrame {
    private GewinnLayout gewinnLayout;

    public GewinnView(GewinnController gewinnController) {
        this.setTitle("Zahlen-Gewinnspiel (v1.0)");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.gewinnLayout = new GewinnLayout(gewinnController);
        this.add(gewinnLayout);
        this.setVisible(true);
    }

    public GewinnLayout getGewinnLayout() {
        return gewinnLayout;
    }
}