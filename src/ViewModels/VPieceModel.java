package ViewModels;

import DataModels.VPiece;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;

public class VPieceModel extends PieceModel {

    VPiece p;
    boolean rotating;

    public VPieceModel(){
        super();

        // Create the piece model
        p = new VPiece();

        // Draw the shape
        this.getPoints().addAll(new Double[]{
                gl*-1, gl*-2,
                gl*0, gl*-2,
                gl*0, gl*0,
                gl*2, gl*0,
                gl*2, gl*1,
                gl*-1, gl*1});
        this.getTransforms().add(new Translate(gl/2, -gl/2));
        this.setTranslateX(-gl/2);
        this.setTranslateY(gl/2);

        // Fill the piece
        this.setFill(Color.rgb(102, 160, 255));
        this.setStroke(Color.BLACK);

        //Initialize members
        rotating = false;
    }

    public void displace(){
        //66a0ff
        //this.setFill(Color.rgb(202, 127, 233));
        //placed = false;
    }

    public void place(){
        //307fff
        //this.setFill(Color.rgb(148,0,211));
        //placed = true;
    }

    @Override
    public void Rotate() {
        if (p.getRotationEnum() != 3)
            p.setRotationEnum(p.getRotationEnum() + 1);
        else
            p.setRotationEnum(0);

        p.SetStructure();
    }

}
