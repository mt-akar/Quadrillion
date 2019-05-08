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

	public PlayScene(MediaView view) {
		super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
		VBox mainLayout = new VBox();
		setRoot(mainLayout);

		// Change after this
		Button tutorialButton = new Button("Tutorial");
		Button playButton = new Button("Play");
		Button levelEditorButton = new Button("Level Editor");
		Button optionsButton = new Button("Settings");
		Button trialButton = new Button("Trial");

		mainLayout.getChildren().addAll(tutorialButton, playButton, levelEditorButton, optionsButton, trialButton, view);
/*
		playButton.setOnAction(e -> {
			Main.mainStage.setScene(new ArcadeGameScene(new GameLevel()));
		});

		levelEditorButton.setOnAction(e -> {
			Main.mainStage.setScene(new SandboxScene());
		});

		optionsButton.setOnAction(e -> {
			Main.mainStage.setScene(new SettingsScene(view));
		});*/
	}
}
