package sample;

import Scenes.TrialScene;
import javafx.application.Application;
import javafx.stage.Stage;
import Scenes.EntryScene;

public class Main extends Application {

    public static Stage mainStage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        primaryStage.setTitle("Super Quadrillion");

        TrialScene trialScene = new TrialScene();
        primaryStage.setScene(trialScene);
        primaryStage.show();
    }
}
