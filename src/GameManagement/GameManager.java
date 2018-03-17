package GameManagement;

import GameObjects.Enemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameManager extends Application {
    private Enemy enemy;
    private Parent root;
    private Stage stage;

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/UI/game.fxml"));
        this.stage = stage;

        stage.setTitle("Play Game");
        stage.setScene(new Scene(root, 600, 400));

        enemy = new Enemy(100, 100, 50, 50, null, root);
        enemy.render();

        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // TODO: update
            }
        };

        timer.start();
    }

    @Override
    public void stop() {

    }
}