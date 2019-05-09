package DataModels.PieceDataModels;

public class RPiece extends Piece {

    public RPiece(){
        setStructure();
    }

    public void rotate(){
        if (rotationEnum != 3)
            rotationEnum++;
        else
            rotationEnum = 0;

        setStructure();
    }

    public int getType(){
        return 12;
    }

    public void setStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, false, false, false},
                    {false, true, true, false},
                    {false, false, true, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, false, false, false},
                    {false, true, true, false},
                    {false, true, false, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, false, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{false, false, false, false},
                    {false, false, true, false},
                    {false, true, true, false},
                    {false, false, false, false}};
        }
    }
}
