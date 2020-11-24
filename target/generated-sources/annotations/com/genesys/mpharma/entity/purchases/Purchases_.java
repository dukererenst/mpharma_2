package com.genesys.mpharma.entity.purchases;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.inventory.WareHouse;
import com.genesys.mpharma.entity.purchases.PurchaseTransaction;
import com.genesys.mpharma.entity.suppliers.Supplier;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-29T16:24:16")
@StaticMetamodel(Purchases.class)
public class Purchases_ extends EntityModel_ {

    public static volatile SingularAttribute<Purchases, PurchaseTransaction> purchaseTransaction;
    public static volatile SingularAttribute<Purchases, String> note;
    public static volatile SingularAttribute<Purchases, Double> totalAmount;
    public static volatile SingularAttribute<Purchases, Date> purchaseDate;
    public static volatile SingularAttribute<Purchases, Supplier> supplier;
    public static volatile SingularAttribute<Purchases, WareHouse> wareHouse;

}