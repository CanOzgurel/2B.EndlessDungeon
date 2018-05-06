package management;

import objects.ObjectHandler;

/**
 * class GameManager
 * Manages the attacks of the player and the enemies
 * Singleton class
 * Façade class of the management package
 */
public class GameManager {
    private static GameManager instance = new GameManager();
    private TurnManager turnManager;


    private GameManager() {
        turnManager = new TurnManager();
    }

    // Returns the singleton instance of the GameManager
    public static GameManager getInstance() {
        return instance;
    }

    // Checks if the player can attack or not depending on the turn number and the chosen enemy
    public boolean canPlayerAttack() {
        return (turnManager.isPlayersTurn() && ObjectHandler.getInstance().getClickedEnemy() != null);
    }

    // Manages the attacks of the player and controls the stage progression
    public void managePlayerAttacks(int n) {
        if (canPlayerAttack())
            ObjectHandler.getInstance().getPlayer().attack(ObjectHandler.getInstance().getClickedEnemy(), n);

        if(!ObjectHandler.getInstance().turnUpdate())
            turnManager.playTurn();
        else
            turnManager.resetTurnNo();

    }

    // Manages the attacks of the enemies and uses delays to increase the authenticity of the game
    public void manageEnemyAttacks() {
        if (!turnManager.isPlayersTurn()) {
            ObjectHandler.getInstance().getEnemyLeft().attack(ObjectHandler.getInstance().getPlayer());

            System.out.println("Left Enemy Attacked");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ObjectHandler.getInstance().getEnemyRight().attack(ObjectHandler.getInstance().getPlayer());

            System.out.println("Right Enemy Attacked");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ObjectHandler.getInstance().getEnemyBoss().attack(ObjectHandler.getInstance().getPlayer());

            System.out.println("Boss Enemy Attacked");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            turnManager.playTurn();
        }
    }
}