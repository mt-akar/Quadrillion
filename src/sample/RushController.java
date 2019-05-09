package sample;

import Scenes.RushModeRestrictedScene;
import Scenes.RushModeThreeMinuteScene;
import Scenes.RushModeThreePuzzleScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RushController implements Initializable {

    Button backButton;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        Scene scene = new Scene(loader.load(), 1600, 900);
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }
    public void ThreeMinutesButton(ActionEvent event){
        Main.mainStage.setScene(new RushModeThreeMinuteScene());
    }
    public void ThreePuzzlesButton(ActionEvent event){
        Main.mainStage.setScene(new RushModeThreePuzzleScene());
    }
    public void RestrictedModeButton(ActionEvent event){
        Main.mainStage.setScene(new RushModeRestrictedScene());
    }
}