package Scenes;

        import DataModels.GameLevel;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.Pane;
        import javafx.scene.layout.VBox;
        import sample.Glob;
        import sample.Main;

public class EntryScene extends Scene {

    public EntryScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        Button tutorialButton = new Button("Tutorial");
        Button playButton = new Button("Play");
        Button levelEditorButton = new Button("Level Editor");
        Button optionsButton = new Button("Options");
        Button trialButton = new Button("Trial");

        mainLayout.getChildren().addAll(tutorialButton, playButton, levelEditorButton, optionsButton, trialButton);

        playButton.setOnAction(e -> {
            Main.mainStage.setScene(new ArcadeGameScene(new GameLevel()));
        });

        levelEditorButton.setOnAction(e -> {
            Main.mainStage.setScene(new SandboxScene());
        });
    }
}
