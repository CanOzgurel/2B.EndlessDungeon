import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class SoundManager extends JPanel implements ActionListener{

    JSlider slider;
    ImageIcon muteIcon = new ImageIcon("src/res/mute.jpg");
    ImageIcon unmuteIcon = new ImageIcon("src/res/unmute.jpg");

    File file;

    JButton mute;
    Clip clip;

    JComboBox soundList;

    private boolean muted = false;

    private static final float DIV = (float) 2.85;
    private static final float SHIFT = (float) 29;
    private static final float MIN = (float)-80;


    private float volume = 0;

    String[] sounds = { "sound 1", "sound 2", "sound 3", "sound 4"};

    // Constructor
    public SoundManager() {

        this.setSize(500, 350);
        this.setVisible(true);
        this.setName("Sound Manager");
        this.setLayout(new FlowLayout());

        soundInit("src/res/sound3.wav");

        soundList = new JComboBox(sounds);
        soundList.setSelectedIndex(3);
        soundList.addActionListener(this);
        soundList.setActionCommand("selection");


        GridBagConstraints c = new GridBagConstraints();

        mute = new JButton();
        mute.setIcon(muteIcon);
        mute.setActionCommand("mute");
        mute.addActionListener(this);
        mute.setToolTipText("Mute");
        mute.setSize(50, 50);


        slider =  new JSlider(JSlider.HORIZONTAL, 0, 100, 70);

        slider.setPreferredSize(new Dimension(150, 30));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                float value = (slider.getValue()/DIV) - SHIFT;

                FloatControl control =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                control.setValue(value);


            }
        });


        add(soundList);
        add(slider);
        add(mute);


    }

    public void soundInit(String path)
    {
        if(clip != null)
        {
            if(clip.isOpen())
                clip.close();
        }
        try {
            // Open an audio input stream.
            file = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            // Get a sound clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent e) {
        if ("mute".equals(e.getActionCommand())) {
            if (muted)
            {

                mute(volume);
                muted = false;
                mute.setIcon(muteIcon);
            }

            else
            {
                FloatControl control =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                volume = control.getValue();

                mute(MIN);
                muted = true;
                mute.setIcon(unmuteIcon);
            }

        }
        else if ("selection".equals(e.getActionCommand()))
        {

            JComboBox cb = (JComboBox)e.getSource();
            int selected = cb.getSelectedIndex();
            if(selected == 0)
            {
                soundInit("sound1.wav");
            }
            else if (selected == 1)
            {
                soundInit("sound2.wav");
            }
            else if (selected == 2)
            {
                soundInit("sound3.wav");
            }
            else
            {
                soundInit("sound4.wav");
            }


        }
    }

    public void stop(){
        clip.stop();
    }

    public void play(){
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void mute(float value)
    {

        FloatControl control =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        control.setValue(value);
    }
}


