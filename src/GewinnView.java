import javax.swing.*;

public class GewinnView extends JFrame {
    private GewinnLayout gewinnLayout;
    public GewinnView(GewinnController controller) {

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gewinnLayout = new GewinnLayout(controller);
        add(gewinnLayout);
        setVisible(true);
    }

    public GewinnLayout getGewinnLayout() {
        return gewinnLayout;
    }
}