/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.suppliers.SupplierProduct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=SupplierProduct.class)
public class SupplierProductConvertor extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        SupplierProduct supplierProduct   = (SupplierProduct) value;
        if (supplierProduct != null){
            if (component.getId().toLowerCase().contains("name")){
                return supplierProduct.toString();
            }
            return supplierProduct.getId();
        }
        return null;
    }
}
