/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.suppliers.Supplier;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=Supplier.class)
public class SupplierConvertor extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        Supplier supplier   = (Supplier) value;
        if (supplier != null){
            if (component.getId().toLowerCase().contains("name")){
                return supplier.toString();
            }
            return supplier.getId();
        }
        return null;
    }
}
