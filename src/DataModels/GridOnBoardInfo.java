package DataModels;

public class GridOnBoardInfo {
    public int type;
    public int coordX;
    public int coordY;
    public int rotationEnum;

    public GridOnBoardInfo(int type, int coordX, int coordY, int rotationEnum){
        this.type = type;
        this.coordX = coordX;
        this.coordY = coordY;
        this.rotationEnum = rotationEnum;
    }
}