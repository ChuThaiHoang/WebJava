/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Deal;
import entity.ManagerCart;
import entity.oderCart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eotke
 */
public class DealDao extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<oderCart> getCartByAccountId(int AccountID) {
        List<oderCart> list = new ArrayList<>();
        String query = "SELECT tmdt.cart.id,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.cart.Amount FROM  tmdt.product inner join tmdt.cart  on  tmdt.product.id = tmdt.cart.ProductID\n"
                + "where tmdt.cart.AccountID = ?";
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

    public void DeleteDealCart(String id) {
        String query = "delete from tmdt.deal where dealid = ?; ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UpdateCheckPayOderCart(int checkPay, String id) {
        String query = "UPDATE `tmdt`.`deal` SET `checkPay` = ? WHERE (`dealid` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, checkPay);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addDeal(int AccountID, int ProductID, int Amount) {
        String query = "INSERT INTO `tmdt`.`deal` (`AccountID`, `ProductID`,`Amount`, `checkPay`)"
                + " VALUES (?, ?, ?,0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            ps.setInt(2, ProductID);
            ps.setInt(3, Amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Deal getDealByID(String id) {
        String query = "SELECT * FROM tmdt.deal where dealid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Deal(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ManagerCart> getDealOderCartById(int AccountID) {
        List<ManagerCart> list = new ArrayList<>();
        String query = "SELECT tmdt.deal.dealid,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.deal.Amount,tmdt.deal.checkPay\n"
                + "FROM  tmdt.product inner join tmdt.deal  on  tmdt.product.id = tmdt.deal.ProductID \n"
                + "where tmdt.deal.AccountID = ? order by dealid desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ManagerCart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<ManagerCart> getDealOderCartBySellId(int AccountID) {
        List<ManagerCart> list = new ArrayList<>();
        String query = "SELECT  tmdt.deal.dealid,tmdt.product.name,tmdt.product.image,\n"
                + "tmdt.product.price,tmdt.deal.Amount,tmdt.deal.checkPay\n"
                + "FROM  tmdt.product inner join tmdt.account  on  tmdt.product.sell_ID = tmdt.account.uID\n"
                + "inner join tmdt.deal  on  tmdt.product.id = tmdt.deal.ProductID\n"
                + "where tmdt.account.uID = ? order by dealid desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ManagerCart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void DeleteOderDeal(String id) {
        String query = "delete from tmdt.deal where dealid = ?; ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
