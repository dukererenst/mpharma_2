/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.suppliers;

import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.Product;
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

@Table(name = "supplier_product")
@Entity
@Getter
@Setter
public class SupplierProduct extends EntityModel{

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier; 
    
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product; 

    @Override
    public String toString() {
        return product.getMedicineName();
    }  
}
