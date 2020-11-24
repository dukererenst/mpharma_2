/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.manufacturer;

import com.genesys.mpharma.entity.EntityModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Table(name = "manufacturer_information")
@Entity
@Getter
@Setter
public class Manufacturer extends EntityModel {
    
    private static final long serialVersionUID = 7593933453310232383L;
    
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    
    @Column(name = "manufacturer_code")
    private String manufacturerCode;
    
    @Column(name = "manufacturer_telephone")
    private String manufacturerTelephone;
    
    @Column(name = "manufacturer_email_address")
    private String manufacturerEmailAddress;
    
    @Column(name = "manufacturer_location")
    private String manufacturerLocation;

    @Override
    public String toString() {
        return manufacturerName;
    }
    
    
    
}
