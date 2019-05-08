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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class SettingsController implements Initializable{

    Button backButton;

    public void initialize(URL location, ResourceBundle resources) { System.out.println("View is now loaded!"); }
    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add("Style.css");
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
