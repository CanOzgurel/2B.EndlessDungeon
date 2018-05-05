import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.add(new GamePanel(), BorderLayout.CENTER);
        this.add(new ActionBar(), BorderLayout.SOUTH);
    }
}