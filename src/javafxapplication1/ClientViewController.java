/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Entite.Category;
import Service.Crud_category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ClientViewController implements Initializable {

    @FXML
    private HBox search;
    @FXML
    private AnchorPane form_client;
    @FXML
    private ComboBox<Category> box_category;
    @FXML
    private Button notif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.form_client.setVisible(true);
        
    }    

    @FXML
    private void list_category(ActionEvent event) {
        Crud_category crud = new Crud_category() ;
        ObservableList<Category> list= FXCollections.observableArrayList();
        
        
    }

    @FXML
    private void shownotif(ActionEvent event) {
        
        Notifications notificationBuilder= Notifications.create()
                .title("E-mail")
                .text("Your email has been sent")
                .hideAfter(Duration.seconds(6))
                        .position(Pos.TOP_RIGHT);
                 notificationBuilder.show();
    }
    
}
