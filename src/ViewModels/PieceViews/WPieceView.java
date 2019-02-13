package ViewModels.PieceViews;

import DataModels.PieceModels.WPiece;
import javafx.scene.paint.Color;
import sample.Glob;

public class WPieceView extends PieceView {

    public WPieceView(){
        // Create the piece
        p = new WPiece();

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

        // Paint the piece
        this.setFill(Glob.WPieceDisplacedColor);
        this.setStroke(Color.BLACK);
    }

    public void place(){
        this.setFill(Glob.WPiecePlacedColor);
    }

    public void displace(){
        this.setFill(Glob.WPieceDisplacedColor);
    }
}
