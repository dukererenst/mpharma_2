/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller.setting;

import com.genesys.mpharma.abstracts.MPharmaMethods;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.setting.BankAccount;
import com.genesys.mpharma.entity.setting.BankBranch;
import com.genesys.mpharma.service.IdGenerator;
import com.genesys.mpharma.service.MPharmaService;
import com.genesys.mpharma.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "bankAccountController")
@SessionScoped
public class BankAccountController implements Serializable, MPharmaMethods {

    private static final long serialVersionUID = -2495950166863018994L;
    
    @Inject
    private MPharmaService mPharmaService;
    
    @Inject
    private IdGenerator idGenerator;
    
    @Getter
    @Setter
    private BankAccount bankAccount = new BankAccount();
    
    @Getter
    private List<BankBranch> bankBranches = new ArrayList<>();

    /**
     * Creates a new instance of BankAccountController
     */
    public BankAccountController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(bankAccount);
        if(mPharmaService.save(bankAccount) != null){
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        bankAccount = new BankAccount();
    }

    @Override
    public void editMethod(EntityModel em) {
        bankAccount = (BankAccount) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if(mPharmaService.delete(em)){
            Msg.successDelete();
        }else{
            Msg.failedDelete();
        }
    }

    @Override
    public List findAll() {
       return mPharmaService.findAll(BankAccount.class);
    }
    
    public void loadBankBranches() {
        
        if(bankAccount.getBank() == null) bankBranches = new ArrayList<>();
       
        bankBranches = mPharmaService.getBankBranchesByBank(bankAccount.getBank());
    }
    
}
