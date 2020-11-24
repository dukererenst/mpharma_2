/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.convertor;

import com.genesys.mpharma.entity.setting.Bank;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author Darlington
 */
@FacesConverter(forClass=Bank.class)
public class BankConvertor extends SelectItemsConverter{
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        Bank bank   = (Bank) value;
        if (bank != null){
            if (component.getId().toLowerCase().contains("name")){
                return bank.toString();
            }
            return bank.getId();
        }
        return null;
    }  
}
