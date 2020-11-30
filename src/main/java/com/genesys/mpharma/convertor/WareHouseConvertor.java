/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.inventory.WareHouse;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author darlington.otchere
 */
@FacesConverter(forClass=WareHouse.class)
public class WareHouseConvertor extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        WareHouse wareHouse   = (WareHouse) value;
        if (wareHouse != null){
            if (component.getId().toLowerCase().contains("name")){
                return wareHouse.toString();
            }
            return wareHouse.getId();
        }
        return null;
    }
}
