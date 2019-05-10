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

    boolean isColorBlind;

    public void initialize(URL location, ResourceBundle resources) {
        if (SettingsController.colorBlindMode){
            isColorBlind = true;
        }
        else{
            isColorBlind = false;
        }
        System.out.println("View is now loaded!");
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
            if (SettingsController.nightMode) {
                scene.getStylesheets().add("CSS_StyleSheets/Dark.css");
                System.out.println("Dark");
            } else {
                if (SettingsController.themeSelection.equals("Bilkent Theme")) {
                    scene.getStylesheets().add("CSS_StyleSheets/FlatBee.css");
                } else {
                    scene.getStylesheets().add("CSS_StyleSheets/Style.css");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void sendArcadeButton() {
        for (int i = 1; i <= 40; i++) {
            final int level = i;
            Scene scene1 = new ArcadeGameScene(new GameLevel(level), true, isColorBlind);
            scene1.getStylesheets().add("CSS_StyleSheets/Style.css");
            Main.mainStage.setScene(scene1);
        }
    }

    public void easy1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(1), true, isColorBlind));
    }

    public void easy2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(2), true, isColorBlind));
    }

    public void easy3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(3), true, isColorBlind));
    }

    public void easy4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(4), true, isColorBlind));
    }

    public void easy5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(5), true, isColorBlind));
    }

    public void med1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(6), true, isColorBlind));
    }

    public void med2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(7), true, isColorBlind));
    }

    public void med3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(8), true, isColorBlind));
    }

    public void med4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(9), true, isColorBlind));
    }

    public void med5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(10), true, isColorBlind));
    }

    public void hard1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(11), true, isColorBlind));
    }

    public void hard2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(12), true, isColorBlind));
    }

    public void hard3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(13), true, isColorBlind));
    }

    public void hard4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(14), true, isColorBlind));
    }

    public void hard5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(15), true, isColorBlind));
    }

    public void h1() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(16), true, isColorBlind));
    }

    public void h2() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(17), true, isColorBlind));
    }

    public void h3() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(18), true, isColorBlind));
    }

    public void h4() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(19), true, isColorBlind));
    }

    public void h5() {
        Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(20), true, isColorBlind));
    }


}