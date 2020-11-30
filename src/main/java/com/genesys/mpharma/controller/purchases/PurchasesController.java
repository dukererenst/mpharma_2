/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.purchases;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.enums.TransactionType;
import com.genesys.mpharma.entity.inventory.WareHouse;
import com.genesys.mpharma.entity.purchases.PurchaseItem;
import com.genesys.mpharma.entity.purchases.PurchaseTransaction;
import com.genesys.mpharma.entity.purchases.Purchases;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
import com.genesys.mpharma.service.IdGenerator;
import com.genesys.mpharma.service.MPharmaService;
import com.genesys.mpharma.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "purchasesController")
@SessionScoped
public class PurchasesController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -6639558530017982822L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private Purchases purchases = new Purchases();
    
    @Getter
    @Setter
    private PurchaseItem purchaseItem = new PurchaseItem();
    
    @Getter
    @Setter
    private List<PurchaseItem> purchaseItems = new ArrayList<>();
    
    @Getter
    private List<SupplierProduct> supplierProducts = new ArrayList<>();
    
    @Getter
    @Setter
    private String date;
    
    @Getter
    @Setter
    private TransactionType transactionType;
    
    private static double totalAmount;
    
    PurchaseTransaction purchaseTransaction  = new PurchaseTransaction();
    
    /**
     * Creates a new instance of PurchasesController
     */
    public PurchasesController() {
    }

    @Override
    public void saveMethod() {
        try {
            convertDate();
        } catch (ParseException ex) {
            Logger.getLogger(PurchasesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idGenerator.uniqueEntityId(purchaseTransaction);
        purchaseTransaction.setTotalAmount(totalAmount);
        purchaseTransaction.setSupplier(purchases.getSupplier());
        purchaseTransaction.setTransactionDate(purchases.getPurchaseDate());
        purchaseTransaction.setCreatedOn(new Date());
        
        if (mPharmaService.save(purchaseTransaction) != null) {
            idGenerator.uniqueEntityId(purchases);
            purchases.setTotalAmount(totalAmount);
            purchases.setPurchaseTransaction(purchaseTransaction);
            
            if (mPharmaService.save(purchases) != null) {
                saveItems();
                Msg.successSave();
                clearMethod();
            } 
            else {
                Msg.failedDelete();
            }
        }
        else{
            Msg.failedDelete();
        }
    }

    @Override
    public void clearMethod() {
        purchases = new Purchases();
        supplierProducts = new ArrayList<>();
        date = "";
        totalAmount = 0.0;
        transactionType = null;
        purchaseTransaction = new PurchaseTransaction();
    }

    @Override
    public void editMethod(EntityModel em) {
        purchases = (Purchases) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if (mPharmaService.delete(em)) {
            Msg.successSave();
        } else {
            Msg.failedDelete();
        }
    }

    @Override
    public List findAll() {
        return mPharmaService.findAll(Purchases.class);
    }
    
    public void addPurchaseItem(){
        purchaseItems.add(purchaseItem);
        totalAmount = totalAmount + purchaseItem.getTotalAmount();
        purchaseItem = new PurchaseItem();
        updateDate();
    }
    
    public void saveItems(){
        for (PurchaseItem item : purchaseItems) {
            item.setPurchases(purchases);
            item.setCreatedOn(new Date());
            idGenerator.uniqueEntityId(item);
            mPharmaService.save(item);
        }
        purchaseItems = new ArrayList<>();
    }
    
    public void updateCost(){
        if(purchaseItem.getUnitCostPrice() != null && purchaseItem.getQuantity() != 0){
            double value = purchaseItem.getUnitCostPrice()*purchaseItem.getQuantity();
            purchaseItem.setTotalAmount(value);
        }
        else{
            purchaseItem.setTotalAmount(0.0);
        }
    }
    
    public void loadSupplierProducts() {
        if(purchases.getSupplier() != null){
            supplierProducts = mPharmaService.getSupplierProductBySupplier(purchases.getSupplier());
        }else{
            supplierProducts = new ArrayList<>();
        }
    }
    
    public void convertDate() throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = format.parse(date);
        purchases.setPurchaseDate(convertedDate);
    }
    
    private void updateDate(){
        setDate(date);
    }
    
    public void updatePurchaseForm(){
        purchases.setWareHouse(purchases.getWareHouse());
        purchases.setNote(purchases.getNote());
    }
    
    public void removePurchaseItem(PurchaseItem item){
        purchaseItems.remove(item);
    }
    
    public void updateTransactionType(){
        purchaseTransaction.setTransactionType(transactionType);
        setTransactionType(transactionType);
    }
}
