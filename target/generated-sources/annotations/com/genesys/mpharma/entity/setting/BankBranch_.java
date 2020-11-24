package com.genesys.mpharma.entity.setting;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.setting.Bank;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-29T16:24:16")
@StaticMetamodel(BankBranch.class)
public class BankBranch_ extends EntityModel_ {

    public static volatile SingularAttribute<BankBranch, Bank> bank;
    public static volatile SingularAttribute<BankBranch, String> emailAddress;
    public static volatile SingularAttribute<BankBranch, String> branchName;
    public static volatile SingularAttribute<BankBranch, String> telephone;
    public static volatile SingularAttribute<BankBranch, String> location;

}