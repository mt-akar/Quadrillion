package Scenes;

import ViewModels.QuadButton;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;
import sample.Main;

public class RushModeSelectionScene extends QuadScene {
	
	public QuadButton[] buttons;

    public RushModeSelectionScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        Button threePuzzleMode = new Button("3 Puzzle Challenge");
        mainLayout.getChildren().add(threePuzzleMode);
        threePuzzleMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeThreePuzzleScene());
        });

        Button threeMinuteMode = new Button("3 Minute Challenge");
        mainLayout.getChildren().add(threeMinuteMode);
        threeMinuteMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeThreeMinuteScene());
        });

        Button restrictedMode = new Button("30 Move Challenge");
        mainLayout.getChildren().add(restrictedMode);
        restrictedMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeRestrictedScene());
        });
    }
}
