package sample;
import DataModels.GameLevel;
import DataModels.Player;
import Scenes.ArcadeGameScene;
import Scenes.SettingsScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import javafx.fxml.Initializable;

//THIS CONTROLLER MANAGES FirstPageLoginRegister.fxml & LOGINPAGE.fxml & REGISTERPAGE.fxml

public class firstPageController implements Initializable {

    Button loginButton, registerButton, creditsButton, backButton;

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loginButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/LoginPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 1600, 900);
            scene = new Scene(loader.load(), 800, 600);
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
        Main.mainStage.setScene(scene);
        Main.mainStage.show();
    }
    public void registerButton(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/RegisterPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
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
    }

    public void creditsButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/FXMLDeneme/creditsPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(), 800, 600);
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
        //Main.mainStage.setMaximized(true);
        Main.mainStage.show();
    }

    @FXML
    private Label statusLog;

    @FXML
    private TextField usernameLog;

    @FXML
    private TextField passwordLog;

    public void sendMenuButton(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        FXMLLoader loader = new FXMLLoader();
        System.out.println("LOGIN BUTTON CLICKED!");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/talha_sen";
        try {
            Connection con = DriverManager.getConnection(url, "talha.sen", "p2yjILda");
            Statement st = con.createStatement();
            System.out.println("CONNECTED TO DATABASE");

            //DatabaseMetaData meta = con.getMetaData();
            //ResultSet result = meta.getTables(null, null, "%", null);

            String query01 = "SELECT * FROM player " +
                    "WHERE username = '" + usernameLog.getText() + "' AND password = '" + passwordLog.getText() + "';";
            System.out.println(query01);
            ResultSet tableR = st.executeQuery(query01);

            if(tableR.next()) {
                statusLog.setText("Login Successful!");
                // Setting the arttributes of the player in the main class
                Main.player = new Player(usernameLog.getText(), passwordLog.getText());

                loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
                Scene scene = null;

                try {
                    scene = new Scene(loader.load(), 1600, 900);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Main.mainStage.setTitle("My Little Quadrillion - v0.01");
                Main.mainStage.setScene(scene);
                //Main.mainStage.setMaximized(true);
                Main.mainStage.show();
            } else {
                statusLog.setText("Username and Password do NOT match!");
            }

        } catch (SQLException except) {
            System.out.println(except.getMessage());
        }

    }

    @FXML
    private Label statusReg;

    @FXML
    private TextField usernameReg;

    @FXML
    private TextField passwordReg;

    @FXML
    private TextField passwordRegRep;

    public void sendMenuButtonByAutoLog(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        FXMLLoader loader = new FXMLLoader();
        System.out.println("REGISTER BUTTON CLICKED!");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/talha_sen";
        try {
            Connection con = DriverManager.getConnection(url, "talha.sen", "p2yjILda");
            Statement st = con.createStatement();
            System.out.println("CONNECTED TO DATABASE");

            /*
                                DON'T FORGET TO CHANGE THE STYLE OF LEVELS!*************************
             */
            //System.out.println(passwordReg.getText().equals(passwordRegRep.getText()));

            if(!passwordReg.getText().equals(passwordRegRep.getText())) {
                statusReg.setText("Passwords do NOT match!");
            } else {
                System.out.println(usernameReg.getText() + "    " + passwordReg.getText());
                String query02 = "INSERT INTO player VALUES('" + usernameReg.getText() + "', '" + passwordReg.getText() + "', 'a', 'b', 'c', 'd', '0');";
                System.out.println(query02);
                int isSucccess = st.executeUpdate(query02);
                System.out.println(isSucccess);
                con.close();


                if( isSucccess  == 1) {
                    statusReg.setText("--------Register Successful!----------");
                    loader.setLocation(getClass().getResource("/FXMLDeneme/samplex.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(loader.load(), 800, 600);
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
                    //Main.mainStage.setMaximized(true);
                    Main.mainStage.show();
                }

            }

        } catch (SQLException except) {
            System.out.println(except.getMessage());
        }
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("back button is now loaded!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLDeneme/FirstPageLoginRegister.fxml"));
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



}