package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// THIS CONTROLLER MANAGE THE BACK BUTTON OF THE CREDIT PAGE.
public class creditsController implements Initializable {
    Button backButton;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/SettingsPage.fxml"));
        Scene scene = new Scene(loader.load(), 1600, 900);
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