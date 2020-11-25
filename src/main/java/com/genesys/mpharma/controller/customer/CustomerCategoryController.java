/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.customer;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.customer.CustomerCategory;
import com.genesys.mpharma.service.IdGenerator;
import com.genesys.mpharma.service.MPharmaService;
import com.genesys.mpharma.util.Msg;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "customerCategoryController")
@SessionScoped
public class CustomerCategoryController implements Serializable, MPharmaMethods{

    private static final long serialVersionUID = 3485362041598818437L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private CustomerCategory customerCategory = new CustomerCategory();

    /**
     * Creates a new instance of CustomerCategoryController
     */
    public CustomerCategoryController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(customerCategory);
        if(mPharmaService.save(customerCategory) != null)
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
        customerCategory = new CustomerCategory();
    }

    @Override
    public void editMethod(EntityModel em) {
        customerCategory = (CustomerCategory) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if(mPharmaService.delete(em))
        {
            Msg.successDelete();
        }
        else{
            Msg.failedDelete();
        }
    }

    @Override
    public List findAll() {
        return mPharmaService.findAll(CustomerCategory.class);
    }
    
}
