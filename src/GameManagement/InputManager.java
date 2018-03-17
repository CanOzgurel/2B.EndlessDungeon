/**
 * @(#)WaveManager.java
 *
 * WaveManager class
 *
 * @author Alperen Kaya
 * @version 1.00 2018/3/15
 */
import javafx.event.EventHandler;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class InputManager implements EventHandler<KeyEvent>{


    private ArrayList <String> inputList;
    private ArrayList <Boolean> buttonsPressed;

    public void InputManager(){

        inputList = new ArrayList<>();
        buttonsPressed = new ArrayList<>();

    }
    /*
    public void updateInputs(){



    }*/

}
