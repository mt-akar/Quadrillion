package Scenes;

import DataModels.GameLevel;
import ViewModels.QuadButton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import sample.Glob;
import sample.Main;

public class PlayScene extends QuadScene {

	public QuadButton[] buttons;

	public PlayScene(MediaView mediaView) {
		super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
		VBox mainLayout = new VBox();
		setRoot(mainLayout);

		// Change after this
		Button tutorialButton = new Button("Tutorial");
		Button playButton = new Button("Play");
		Button rushModeButton = new Button("Rush Mode");
		Button levelEditorButton = new Button("Level Editor");
		Button sandboxButtonButton = new Button("Sandbox");

		mainLayout.getChildren().addAll(tutorialButton, playButton, rushModeButton, levelEditorButton, sandboxButtonButton, mediaView);

		playButton.setOnAction(e -> {
			Main.mainStage.setScene(new ArcadeScene());
		});

		rushModeButton.setOnAction(e -> {
			Main.mainStage.setScene(new RushModeSelectionScene());
		});

		levelEditorButton.setOnAction(e -> {
			Main.mainStage.setScene(new CustomLevelsScene());
		});

		sandboxButtonButton.setOnAction(e -> {
			Main.mainStage.setScene(new SandboxScene());
		});
	}
}
