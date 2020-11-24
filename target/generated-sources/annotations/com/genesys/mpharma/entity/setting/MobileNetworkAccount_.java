package com.genesys.mpharma.entity.setting;

import com.genesys.mpharma.entity.EntityModel_;
import com.genesys.mpharma.entity.setting.MobileNetwork;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-29T16:24:16")
@StaticMetamodel(MobileNetworkAccount.class)
public class MobileNetworkAccount_ extends EntityModel_ {

    public static volatile SingularAttribute<MobileNetworkAccount, String> phoneNumber;
    public static volatile SingularAttribute<MobileNetworkAccount, String> accountName;
    public static volatile SingularAttribute<MobileNetworkAccount, MobileNetwork> mobileNetwork;

}