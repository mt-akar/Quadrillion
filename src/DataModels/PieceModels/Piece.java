package DataModels.PieceModels;

public abstract class Piece {

    int rotationEnum;

    public boolean[][] structure;

    public abstract void setStructure();

    public abstract void incrementRotationEnum();

    public int getRotationEnum(){
        return rotationEnum;
    }
}