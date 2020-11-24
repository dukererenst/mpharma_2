/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.manufacturer.Manufacturer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=Manufacturer.class)
public class ManufacturerConvertor extends SelectItemsConverter{
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        Manufacturer manufacturer   = (Manufacturer) value;
        if (manufacturer != null){
            if (component.getId().toLowerCase().contains("name")){
                return manufacturer.toString();
            }
            return manufacturer.getId();
        }
        return null;
    }  
}
