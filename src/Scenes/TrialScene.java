package Scenes;

import ViewModels.VPieceModel;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import sample.*;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class TrialScene extends Scene {

    static double mousePrevX, mousePrevY;
    double gl = Glob.gl();

    public TrialScene() {
        super(new Pane(), 900, 600);
        Pane trialLayout = new Pane();
        setRoot(trialLayout);

        Line l1 = new Line(0, 300, 900, 300);
        Line l2 = new Line(450, 0, 450, 600);
        trialLayout.getChildren().addAll(l1, l2);

        Polygon polygon1 = new Polygon();
        polygon1.setLayoutX(100);
        polygon1.setLayoutY(100);
        polygon1.getPoints().addAll(new Double[]{
                0.0, 0.0,
                50.0, 0.0,
                300.0, 100.0,
                0.0, 100.0});
        polygon1.getTransforms().add(new Translate(150, 50));
        polygon1.setTranslateX(-150);
        polygon1.setTranslateY(-50);
        polygon1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        polygon1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        //trialLayout.getChildren().add(polygon1);

        VPieceModel v1 = new VPieceModel();
        v1.setLayoutX(gl);
        v1.setLayoutY(2*gl);
        v1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        v1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        trialLayout.getChildren().add(v1);

    }

    public EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    System.out.println("pressed");

                    // Define a pointer to shape object
                    Shape s = ((Shape)(t.getSource()));

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY) {
                        //p.Rotate();
                        RotateTransition rot = new RotateTransition();
                        rot.setDuration(Duration.seconds(.5));
                        rot.setByAngle(90);
                        rot.setNode(s);
                        rot.play();
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();

                    // Bring piece to front
                    s.toFront();
                }
            };

    public EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    System.out.println("dragged");

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to shape object
                    Shape s = ((Shape)(t.getSource()));


                    // Move the piece
                    //if (s.getLayoutX() + t.getSceneX() - mousePrevX >= 0)
                        s.setLayoutX(s.getLayoutX() + t.getSceneX() - mousePrevX);
                    //s.setLayoutY(Math.max(s.getLayoutY() + t.getSceneY() - mousePrevY, 0));
                    s.setLayoutY(s.getLayoutY() + t.getSceneY() - mousePrevY);

                    System.out.println("x: " + s.getLayoutX());
                    System.out.println("y: " + s.getLayoutY());

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };
}
