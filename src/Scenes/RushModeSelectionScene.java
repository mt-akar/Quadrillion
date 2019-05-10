package Scenes;

import ViewModels.QuadButton;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;
import sample.Main;
import sample.SettingsController;

public class RushModeSelectionScene extends QuadScene {
	
	public QuadButton[] buttons;

	private boolean colorBlind;

    public RushModeSelectionScene(boolean isColorBlind) {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        if (SettingsController.nightMode) {
            getStylesheets().add("CSS_StyleSheets/Dark.css");
            System.out.println("Dark");
        } else {
            if (SettingsController.themeSelection.equals("Bilkent Theme")) {
                getStylesheets().add("CSS_StyleSheets/FlatBee.css");
            } else {
                getStylesheets().add("CSS_StyleSheets/Style.css");
            }
        }
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
        colorBlind = isColorBlind;

        Button threePuzzleMode = new Button("3 Puzzle Challenge");
        mainLayout.getChildren().add(threePuzzleMode);
        threePuzzleMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeThreePuzzleScene(colorBlind));
        });

        Button threeMinuteMode = new Button("3 Minute Challenge");
        mainLayout.getChildren().add(threeMinuteMode);
        threeMinuteMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeThreeMinuteScene(colorBlind));
        });

        Button restrictedMode = new Button("30 Move Challenge");
        mainLayout.getChildren().add(restrictedMode);
        restrictedMode.setOnAction(e -> {
            Main.mainStage.setScene(new RushModeRestrictedScene(colorBlind));
        });
    }
}
