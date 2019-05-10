package ViewModels.PieceViews;

import DataModels.PieceDataModels.RPiece;
import sample.Glob;

public class RPieceView extends PieceView {

    boolean colorBlind;

    public RPieceView(boolean isColorBlind){
        // Create the piece
        p = new RPiece();

        colorBlind = isColorBlind;

        // Draw the shape
        this.getPoints().addAll(gl*-1, gl*-1,
                gl*0, gl*-1,
                gl*0, gl*0,
                gl*1, gl*0,
                gl*1, gl*1,
                gl*-1, gl*1);

        // Paint the piece
        if(colorBlind){
            this.setFill(Glob.RPieceCBColor);
            this.setStroke(Glob.RPieceCBColor);

        }else {
            // Paint the piece
            this.setFill(Glob.RPieceDisplacedColor);
            this.setStroke(Glob.RPiecePlacedColor);
        }
    }

    public void adjustColor(){
        if (colorBlind){
            this.setFill(Glob.RPieceCBColor);
        }
        else {
            if (placed)
                this.setFill(Glob.RPiecePlacedColor);
            else
                this.setFill(Glob.RPieceDisplacedColor);
        }
    }
}
