import java.util.concurrent.TimeUnit;

public class GameManager {
    private static GameManager instance = new GameManager();
    private TurnManager turnManager;
    

    private GameManager() {
        turnManager = new TurnManager();
    }

    public static GameManager getInstance() {
        return instance;
    }

    public boolean canPlayerAttack() {
        return (turnManager.isPlayersTurn() && ObjectHandler.getInstance().getClickedEnemy() != null);
    }

    public void managePlayerAttacks(int n) {
        if (canPlayerAttack())
        		ObjectHandler.getInstance().getPlayer().attack(ObjectHandler.getInstance().getClickedEnemy(), n);

            turnManager.playTurn();
    }

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
