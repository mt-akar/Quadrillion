package DataModels.PieceModels;

public class YPiece extends Piece {

    public YPiece(){
        setStructure();
    }

    public void incrementRotationEnum(){
        if (rotationEnum != 7)
            rotationEnum++;
        else
            rotationEnum = 0;

        setStructure();
    }

    public void setStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, false, true, false},
                    {false, false, true, false},
                    {false, true, true, false},
                    {false, false, true, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, false, false, false},
                    {true, true, true, true},
                    {false, false, true, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, true, false, false},
                    {false, true, true, false},
                    {false, true, false, false},
                    {false, true, false, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{false, false, false, false},
                    {false, true, false, false},
                    {true, true, true, true},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 4){
            structure = new boolean[][] {{false, false, true, false},
                    {false, true, true, false},
                    {false, false, true, false},
                    {false, false, true, false}};
        }
        else if(rotationEnum == 5){
            structure = new boolean[][] {{false, false, false, false},
                    {true, true, true, true},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 6){
            structure = new boolean[][] {{false, true, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
                    {false, true, false, false}};
        }
        else if(rotationEnum == 7){
            structure = new boolean[][] {{false, false, false, false},
                    {false, false, true, false},
                    {true, true, true, true},
                    {false, false, false, false}};
        }
    }
}
