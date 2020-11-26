package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.enums.TransactionType;
import com.genesys.mpharma.entity.suppliers.Supplier;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-26T17:36:43")
@StaticMetamodel(PurchaseTransaction.class)
public class PurchaseTransaction_ extends EntityModel_ {

    public static volatile SingularAttribute<PurchaseTransaction, TransactionType> transactionType;
    public static volatile SingularAttribute<PurchaseTransaction, Double> totalAmount;
    public static volatile SingularAttribute<PurchaseTransaction, Supplier> supplier;
    public static volatile SingularAttribute<PurchaseTransaction, Date> transactionDate;

}