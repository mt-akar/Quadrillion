package Scenes;

import DataModels.GameLevel;
import DataModels.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;
import sample.Main;

public class ArcadeScene extends QuadScene {

    public ArcadeScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        Button level1Button = new Button("Level 1");
        Button level2Button = new Button("Level 2");
        Button level3Button = new Button("Level 3");

        mainLayout.getChildren().addAll(level1Button, level2Button, level3Button);

        level1Button.setOnAction(e -> {
            Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(1)));
        });

        level2Button.setOnAction(e -> {
            Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(2)));
        });

        level3Button.setOnAction(e -> {
            Main.mainStage.setScene(new ArcadeGameScene(new GameLevel(3)));
        });
    }
}
