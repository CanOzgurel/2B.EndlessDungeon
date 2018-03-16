
/**
 * @(#)GameManager.java
 *
 * GameManager class
 *
 * @author Alperen Kaya
 * @version 1.00 2018/3/15
 */

import java.util.ArrayList;

public class GameManager {

    private boolean playing;
    private int waveNo;
    private int mapNo;
    public int turnNo = 0;
    private int TurnOwner;
    private ArrayList <GameObject> remainingEnemies;
    private Player player;
    private WaveManager waveManager;
    private InputManager inputManager;

    public void enemyTurn(Enemy e){
        //set TurnOwner variable 0 for make it enemyies turn
        this.TurnOwner = remainingEnemies.indexOf(e)+1;
    }



    public void playerTurn(){
        //set TurnOwner variable 0 for make it enemyies turn
        this.TurnOwner = 0;
    }

    /*
    public void drawScene(){

        //this must be implemented

    }
    */

    private void updateObjects(){

        while(playing) {
            for (int i = 0; i < remainingEnemies.size(); i++) {
                if (remainingEnemies.get(i).health > 0) {
                    remainingEnemies.get(i).updateObject();
                }
            }
            player.updateObject();
            turnNo++;
        }
    }

    public void startGame(){
        //when the game is started
        this.playing = true;
    }


    public void pause() {
        //when the game is paused
        this.playing = false;

    }
    public void exit(){
        // quit game
        System.exit(0);
    }

}