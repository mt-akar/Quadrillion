package ViewModels.PieceViews;



import DataModels.PieceDataModels.UPiece;

import javafx.scene.transform.Rotate;

import javafx.scene.transform.Translate;

import sample.Glob;



public class UPieceView extends PieceView {



    public UPieceView(){

        // Create the piece

        p = new UPiece();



//change

        // Draw the shape

        this.getPoints().addAll(gl*-2, gl*-2,

                gl*-1, gl*-2,

                gl*-1, gl*-1,

                gl*0, gl*-1,

                gl*0, gl*-2,

                gl*1, gl*-2,

                gl*1, gl*0,

                gl*-2, gl*0);



        // Fix the axis for rotation. Refer to ref/axis_fix.png



        // Next line visually translates the polygon while leaving the rotation axis unchanged. Step 1

        this.getTransforms().add(new Translate(0, -gl/2));



        // Next two lines also visually translate the polygon and changes the rotation axis at the same time. Step 2

        this.setTranslateY(gl/2);



        // Paint the piece

        this.setFill(Glob.UPieceDisplacedColor);

        this.setStroke(Glob.UPiecePlacedColor);

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

        if (placed)

            this.setFill(Glob.UPiecePlacedColor);

        else

            this.setFill(Glob.UPieceDisplacedColor);

    }

}