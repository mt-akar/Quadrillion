package Scenes;

import ViewModels.*;
import ViewModels.PieceViews.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.transform.Translate;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;


public class TrialScene extends Scene {

    private static double mousePrevX, mousePrevY;
    private double gl = Glob.gl;

    private double gameBoardOffsetX = Glob.windowWidth() / 2 - gl * 8;
    private  double gameBoardOffsetY = 30;

    private boolean[][] gameBoardLayout = new boolean[16][16];
    private int[][] gridPositions = new int[4][2];
    private Button startGamePhase;

    public TrialScene() {
        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());
        Pane trialLayout = new Pane();
        setRoot(trialLayout);
        //trialLayout.setBackground(new Background(new BackgroundImage(new Image("../Images/bg.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Background image
        //trialLayout.setId("pane");
        //getStylesheets().addAll(this.getClass().getResource("../Images/style.css").toExternalForm());

        for (int i = 0; i <= 16; i++) {
            Line l1 = new Line(gameBoardOffsetX, gameBoardOffsetY + gl * i, gameBoardOffsetX + gl * 16, gameBoardOffsetY + gl * i);
            Line l2 = new Line(gameBoardOffsetX + gl * i, gameBoardOffsetY, gameBoardOffsetX + gl * i, gameBoardOffsetY + gl * 16);
            l1.setStroke(Color.rgb(200, 200, 200));
            l2.setStroke(Color.rgb(200, 200, 200));
            trialLayout.getChildren().addAll(l1, l2);
        }

        Polygon polygon1 = new Polygon();
        polygon1.setLayoutX(100);
        polygon1.setLayoutY(100);
        polygon1.getPoints().addAll(0.0, 0.0,
                50.0, 0.0,
                300.0, 100.0,
                0.0, 100.0);
        polygon1.getTransforms().add(new Translate(150, 50));
        polygon1.setTranslateX(-150);
        polygon1.setTranslateY(-50);
        polygon1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
        polygon1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
        //trialLayout.getChildren().add(polygon1);

        GridView g1 = new GridView(gameBoardOffsetX + gl * 9 / 2, gameBoardOffsetY + gl * 9 / 2, 1);
        g1.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g1.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        g1.setOnMouseReleased(OnMouseReleasedGridEventHandler);
        trialLayout.getChildren().add(g1);

        GridView g2 = new GridView(gameBoardOffsetX + gl * 23 / 2, gameBoardOffsetY + gl * 9 / 2, 2);
        g2.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g2.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        g2.setOnMouseReleased(OnMouseReleasedGridEventHandler);
        trialLayout.getChildren().add(g2);

        GridView g3 = new GridView(gameBoardOffsetX + gl * 9 / 2, gameBoardOffsetY + gl * 23 / 2, 3);
        g3.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g3.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        g3.setOnMouseReleased(OnMouseReleasedGridEventHandler);
        trialLayout.getChildren().add(g3);

        GridView g4 = new GridView(gameBoardOffsetX + gl * 23 / 2, gameBoardOffsetY + gl * 23 / 2, 4);
        g4.setOnMousePressed(OnMousePressedOnGridEventHandler);
        g4.setOnMouseDragged(OnMouseDraggedGridEventHandler);
        g4.setOnMouseReleased(OnMouseReleasedGridEventHandler);
        trialLayout.getChildren().add(g4);

        startGamePhase = new Button("Start the game");
        startGamePhase.setLayoutX(100);
        startGamePhase.setLayoutY(800);
        trialLayout.getChildren().add(startGamePhase);
        startGamePhase.setOnAction(e0 -> {
            trialLayout.getChildren().remove(2, 32);
            g1.setOnMousePressed(e -> {
            });
            g1.setOnMouseDragged(e -> {
            });
            g1.setOnMouseReleased(e -> {
            });
            g2.setOnMousePressed(e -> {
            });
            g2.setOnMouseDragged(e -> {
            });
            g2.setOnMouseReleased(e -> {
            });
            g3.setOnMousePressed(e -> {
            });
            g3.setOnMouseDragged(e -> {
            });
            g3.setOnMouseReleased(e -> {
            });
            g4.setOnMousePressed(e -> {
            });
            g4.setOnMouseDragged(e -> {
            });
            g4.setOnMouseReleased(e -> {
            });
            for (int i = 0; i < 4; i++) {
                YPieceView y1 = new YPieceView();
                y1.setLayoutX(120);
                y1.setLayoutY(100 + i * 180);
                y1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
                y1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
                y1.setOnMouseReleased(OnMouseReleasedPieceEventHandler);
                trialLayout.getChildren().add(y1);
            }
            for (int i = 0; i < 4; i++) {
                WPieceView y1 = new WPieceView();
                y1.setLayoutX(350);
                y1.setLayoutY(100 + i * 180);
                y1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
                y1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
                y1.setOnMouseReleased(OnMouseReleasedPieceEventHandler);
                trialLayout.getChildren().add(y1);
            }
            for (int i = 0; i < 4; i++) {
                LPieceView y1 = new LPieceView();
                y1.setLayoutX(1270);
                y1.setLayoutY(100 + i * 180);
                y1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
                y1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
                y1.setOnMouseReleased(OnMouseReleasedPieceEventHandler);
                trialLayout.getChildren().add(y1);
            }
            for (int i = 0; i < 4; i++) {
                VPieceView y1 = new VPieceView();
                y1.setLayoutX(1480);
                y1.setLayoutY(100 + i * 180);
                y1.setOnMousePressed(OnMousePressedOnPieceEventHandler);
                y1.setOnMouseDragged(OnMouseDraggedPieceEventHandler);
                y1.setOnMouseReleased(OnMouseReleasedPieceEventHandler);
                trialLayout.getChildren().add(y1);
            }

            monitorGameBoardLayout(); // change
            startGamePhase.setDisable(true);
        });
        startGamePhase.setDisable(true);
    }

    private EventHandler<MouseEvent> OnMousePressedOnGridEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to GridView object
                    GridView gw = ((GridView) (t.getSource()));

                    // Bring GridView to front
                    gw.toFront();

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY && !gw.getRotating()) {
                        gw.rotate();

                        // If grid was placed, update gameBoardLayout
                        if(gw.placed){
                            // Calculate grid position enumerator which can be 1 through 13
                            int positionX = (int) ((gw.getLayoutX() - gameBoardOffsetX) / gl) - 1;
                            int positionY = (int) ((gw.getLayoutY() - gameBoardOffsetY) / gl) - 1;

                            // Update gameBoardLayout
                            for (int i = 0; i < 4; i++)
                                for (int j = 0; j < 4; j++)
                                    gameBoardLayout[i + positionX - 1][j + positionY - 1] = gw.g.layout[i][j];
                        }
                        return;
                    }

                    // If left button pressed, disable startGamePhase button
                    startGamePhase.setDisable(true);

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();

                    // If the GridView was placed on game board, remove it
                    if (gw.placed) {
                        gw.placed = false;

                        // Iterate over gridPositions
                        for (int i = 0; i < 4; i++) {

                            // Find the grid's positions
                            if (gridPositions[i][0] == gw.coordX && gridPositions[i][1] == gw.coordY) {

                                // Update gameBoardLayout
                                for (int j = gridPositions[i][0] - 1; j <= gridPositions[i][0] + 2; j++)
                                    for (int k = gridPositions[i][1] - 1; k <= gridPositions[i][1] + 2; k++)
                                        gameBoardLayout[j][k] = false;

                                // Update gridPositions
                                gridPositions[i][0] = 0;
                                gridPositions[i][1] = 0;
                                gw.coordX = 0;
                                gw.coordY = 0;

                                return;
                            }
                        }
                        // Displaced grid should be found, processed and returned during the loop
                        System.out.println("This shouldn't have happened.");
                    }
                }
            };

    private EventHandler<MouseEvent> OnMouseDraggedGridEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to GridView object
                    GridView gw = ((GridView) (t.getSource()));

                    // Move the piece
                    gw.setLayoutX(Math.max(gw.getLayoutX() + t.getSceneX() - mousePrevX, 0));
                    gw.setLayoutY(Math.max(gw.getLayoutY() + t.getSceneY() - mousePrevY, 0));

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    private EventHandler<MouseEvent> OnMouseReleasedGridEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If right button is released, return
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to GridView object
                    GridView gw = ((GridView) (t.getSource()));

                    // If grid is placed outside the game area, return
                    if (gw.getLayoutX() <= gameBoardOffsetX + gl * 1.5 || gameBoardOffsetX + gl * 14.5 <= gw.getLayoutX() ||
                            gw.getLayoutY() < gameBoardOffsetY + gl * 1.5 || gameBoardOffsetY + gl * 14.5 <= gw.getLayoutY())
                        return;

                    // Calculate grid position enumerator which can be 1 through 13
                    int positionX = windowToXCoordinate(gw.getLayoutX());
                    int positionY = windowToYCoordinate(gw.getLayoutY());

                    // Check if the grid can be placed
                    for (int i = 0; i < 4; i++) {
                        // If grid positions array contains 0, that means this grid position slot is empty
                        if (gridPositions[i][0] == 0 || gridPositions[i][1] == 0)
                            continue;

                        // If the grid is too close to a previously placed grid, return
                        if (Math.abs(gridPositions[i][0] - positionX) < 4 && Math.abs(gridPositions[i][1] - positionY) < 4)
                            return;
                    }

                    // PLACE THE GRID //

                    // Snap the grid to game board guidelines
                    gw.setLayoutX(NearestGL(gw.getLayoutX() - gameBoardOffsetX) + gameBoardOffsetX);
                    gw.setLayoutY(NearestGL(gw.getLayoutY() - gameBoardOffsetY) + gameBoardOffsetY);

                    // Set gw.placed to true
                    gw.placed = true;

                    // Update gameBoardLayout
                    for (int i = 0; i < 4; i++)
                        for (int j = 0; j < 4; j++)
                            if (gw.g.layout[i][j])
                                gameBoardLayout[i + positionX - 1][j + positionY - 1] = true;

                    // Update gridPositions
                    for (int i = 0; i < 4; i++) {
                        if (gridPositions[i][0] != 0)
                            continue;
                        gridPositions[i][0] = positionX;
                        gridPositions[i][1] = positionY;
                        gw.coordX = positionX;
                        gw.coordY = positionY;
                        break;
                    }

                    // CHANGE GAME START BUTTON ACTIVITY - Feel free to optimize this section //
                    boolean active = true;
                    int[] gridNeighbours = new int[4];

                    // If any piece is not placed yet
                    for (int i = 0; i < 4; i++) {
                        if (gridPositions[i][0] == 0)
                            active = false;
                    }
                    // Collect grid proximity data
                    for (int i = 0; i <= 2; i++) {
                        for (int j = i + 1; j <= 3; j++) {
                            if (gridPositions[i][0] == 0 || gridPositions[i][1] == 0)
                                continue;
                            int a = Math.abs(gridPositions[i][0] - gridPositions[j][0]);
                            int b = Math.abs(gridPositions[i][1] - gridPositions[j][1]);
                            if ((a == 4 && (b == 0 || b == 2)) || (b == 4 && (a == 0 || a == 2))) {
                                gridNeighbours[i]++;
                                gridNeighbours[j]++;
                            }
                        }
                    }
                    // If any grid is apart from the set
                    for (int i = 0; i < 4; i++) {
                        if (gridNeighbours[i] == 0)
                            active = false;
                    }
                    // If grids are grouped in couples
                    if (gridNeighbours[0] + gridNeighbours[1] + gridNeighbours[2] + gridNeighbours[3] < 6)
                        active = false;

                    // Final call
                    startGamePhase.setDisable(!active);
                    // Optimize up to here //
                }
            };

    private EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to shape object
                    PieceView pv = ((PieceView) (t.getSource()));

                    // Bring piece to front
                    pv.toFront();

                    // REMOVE
                    if (pv.placed){
                        // Update gameBoardLayout
                        for (int i = 0; i < 4; i++)
                            for (int j = 0; j < 4; j++)
                                if (pv.p.structure[i][j])
                                    gameBoardLayout[i + pv.coordX - 1][j + pv.coordY - 1] = true;

                        // Update pv members
                        pv.placed = false;
                        pv.displace();

                        monitorGameBoardLayout();
                    }

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY && !pv.getRotating()) {
                        pv.rotate();
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    private EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If left button is dragged, do nothing
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to PieceView object
                    PieceView pw = ((PieceView) (t.getSource()));

                    // Move the piece
                    pw.setLayoutX(Math.max(pw.getLayoutX() + t.getSceneX() - mousePrevX, gl / 2));
                    pw.setLayoutY(Math.max(pw.getLayoutY() + t.getSceneY() - mousePrevY, gl * 3 / 2));

                    // Update the mouse position AFTER the drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    private EventHandler<MouseEvent> OnMouseReleasedPieceEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // If right button is released, return
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to PieceView object
                    PieceView pv = ((PieceView) (t.getSource()));

                    // Calculate grid position enumerator which can be 1 through 13
                    int piecePositionX = windowToXCoordinate(pv.getLayoutX());
                    int piecePositionY = windowToYCoordinate(pv.getLayoutY());

                    // Check if the piece can be placed
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            // If the corresponding square is not a part of piece, continue
                            if (!pv.p.structure[i][j])
                                continue;
                            // If the corresponding square of the piece is outside the area, return
                            if (i + piecePositionX - 1 < 0 || i + piecePositionX - 1 > 15 || j + piecePositionY - 1 < 0 || j + piecePositionY - 1 > 15)
                                return;
                            // If the corresponding square of the piece cannot be placed, return
                            if (!gameBoardLayout[i + piecePositionX - 1][j + piecePositionY - 1])
                                return;
                        }
                    }

                    // PLACE //

                    // Snap the grid to game board guidelines
                    pv.setLayoutX(NearestGL(pv.getLayoutX() - gameBoardOffsetX) + gameBoardOffsetX);
                    pv.setLayoutY(NearestGL(pv.getLayoutY() - gameBoardOffsetY) + gameBoardOffsetY);

                    // Update gameBoardLayout
                    for (int i = 0; i < 4; i++)
                        for (int j = 0; j < 4; j++)
                            if (pv.p.structure[i][j])
                                gameBoardLayout[i + piecePositionX - 1][j + piecePositionY - 1] = false;

                    // Update pv members
                    pv.coordX = piecePositionX;
                    pv.coordY = piecePositionY;
                    pv.placed = true;

                    // Change color
                    pv.place();

                    monitorGameBoardLayout();

                    // GAME ENDED CHECK //

                    boolean ended = true;
                    for (int i = 0; i < 4; i++){
                        for (int j = -1; j <= 2; j++){
                            for (int k = -1; k <= 2; k++){
                                if (gameBoardLayout[gridPositions[i][0] + k][gridPositions[i][1] + j]){
                                    ended = false;
                                }
                            }
                        }
                    }
                    if(ended)
                        System.out.println("Game over");
                }
            };




    // Helper func that gives the nearest multiple of 'gl' to a given double
    private long NearestGL(double x) {
        return Math.round(x / gl) * (long) gl;
    }

    private void monitorGameBoardLayout() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print((gameBoardLayout[j][i] ? "O" : "-") + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    // This method takes a window position and converts it to board coordinates.
    // Coordinate 1, 1 means corresponds to the left-top-most 4 by 4 grid.
    // There are 13x13 different coordinates on the board.
    private int windowToXCoordinate(double pos){
        return (int) ((NearestGL(pos - gameBoardOffsetX)) / gl) - 1;
    }
    private int windowToYCoordinate(double pos){
        return (int) ((NearestGL(pos - gameBoardOffsetY)) / gl) - 1;
    }

}
