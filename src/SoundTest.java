import javax.swing.*;

public class SoundTest extends JFrame{

    public SoundTest()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test");
        this.setSize(500, 350);
        this.setVisible(true);
        JPanel panel = new SoundManager();
        add(panel);
    }


    public static void main(String[] args)
    {
        SoundTest st = new SoundTest();

    }
}
