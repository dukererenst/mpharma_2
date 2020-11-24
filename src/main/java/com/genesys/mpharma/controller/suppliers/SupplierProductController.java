/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.suppliers;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
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
@Named(value = "supplierProductController")
@SessionScoped
public class SupplierProductController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -6639558530017982822L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private SupplierProduct supplierProduct = new SupplierProduct();
    
    /**
     * Creates a new instance of PurchasesController
     */
    public SupplierProductController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(supplierProduct);
        if (mPharmaService.save(supplierProduct) != null) {
            Msg.successSave();
            clearMethod();
        } 
        else {
            Msg.failedDelete();
        }
    }

    @Override
    public void clearMethod() {
        supplierProduct = new SupplierProduct();
    }

    @Override
    public void editMethod(EntityModel em) {
        supplierProduct = (SupplierProduct) em;
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
        return mPharmaService.findAll(SupplierProduct.class);
    }
    
}
