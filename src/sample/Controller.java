package sample;

import DataModels.GameLevel;
import Scenes.ArcadeGameScene;
import Scenes.SandboxScene;
import Scenes.SettingsScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

// THIS CONTROLLER MANAGES THE SAMPLEX FXML & PLAYMENU FXML & PLAYMENU FXML.

public class Controller implements Initializable {


    Button playButton, settingsButton, exitButton, backButton;
    Stage window;
    Media media = new Media(new File("src/Playlist/tetris.mp3").toURI().toString());
    MediaPlayer player = new MediaPlayer(media);
    MediaView view = new MediaView(player);

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    public void sendPlayMenuButton(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        System.out.println("play menu button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
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
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }

    public void sendLevelEditor(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/LevelEditorPage.fxml"));
        System.out.println("play menu button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();

    }







    public void sendRushPage(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/RushPage.fxml"));
        System.out.println("play menu button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
    }
    public void tutorialButton(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/TutorialPage.fxml"));
        System.out.println("play menu button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
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
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }

    public void playButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/ArcadePage.fxml"));
        System.out.println("play menu button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }
    public void sandboxButton(ActionEvent event){
        System.out.println("sandbox is now loaded!");
        Main.mainStage.setScene(new SandboxScene());
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }
    public void settingsButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/SettingsPage.fxml"));
        System.out.println("settings is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
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
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }
    public void exitButton(ActionEvent event){
        Platform.exit();
        //System.exit(0);
    }
    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/FirstPageLoginRegister.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
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
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void back2Button(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
        Scene scene = new Scene(loader.load(), 1600, 900);
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }
    public void back3Button(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
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
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

}




