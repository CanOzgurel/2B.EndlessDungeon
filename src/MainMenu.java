import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class MainMenu extends JFrame implements ActionListener{


    public static final int HEIGHT = 700;
    public static final int WIDTH = 700;

    private JPanel settings;
    private JPanel howToPage;
    private JPanel creditsPage;
    private JPanel mainBundle;
    private JPanel mainPanel;

    JButton newGame;
    JButton settingsButton;
    JButton howToPlay;
    JButton credits;
    JButton exit;
    JButton back;

    Dimension settingsD = new Dimension(500, 140);
    Dimension mainMenuD =  new Dimension(300, 350);
    Dimension howToPlayD = new Dimension(500, 380);
    Dimension gameD = new Dimension(800, 500);


    MainMenu()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Menu");
        this.setSize(mainMenuD);
        this.setLayout(new BorderLayout());

        settings= new SoundManager();
        howToPage = new Howto();
        creditsPage = new Credits();
        mainPanel = new MainPanel();

        newGame= new JButton("New Game");
        newGame.addActionListener(this);
        newGame.setActionCommand("newGame");

        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(this);
        settingsButton.setActionCommand("settings");

        howToPlay = new JButton("How to Play");
        howToPlay.addActionListener(this);
        howToPlay.setActionCommand("howToPlay");

        credits = new JButton("Credits");
        credits.addActionListener(this);
        credits.setActionCommand("credits");

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("exit");

        back = new JButton("Back");
        back.addActionListener(this);
        back.setActionCommand("back");

        mainBundle = new JPanel(new GridLayout(0,1));
        mainBundle.setSize(200, 200);
        mainBundle.add(newGame);
        mainBundle.add(settingsButton);
        mainBundle.add(howToPlay);
        mainBundle.add(credits);
        mainBundle.add(exit);
        add(mainBundle, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if ("newGame".equals(e.getActionCommand())) {

            remove(mainBundle);
            add(mainPanel, BorderLayout.CENTER);
            add(back, BorderLayout.SOUTH);
            setSize(gameD);
            setTitle("Game");

        }
        else if ("settings".equals(e.getActionCommand()))
        {

            remove(mainBundle);
            add(settings, BorderLayout.CENTER);
            add(back, BorderLayout.SOUTH);
            setSize(settingsD);
            setTitle("Settings");


        }
        else if ("howToPlay".equals(e.getActionCommand()))
        {

            remove(mainBundle);
            add(howToPage, BorderLayout.CENTER);
            add(back, BorderLayout.SOUTH);
            setSize(howToPlayD);
            setTitle("How To Play");

        }
        else if ("credits".equals(e.getActionCommand()))
        {


            remove(mainBundle);
            add(creditsPage, BorderLayout.CENTER);
            add(back, BorderLayout.SOUTH);
            setSize(howToPlayD);
            setTitle("Credits");


        }
        else if ("exit".equals(e.getActionCommand()))
        {

            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
        else if("back".equals(e.getActionCommand()))
        {

            remove(mainPanel);
            remove(settings);
            remove(howToPage);
            remove(creditsPage);
            remove(back);
            setSize(mainMenuD);
            add(mainBundle, BorderLayout.CENTER);
            setTitle("Main Menu");
        }

    }

    public static void main(String[] args)
    {

        MainMenu mm = new MainMenu();
    }
}
