package Scenes;

import DataModels.GameLevel;
import ViewModels.QuadButton;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import sample.Glob;
import sample.Main;

public class MenuScene extends QuadScene {

	public QuadButton[] buttons;

	private boolean colorBlind;

	public MenuScene(MediaView mediaView, boolean isColorBlind) {
		super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
		VBox mainLayout = new VBox();
		setRoot(mainLayout);

		colorBlind = isColorBlind;

		Button playButton = new Button("Play");
		Button settingsButton = new Button("Settings");

		mainLayout.getChildren().addAll(playButton, mediaView);

		playButton.setOnAction(e -> {
			Main.mainStage.setScene(new PlayScene(mediaView, colorBlind));
		});

		settingsButton.setOnAction(e -> {
			Main.mainStage.setScene(new SettingsScene(mediaView));
		});
	}
}
