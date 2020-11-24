/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.inventory.ProductCategory;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=ProductCategory.class)
public class ProductCategoryConvertor extends SelectItemsConverter{
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        ProductCategory category   = (ProductCategory) value;
        if (category != null){
            if (component.getId().toLowerCase().contains("name")){
                return category.toString();
            }
            return category.getId();
        }
        return null;
    }  
}
