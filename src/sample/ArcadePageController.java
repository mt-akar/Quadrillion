package sample;

import DataModels.GameLevel;
import Scenes.ArcadeGameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArcadePageController implements Initializable {

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

    public void sendArcadeButton() {
        for (int i = 1; i <= 40; i++) {
            final int level = i;
            Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(level)));
        }
    }

    public void easy1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(1)));
    }

    public void easy2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(2)));
    }

    public void easy3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(3)));
    }

    public void easy4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(4)));
    }

    public void easy5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(5)));
    }

    public void med1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(6)));
    }

    public void med2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(7)));
    }

    public void med3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(8)));
    }

    public void med4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(9)));
    }

    public void med5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(10)));
    }

    public void hard1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(11)));
    }

    public void hard2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(12)));
    }

    public void hard3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(13)));
    }

    public void hard4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(14)));
    }

    public void hard5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(15)));
    }

    public void h1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(16)));
    }

    public void h2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(17)));
    }

    public void h3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(18)));
    }

    public void h4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(19)));
    }

    public void h5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(20)));
    }


}