/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.service;

import com.genesys.mpharma.entity.EntityModel;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.ejb.Stateless;

/**
 *
 * @author Darlington
 */
@Stateless
public class IdGenerator implements Serializable {
    private static final long serialVersionUID = 1L;
   
    public void uniqueEntityId(EntityModel entityModel) {
        if (Strings.isNullOrEmpty(entityModel.getId())) {
            entityModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            entityModel.setCreatedOn(new Date());
        } 
        else {
            entityModel.setUpdatedOn(new Date());
        }
    }  
}
