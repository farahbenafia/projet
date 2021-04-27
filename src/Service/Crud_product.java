/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication1.Connexion_BD.DataSource;

/**
 *
 * @author HP
 */
public class Crud_product {
    
    private Statement ste;
    private PreparedStatement pst;
    
    private ResultSet rs;
    
    private Connection connection;
    
    public Crud_product(){
        connection=DataSource.getInstance().getcnx();
        
    }
    
    public void addproduct (Product p) {
        String req="insert into product( name_product,reference,price,brand,supplier,time_use,skin_type,photo_product) values ('" +p.getNameProduct()+ "','" +p.getReference()+"','" +p.getPrice()+ "' ,'" +p.getBrand()+"','" +p.getSupplier()+"' ,'" +p.getTimeUse()+"','" +p.getSkinType()+"','" +p.getPhotoProduct()+"')";
        try {
            ste= connection.createStatement();
            ste.executeUpdate(req);
                    } catch (SQLException ex) {
            Logger.getLogger(Crud_product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
      try {
            String requete = "SELECT * FROM product";
            Statement st = DataSource.getInstance().getcnx().createStatement();
            //contenaire
            ResultSet rs =  st.executeQuery(requete);
                while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setNameProduct(rs.getString("name_product"));
                product.setBrand(rs.getString("brand"));
                product.setReference(rs.getString("reference"));
                product.setSupplier(rs.getString("supplier"));
                product.setTimeUse(rs.getString("time_use"));
                product.setPrice(rs.getInt("price"));
                product.setSkinType(rs.getString("skin_type"));
                
                products.add(product);                
        }
      return products;
      }
        catch(Exception e){
                        System.out.println(e);

        return null;
        }
    }
    
    public void delet(int id){
        String req="delete from product where id= " +id;
        try {
            pst=connection.prepareStatement(req);
            
            pst.executeUpdate(req);
           
            System.out.println("suppression");
        } catch (SQLException ex) {
            Logger.getLogger(Crud_product.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    public void update (Product p){
        
       String req="update product set name_product=? ,price=? ,brand=?,supplier=?,time_use=?,skin_type=?,reference=? where id=?  ";
       
        try {
            pst=connection.prepareStatement(req);
            
            pst.setString(1, p.getNameProduct());
            pst.setDouble(2, p.getPrice());
            pst.setString(3, p.getBrand());
            pst.setString(4, p.getSupplier());
            pst.setString(5, p.getTimeUse());
            pst.setString(6, p.getSkinType());
            pst.setString(7, p.getReference());
            pst.setInt(8, p.getId());
            
            pst.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(Crud_product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
