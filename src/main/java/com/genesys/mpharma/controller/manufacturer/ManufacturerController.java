/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.manufacturer;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.manufacturer.Manufacturer;
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
@Named(value = "manufacturerController")
@SessionScoped
public class ManufacturerController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -5740273106041313145L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private Manufacturer manufacturer = new Manufacturer();

    /**
     * Creates a new instance of ManufacturerController
     */
    public ManufacturerController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(manufacturer);
        if(mPharmaService.save(manufacturer) != null){
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        manufacturer = new Manufacturer();
    }

    @Override
    public void editMethod(EntityModel em) {
        manufacturer = (Manufacturer) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if (mPharmaService.delete(em)) {
            Msg.successDelete();
        } else {
            Msg.failedDelete();
        }
    }

    @Override
    public List findAll() {
        return mPharmaService.findAll(Manufacturer.class);
    }
    
}
