/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eotke
 */
public class CategoryDao extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.category;";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public Category getCategorybyID(String id) {
        String query = "SELECT * FROM tmdt.category where cid = ?;";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Category> getCategorybyLock() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.category where tmdt.category.lock = 0;";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    
     public void DeleteCategory (String id){
        String query = "delete from tmdt.category where cid = ?; ";
        try {
            ps = connection.prepareStatement(query); 
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public Category CheckCate(String name) {
        String query = "SELECT * FROM  `tmdt`.`category` where cname = ?";
        Category a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }

        return a;
    }
     public void AddCategory(String name) {
        String query = "INSERT INTO `tmdt`.`category` (`cname`, `lock`) VALUES (?, '0');";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public void editCategory(String name, String id) {
        String query = "UPDATE `tmdt`.`category` SET `cname` = ? WHERE (`cid` = ?);";
        try {
            ps = connection.prepareStatement(query);   
            ps.setString(1, name);      
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public void LockC(int lock, String id) {
        String query = "UPDATE `tmdt`.`category` SET `lock` = ? WHERE (`cid` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, lock);
            ps.setString(2, id);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
