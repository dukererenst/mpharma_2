package com.genesys.mpharma.entity.suppliers;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.inventory.Product;
import com.genesys.mpharma.entity.suppliers.Supplier;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-26T17:36:43")
@StaticMetamodel(SupplierProduct.class)
public class SupplierProduct_ extends EntityModel_ {

    public static volatile SingularAttribute<SupplierProduct, Product> product;
    public static volatile SingularAttribute<SupplierProduct, Supplier> supplier;

}