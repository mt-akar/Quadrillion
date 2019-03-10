package Scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class TutorialScene extends Scene {

    public TutorialScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }
}
