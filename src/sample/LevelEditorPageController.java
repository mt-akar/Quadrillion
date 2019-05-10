package sample;

import DataModels.GameLevel;
import DataModels.GridOnBoardInfo;
import DataModels.PieceOnBoardInfo;
import Scenes.ArcadeGameScene;
import Scenes.LevelEditorScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LevelEditorPageController implements Initializable {
    Button backButton;

    boolean isColorBlind;

    @FXML
    private ComboBox myCombobox;

    public ArrayList<GameLevel> levels;

    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> comboList = new ArrayList<String>();
        levels = new ArrayList<GameLevel>();
        if(SettingsController.colorBlindMode){
            isColorBlind = true;
        }
        else{
            isColorBlind = false;
        }

        ObservableList<String> comboItems = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://dijkstra.ug.bilkent.edu.tr/talha_sen";

        try {
            Connection con = DriverManager.getConnection(url, "talha.sen", "p2yjILda");
            Statement st = con.createStatement();
            System.out.println("CONNECTED TO DATABASE");

            String query12 = "SELECT * FROM createdLevel;";
            ResultSet rs = st.executeQuery(query12);
            System.out.println("2");

            while (rs.next()) {
                String name = rs.getString("name");
                String gridPlaces = rs.getString("gridPlaces");
                String prePieces = rs.getString("prePieces");
                String username = rs.getString("username");
                comboList.add(name + " by " + username);

                GameLevel level = new GameLevel();
                        /*
                System.out.println("" + gridPlaces.charAt(0) + "" + gridPlaces.charAt(2) + "" + gridPlaces.charAt(4) + "" + gridPlaces.charAt(6));
                System.out.println("" + gridPlaces.charAt(8) + "" + gridPlaces.charAt(10) + "" + gridPlaces.charAt(12) + "" + gridPlaces.charAt(14));
                System.out.println("" + gridPlaces.charAt(16) + "" + gridPlaces.charAt(18) + "" + gridPlaces.charAt(20) + "" + gridPlaces.charAt(22));
                System.out.println("" + gridPlaces.charAt(24) + "" + gridPlaces.charAt(26) + "" + gridPlaces.charAt(28) + "" + gridPlaces.charAt(30));

                level.gridInfos = new GridOnBoardInfo[]{
                        new GridOnBoardInfo(Integer.parseInt(gridPlaces.substring(0, 1)), Integer.parseInt(gridPlaces.substring(2, 3)), Integer.parseInt(gridPlaces.substring(4, 5)), Integer.parseInt(gridPlaces.substring(6, 7))),
                        new GridOnBoardInfo(Integer.parseInt(gridPlaces.substring(8, 9)), Integer.parseInt(gridPlaces.substring(10, 11)), Integer.parseInt(gridPlaces.substring(12, 13)), Integer.parseInt(gridPlaces.substring(14, 15))),
                        new GridOnBoardInfo(Integer.parseInt(gridPlaces.substring(16, 17)), Integer.parseInt(gridPlaces.substring(18, 19)), Integer.parseInt(gridPlaces.substring(20, 21)), Integer.parseInt(gridPlaces.substring(22, 23))),
                        new GridOnBoardInfo(Integer.parseInt(gridPlaces.substring(24, 25)), Integer.parseInt(gridPlaces.substring(26, 27)), Integer.parseInt(gridPlaces.substring(28, 29)), Integer.parseInt(gridPlaces.substring(30, 31)))
                };*/

                String[] gridArray = gridPlaces.split(",");
                level.gridInfos = new GridOnBoardInfo[4];

                for (int i = 0; i < 4; i++) {
                    System.out.println("" + Integer.parseInt(gridArray[i * 4]) + Integer.parseInt(gridArray[i * 4 + 1]) + Integer.parseInt(gridArray[i * 4 + 2]) + Integer.parseInt(gridArray[i * 4 + 3]));
                    level.gridInfos[i] = new GridOnBoardInfo(Integer.parseInt(gridArray[i * 4]), Integer.parseInt(gridArray[i * 4 + 1]),
                            Integer.parseInt(gridArray[i * 4 + 2]), Integer.parseInt(gridArray[i * 4 + 3]));
                }

                String[] pieceArray = prePieces.split(",");
                level.pieceInfos = new PieceOnBoardInfo[12];
                int numOfPrePlacedPieces = pieceArray.length / 4;

                ArrayList<Integer> prePlacedTypes = new ArrayList<Integer>();
                for (int i = 0; i < numOfPrePlacedPieces; i++) {
                    System.out.println("" + Integer.parseInt(pieceArray[i * 4]) + Integer.parseInt(pieceArray[i * 4 + 1]) + Integer.parseInt(pieceArray[i * 4 + 2]) + Integer.parseInt(pieceArray[i * 4 + 3]));
                    level.pieceInfos[i] = new PieceOnBoardInfo(Integer.parseInt(pieceArray[i * 4]), true, Integer.parseInt(pieceArray[i * 4 + 1]),
                            Integer.parseInt(pieceArray[i * 4 + 2]), Integer.parseInt(pieceArray[i * 4 + 3]));
                    prePlacedTypes.add(Integer.parseInt(pieceArray[i * 4]));
                }
                System.out.println("prePlacedTypes size: " + prePlacedTypes.size());

                int count = 0;
                for (int i = 1; i <= 12; i++) {
                    if (!prePlacedTypes.contains(i)) {
                        level.pieceInfos[numOfPrePlacedPieces + count] = new PieceOnBoardInfo(i, false, 0, 0, 0);
                        count++;
                    }
                }
                System.out.println("count: " + count);

                levels.add(level);
            }

        } catch (SQLException except) {
            System.out.println(except.getMessage());
        }
        //System.out.println("items: " + myCombobox.getItems());
        comboItems = FXCollections.observableArrayList(comboList);
        myCombobox.setItems(comboItems);
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
            if (SettingsController.nightMode) {
                scene.getStylesheets().add("CSS_StyleSheets/Dark.css");
                System.out.println("Dark");
            } else {
                if (SettingsController.themeSelection.equals("Bilkent Theme")) {
                    scene.getStylesheets().add("CSS_StyleSheets/FlatBee.css");
                } else {
                    scene.getStylesheets().add("CSS_StyleSheets/Style.css");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void createButton(ActionEvent event) throws IOException {
        Main.mainStage.setScene(new LevelEditorScene(isColorBlind));
    }

    public void comboChoice(ActionEvent event) throws IOException {
        int levelIndex = myCombobox.getSelectionModel().getSelectedIndex();
        Main.mainStage.setScene(new ArcadeGameScene(levels.get(levelIndex), false, isColorBlind));
    }
}