package sample;

import DataModels.GameLevel;
import Scenes.EntryScene;
import Scenes.GameScene;
import Scenes.LevelEditorScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main extends Application {

    // We will need this
    public static Stage mainStage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage){
        mainStage = primaryStage;

        //LevelEditorScene gameScene = new LevelEditorScene();
        EntryScene EntryScene = new EntryScene();
        primaryStage.setScene(EntryScene);

        primaryStage.setTitle("My Little Quadrillion - v0.01");
        primaryStage.getIcons().add(new Image("file:src/Images/logo.png"));
        primaryStage.setResizable(false);


        primaryStage.show();
    }
}
