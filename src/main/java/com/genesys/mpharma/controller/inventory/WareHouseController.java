/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.inventory;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.WareHouse;
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
@Named(value = "wareHouseController")
@SessionScoped
public class WareHouseController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -6321321926842103676L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private WareHouse wareHouse = new WareHouse();

    /**
     * Creates a new instance of WareHouseController
     */
    public WareHouseController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(wareHouse);
        if (mPharmaService.save(wareHouse) != null) {
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        wareHouse = new WareHouse();
    }

    @Override
    public void editMethod(EntityModel em) {
        wareHouse = (WareHouse) em;
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
        return mPharmaService.findAll(WareHouse.class);
    }
    
}
