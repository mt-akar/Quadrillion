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

	private boolean colorBlind;

	public PlayScene(MediaView mediaView, boolean isColorBlind) {
		super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
		VBox mainLayout = new VBox();
		setRoot(mainLayout);
		colorBlind = isColorBlind;

		// Change after this
		Button tutorialButton = new Button("Tutorial");
		Button playButton = new Button("Play");
		Button rushModeButton = new Button("Rush Mode");
		Button levelEditorButton = new Button("Level Editor");
		Button sandboxButtonButton = new Button("Sandbox");

		mainLayout.getChildren().addAll(tutorialButton, playButton, rushModeButton, levelEditorButton, sandboxButtonButton, mediaView);

		playButton.setOnAction(e -> {
			Main.mainStage.setScene(new ArcadeScene(colorBlind));
		});

		rushModeButton.setOnAction(e -> {
			Main.mainStage.setScene(new RushModeSelectionScene(colorBlind));
		});

		levelEditorButton.setOnAction(e -> {
			Main.mainStage.setScene(new CustomLevelsScene(colorBlind));
		});

		sandboxButtonButton.setOnAction(e -> {
			Main.mainStage.setScene(new SandboxScene(colorBlind));
		});
	}
}
