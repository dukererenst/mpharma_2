/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.suppliers.Supplier;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.WareHouse;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "purchase")
@Entity
@Getter
@Setter
public class Purchases extends EntityModel {

    @JoinColumn(name = "supplier")
    @ManyToOne
    private Supplier supplier;
    
    @JoinColumn(name = "ware_house")
    @ManyToOne
    private WareHouse wareHouse;
    
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    @Column(name = "note")
    private String note;
    
    @JoinColumn(name = "transaction")
    @ManyToOne
    private PurchaseTransaction purchaseTransaction;
    
    @Column(name = "total_amount")
    private Double totalAmount;
}
