package ViewModels.PieceViews;

import DataModels.PieceDataModels.ZPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import sample.Glob;

public class ZPieceView extends PieceView {

    boolean colorBlind;

    public ZPieceView( boolean isColorBlind){
        // Create the piece
        p = new ZPiece();

        colorBlind = isColorBlind;

        // Draw the shape
        this.getPoints().addAll(gl*-2, gl*-2,
                gl*0, gl*-2,
                gl*0, gl*0,
                gl*1, gl*0,
                gl*1, gl*1,
                gl*-1, gl*1,
                gl*-1, gl*-1,
                gl*-2, gl*-1);

        // Paint the piece
        if(colorBlind){
            this.setFill(Glob.ZPieceCBColor);
            this.setStroke(Glob.ZPieceCBColor);

        }else {
            // Paint the piece
            this.setFill(Glob.ZPieceDisplacedColor);
            this.setStroke(Glob.ZPiecePlacedColor);
        }
    }

    public void rotate(){
        RotateTransition rot = new RotateTransition();
        rot.setDuration(Duration.seconds(animationTime));
        rot.setByAngle(90);
        rot.setAxis(new Point3D(0, 0, 1));
        rot.setNode(this);
        p.rotate();
        rot.play();
        rotating = true;
        rot.setOnFinished(e -> {
            if (p.getRotationEnum() == 2 || p.getRotationEnum() == 0) {
                ScaleTransition sca = new ScaleTransition();
                sca.setDuration(Duration.seconds(animationTime / 2));
                sca.setToX(p.getRotationEnum() == 2 ? -1 : 1);
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

    public void rotateWOAnimating(){
        // Rotate the visual
        this.getTransforms().add(new Rotate(p.getRotationEnum() <= 1 ? 90 : -90));

        // Compensate for incorrect rotation axis
        if(p.getRotationEnum() <= 1) {
            this.getTransforms().add(new Translate(0, gl));
        }

        if (p.getRotationEnum() == 1) {
            this.getTransforms().add(new Scale(-1, 1));
        }

        if(p.getRotationEnum() >= 1){
            this.getTransforms().add(new Translate(gl, 0));
        }

        // Rotate the structure
        p.rotate();
    }

    public void adjustColor(){
        if (colorBlind){
            this.setFill(Glob.ZPieceCBColor);
        }
        else {
            if (placed)
                this.setFill(Glob.ZPiecePlacedColor);
            else
                this.setFill(Glob.ZPieceDisplacedColor);
        }
    }
}
