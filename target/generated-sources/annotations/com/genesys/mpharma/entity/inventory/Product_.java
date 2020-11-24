package com.genesys.mpharma.entity.inventory;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.inventory.ProductCategory;
import com.genesys.mpharma.entity.manufacturer.Manufacturer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-29T16:24:16")
@StaticMetamodel(Product.class)
public class Product_ extends EntityModel_ {

    public static volatile SingularAttribute<Product, ProductCategory> medicineCategory;
    public static volatile SingularAttribute<Product, Integer> minLevel;
    public static volatile SingularAttribute<Product, String> note;
    public static volatile SingularAttribute<Product, Integer> reOrderLevel;
    public static volatile SingularAttribute<Product, Manufacturer> medicineCompany;
    public static volatile SingularAttribute<Product, String> genericName;
    public static volatile SingularAttribute<Product, String> medicineName;

}