package sample;
import Scenes.SettingsScene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;


public class SettingsController implements Initializable{

    Button backButton;
    ToggleButton nightModeButton, colorBlindModeButton;
    static boolean nightMode = false;
    static boolean colorBlindMode = false;
    static int nightModeCount;
    @FXML
    ComboBox<String> theme; // Value injected by FXMLLoader
    static String themeSelection = "Classic Theme";

    public void initialize(URL location, ResourceBundle resources) { System.out.println("View is now loaded!"); }
    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
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
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void comboBox(ActionEvent event) throws IOException {
        System.out.println("combobox is now loaded!");
        themeSelection = theme.getSelectionModel().selectedItemProperty().getValue();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/SettingsPage.fxml"));
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
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void nightMode(ActionEvent event) throws IOException {
        System.out.println("Night mode is now loaded!");
        nightModeCount++;
        if (nightModeCount % 2 == 0) {
            nightMode = false;
        } else {
            nightMode = true;
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/SettingsPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
            if (nightMode) {
                //scene.getStylesheets().add("CSS_StyleSheets/ColorB.scss");
                scene.getStylesheets().add("CSS_StyleSheets/Dark.css");
                System.out.println("Dark");
            } else {
                scene.getStylesheets().add("CSS_StyleSheets/Style.css");
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

    /*
    public void colorBlindMode(ActionEvent event) throws IOException {
        System.out.println("Color blind mode is now loaded!");
        themeSelection = theme.getSelectionModel().selectedItemProperty().getValue();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/SettingsPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
            if (SettingsController.themeSelection.equals("Bilkent Theme")) {
                //scene.getStylesheets().add("CSS_StyleSheets/ColorB.scss");
                scene.getStylesheets().add("CSS_StyleSheets/FlatBee.css");
                System.out.println("done");
            } else {
                scene.getStylesheets().add("CSS_StyleSheets/Style.css");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }*/

    public void credits(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/creditsPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
            if (SettingsController.themeSelection.equals("Bilkent Theme")) {
                scene.getStylesheets().add("CSS_StyleSheets/FlatBee.css");
            } else {
                scene.getStylesheets().add("CSS_StyleSheets/Style.css");
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
}
