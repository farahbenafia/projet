package javafxapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entite.Category;
import Entite.Product;
import Service.Crud_category;
import Service.Crud_product;
import java.io.File;
import java.net.URL;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class MyViewController implements Initializable {

    @FXML
    private TextField name_input;
    @FXML
    private TextField ref_input;
    @FXML
    private TextField brand_input;
    @FXML
    private TextField supplier_input;
    @FXML
    private TextField time_input;
    @FXML
    private Button button_add;
    @FXML
    private TextField price_input;
    @FXML
    private TextField type_input;
    @FXML
    private AnchorPane form_add;
    @FXML
    private TableColumn<?, ?> tab_name;
    @FXML
    private TableColumn<?, ?> tab_ref;
    @FXML
    private TableColumn<?, ?> tab_brand;
    @FXML
    private TableColumn<?, ?> tab_supplier;
    @FXML
    private TableColumn<?, ?> tab_time;
    @FXML
    private TableColumn<?, ?> tab_price;
    @FXML
    private TableColumn<?, ?> tab_skin;
    @FXML
    private TableColumn<?, ?> tab_categ;
    @FXML
    private TableView<Product> tab_product;
    @FXML
    private Button button_delete;
    @FXML
    private Button button_update;
    @FXML
    private AnchorPane form_update;
    @FXML
    private TextField ref_inputupdate;
    @FXML
    private TextField skin_update;
    @FXML
    private TextField price_update;
    @FXML
    private TextField time_update;
    @FXML
    private TextField supplier_update;
    @FXML
    private Button buttoon_update;
    @FXML
    private TextField name_inputupdate;
    @FXML
    private TextField brand_update;
    @FXML
    private Button button_addCategory;
    @FXML
    private AnchorPane form_category;
    @FXML
    private Text text_cat;
    @FXML
    private TextField cat_input;
    @FXML
    private Button button_addcategory;
    @FXML
    private TableView<Category> tab_category;
    @FXML
    private TableColumn<?, ?> tab_idcat;
    @FXML
    private TableColumn<?, ?> tab_namecat;
    @FXML
    private Button button_ajoutp;
    @FXML
    private Button button_GererProduct;
    @FXML
    private Button button_GererCategory;
    @FXML
    private Button button_return;
    @FXML
    private TextField input_upcategory;
    @FXML
    private Button button_updatecategory;
    @FXML
    private AnchorPane form_updatecategory;
    @FXML
    private Label erreurCategory;
    @FXML
    private Button button_deleteCategory;
    @FXML
    private Button button_add1;
    @FXML
    private Button notif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      this.showProducts();
      this.form_add.setVisible(false);
      this.form_update.setVisible(false);
      this.form_category.setVisible(false);
      this.tab_category.setVisible(false);
      this.button_delete.setVisible(false);
      this.button_update.setVisible(false);
      this.button_ajoutp.setVisible(false);
      this.button_addCategory.setVisible(false);
      this.button_return.setVisible(false);
      this.form_updatecategory.setVisible(false);
      this.button_GererCategory.setVisible(true);
      this.button_GererProduct.setVisible(true);
      this.button_updatecategory.setVisible(false);
      this.button_deleteCategory.setVisible(false);
      
      
      this.showCategorys();
      
    
   }
    public void showProducts (){
        Crud_product crud = new Crud_product() ;
        ObservableList<Product> list=crud.getProduct();
        this.tab_name.setCellValueFactory(new PropertyValueFactory <>("nameProduct"));
        this.tab_brand.setCellValueFactory(new PropertyValueFactory <>("brand"));
        this.tab_supplier.setCellValueFactory(new PropertyValueFactory <>("supplier"));
        this.tab_ref.setCellValueFactory(new PropertyValueFactory <>("reference"));
        this.tab_price.setCellValueFactory(new PropertyValueFactory <>("price"));
        this.tab_time.setCellValueFactory(new PropertyValueFactory <>("timeUse"));
        this.tab_skin.setCellValueFactory(new PropertyValueFactory <>("skinType"));
        
        this.tab_product.setItems(list);
    
    }    

    @FXML
    private void addProduct(ActionEvent event) {
        Crud_product crud = new Crud_product();
        Product p1 = new Product();
        p1.setNameProduct(this.name_input.getText());
        p1.setBrand(this.brand_input.getText());
        p1.setReference(this.ref_input.getText());
        p1.setPrice(this.price_input.getAnchor());
        p1.setSupplier(this.supplier_input.getText());
        p1.setSkinType(this.type_input.getText());
        p1.setTimeUse(this.time_input.getText());
        p1.setPhotoProduct("ffff");
        
        crud.addproduct(p1);
        this.showProducts();
        this.form_add.setVisible(false);
        
         
    }

    @FXML
    private void delete(ActionEvent event) {
       
        Product p = this.tab_product.getSelectionModel().getSelectedItem();
        Crud_product crud = new Crud_product();
        crud.delet(p.getId());
        this.showProducts();
        
    }

    @FXML
    private void showadd(ActionEvent event) {
        this.form_update.setVisible(false);
        this.form_add.setVisible(true);
        
    }

    @FXML
    private void showupdate(ActionEvent event) {
        if(this.tab_product.getSelectionModel().getSelectedItem()!= null){
        Product p = tab_product.getSelectionModel().getSelectedItem();    
        this.form_add.setVisible(false);
        this.name_inputupdate.setText(p.getNameProduct());
        this.brand_update.setText(p.getBrand());
        this.price_update.setText(String.valueOf(p.getPrice()));
        this.supplier_update.setText(p.getSupplier());
        this.skin_update.setText(p.getSkinType());
        this.time_update.setText(p.getTimeUse());
        this.ref_inputupdate.setText(p.getReference());
        this.form_update.setVisible(true);
        
        }
    }

    @FXML
    private void updateProduct(ActionEvent event) {
        Product p = new Product();
        p.setId(tab_product.getSelectionModel().getSelectedItem().getId());
        p.setNameProduct(this.name_inputupdate.getText());
        p.setBrand(this.brand_update.getText());
        p.setReference(this.ref_inputupdate.getText());
        p.setSupplier(this.supplier_update.getText());
        p.setPrice(Double.valueOf(this.price_update.getText()));
        p.setSkinType(this.skin_update.getText());
        p.setTimeUse(this.time_update.getText());
        Crud_product crud = new Crud_product();
        crud.update(p);
        this.tab_product.getItems().clear();
        this.showProducts();
    }

    @FXML
    private void showaddCategory(ActionEvent event) {
       
        
        this.form_category.setVisible(true);
        Crud_category category=new Crud_category();
        Category c1 = new Category();
        c1.setNameCategory(this.cat_input.getText());
        category.addcategory(c1);
        this.form_add.setVisible(false);
        this.form_updatecategory.setVisible(false);
        this.erreurCategory.setVisible(false);
        
    }
    public void showCategorys (){
        Crud_category crudc = new Crud_category();
        ObservableList<Category> ListC=crudc.getCategory();
        this.tab_idcat.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tab_namecat.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));
        this.tab_category.setItems(ListC);
    }
    
    @FXML
    private void updateCategory(ActionEvent event){
        Category c = new Category();
        c.setId(tab_category.getSelectionModel().getSelectedItem().getId());
        c.setNameCategory(this.input_upcategory.getText());
        Crud_category crud = new Crud_category();
        crud.update(c);
         this.tab_category.getItems().clear();
        this.showCategorys();
    }

    @FXML
    private void GererProduct(ActionEvent event) {
        
        this.tab_product.setVisible(true);
        this.button_GererCategory.setVisible(false);
        this.button_GererProduct.setVisible(false);
        this.button_delete.setVisible(true);
        this.button_update.setVisible(true);
        this.button_ajoutp.setVisible(true);
        this.button_return.setVisible(true);
        
        
    }

    @FXML
    private void GererCategory(ActionEvent event) {
        this.form_category.setVisible(false);
        this.tab_category.setVisible(true);
        this.button_GererCategory.setVisible(false);
        this.button_GererProduct.setVisible(false);
        this.button_updatecategory.setVisible(true);
        this.form_updatecategory.setVisible(false);
        this.button_addCategory.setVisible(true);
        this.button_return.setVisible(true);
        this.button_deleteCategory.setVisible(true);
        
        
    }

    @FXML
    private void ReturnProduct(ActionEvent event) {
        this.button_GererCategory.setVisible(true);
        this.button_GererProduct.setVisible(true);
        this.form_category.setVisible(false);
        this.tab_category.setVisible(false);
        this.button_delete.setVisible(false);
        this.button_update.setVisible(false);
        this.button_ajoutp.setVisible(false);
        this.button_return.setVisible(false);
        this.tab_product.setVisible(false);
        this.form_update.setVisible(false);
        this.form_add.setVisible(false);
        this.button_deleteCategory.setVisible(false);
        this.button_updatecategory.setVisible(false);
        this.button_addCategory.setVisible(false);
        this.form_updatecategory.setVisible(false);
    }

    @FXML
    private void showupdateCategory(ActionEvent event) {
         if(this.tab_category.getSelectionModel().getSelectedItem()!= null){
        Category c = tab_category.getSelectionModel().getSelectedItem();    
        this.form_add.setVisible(false);
        this.input_upcategory.setText((c.getNameCategory()));
        
        this.form_update.setVisible(false);
        this.form_updatecategory.setVisible(true);
        this.form_category.setVisible(false);
    }
}

    @FXML
    private void addCategory(ActionEvent event) {
        this.erreurCategory.setVisible(false);
        Crud_category category=new Crud_category();
        Category c1 = new Category();
        if(this.cat_input.getText().isEmpty()==false){
        this.erreurCategory.setVisible(false);
        c1.setNameCategory(this.cat_input.getText());
        category.addcategory(c1);
        this.showCategorys();
        
        }
        else{
        this.erreurCategory.setVisible(true);
        }

    }

    @FXML
    private void showdeleteCategory(ActionEvent event) {
        Category c =this.tab_category.getSelectionModel().getSelectedItem();
        Crud_category crud = new Crud_category();
        crud.delet(c.getId());
        this.showCategorys();
        
          Notifications notificationBuilder= Notifications.create()
                .title("E-mail")
                .text("Your email has been sent")
                .hideAfter(Duration.seconds(6))
                        .position(Pos.TOP_RIGHT);
                 notificationBuilder.show();               

    }

    @FXML
    private void upload_image(ActionEvent event) {
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", ".jpg", ".png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            
    }
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
