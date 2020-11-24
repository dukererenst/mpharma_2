/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.inventory;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.ProductCategory;
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
@Named(value = "productCategoryController")
@SessionScoped
public class ProductCategoryController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = 9145486857637720622L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private ProductCategory productCategory;
    /**
     * Creates a new instance of ProductCategory
     */
    public ProductCategoryController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(productCategory);
        if(mPharmaService.save(productCategory) != null){
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        productCategory = new ProductCategory();
    }

    @Override
    public void editMethod(EntityModel em) {
        productCategory = (ProductCategory) em;
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
        return mPharmaService.findAll(ProductCategory.class);
    }
    
}
