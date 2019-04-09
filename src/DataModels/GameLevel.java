package DataModels;

public class GameLevel {

    public PieceOnBoardInfo[] pieceInfos;
    public GridOnBoardInfo[] gridInfos;

    public GameLevel(int level){
        if (level == 1){
            gridInfos = new GridOnBoardInfo[] {
                    new GridOnBoardInfo(2,5, 4, 2),
                    new GridOnBoardInfo(1,9, 6, 3),
                    new GridOnBoardInfo(4,5, 8, 1),
                    new GridOnBoardInfo(3,9, 10, 0)
            };

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
        if (level == 2){
            gridInfos = new GridOnBoardInfo[] {
                    new GridOnBoardInfo(2,7, 5, 3),
                    new GridOnBoardInfo(1,11, 7, 3),
                    new GridOnBoardInfo(3,9, 11, 0),
                    new GridOnBoardInfo(4,5, 9, 0)
            };

            pieceInfos = new PieceOnBoardInfo[] {
                    new PieceOnBoardInfo(3, true, 7, 4, 5),
                    new PieceOnBoardInfo(7, true, 9, 5, 2),
                    new PieceOnBoardInfo(9, true, 7, 6, 6),
                    new PieceOnBoardInfo(4, true, 7, 9, 3),
                    new PieceOnBoardInfo(10, true, 12, 6, 2),
                    new PieceOnBoardInfo(5, true, 12, 8, 0),
                    new PieceOnBoardInfo(12, true, 10, 8, 3),

                    new PieceOnBoardInfo(1, false, 0, 0, 0),
                    new PieceOnBoardInfo(2, false, 0, 0, 0),
                    new PieceOnBoardInfo(3, false, 0, 0, 0),
                    new PieceOnBoardInfo(4, false, 0, 0, 0),
                    new PieceOnBoardInfo(11, false, 0, 0, 0)
            };
        }
        if (level == 3){
            gridInfos = new GridOnBoardInfo[] {
                    new GridOnBoardInfo(1,7, 5, 2),
                    new GridOnBoardInfo(4,11, 7, 2),
                    new GridOnBoardInfo(2,9, 11, 1),
                    new GridOnBoardInfo(1,5, 9, 1)
            };

            pieceInfos = new PieceOnBoardInfo[] {
                    new PieceOnBoardInfo(9, false, 0, 0, 0),
                    new PieceOnBoardInfo(4, false, 0, 0, 0),
                    new PieceOnBoardInfo(7, false, 0, 0, 0),
                    new PieceOnBoardInfo(1, false, 0, 0, 0),
                    new PieceOnBoardInfo(8, false, 0, 0, 0),
                    new PieceOnBoardInfo(3, false, 0, 0, 0),
                    new PieceOnBoardInfo(12, false, 0, 0, 0),
                    new PieceOnBoardInfo(10, false, 0, 0, 0),
                    new PieceOnBoardInfo(5, false, 0, 0, 0),
                    new PieceOnBoardInfo(2, false, 0, 0, 0),
                    new PieceOnBoardInfo(6, false, 0, 0, 0),
                    new PieceOnBoardInfo(11, false, 0, 0, 0)
            };
        }
    }
}
