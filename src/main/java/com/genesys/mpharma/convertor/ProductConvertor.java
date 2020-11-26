/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.inventory.Product;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=Product.class)
public class ProductConvertor extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        Product product   = (Product) value;
        if (product != null){
            if (component.getId().toLowerCase().contains("name")){
                return product.toString();
            }
            return product.getId();
        }
        return null;
    }
}
