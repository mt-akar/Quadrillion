package DataModels;

public class VPiece extends Piece {

    public VPiece(){
        SetStructure();
    }

    public void SetStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, true, false, false},
                    {false, true, false, false},
                    {false, true, true, true},
                    {false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, false, false, false},
                    {false, true, true, true},
                    {false, true, false, false},
                    {false, true, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, false, false, false},
                    {true, true, true, false},
                    {false, false, true, false},
                    {false, false, true, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{false, false, true, false},
                    {false, false, true, false},
                    {true, true, true, false},
                    {false, false, false, false}};
        }
    }
}
