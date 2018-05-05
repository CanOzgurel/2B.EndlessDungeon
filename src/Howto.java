import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Howto extends JPanel{

    JTextArea textArea;


    String path = "src/res/howToPlay.txt";
    FileReader fr;
    BufferedReader reader;



    public Howto()
    {
        setName("How to Play");
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        try
        {
            fr = new FileReader(path);
            reader = new BufferedReader(fr);
            textArea.read(reader, textArea);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        add(textArea);

    }


}
