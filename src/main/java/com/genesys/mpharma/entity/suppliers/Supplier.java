/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.suppliers;

import com.genesys.mpharma.entity.EntityModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "supplier_information")
@Entity
@Getter
@Setter
public class Supplier extends EntityModel {

    private static final long serialVersionUID = 1L;

    @Column(name = "supplier_name")
    private String supplierName;
    
    @Column(name = "supplier_code")
    private String supplierCode;
    
    @Column(name = "supplier_telephone")
    private String supplierTelephone;
    
    @Column(name = "supplier_email_address")
    private String supplierEmailAddress;
    
    @Column(name = "supplier_location")
    private String supplierLocation;

    @Override
    public String toString() {
        return supplierName;
    } 
}
