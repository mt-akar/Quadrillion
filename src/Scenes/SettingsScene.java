package Scenes;

import ViewModels.ToggleSwitch;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import sample.Glob;

public class SettingsScene extends QuadScene {

    ImageView speakerView;
    Image speaker;
    Image speakerOff;
    boolean volumeOn;

    public SettingsScene(MediaView view) {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        //MediaView view = new MediaView();
        VBox settingsLayout = new VBox(8);
        setRoot(settingsLayout);

        MediaPlayer mp = view.getMediaPlayer();

        Slider volumeSlider = new Slider();
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(mp.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(volumeSlider.getValue() / 100);
                toggleSpeaker(volumeSlider.getValue());
            }
        });

        volumeOn = true;

        speaker = new Image("file:src/Images/speaker.png", 50, 50, true, true);
        speakerOff = new Image("file:src/Images/speakerOff.png", 50, 50, true, true);

        speakerView = new ImageView(speaker);

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

        HBox volumeGroup = new HBox(8);
        volumeGroup.getChildren().addAll(speakerView, volumeSlider);


        settingsLayout.getChildren().addAll(themeGroup, nightModeGroup, colorBlindModeGroup, volumeGroup);

    }

    private void getChoice(ChoiceBox<String> themes){
        String theme = themes.getValue();
        System.out.println(theme);
    }

    private void toggleSpeaker(double value){
        if (value == 0 && volumeOn){
            speakerView.setImage(speakerOff);
            volumeOn = false;
        }
        else if(value != 0 && !volumeOn){
            speakerView.setImage(speaker);
            volumeOn = true;
        }
    }
}
