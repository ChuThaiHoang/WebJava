/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.AccountLock;
import entity.AccountSellID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eotke
 */
public class AccountDao extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "SELECT * FROM tmdt.account\n"
                + "where user = ? and pass = ? ;";
        Account a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }

        return a;
    }

    public void SignUp(String use, String pass, String name, String phone) {
        String query = "INSERT INTO `tmdt`.`account` (`user`, `pass`, `isSell`, `isAdmin`, `name`, `sdt`, `lock`)"
                + " VALUES (?, ?, '0', '0', ?, ?,'0');";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, use);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public void AddAccount(String use, String pass,String issell, String isadmin, String name, String phone, String address) {
        String query = "INSERT INTO `tmdt`.`account` (`user`, `pass`, `isSell`, `isAdmin`, `name`, `sdt`, `diaChi`, `lock`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?,0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, use);
            ps.setString(2, pass);
            ps.setString(3, issell);
            ps.setString(4, isadmin);
            ps.setString(5, name);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account Checklogin(String user) {
        String query = "SELECT * FROM  `tmdt`.`account` where user = ?";
        Account a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }

        return a;
    }

    public Account getAccountbyID(String id) {
        String query = "SELECT * FROM tmdt.account where uID = ?;";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void settingAccount(String user, String pass, String name, String phone, String address, String id) {
        String query = "UPDATE `tmdt`.`account` SET `user` = ?, `pass` = ?, `name` = ?, `sdt` = ? , `diaChi` = ? "
                + "WHERE (`uID` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editAccount(String user, String pass,String isSell, String isAdmin, String name, String phone, String address, String id) {
        String query = "UPDATE `tmdt`.`account` SET `user` = ?, `pass` = ?,`isSell` = ?, `isAdmin` = ?, `name` = ?, `sdt` = ? , `diaChi` = ? "
                + "WHERE (`uID` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, name);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public List<Account> getAccount(){
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.account;";
        
         try { 
            ps = connection.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next() ) {                
               list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }       
        return list;
    }
     public List<Account> getAccountByIDAdmin(){
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.account where uID != 1;";
        
         try { 
            ps = connection.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next() ) {                
               list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }       
        return list;
    }
     public List<Account> getAccountByUser(){
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM tmdt.account where isAdmin = 0;";
        
         try { 
            ps = connection.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next() ) {                
               list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
     public void DeleteAccount (String id){
        String query = "delete from tmdt.account where uID = ?; ";
        try {
            ps = connection.prepareStatement(query); 
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public AccountLock LockAccount(String id) {
        String query = "SELECT tmdt.account.lock FROM  `tmdt`.`account` where uID = ?";
        AccountLock a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountLock(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return a;
    }
      public AccountLock LockAccountByUser(String id) {
        String query = "SELECT tmdt.account.lock FROM  `tmdt`.`account` where user = ?";
        AccountLock a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountLock(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return a;
    }
      public void LockA(int lock, String id) {
        String query = "UPDATE `tmdt`.`account` SET `lock` = ? WHERE (`uID` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, lock);
            ps.setString(2, id);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
      public AccountSellID CheckSeller(String id) {
        String query = "SELECT tmdt.account.isSell FROM  `tmdt`.`account` where uID = ?";
        AccountSellID a = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountSellID(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return a;
    }
      public void SigupSeller(int sell, String id) {
        String query = "UPDATE `tmdt`.`account` SET `isSell` = ? WHERE (`uID` = ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, sell);
            ps.setString(2, id);          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
