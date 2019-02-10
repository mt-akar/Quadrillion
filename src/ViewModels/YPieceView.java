package ViewModels;

import DataModels.YPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class YPieceView extends PieceView {

    public YPieceView(){
        // Create the piece
        p = new YPiece();

        // Draw the shape
        this.getPoints().addAll(gl*0, gl*-1,
                gl*1, gl*-1,
                gl*1, gl*0,
                gl*2, gl*0,
                gl*2, gl*1,
                gl*-2, gl*1,
                gl*-2, gl*0,
                gl*0, gl*0);

        // Fill the piece
        this.setFill(Color.rgb(255, 115, 222));
        this.setStroke(Color.BLACK);

        //Initialize members
        rotating = false;
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

    public void displace(){
        //ff73de
        //this.setFill(Color.rgb(202, 127, 233));
        //placed = false;
    }

    public void place(){
        //ff96e7
        //this.setFill(Color.rgb(148,0,211));
        //placed = true;
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