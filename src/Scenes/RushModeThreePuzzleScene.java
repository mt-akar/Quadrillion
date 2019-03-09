package Scenes;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Glob;

public class RushModeThreePuzzleScene extends Scene {

    private static double mousePrevX, mousePrevY;
    private double gl = Glob.gl;

    private double gameBoardOffsetX = Glob.windowWidth() / 2 - gl * 8;
    private  double gameBoardOffsetY = 30;

    private boolean[][] gameBoardLayout = new boolean[16][16];
    private int[][] gridPositions;

    public RushModeThreePuzzleScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        VBox mainLayout = new VBox();
        setRoot(mainLayout);
    }

    private EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler;

    private EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler;

    private EventHandler<MouseEvent> OnMouseReleasedPieceEventHandler;
}
