/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.purchases;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.purchases.PurchaseItem;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
import com.genesys.mpharma.service.IdGenerator;
import com.genesys.mpharma.service.MPharmaService;
import com.genesys.mpharma.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "purchaseItemController")
@SessionScoped
public class PurchaseItemController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -7497982333229030504L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private PurchaseItem purchaseItem = new PurchaseItem();
    
    @Getter
    private List<SupplierProduct> supplierProducts = new ArrayList<>();

    /**
     * Creates a new instance of PurchaseItemController
     */
    public PurchaseItemController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(purchaseItem);
        if(mPharmaService.save(purchaseItem)){
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        purchaseItem = new PurchaseItem();
    }

    @Override
    public void editMethod(EntityModel em) {
        purchaseItem = (PurchaseItem) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if(mPharmaService.delete(em)){
            Msg.successDelete();
        }
        else{
            Msg.failedDelete();       
        }
    }

    @Override
    public List findAll() {
        return mPharmaService.findAll(PurchaseItem.class);
    }
    
    public void loadSupplierProducts(){
        
        if(purchaseItem.getSupplierProduct().getSupplier() == null) supplierProducts = new ArrayList<>();
        
        supplierProducts = mPharmaService.getSupplierProductBySupplier(purchaseItem.getSupplierProduct().getSupplier());
    }
    
}
