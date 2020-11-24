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
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "mobile_network")
@Entity
@Getter
@Setter
public class MobileNetworkAccount extends EntityModel{
    
    @Column(name = "account_name")
    private String accountName; 
    
    @Column(name = "phone_number")
    private String phoneNumber; 
    
    @JoinColumn(name = "mobile_network")
    private MobileNetwork mobileNetwork; 
    
    
}
