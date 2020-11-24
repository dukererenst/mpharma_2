/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.setting;

import com.genesys.mpharma.entity.EntityModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "bank_account")
@Entity
@Getter
@Setter
public class BankAccount extends EntityModel{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "account_name")
    private String accountName; 
    
    @Column(name = "account_number")
    private String accountNumber; 
    
    @JoinColumn(name = "bank")
    @ManyToOne
    private Bank bank; 
    
    @JoinColumn(name = "bank_branch")
    private BankBranch bankBranch; 
}
