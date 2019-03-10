package Scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class LoginScene extends Scene {

    public LoginScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }
}
