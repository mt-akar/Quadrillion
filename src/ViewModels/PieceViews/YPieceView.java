package ViewModels.PieceViews;

import DataModels.PieceDataModels.YPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import sample.Glob;

public class YPieceView extends PieceView {

    boolean colorBlind;

    public YPieceView(boolean isColorBlind){
        // Create the piece
        p = new YPiece();

        colorBlind = isColorBlind;

        // Draw the shape
        this.getPoints().addAll(gl*0, gl*-1,
                gl*1, gl*-1,
                gl*1, gl*0,
                gl*2, gl*0,
                gl*2, gl*1,
                gl*-2, gl*1,
                gl*-2, gl*0,
                gl*0, gl*0);

        // Paint the piece
        if(colorBlind){
            this.setFill(Glob.YPieceCBColor);
            this.setStroke(Glob.YPieceCBColor);

        }else {
            // Paint the piece
            this.setFill(Glob.YPieceDisplacedColor);
            this.setStroke(Glob.YPiecePlacedColor);
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

    public void rotateWOAnimating(){
        // Rotate the visual
        this.getTransforms().add(new Rotate(p.getRotationEnum() <= 3 ? 90 : -90));
        if (p.getRotationEnum() == 3) {
            this.getTransforms().add(new Scale(-1, 1));
        }

        // Rotate the structure
        p.rotate();
    }

    public void adjustColor(){
        if (colorBlind){
            this.setFill(Glob.YPieceCBColor);
        }
        else {
            if (placed)
                this.setFill(Glob.YPiecePlacedColor);
            else
                this.setFill(Glob.YPieceDisplacedColor);
        }
    }
}




        /*
        if (p.getRotationEnum() == 4 || p.getRotationEnum() == 0) {
            System.out.println("Y flip");
            ScaleTransition sca = new ScaleTransition();
            sca.setByX(2);
            sca.setDuration(Duration.seconds(.5));
            sca.setNode(this);
            sca.play();
            sca.setOnFinished(e2 ->
                    rotating = false
            );
        }
        else
            rotating = false;
            */