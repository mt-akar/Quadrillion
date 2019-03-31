package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class SettingsScene extends QuadScene {

    public SettingsScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        Button themeConfirmButton = new Button("Set theme");
        ChoiceBox<String> themes = new ChoiceBox<>();

        themes.getItems().add("Classic Theme");
        themes.getItems().add("Summer Theme");
        themes.getItems().add("Bilkent Theme");

        themes.setValue("Classic Theme");

        themeConfirmButton.setOnAction(event -> getChoice(themes));

        mainLayout.getChildren().addAll(themes, themeConfirmButton);


    }

    private void getChoice(ChoiceBox<String> themes){
        String theme = themes.getValue();
        System.out.println(theme);
    }
}
