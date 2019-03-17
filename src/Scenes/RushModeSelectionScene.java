package Scenes;

import ViewModels.QuadButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class RushModeSelectionScene extends QuadScene {
	
	public QuadButton[] buttons;

    public RushModeSelectionScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }
}
