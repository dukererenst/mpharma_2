/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.suppliers;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.suppliers.Supplier;
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
@Named(value = "supplierController")
@SessionScoped
public class SupplierController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -6639558530017982822L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private Supplier supplier = new Supplier();
    
    /**
     * Creates a new instance of PurchasesController
     */
    public SupplierController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(supplier);
        if (mPharmaService.save(supplier) != null) {
            Msg.successSave();
            clearMethod();
        } 
        else {
            Msg.failedDelete();
        }
    }

    @Override
    public void clearMethod() {
        supplier = new Supplier();
    }

    @Override
    public void editMethod(EntityModel em) {
        supplier = (Supplier) em;
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
        return mPharmaService.findAll(Supplier.class);
    }
    
}
