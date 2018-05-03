public class TurnManager {
    private int turnNo;

    public TurnManager() {
        turnNo = 0;
    }

    public void playTurn() {
        turnNo++;
    }

    public boolean isPlayersTurn() {
        return (turnNo % 2) == 0;
    }

    public void resetTurnNo() {
        turnNo = 0;
    }
}
