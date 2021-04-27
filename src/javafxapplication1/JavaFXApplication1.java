/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entite.Product;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafxapplication1.Connexion_BD.DataSource;



/**
 *
 * @author HP
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MyView.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
     
    public void startclient (Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);

        DataSource ds1 = DataSource.getInstance();
        DataSource ds2 = DataSource.getInstance();
        DataSource ds3 = DataSource.getInstance();
        
        
    }
    
}
