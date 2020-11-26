package com.genesys.mpharma.entity.setting;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.setting.Bank;
import com.genesys.mpharma.entity.setting.BankBranch;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-25T23:29:45")
@StaticMetamodel(BankAccount.class)
public class BankAccount_ extends EntityModel_ {

    public static volatile SingularAttribute<BankAccount, Bank> bank;
    public static volatile SingularAttribute<BankAccount, String> accountName;
    public static volatile SingularAttribute<BankAccount, BankBranch> bankBranch;
    public static volatile SingularAttribute<BankAccount, String> accountNumber;

}