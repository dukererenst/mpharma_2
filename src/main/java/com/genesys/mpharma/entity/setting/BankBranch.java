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
@Table(name = "bank_branch")
@Entity
@Getter
@Setter
public class BankBranch extends EntityModel{

    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "bank")
    @ManyToOne
    private Bank bank; 
    
    @Column(name = "branch_name")
    private String branchName; 
    
    @Column(name = "telephone")
    private String telephone; 
    
    @Column(name = "email_address")
    private String emailAddress; 
    
    @Column(name = "location")
    private String location; 
}
