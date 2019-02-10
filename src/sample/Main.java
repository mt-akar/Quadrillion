package sample;

import Scenes.TrialScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main extends Application {

    public static Stage mainStage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage){
        mainStage = primaryStage;

        TrialScene trialScene = new TrialScene();
        primaryStage.setScene(trialScene);

        primaryStage.setTitle("Super Quadrillion - v0.01");
        primaryStage.getIcons().add(new Image("file:src/Images/logo.png"));
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}
