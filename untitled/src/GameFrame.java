import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public static final int HEIGHT = 700;
    public static final int WIDTH = 700;

    public GameFrame() {
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MainPanel());
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
