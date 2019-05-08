package Scenes;

import DataModels.GameLevel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class LevelEditorScene extends QuadScene {
	
	public GameLevel[] levels;

    public LevelEditorScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }
}
