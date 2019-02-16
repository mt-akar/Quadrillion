package ViewModels.PieceViews;

import DataModels.PieceModels.RPiece;
import javafx.scene.paint.Color;
import sample.Glob;

public class RPieceView extends PieceView {

    public RPieceView(){
        // Create the piece
        p = new RPiece();

        // Draw the shape
        this.getPoints().addAll(gl*-1, gl*-1,
                gl*0, gl*-1,
                gl*0, gl*0,
                gl*1, gl*0,
                gl*1, gl*1,
                gl*-1, gl*1);

        // Paint the piece
        this.setFill(Glob.RPieceDisplacedColor);
        this.setStroke(Glob.RPiecePlacedColor);
    }

    public void adjustColor(){
        if (placed)
            this.setFill(Glob.RPiecePlacedColor);
        else
            this.setFill(Glob.RPieceDisplacedColor);
    }
}
