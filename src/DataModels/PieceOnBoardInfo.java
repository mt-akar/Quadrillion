package DataModels;

public class PieceOnBoardInfo {
    public int type;
    public boolean placed;
    public int coordX;
    public int coordY;
    public int rotationEnum;

    public PieceOnBoardInfo(int type, boolean placed, int coordX, int coordY, int rotationEnum){
        this.type = type;
        this.placed = placed;
        this.coordX = coordX;
        this.coordY = coordY;
        this.rotationEnum = rotationEnum;
    }
}