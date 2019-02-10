package Scenes;

import ViewModels.GridView;
import ViewModels.PieceView;
import ViewModels.VPieceView;
import ViewModels.YPieceView;
import javafx.scene.paint.Color;
import sample.*;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.transform.Translate;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;


public class TrialScene extends Scene {

    static double mousePrevX, mousePrevY;
    double gl = Glob.gl();

    double gameBoardOffsetX = Glob.windowWidth() / 2 - gl * 8;
    double gameBoardOffsetY = 30;

    public TrialScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        Pane trialLayout = new Pane();
        setRoot(trialLayout);

        for(int i = 0; i <= 16; i++) {
            Line l1 = new Line(gameBoardOffsetX, gameBoardOffsetY + gl * i, gameBoardOffsetX + gl * 16, gameBoardOffsetY + gl * i);
            Line l2 = new Line(gameBoardOffsetX + gl * i, gameBoardOffsetY, gameBoardOffsetX + gl * i, gameBoardOffsetY + gl * 16);
            l1.setStroke(Color.rgb(200, 200, 200));
            l2.setStroke(Color.rgb(200, 200, 200));
            trialLayout.getChildren().addAll(l1, l2);
        }

        Polygon polygon1 = new Polygon();
        polygon1.setLayoutX(100);
        polygon1.setLayoutY(100);
        polygon1.getPoints().addAll(0.0, 0.0,
                50.0, 0.0,
                300.0, 100.0,
                0.0, 100.0);
        polygon1.getTransforms().add(new Translate(150, 50));
        polygon1.setTranslateX(-150);
        polygon1.setTranslateY(-50);
        polygon1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        polygon1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        //trialLayout.getChildren().add(polygon1);

        VPieceView v1 = new VPieceView();
        v1.setLayoutX(100);
        v1.setLayoutY(400);
        v1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        v1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        trialLayout.getChildren().add(v1);

        YPieceView y1 = new YPieceView();
        y1.setLayoutX(350);
        y1.setLayoutY(400);
        y1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        y1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        trialLayout.getChildren().add(y1);

        GridView g1 = new GridView(gameBoardOffsetX + gl*9/2, gameBoardOffsetY + gl*9/2, 1);
        g1.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g1.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        trialLayout.getChildren().add(g1);

        GridView g2 = new GridView(gameBoardOffsetX + gl*23/2, gameBoardOffsetY + gl*9/2, 2);
        g2.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g2.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        trialLayout.getChildren().add(g2);

        GridView g3 = new GridView(gameBoardOffsetX + gl*9/2, gameBoardOffsetY + gl*23/2, 3);
        g3.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g3.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        trialLayout.getChildren().add(g3);

        GridView g4 = new GridView(gameBoardOffsetX + gl*23/2, gameBoardOffsetY + gl*23/2, 4);
        g4.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g4.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        trialLayout.getChildren().add(g4);
    }

    public EventHandler<MouseEvent> OnMousePressedOnGridEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to shape object
                    GridView s = ((GridView)(t.getSource()));

                    // Bring piece to front
                    s.toFront();

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY && !s.getRotating()) {
                        RotateTransition rot = new RotateTransition();
                        rot.setDuration(Duration.seconds(.5));
                        rot.setByAngle(90);
                        rot.setNode(s);
                        rot.play();
                        s.setRotating(true);
                        rot.setOnFinished(e -> {
                            s.setRotating(false);
                        });
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    public EventHandler<MouseEvent> OnMouseDraggedGridEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to shape object
                    GridView s = ((GridView)(t.getSource()));


                    // Move the piece
                    s.setLayoutX(Math.max(s.getLayoutX() + t.getSceneX() - mousePrevX, 0));
                    s.setLayoutY(Math.max(s.getLayoutY() + t.getSceneY() - mousePrevY, 0));

                    System.out.println("x: " + s.getLayoutX());
                    System.out.println("y: " + s.getLayoutY());

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };



    public EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to shape object
                    PieceView pv = ((PieceView)(t.getSource()));

                    // Bring piece to front
                    pv.toFront();

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

    public EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to shape object
                    Shape s = ((Shape)(t.getSource()));


                    // Move the piece
                    s.setLayoutX(Math.max(s.getLayoutX() + t.getSceneX() - mousePrevX, gl/2));
                    s.setLayoutY(Math.max(s.getLayoutY() + t.getSceneY() - mousePrevY, gl*3/2));

                    System.out.println("x: " + s.getLayoutX());
                    System.out.println("y: " + s.getLayoutY());

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };



}
