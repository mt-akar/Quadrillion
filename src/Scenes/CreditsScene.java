package Scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class CreditsScene extends Scene {

    public CreditsScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }
}
