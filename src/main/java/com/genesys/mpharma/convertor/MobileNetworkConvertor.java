/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.setting.MobileNetwork;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=MobileNetwork.class)
public class MobileNetworkConvertor extends SelectItemsConverter{
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        MobileNetwork mobileNetwork   = (MobileNetwork) value;
        if (mobileNetwork != null){
            if (component.getId().toLowerCase().contains("name")){
                return mobileNetwork.toString();
            }
            return mobileNetwork.getId();
        }
        return null;
    }  
}
