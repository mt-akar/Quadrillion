package Scenes;

import DataModels.GameLevel;
import ViewModels.QuadButton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sample.Glob;
import sample.Main;

public class CustomLevelsScene extends QuadScene {

    public QuadButton[] buttons;

    public CustomLevelsScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        System.out.println("here");

        // Change after this
        Button newButton = new Button("New");

        mainLayout.getChildren().addAll(newButton);

        newButton.setOnAction(e -> {
            Main.mainStage.setScene(new LevelEditorScene());
        });

        // TODO: Fetch custom levels from database and display

        //Fetch

        // Display
        for (int i = 1; i < 0; i++) {
            Button levelButton = new Button("Play " + "Level Name");
            mainLayout.getChildren().add(levelButton);
            levelButton.setOnAction(e -> {
                Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(), false));
            });
        }
    }
}
