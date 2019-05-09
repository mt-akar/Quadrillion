package sample;
import Scenes.CustomLevelsScene;
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
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LevelEditorPageController implements Initializable {
    Button backButton;

    @FXML
    ComboBox<String> combo;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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
            System.out.println(tab);
        }
        catch (SQLException except) {
            System.out.println(except.getMessage());
        }


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

    }
}