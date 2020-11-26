package com.genesys.mpharma.entity.customer;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.customer.CustomerCategory;
import com.genesys.mpharma.entity.enums.CustomerGroup;
import com.genesys.mpharma.entity.enums.CustomerStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-25T23:29:45")
@StaticMetamodel(Customer.class)
public class Customer_ extends EntityModel_ {

    public static volatile SingularAttribute<Customer, CustomerStatus> customerStatus;
    public static volatile SingularAttribute<Customer, String> emailAddress;
    public static volatile SingularAttribute<Customer, String> secondaryTelephone;
    public static volatile SingularAttribute<Customer, String> primaryTelephone;
    public static volatile SingularAttribute<Customer, CustomerGroup> customerGroup;
    public static volatile SingularAttribute<Customer, String> physicalAddress;
    public static volatile SingularAttribute<Customer, String> ghanaPostCode;
    public static volatile SingularAttribute<Customer, CustomerCategory> customerCategory;
    public static volatile SingularAttribute<Customer, String> customerName;

}