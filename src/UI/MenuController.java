package UI;

import GameManagement.GameManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnCredits;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnExit;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == btnPlay) {
            stage = (Stage) btnPlay.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("game.fxml"));

            GameManager gameManager = new GameManager();
            gameManager.start(stage);
        }
        else if (event.getSource() == btnSettings) {
            stage = (Stage) btnSettings.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        }
        else if (event.getSource() == btnCredits) {
            stage = (Stage) btnCredits.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        }
        else if (event.getSource() == btnBack) {
            stage = (Stage) btnBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
        }
        else {
            System.exit(0);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
