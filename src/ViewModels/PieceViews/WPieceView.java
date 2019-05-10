package ViewModels.PieceViews;

import DataModels.PieceDataModels.WPiece;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import sample.Glob;

public class WPieceView extends PieceView {

    boolean colorBlind;

    public WPieceView(boolean isColorBlind){
        // Create the piece
        p = new WPiece();
        colorBlind = isColorBlind;

//change
        // Draw the shape
        this.getPoints().addAll(gl*-2, gl*-2,
                gl*-1, gl*-2,
                gl*-1, gl*-1,
                gl*0, gl*-1,
                gl*0, gl*0,
                gl*1, gl*0,
                gl*1, gl*1,
                gl*-1, gl*1,
                gl*-1, gl*0,
                gl*-2, gl*0);

        if(colorBlind){
            this.setFill(Glob.WPieceCBColor);
            this.setFill(Glob.WPieceCBColor);

        }else {
            // Paint the piece
            this.setFill(Glob.WPieceDisplacedColor);
            this.setStroke(Glob.WPiecePlacedColor);
        }

    }

    public void rotateWOAnimating(){
        // Rotate the visual
        this.getTransforms().add(new Rotate(90));

        // Compensate for incorrect rotation axis
        this.getTransforms().add(new Translate(0, gl));

        // Rotate the structure
        p.rotate();
    }

    public void adjustColor(){
        if (colorBlind){
            this.setFill(Glob.WPieceCBColor);
        }
        else {
            if (placed)
                this.setFill(Glob.WPiecePlacedColor);
            else
                this.setFill(Glob.WPieceDisplacedColor);
        }

    }
}
