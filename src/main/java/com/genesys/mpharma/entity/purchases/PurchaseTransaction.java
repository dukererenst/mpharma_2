/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.suppliers.Supplier;
import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.enums.TransactionType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "purchase_transaction")
@Entity
@Getter
@Setter
public class PurchaseTransaction extends EntityModel {

    private static final long serialVersionUID = -9012881333779282150L;

    @Column(name = "total_amount")
    private Double totalAmount;
    
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @JoinColumn(name = "supplier")
    @ManyToOne
    private Supplier supplier;
    
     @Column(name = "transaction_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
}
