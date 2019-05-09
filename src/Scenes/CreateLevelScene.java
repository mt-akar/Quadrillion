package Scenes;



import DataModels.GameLevel;

import ViewModels.GridView;

import ViewModels.PieceViews.PieceView;

import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.input.MouseButton;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

import sample.Glob;



public class CreateLevelScene extends QuadScene {



    private static double mousePrevX, mousePrevY;

    private double gl = Glob.gl;



    private double gameBoardOffsetX = Glob.windowWidth() / 2 - gl * 8;

    private  double gameBoardOffsetY = 30;



    private boolean[][] gameBoardLayout = new boolean[16][16];

    private int[][] gridPositions;



    private GameLevel level;



    public CreateLevelScene() {

        super(new Pane(), Glob.windowWidth(), Glob.windowHeight());

        VBox mainLayout = new VBox();

        setRoot(mainLayout);

    }



    public GameLevel getLevel() {

        return null;

    }



    private EventHandler<MouseEvent> OnMousePressedOnGridEventHandler;



    private EventHandler<MouseEvent> OnMouseDraggedGridEventHandler;



    private EventHandler<MouseEvent> OnMouseReleasedGridEventHandler;



    private EventHandler<MouseEvent> OnMousePressedOnPieceEventHandler;



    private EventHandler<MouseEvent> OnMouseDraggedPieceEventHandler;



    private EventHandler<MouseEvent> OnMouseReleasedPieceEventHandler;

}