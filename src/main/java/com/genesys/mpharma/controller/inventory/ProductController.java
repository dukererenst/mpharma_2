/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.inventory;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.Product;
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
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = 1446081772077423616L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private Product product = new Product();

    /**
     * Creates a new instance of ProductController
     */
    public ProductController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(product);
        if(mPharmaService.save(product) != null)
        {
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        product = new Product();
    }

    @Override
    public void editMethod(EntityModel em) {
        product = (Product) em;
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
        return mPharmaService.findAll(Product.class);
    }
    
}
