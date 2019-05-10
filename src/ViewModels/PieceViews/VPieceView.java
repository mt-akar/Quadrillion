package ViewModels.PieceViews;

import DataModels.PieceDataModels.VPiece;
import javafx.scene.transform.Translate;
import sample.Glob;

public class VPieceView extends PieceView {

    boolean colorBlind;

    public VPieceView(boolean isColorBlind){
        // Create the piece
        p = new VPiece();

        colorBlind = isColorBlind;

        // Draw the shape
        this.getPoints().addAll(gl*-1, gl*-2,
                gl*0, gl*-2,
                gl*0, gl*0,
                gl*2, gl*0,
                gl*2, gl*1,
                gl*-1, gl*1);

        // Fix the axis for rotation. Refer to ref/axis_fix.png

        // Next line visually translates the polygon while leaving the rotation axis unchanged. Step 1
        this.getTransforms().add(new Translate(gl/2, -gl/2));

        // Next two lines also visually translate the polygon and changes the rotation axis at the same time. Step 2
        this.setTranslateX(-gl/2);
        this.setTranslateY(gl/2);

        // Paint the piece
        if(colorBlind){
            this.setFill(Glob.VPieceCBColor);
            this.setStroke(Glob.VPieceCBColor);

        }else {
            // Paint the piece
            this.setFill(Glob.VPieceDisplacedColor);
            this.setStroke(Glob.VPiecePlacedColor);
        }
    }

    public void adjustColor(){
        if (colorBlind){
            this.setFill(Glob.VPieceCBColor);
        }
        else {
            if (placed)
                this.setFill(Glob.VPiecePlacedColor);
            else
                this.setFill(Glob.VPieceDisplacedColor);
        }
    }
}