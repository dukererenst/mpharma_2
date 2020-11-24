/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.purchases;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.purchases.PurchaseTransaction;
import com.genesys.mpharma.service.IdGenerator;
import com.genesys.mpharma.service.MPharmaService;
import com.genesys.mpharma.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "purchaseTransactionController")
@SessionScoped
public class PurchaseTransactionController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -3710736332315081136L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private PurchaseTransaction purchaseTransaction = new PurchaseTransaction();

    /**
     * Creates a new instance of PurchaseTransactionController
     */
    public PurchaseTransactionController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(purchaseTransaction);
        if (mPharmaService.save(purchaseTransaction) != null) {
            Msg.successSave();
            clearMethod();
        } else {
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        purchaseTransaction = new PurchaseTransaction();
    }

    @Override
    public void editMethod(EntityModel em) {
        purchaseTransaction = (PurchaseTransaction) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if (mPharmaService.delete(em)) {
            Msg.successDelete();
        } 
        else {
            Msg.failedDelete();
        }
    }

    @Override
    public List findAll() {
        return mPharmaService.findAll(PurchaseTransaction.class);
    }
    
}
