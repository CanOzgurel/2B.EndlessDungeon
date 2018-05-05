import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Credits extends JPanel{

    JTextArea textArea;


    String path = "src/res/credits.txt";
    FileReader fr;
    BufferedReader reader;

    public Credits()
    {
        setName("Credits");
        textArea = new JTextArea();
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