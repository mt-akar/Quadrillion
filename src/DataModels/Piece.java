package DataModels;

public abstract class Piece {

    int rotationEnum;
    public boolean[][] structure;

    public Piece(){
        super();

        rotationEnum = 0;
    }

    public int getRotationEnum(){
        return rotationEnum;
    }

    public void setRotationEnum(int rot){
        rotationEnum = rot;
    }

    public abstract void SetStructure();
}
