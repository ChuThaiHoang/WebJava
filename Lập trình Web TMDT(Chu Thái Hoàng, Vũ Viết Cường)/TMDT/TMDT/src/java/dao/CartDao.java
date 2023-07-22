/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Cart;
import entity.ManagerCart;
import entity.Product;
import entity.oderCart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eotke
 */
public class CartDao extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<oderCart> getCartByAccountId(int AccountID) {
        List<oderCart> list = new ArrayList<>();
        String query = "SELECT tmdt.cart.id,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.cart.Amount FROM  tmdt.product inner join tmdt.cart  on  tmdt.product.id = tmdt.cart.ProductID\n"
                + "where tmdt.cart.AccountID = ? and tmdt.cart.lock = 0";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new oderCart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<oderCart> getOderCartByAccountId(int AccountID) {
        List<oderCart> list = new ArrayList<>();
        String query = "SELECT tmdt.cart.id,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.cart.Amount FROM  tmdt.product inner join tmdt.cart  on  tmdt.product.id = tmdt.cart.ProductID\n"
                + "where tmdt.cart.AccountID = ? and tmdt.cart.lock = 1";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new oderCart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }



    public List<oderCart> getCartByDeal(int AccountID, String sql) {
        List<oderCart> list = new ArrayList<>();
        String query = "SELECT tmdt.cart.id,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.cart.Amount FROM  tmdt.product inner join tmdt.cart  on  tmdt.product.id = tmdt.cart.ProductID\n"
                + "where tmdt.cart.AccountID = ? ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setString(2, sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new oderCart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));

            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Cart getCartByID(String id) {
        String query = "SELECT * FROM tmdt.cart where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editAmountCart(int Amount, String id) {
        String query = "UPDATE `tmdt`.`cart` SET `Amount` = ? WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, Amount);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void LockCart(String id) {
        String query = "UPDATE `tmdt`.`cart` SET `lock` = 1 WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UnLockCart(int id) {
        String query = "UPDATE `tmdt`.`cart` SET `lock` = 0 WHERE (`id` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void DeleteOderCart(String id) {
        String query = "delete from tmdt.cart where id = ?; ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Cart getCartByAccIdAndProId(int AccountID, int ProductID) {
        String query = "SELECT * FROM tmdt.cart "
                + "where AccountID = ? and ProductID = ?;";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setInt(2, ProductID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addCart(int AccountID, String ProductID) {
        String query = "INSERT INTO `tmdt`.`cart` (`AccountID`, `ProductID`, `Amount`, `lock`)"
                + " VALUES (?, ?, ?,0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setString(2, ProductID);
            ps.setString(3, "1");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void addCartDetail(int AccountID, String ProductID, String amount) {
        String query = "INSERT INTO `tmdt`.`cart` (`AccountID`, `ProductID`, `Amount`, `lock`)"
                + " VALUES (?, ?, ?,0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setString(2, ProductID);
            ps.setString(3, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addCartOnDetail(int AccountID, String ProductID) {
        String query = "INSERT INTO `tmdt`.`cart` (`AccountID`, `ProductID`, `Amount`, `lock`)"
                + " VALUES (?, ?, ?,1);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setString(2, ProductID);
            ps.setString(3, "1");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
