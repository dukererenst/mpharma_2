package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.purchases.Purchases;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-26T22:10:53")
@StaticMetamodel(PurchaseItem.class)
public class PurchaseItem_ extends EntityModel_ {

    public static volatile SingularAttribute<PurchaseItem, Double> totalAmount;
    public static volatile SingularAttribute<PurchaseItem, Integer> approved;
    public static volatile SingularAttribute<PurchaseItem, Integer> quantity;
    public static volatile SingularAttribute<PurchaseItem, SupplierProduct> supplierProduct;
    public static volatile SingularAttribute<PurchaseItem, Purchases> purchases;
    public static volatile SingularAttribute<PurchaseItem, Double> unitCostPrice;

}