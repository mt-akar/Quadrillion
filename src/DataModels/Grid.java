package DataModels;

public class Grid {

    public int type;
    public int rotationEnum = 0;
    public boolean[][] layout;

    public Grid() {
        layout = new boolean[][]{{true, true, true, true},
                {false, true, true, true},
                {false, true, true, true},
                {true, true, true, true}};
    }

    public Grid(int type) {
        this.type = type;
        setLayout(type);
    }

    public void setLayout(int type) {
        if (type == 1) {
            layout = new boolean[][]{{true, true, true, true},
                    {false, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true}};
        } else if (type == 2) {
            layout = new boolean[][]{{false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true},
                    {false, true, true, true}};
        } else if (type == 3) {
            layout = new boolean[][]{{false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, false},
                    {true, true, true, true}};
        } else if (type == 4) {
            layout = new boolean[][]{{true, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        } else if (type == 5) {
            layout = new boolean[][]{{false, true, true, true},
                    {true, true, true, true},
                    {true, false, true, true},
                    {true, true, true, true}};
        } else if (type == 6) {
            layout = new boolean[][]{{true, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true},
                    {false, true, true, true}};
        } else if (type == 7) {
            layout = new boolean[][]{{false, true, true, true},
                    {true, true, false, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        } else if (type == 8) {
            layout = new boolean[][]{{true, true, true, true},
                    {true, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true}};
        }
    }

    public boolean rotate() {

        if (rotationEnum != 3) {
            rotationEnum++;

            boolean[][] newLayout = new boolean[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    newLayout[3 - j][i] = layout[i][j];
                }
            }
            layout = newLayout;

            return false;

        } else {
            rotationEnum = 0;

            if (type < 5) {
                type += 4;
                setLayout(type);
            } else {
                type -= 4;
                setLayout(type);
            }

            return true;
        }

    }
}
