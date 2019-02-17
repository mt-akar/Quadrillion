package ViewModels;

import DataModels.Grid;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.Glob;

public class GridView extends Group {

    private static double gl = Glob.gl;

    public int coordX;
    public int coordY;

    public Grid g;

    private boolean rotating;

    public boolean placed;

    // Grid view without dots
    public GridView(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
        Rectangle border = new Rectangle();
        border.setX(-60);
        border.setY(-60);
        border.setHeight(gl * 4);
        border.setWidth(gl * 4);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);
        getChildren().add(border);
        for (int i = - 1; i <= 1; i++) {
            Line l1 = new Line(i*gl, -2*gl, i*gl, 2*gl);
            Line l2 = new Line(-2*gl, i*gl, 2*gl, i*gl);
            getChildren().addAll(l1, l2);
        }

        g = new Grid();
    }

    // Grid view with dots, from the original game
    public GridView(double x, double y, int type) {
        setLayoutX(x);
        setLayoutY(y);
        Rectangle border = new Rectangle();
        border.setX(-gl * 2);
        border.setY(-gl * 2);
        border.setHeight(gl * 4);
        border.setWidth(gl * 4);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);
        getChildren().add(border);
        for (int i = - 1; i <= 1; i++) {
            Line l1 = new Line(i*gl, -2*gl, i*gl, 2*gl);
            Line l2 = new Line(-2*gl, i*gl, 2*gl, i*gl);
            getChildren().addAll(l1, l2);
        }

        if(type == 1) {
            Circle c1 = new Circle(-gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            Circle c2 = new Circle(gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            getChildren().addAll(c1, c2);
        }
        else if(type == 2) {
            Circle c1 = new Circle(-3 * gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            Circle c2 = new Circle(3 * gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            getChildren().addAll(c1, c2);
        }
        else if(type == 3) {
            Circle c1 = new Circle(-3 * gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            Circle c2 = new Circle(gl / 2, 3 * gl / 2, gl / 3, Color.BLACK);
            getChildren().addAll(c1, c2);
        }
        else if(type == 4) {
            Circle c1 = new Circle(-gl / 2, -3 * gl / 2, gl / 3, Color.BLACK);
            getChildren().add(c1);
        }
        else{
            System.out.println("Invalid grid type");
        }

        g = new Grid(type);
    }

    public boolean getRotating(){
        return rotating;
    }

    public void rotate(){
        RotateTransition rot = new RotateTransition();
        rot.setDuration(Duration.seconds(.5));
        rot.setByAngle(90);
        rot.setNode(this);
        rot.play();
        rotating = true;
        rot.setOnFinished(e ->
                rotating = false
        );

        g.rotate();
    }

    // Rotate without animating
    public void rotateWOAnimating(){
        // Rotate the visual
        this.getTransforms().add(new Rotate(90));

        // Rotate the structure
        g.rotate();
    }
}
