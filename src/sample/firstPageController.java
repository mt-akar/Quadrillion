package sample;
import DataModels.GameLevel;
import Scenes.ArcadeGameScene;
import Scenes.SettingsScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javafx.fxml.Initializable;

//THIS CONTROLLER MANAGES FirstPageLoginRegister.fxml & LOGINPAGE.fxml & REGISTERPAGE.fxml

public class firstPageController implements Initializable {

    Button backButton;
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("View is now loaded!");
    }

    public void loginButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/LoginPage.fxml"));
        System.out.println("login button is now loaded!");
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }
    public void registerButton(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/RegisterPage.fxml"));
        System.out.println("register button is now loaded!");
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

    public void creditsButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/creditsPage.fxml"));
        System.out.println("settings is now loaded!");
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
    public void sendMenuButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
        System.out.println("settings is now loaded!");
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
    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/FirstPageLoginRegister.fxml"));
        Scene scene = new Scene(loader.load(), 1600, 900);
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }



}
