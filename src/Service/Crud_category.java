/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication1.Connexion_BD.DataSource;

/**
 *
 * @author HP
 */
public class Crud_category {
    
    private Statement ste;
    private PreparedStatement pst;
    
    private ResultSet rs;
    
    private Connection connection;
    
    public Crud_category (){
        connection=DataSource.getInstance().getcnx();
    }
    
    public void addcategory(Category c){
        String req= "insert into category (name_category) values ('"+c.getNameCategory()+"')";
        
       try {
            ste= connection.createStatement();
            ste.executeUpdate(req);
                    } catch (SQLException ex) {
            Logger.getLogger(Crud_product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public ObservableList<Category> getCategory() {
        ObservableList<Category> categorys = FXCollections.observableArrayList();
           
       
        try {
             String requete = "SELECT * FROM category";
             Statement st= DataSource.getInstance().getcnx().createStatement();
             ResultSet rs =  st.executeQuery(requete);
             while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setNameCategory(rs.getNString("name_category"));
                categorys.add(category);
                        }
             return categorys; 
                     
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }

        return null;
   }
   public void update (Category c){
        
       String req="update category set name_category=? where id=?  ";
       
        try {
            pst=connection.prepareStatement(req);
            
            pst.setString(1, c.getNameCategory());
            pst.setInt(2, c.getId());
            pst.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(Crud_product.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void delet(int id){
        String req="delete from category where id= " +id;
        try {
            pst=connection.prepareStatement(req);
            
            pst.executeUpdate(req);
           
            System.out.println("suppression");
        } catch (SQLException ex) {
            Logger.getLogger(Crud_category.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}


    
            
        
        
        
    

   


