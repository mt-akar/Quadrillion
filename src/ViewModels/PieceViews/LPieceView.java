package ViewModels.PieceViews;

import DataModels.PieceModels.LPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import sample.Glob;

public class LPieceView extends PieceView {

    public LPieceView(){
        // Create the piece
        p = new LPiece();

        // Draw the shape
        this.getPoints().addAll(gl*-1, gl*-2,
                gl*0, gl*-2,
                gl*0, gl*1,
                gl*1, gl*1,
                gl*1, gl*2,
                gl*-1, gl*2);

        // Paint the piece
        this.setFill(Glob.LPieceDisplacedColor);
        this.setStroke(Color.BLACK);
    }

    public void rotate(){
        RotateTransition rot = new RotateTransition();
        rot.setDuration(Duration.seconds(animationTime));
        rot.setByAngle(90);
        rot.setAxis(new Point3D(0, 0, 1));
        rot.setNode(this);
        p.incrementRotationEnum();
        rot.play();
        rotating = true;
        rot.setOnFinished(e -> {
            if (p.getRotationEnum() == 4 || p.getRotationEnum() == 0) {
                ScaleTransition sca = new ScaleTransition();
                sca.setDuration(Duration.seconds(animationTime / 2));
                sca.setToX(p.getRotationEnum() == 4 ? -1 : 1);
                sca.setNode(this);
                sca.play();
                sca.setOnFinished(e2 ->
                        rotating = false
                );
            }
            else
                rotating = false;
        });
    }

    public void place(){
        this.setFill(Glob.LPiecePlacedColor);
    }

    public void displace(){
        this.setFill(Glob.LPieceDisplacedColor);
    }
}