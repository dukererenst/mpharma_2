/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.customer;

import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.enums.CustomerGroup;
import com.genesys.mpharma.entity.enums.CustomerStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "customer_information")
@Entity
@Getter
@Setter
public class Customer extends EntityModel {

    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_group")
    @Enumerated(EnumType.STRING)
    private CustomerGroup customerGroup;
    
    @JoinColumn(name = "customer_category")
    @ManyToOne
    private CustomerCategory customerCategory;
    
    @Column(name = "email_address")
    private String emailAddress;
    
    @Column(name = "primary_telephone")
    private String primaryTelephone;
    
    @Column(name = "secondary_telephone")
    private String secondaryTelephone;
    
    @Column(name = "ghana_post_code")
    private String ghanaPostCode;
    
    @Column(name = "physical_address")
    private String physicalAddress;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
}
