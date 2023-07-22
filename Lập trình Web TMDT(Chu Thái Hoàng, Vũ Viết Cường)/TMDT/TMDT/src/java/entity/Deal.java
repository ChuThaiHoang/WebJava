/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author eotke
 */
public class Deal {
    private int id,AccountID,ProductID,amount,checkPay;

    public Deal(int id, int AccountID, int ProductID, int amount, int checkPay) {
        this.id = id;
        this.AccountID = AccountID;
        this.ProductID = ProductID;
        this.amount = amount;
        this.checkPay = checkPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCheckPay() {
        return checkPay;
    }

    public void setCheckPay(int checkPay) {
        this.checkPay = checkPay;
    }

   
    
   
    
}
