package ViewModels.PieceViews;

import DataModels.PieceDataModels.NPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import sample.Glob;

public class NPieceView extends PieceView {

    public NPieceView(){
        // Create the piece
        p = new NPiece();

//change
        // Draw the shape
        this.getPoints().addAll(gl*-1, gl*-2,
                gl*1, gl*-2,
                gl*1, gl*-1,
                gl*0, gl*-1,
                gl*0, gl*0,
                gl*-2, gl*0,
                gl*-2, gl*-1,
                gl*-1, gl*-1);

        // Fix the axis for rotation. Refer to ref/axis_fix.png

        // Next line visually translates the polygon while leaving the rotation axis unchanged. Step 1
        this.getTransforms().add(new Translate(0, -gl/2));

        // Next two lines also visually translate the polygon and changes the rotation axis at the same time. Step 2
        this.setTranslateY(gl/2);

        // Paint the piece
        this.setFill(Glob.NPieceDisplacedColor);
        this.setStroke(Glob.NPiecePlacedColor);
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
        this.getTransforms().add(new Rotate(p.getRotationEnum() <= 3 ? 90 : -90));

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

        if(p.getRotationEnum() > 1){
            this.getTransforms().add(new Translate(-gl, 2 * gl));
        }

        // Rotate the structure
        p.rotate();
    }

    public void adjustColor(){
        if (placed)
            this.setFill(Glob.NPiecePlacedColor);
        else
            this.setFill(Glob.NPieceDisplacedColor);
    }
}