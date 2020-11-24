/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.setting;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.setting.BankBranch;
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
@Named(value = "bankBranchController")
@SessionScoped
public class BankBranchController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = 2697969993469398590L;

    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private BankBranch bankBranch = new BankBranch();
    
    /**
     * Creates a new instance of BankController
     */
    public BankBranchController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(bankBranch);
        if (mPharmaService.save(bankBranch) != null) {
            Msg.successSave();
            clearMethod();
        } else {
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        bankBranch = new BankBranch();
    }

    @Override
    public void editMethod(EntityModel em) {
        bankBranch = (BankBranch) em;
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
        return mPharmaService.findAll(BankBranch.class);
    }
    
}
