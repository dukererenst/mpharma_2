/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.customer;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.customer.Customer;
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
@Named(value = "customerController")
@SessionScoped
public class customerController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -7339304365200462940L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private Customer customer;
    
    /**
     * Creates a new instance of customerController
     */
    public customerController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(customer);
        if(mPharmaService.save(customer) != null)
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
        customer = new Customer();
    }

    @Override
    public void editMethod(EntityModel em) {
        customer = (Customer) em;
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
        return mPharmaService.findAll(Customer.class);
    }
    
}
