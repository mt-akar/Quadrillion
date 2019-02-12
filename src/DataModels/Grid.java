package DataModels;

public class Grid {

    public boolean[][] layout;

    public Grid(){
        layout = new boolean[4][4];
    }

    public Grid(int type){
        if(type == 1){
            layout = new boolean[][] {{true, true, true, true},
                    {false, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true}};
        }
        else if(type == 2){
            layout = new boolean[][] {{false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true},
                    {false, true, true, true}};
        }
        else if(type == 3){
            layout = new boolean[][] {{false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, false},
                    {true, true, true, true}};
        }
        else if(type == 4){
            layout = new boolean[][] {{true, true, true, true},
                    {false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        }
    }

    public void rotate(){
        boolean[][] newLayout = new boolean[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                newLayout[3-j][i] = layout[i][j];
            }
        }
        layout = newLayout;
    }
}
