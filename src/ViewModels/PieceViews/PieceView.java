package ViewModels.PieceViews;

import DataModels.PieceModels.Piece;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import sample.Glob;

public abstract class PieceView extends Polygon{

    double gl = Glob.gl;
    double animationTime = .15;
    public int coordX;
    public int coordY;
    public Piece p;
    boolean rotating;
    public boolean placed;

    public void rotate(){
        RotateTransition rot = new RotateTransition();
        rot.setDuration(Duration.seconds(animationTime));
        rot.setByAngle(90);
        rot.setNode(this);
        p.incrementRotationEnum();
        rot.play();
        rotating = true;
        rot.setOnFinished(e ->
            rotating = false
        );
    }

    public boolean getRotating(){
        return rotating;
    }

    public abstract void place();

    public abstract void displace();
}