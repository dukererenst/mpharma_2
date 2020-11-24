/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.inventory;

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
@Table(name = "warehouse")
@Entity
@Getter
@Setter
public class WareHouse extends EntityModel{
    
    @Column(name = "warehouse_name")
    private String wareHouseName;
    
    @Column(name = "warehouse_code")
    private String wareHouseCode;
    
    @Column(name = "warehouse_lcoation")
    private String wareHouseLocation;
}
