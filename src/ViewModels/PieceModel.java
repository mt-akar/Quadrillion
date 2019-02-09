package ViewModels;

import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import sample.Glob;
//import Scenes.GameScene;

public abstract class PieceModel extends Polygon{

    double gl = Glob.gl();

    public boolean placed = false;

    public PieceModel(){
        super();

        this.setStroke(Color.BLACK);
    }

    protected abstract void Rotate();
}