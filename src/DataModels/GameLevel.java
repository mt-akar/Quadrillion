package DataModels;

public class GameLevel {

    public PieceOnBoardInfo[] pieceInfos;
    public GridOnBoardInfo[] gridInfos;

    public GameLevel(){
        // level 2
        gridInfos = new GridOnBoardInfo[] {
                new GridOnBoardInfo(2,5, 4, 2),
                new GridOnBoardInfo(1,9, 6, 3),
                new GridOnBoardInfo(4,5, 8, 1),
                new GridOnBoardInfo(3,9, 10, 0)
        };

        // level 2 on steroids
        pieceInfos = new PieceOnBoardInfo[] {
                new PieceOnBoardInfo(9, true, 4, 4, 1),
                new PieceOnBoardInfo(4, true, 6, 3, 2),
                new PieceOnBoardInfo(7, true, 7, 5, 3),
                new PieceOnBoardInfo(1, true, 5, 7, 1),
                new PieceOnBoardInfo(8, true, 5, 9, 1),
                new PieceOnBoardInfo(3, true, 6, 9, 5),
                new PieceOnBoardInfo(12, true, 8, 10, 1),
                new PieceOnBoardInfo(10, true, 10, 5, 2),
                new PieceOnBoardInfo(5, true, 10, 7, 0),

                new PieceOnBoardInfo(2, false, 0, 0, 0),
                new PieceOnBoardInfo(6, false, 0, 0, 0),
                new PieceOnBoardInfo(11, false, 0, 0, 0)
        };
    }
}
