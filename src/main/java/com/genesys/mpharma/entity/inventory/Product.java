/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.inventory;

import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.manufacturer.Manufacturer;
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
@Table(name = "medicine")
@Entity
@Getter
@Setter
public class Product extends EntityModel {

    private static final long serialVersionUID = 1L;

    @Column(name = "medicine_name")
    private String medicineName;

    @JoinColumn(name = "medicine_category")
    @ManyToOne
    private ProductCategory medicineCategory;

    @JoinColumn(name = "medicine_company")
    @ManyToOne
    private Manufacturer medicineCompany;

    @Column(name = "generic_name")
    private String genericName;

    @Column(name = "min_level")
    private int minLevel;

    @Column(name = "re_order_level")
    private int reOrderLevel;

    @Column(name = "note")
    private String note;

    @Override
    public String toString() {
        return medicineName;
    }
    
    
}
