package Scenes;

import DataModels.GameLevel;
import ViewModels.*;
import ViewModels.PieceViews.*;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Timer;
import DataModels.GameLevel;

import ViewModels.*;

import ViewModels.PieceViews.*;

import javafx.application.Platform;

import javafx.beans.property.IntegerProperty;

import javafx.beans.property.SimpleIntegerProperty;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import sample.*;

import javafx.event.EventHandler;

import javafx.scene.input.MouseButton;

import javafx.scene.input.MouseEvent;

import javafx.scene.Scene;


import java.io.IOException;
import java.util.Timer;

import java.util.TimerTask;

public class ArcadeGameScene extends QuadScene {

    private static double mousePrevX, mousePrevY;
    private double gl = Glob.gl;

    private double gameBoardOffsetX = Glob.windowWidth() / 2 - gl * 8;
    private  double gameBoardOffsetY = 30;

    private boolean[][] gameBoardLayout = new boolean[16][16];
    private int[][] gridPositions;
    int moveCounter = 0;
    int sec = 0;
    Timer myTimer = new Timer();
    TimerTask secTask = new TimerTask() {
        @Override
        public void run() {
            sec++;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    property.set(sec);
                    start();
                }

            });


        }

    };
    IntegerProperty property = new SimpleIntegerProperty();
    public void start(){
        myTimer.scheduleAtFixedRate(secTask,1000,1000);
    };

    Label CounterLabel = new Label("0");
    Label CounterTextLabel = new Label("Move Counter");
    Label TimerLabel = new Label("Start");
    Label SecondsLabel = new Label("Seconds");
    Label ElapsedLabel = new Label("Elapsed Time");

    public ArcadeGameScene(GameLevel level) {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        TimerLabel.textProperty().bind(property.asString());
        TimerLabel.setScaleX(4);
        TimerLabel.setScaleY(4);
        TimerLabel.setLayoutX(200);
        TimerLabel.setLayoutY(100);
        SecondsLabel.setScaleX(2);
        SecondsLabel.setScaleY(2);
        SecondsLabel.setLayoutX(300);
        SecondsLabel.setLayoutY(100);
        ElapsedLabel.setScaleX(2.5);
        ElapsedLabel.setScaleY(2.5);
        ElapsedLabel.setLayoutX(200);
        ElapsedLabel.setLayoutY(50);
        CounterLabel.setScaleX(2.5);
        CounterLabel.setScaleY(2.5);
        CounterLabel.setLayoutX(1225);
        CounterLabel.setLayoutY(115);
        CounterTextLabel.setScaleX(2.75);
        CounterTextLabel.setScaleY(2.75);
        CounterTextLabel.setLayoutX(1200);
        CounterTextLabel.setLayoutY(75);
        start();


        Pane gameSceneLayout = new Pane();
        setRoot(gameSceneLayout);
        gameSceneLayout.getChildren().add(CounterLabel);
        gameSceneLayout.getChildren().add(CounterTextLabel);
        gameSceneLayout.getChildren().add(TimerLabel);
        gameSceneLayout.getChildren().add(SecondsLabel);
        gameSceneLayout.getChildren().add(ElapsedLabel);
        GridView[] gridViews = new GridView[4];

        gridViews[0] = new GridView(xCoordinateToWindow(level.gridInfos[0].coordX), yCoordinateToWindow(level.gridInfos[0].coordY), level.gridInfos[0].type);
        gridViews[0].coordX = level.gridInfos[0].coordX;
        gridViews[0].coordY = level.gridInfos[0].coordY;
        for (int i = 0; i < level.gridInfos[0].rotationEnum; i++)
            gridViews[0].rotateWOAnimating();
        gameSceneLayout.getChildren().add(gridViews[0]);

        gridViews[1] = new GridView(xCoordinateToWindow(level.gridInfos[1].coordX), yCoordinateToWindow(level.gridInfos[1].coordY), level.gridInfos[1].type);
        gridViews[1].coordX = level.gridInfos[1].coordX;
        gridViews[1].coordY = level.gridInfos[1].coordY;
        for (int i = 0; i < level.gridInfos[1].rotationEnum; i++)
            gridViews[1].rotateWOAnimating();
        gameSceneLayout.getChildren().add(gridViews[1]);

        gridViews[2] = new GridView(xCoordinateToWindow(level.gridInfos[2].coordX), yCoordinateToWindow(level.gridInfos[2].coordY), level.gridInfos[2].type);
        gridViews[2].coordX = level.gridInfos[2].coordX;
        gridViews[2].coordY = level.gridInfos[2].coordY;
        for (int i = 0; i < level.gridInfos[2].rotationEnum; i++)
            gridViews[2].rotateWOAnimating();
        gameSceneLayout.getChildren().add(gridViews[2]);

        gridViews[3] = new GridView(xCoordinateToWindow(level.gridInfos[3].coordX), yCoordinateToWindow(level.gridInfos[3].coordY), level.gridInfos[3].type);
        gridViews[3].coordX = level.gridInfos[3].coordX;
        gridViews[3].coordY = level.gridInfos[3].coordY;
        for (int i = 0; i < level.gridInfos[3].rotationEnum; i++)
            gridViews[3].rotateWOAnimating();
        gameSceneLayout.getChildren().add(gridViews[3]);

        // Update grid view positions
        gridPositions = new int[][] {
            {level.gridInfos[0].coordX, level.gridInfos[0].coordY},
            {level.gridInfos[1].coordX, level.gridInfos[1].coordY},
            {level.gridInfos[2].coordX, level.gridInfos[2].coordY},
            {level.gridInfos[3].coordX, level.gridInfos[3].coordY}
        };

        // Update gameSceneLayout for grids
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++)
                    if (gridViews[i].g.layout[j][k])
                        gameBoardLayout[j + gridViews[i].coordX - 1][k + gridViews[i].coordY - 1] = true;

        // Add pre-placed pieces
        for (int i = 0; i < level.pieceInfos.length; i++){
            if (!level.pieceInfos[i].placed)
                continue;

            PieceView pv;

            if (level.pieceInfos[i].type == 1){
                pv = new LPieceView();
            }
            else if (level.pieceInfos[i].type == 2){
                pv = new YPieceView();
            }
            else if (level.pieceInfos[i].type == 3){
                pv = new PPieceView();
            }
            else if (level.pieceInfos[i].type == 4){
                pv = new UPieceView();
            }
            else if (level.pieceInfos[i].type == 5){
                pv = new ZPieceView();
            }
            else if (level.pieceInfos[i].type == 6){
                pv = new FPieceView();
            }
            else if (level.pieceInfos[i].type == 7){
                pv = new TPieceView();
            }
            else if (level.pieceInfos[i].type == 8){
                pv = new WPieceView();
            }
            else if (level.pieceInfos[i].type == 9){
                pv = new SPieceView();
            }
            else if (level.pieceInfos[i].type == 10){
                pv = new VPieceView();
            }
            else if (level.pieceInfos[i].type == 11){
                pv = new NPieceView();
            }
            else{
                pv = new RPieceView();
            }

            // Update pw members
            pv.coordX = level.pieceInfos[i].coordX;
            pv.coordY = level.pieceInfos[i].coordY;
            pv.placed = true;

            // Set position of the piece
            pv.setLayoutX(xCoordinateToWindow(pv.coordX));
            pv.setLayoutY(yCoordinateToWindow(pv.coordY));

            // Set rotation of the piece
            for (int j = 0; j < level.pieceInfos[i].rotationEnum; j++)
                pv.rotateWOAnimating();

            // Update gameBoardLayout
            for (int j = 0; j < pv.p.structure.length; j++)
                for (int k = 0; k < pv.p.structure[0].length; k++)
                    if (pv.p.structure[j][k])
                        gameBoardLayout[j + pv.coordX - 1][k + pv.coordY - 1] = false;

            // Set color of the piece
            pv.adjustColor();

            // Add piece to the screen
            gameSceneLayout.getChildren().add(pv);
        }

        // Add non-pre-placed pieces
        double placeOnScreenOffset = 0;
        for (int i = 0; i < level.pieceInfos.length; i++) {
            if (level.pieceInfos[i].placed)
                continue;

            PieceView pv;

            if (level.pieceInfos[i].type == 1){
                pv = new LPieceView();
            }
            else if (level.pieceInfos[i].type == 2){
                pv = new YPieceView();
            }
            else if (level.pieceInfos[i].type == 3){
                pv = new PPieceView();
            }
            else if (level.pieceInfos[i].type == 4){
                pv = new UPieceView();
            }
            else if (level.pieceInfos[i].type == 5){
                pv = new ZPieceView();
            }
            else if (level.pieceInfos[i].type == 6){
                pv = new FPieceView();
            }
            else if (level.pieceInfos[i].type == 7){
                pv = new TPieceView();
            }
            else if (level.pieceInfos[i].type == 8){
                pv = new WPieceView();
            }
            else if (level.pieceInfos[i].type == 9){
                pv = new SPieceView();
            }
            else if (level.pieceInfos[i].type == 10){
                pv = new VPieceView();
            }
            else if (level.pieceInfos[i].type == 11){
                pv = new NPieceView();
            }
            else{
                pv = new RPieceView();
            }

            // Set position of the piece
            pv.setLayoutX(placeOnScreenOffset < 6 ? 120 + (int)(placeOnScreenOffset / 3) * 230 : 810 + (int)(placeOnScreenOffset / 3) * 230);
            pv.setLayoutY(200 + (placeOnScreenOffset % 3) * 180);

            // Set stroke
            pv.setStroke(Color.BLACK);

            // Add event handlers
            pv.setOnMousePressed(OnMousePressedOnPieceEventHandler);
            pv.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
            pv.setOnMouseReleased(OnMouseReleasedPieceEventHandler);

            // Add piece to the screen
            gameSceneLayout.getChildren().add(pv);
            placeOnScreenOffset++;
        }

        Button backButton = new Button("Back");
        gameSceneLayout.getChildren().add(backButton);
        backButton.setOnAction(e -> {
            System.out.println("back button is now loaded!");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXMLDeneme/RushPage.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load(), 1600, 900);
            } catch (IOException ev) {
                ev.printStackTrace();
            }

            Main.mainStage.setTitle("My Little Quadrillion - v0.01");
            Main.mainStage.setScene(scene);
            Main.mainStage.show();
            Stage stg2 = (Stage) backButton.getScene().getWindow();
            stg2.close();
        });
    }

    private EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to shape object
                    PieceView pv = ((PieceView) (t.getSource()));

                    // Bring piece to front
                    pv.toFront();

                    // REMOVE
                    if (pv.placed){
                        // Update gameBoardLayout
                        for (int i = 0; i < pv.p.structure.length; i++)
                            for (int j = 0; j < pv.p.structure[0].length; j++)
                                if (pv.p.structure[i][j])
                                    gameBoardLayout[i + pv.coordX - 1][j + pv.coordY - 1] = true;

                        // Update pv members
                        pv.placed = false;
                        pv.adjustColor();

                        monitorGameBoardLayout();
                    }

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY && !pv.getRotating()) {
                        pv.rotate();
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    private EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to PieceView object
                    PieceView pw = ((PieceView) (t.getSource()));

                    // Move the piece
                    pw.setLayoutX(Math.min(Math.max(gl / 2, pw.getLayoutX() + t.getSceneX() - mousePrevX), Glob.windowWidth()));
                    pw.setLayoutY(Math.min(Math.max(gl / 2, pw.getLayoutY() + t.getSceneY() - mousePrevY),Glob.windowHeight()));

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    private EventHandler<MouseEvent> OnMouseReleasedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If right button is released, return
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to PieceView object
                    PieceView pv = ((PieceView) (t.getSource()));

                    // Calculate grid position enumerator which can be 1 through 13
                    int piecePositionX = windowToXCoordinate(pv.getLayoutX());
                    int piecePositionY = windowToYCoordinate(pv.getLayoutY());

                    // Check if the piece can be placed
                    for (int i = 0; i < pv.p.structure.length; i++) {
                        for (int j = 0; j < pv.p.structure[0].length; j++) {
                            // If the corresponding square is not a part of piece, continue
                            if (!pv.p.structure[i][j])
                                continue;
                            // If the corresponding square of the piece is outside the area, return
                            if (i + piecePositionX - 1 < 0 || i + piecePositionX - 1 > 15 || j + piecePositionY - 1 < 0 || j + piecePositionY - 1 > 15)
                                return;
                            // If the corresponding square of the piece cannot be placed, return
                            if (!gameBoardLayout[i + piecePositionX - 1][j + piecePositionY - 1])
                                return;
                        }
                    }

                    // PLACE //
                    IntegerProperty CounterProperty = new SimpleIntegerProperty(0);
                    moveCounter++;
                    CounterProperty.set(moveCounter);
                    CounterLabel.textProperty().bind(CounterProperty.asString());
                    // Snap the grid to game board guidelines
                    pv.setLayoutX(NearestGL(pv.getLayoutX() - gameBoardOffsetX) + gameBoardOffsetX);
                    pv.setLayoutY(NearestGL(pv.getLayoutY() - gameBoardOffsetY) + gameBoardOffsetY);

                    // Update gameBoardLayout
                    for (int i = 0; i < pv.p.structure.length; i++)
                        for (int j = 0; j < pv.p.structure[0].length; j++)
                            if (pv.p.structure[i][j])
                                gameBoardLayout[i + piecePositionX - 1][j + piecePositionY - 1] = false;

                    // Update pv members
                    pv.coordX = piecePositionX;
                    pv.coordY = piecePositionY;
                    pv.placed = true;

                    // Change color
                    pv.adjustColor();

                    monitorGameBoardLayout();

                    // GAME ENDED CHECK //

                    boolean ended = true;
                    for (int i = 0; i < 4; i++){
                        for (int j = -1; j <= 2; j++){
                            for (int k = -1; k <= 2; k++){
                                if (gameBoardLayout[gridPositions[i][0] + k][gridPositions[i][1] + j]){
                                    ended = false;
                                }
                            }
                        }
                    }
                    if (ended) {
                        System.out.println("Game over");
                        secTask.cancel();
                        myTimer.cancel();
                        Stage popupwindow = new Stage();

                        popupwindow.initModality(Modality.APPLICATION_MODAL);
                        popupwindow.setTitle("Game Over");
                        popupwindow.setHeight(400);
                        popupwindow.setWidth(600);


                        Label label1 = new Label("You solved the puzzle in " + sec + " seconds \n with " + moveCounter + " moves");
                        label1.setScaleX(2);
                        label1.setScaleY(2);


                        Button button1 = new Button("OK");


                        button1.setOnAction(e -> {
                            popupwindow.close();
                            Main.mainStage.setScene(new ArcadeScene());
                        });


                        VBox layout = new VBox(10);


                        layout.getChildren().addAll(label1, button1);

                        layout.setAlignment(Pos.CENTER);

                        Scene scene1 = new Scene(layout, 300, 250);

                        popupwindow.setScene(scene1);

                        popupwindow.showAndWait();
                    }
                }

                ;
            };



    // Helper func that gives the nearest multiple of 'gl' to a given double
    private long NearestGL(double x) {
        return Math.round(x / gl) * (long) gl;
    }

    private void monitorGameBoardLayout() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print((gameBoardLayout[j][i] ? "O" : "-") + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    // This method takes a window position and converts it to board coordinates.
    // Coordinate 1, 1 means corresponds to the left-top-most 4 by 4 grid.
    // There are 13x13 different coordinates on the board.
    private int windowToXCoordinate(double pos){
        return (int) ((NearestGL(pos - gameBoardOffsetX)) / gl) - 1;
    }
    private int windowToYCoordinate(double pos){
        return (int) ((NearestGL(pos - gameBoardOffsetY)) / gl) - 1;
    }

    // This method reverses windowToXCoordinate method
    private double xCoordinateToWindow(int pos){
        return (pos + 1) * gl + gameBoardOffsetX;
    }
    private double yCoordinateToWindow(int pos){
        return (pos + 1) * gl + gameBoardOffsetY;
    }

}