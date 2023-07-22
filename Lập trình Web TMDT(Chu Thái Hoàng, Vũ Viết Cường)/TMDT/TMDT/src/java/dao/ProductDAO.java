/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eotke
 */
public class ProductDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.product";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    public List<Product> GetProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.product where tmdt.product.lock = 0 and tmdt.product.amount != 0 order by id desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    public Product getLast() {
        String query = "SELECT  * FROM  tmdt.product\n"
                + "order by id desc  LIMIT 1;";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
        }

        return null;
    }
    public List<Product> getProductByCategory(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT  * FROM  tmdt.product "
                + "where cateID = ? and tmdt.product.lock = 0 and tmdt.product.amount != 0";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    public List<Product> getProductCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT  * FROM  tmdt.product\n"
                + "where cateID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public Product getProductID(String id) {
        String query = "SELECT  * FROM  tmdt.product\n"
                + "where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Product> getProductSellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT  * FROM  tmdt.product\n"
                + "where sell_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public void addProduct(String name, String image, String price, String title, String description, String cateID, int sell_ID, String amount) {
        String query = "INSERT INTO `tmdt`.`product` (`name`, `image`, `price`, `title`, `description`, `cateID`, `sell_ID`, `amount`,`lock`)"
                + " VALUES (?, ?, ?, ?, ?,?, ?, ?,0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, cateID);
            ps.setInt(7, sell_ID);
            ps.setString(8, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price, String title, String description, String amount, String pid) {
        String query = "UPDATE `tmdt`.`product` SET `name` = ?, `image` = ?, `price` = ?, `title` = ?, `description` = ?, `amount` = ? "
                + "WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, amount);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void DeleteProduct(String id) {
        String query = "delete from tmdt.product where id = ?; ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void LockP(int lock, String id) {
        String query = "UPDATE `tmdt`.`product` SET `lock` = ? WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, lock);
            ps.setString(2, id);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void UpdateAmount(int amount, String id) {
        String query = "UPDATE `tmdt`.`product` SET `amount` = ? WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, id);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<Product> getProductByName(String name){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.product where name like ? and tmdt.product.amount != 0;";
         try { 
            ps = connection.prepareStatement(query); 
            ps.setString(1,'%'+name+'%');
            rs = ps.executeQuery();
            while (rs.next() ) {                
               list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }

}
