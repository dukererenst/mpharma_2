/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.purchases;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.purchases.Purchases;
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
    
    /**
     * Creates a new instance of PurchasesController
     */
    public PurchasesController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(purchases);
        if (mPharmaService.save(purchases) != null) {
            Msg.successSave();
            clearMethod();
        } 
        else {
            Msg.failedDelete();
        }
    }

    @Override
    public void clearMethod() {
        purchases = new Purchases();
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
    
}
