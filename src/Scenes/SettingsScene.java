package Scenes;

import ViewModels.ToggleSwitch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.Glob;

public class SettingsScene extends QuadScene {

    public SettingsScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox settingsLayout = new VBox(8);
        setRoot(settingsLayout);

        Button themeConfirmButton = new Button("Set theme");
        ChoiceBox<String> themes = new ChoiceBox<>();

        themes.getItems().add("Classic Theme");
        themes.getItems().add("Summer Theme");
        themes.getItems().add("Bilkent Theme");

        themes.setValue("Classic Theme");

        themeConfirmButton.setOnAction(event -> getChoice(themes));

        ToggleSwitch nightModeSwitch = new ToggleSwitch();
        ToggleSwitch colorBlindModeSwitch = new ToggleSwitch();

        Text nightModeText = new Text("Night Mode: ");
        Text colorBlindModeText = new Text("ColorBlind Mode: ");

        HBox nightModeGroup = new HBox(8);
        nightModeGroup.getChildren().addAll(nightModeText, nightModeSwitch);
        HBox colorBlindModeGroup = new HBox(8);
        colorBlindModeGroup.getChildren().addAll(colorBlindModeText, colorBlindModeSwitch);
        HBox themeGroup = new HBox(8);
        themeGroup.getChildren().addAll(themes, themeConfirmButton);

        settingsLayout.getChildren().addAll(themeGroup, nightModeGroup, colorBlindModeGroup);

    }

    private void getChoice(ChoiceBox<String> themes){
        String theme = themes.getValue();
        System.out.println(theme);
    }
}
