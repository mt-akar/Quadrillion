package sample;
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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LevelEditorPageController implements Initializable {
    Button backButton;

    @FXML
    private ComboBox<String> comboBox;

    public void initialize(URL location, ResourceBundle resources) {

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

            String query11 = "SELECT COUNT(*) FROM createdLevel;";
            ResultSet tab = st.executeQuery(query11);

            //comboBox.setVisibleRowCount(1);

            String query12 = "SELECT * FROM createdLevel;";
            ResultSet rs = st.executeQuery(query12);

            while(rs.next()){
                String name = rs.getString("name");
                String gridPlaces = rs.getString("gridPlaces");
                String prePieces = rs.getString("prePieces");
                String username = rs.getString("username");
                //comboItems.add(name + " by " + username);
                System.out.println("item added: " + name + " by " + username);
                comboBox.getItems().add(name + " by " + username);
                //comboBox.setItems(FXCollections.observableArrayList("Element 1"));
            }

        }
        catch (SQLException except) {
            System.out.println(except.getMessage());
        }
        System.out.println("items: " + comboBox.getItems());
        //comboBox.setItems(comboItems);
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/PlayMenu.fxml"));
        Scene scene = new Scene(loader.load(), 1600, 900);
        Main.mainStage.setTitle("My Little Quadrillion - v0.01");
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
        Stage stg2 = (Stage) backButton.getScene().getWindow();
        stg2.close();
    }

    public void createButton(ActionEvent event) throws IOException {
        Main.mainStage.setScene(new LevelEditorScene());
    }

    public void comboChoice(ActionEvent event) throws IOException {
        System.out.println(event.toString());
    }
}