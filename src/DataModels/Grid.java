package DataModels;

public class Grid {

    boolean[][] layout;

    public Grid(){
        layout = new boolean[4][4];
    }

    public Grid(int type){
        if(type == 1){
            layout = new boolean[][] {{true, false, false, true},
                    {true, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        }
        else if(type == 2){
            layout = new boolean[][] {{false, true, true, false},
                    {true, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        }
        else if(type == 3){
            layout = new boolean[][] {{false, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true},
                    {true, true, false, true}};
        }
        else if(type == 4){
            layout = new boolean[][] {{true, false, true, true},
                    {true, true, true, true},
                    {true, true, true, true},
                    {true, true, true, true}};
        }
    }
}
