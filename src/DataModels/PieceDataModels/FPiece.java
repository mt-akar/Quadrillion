package DataModels.PieceDataModels;

public class FPiece extends Piece {

    public FPiece(){
        setStructure();
    }

    public void rotate(){
        if (rotationEnum != 7)
            rotationEnum++;
        else
            rotationEnum = 0;

        setStructure();
    }

    public int getType(){
        return 6;
    }

    public void setStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, true, false, false},
                    {true, true, true, false},
                    {true, false, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, true, false, false},
                    {true, true, false, false},
                    {false, true, true, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, false, true, false},
                    {true, true, true, false},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{true, true, false, false},
                    {false, true, true, false},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 4){
            structure = new boolean[][] {{true, false, false, false},
                    {true, true, true, false},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 5){
            structure = new boolean[][] {{false, true, false, false},
                    {false, true, true, false},
                    {true, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 6){
            structure = new boolean[][] {{false, true, false, false},
                    {true, true, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 7){
            structure = new boolean[][] {{false, true, true, false},
                    {true, true, false, false},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
    }
}
