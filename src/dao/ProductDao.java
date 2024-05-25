/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;
import java.text.DecimalFormat;

/**
 *
 * @author Win
 */
public class ProductDao {
    public static void save(Product product){
        if(getProductByname(product.getName()) != null){
                JOptionPane.showMessageDialog(null, "The product was exist!");
                return;
            }
        try {
            double number = Double.parseDouble(product.getPrice());
            DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String query = "INSERT INTO product (name, category, price, img) VALUES ('" + product.getName() + "', '" + product.getCategory() + "', '" + decimalFormat.format(number)  + "', '" + product.getImg() + "')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            String query = "Select * from product";
            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                product.setImg(rs.getString("img"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    
    public static void update(Product product){
        if(getProductByname(product.getName()) != null){
                JOptionPane.showMessageDialog(null, "The product was exist!");
                return;
            }
        
        String query = "update product set name='" + product.getName() +"',category='" + product.getCategory()+"',price='" + product.getPrice()+"' where id ='" + product.getId() + "'";
        DbOperations.setDataOrDelete(query, "Product updated Successfully!");
    }
    
    public static void delete(String id){
        String query = "delete from product where id ='" +id +"'";
        DbOperations.setDataOrDelete(query, "Product Delete Successfully!");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        
        try {
            ResultSet rs = DbOperations.getData("select * from product where category='" + category +"'");
            
            while (rs.next()) {
                Product product = new  Product();
                product.setName(rs.getString("name"));
                arrayList.add(product); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }
    
    
    public static ArrayList<Product> filterProductByName(String name, String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        
        try {
            ResultSet rs = DbOperations.getData("select * from product where name like '%"+name + "%' and category='" + category +"'");
            
            while (rs.next()) {
                Product product = new  Product();
                product.setName(rs.getString("name"));
                arrayList.add(product); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }
    
    public static Product getProductByname(String name){
        try {
            Product product = new Product();
            ResultSet rs =DbOperations.getData("select * from product where name='" +name+ "'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
                return product;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }
}
