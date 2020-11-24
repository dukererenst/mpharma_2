/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
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
@Table(name = "purchase_items")
@Entity
@Getter
@Setter
public class PurchaseItem extends EntityModel {

    @Column(name = "unit_cost_price")
    private Double unitCostPrice;
    
    @Column(name = "total_amount")
    private Double totalAmount;
    
    @Column(name = "quantity")
    private int quantity;
    
     @Column(name = "approved")
    private int approved;
    

    @JoinColumn(name = "supplier_product")
    @ManyToOne
    private SupplierProduct supplierProduct;
    
    @JoinColumn(name = "purchases")
    @ManyToOne
    private Purchases purchases;
   
}
