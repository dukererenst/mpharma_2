/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.setting;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.setting.MobileNetworkAccount;
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
@Named(value = "mobileNetworkAccountController")
@SessionScoped
public class MobileNetworkAccountController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = 2697969993469398590L;

    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private MobileNetworkAccount mobileNetworkAccount = new MobileNetworkAccount();
    
    /**
     * Creates a new instance of BankController
     */
    public MobileNetworkAccountController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(mobileNetworkAccount);
        if (mPharmaService.save(mobileNetworkAccount) != null) {
            Msg.successSave();
            clearMethod();
        } else {
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        mobileNetworkAccount = new MobileNetworkAccount();
    }

    @Override
    public void editMethod(EntityModel em) {
        mobileNetworkAccount = (MobileNetworkAccount) em;
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
        return mPharmaService.findAll(MobileNetworkAccount.class);
    }
    
}
