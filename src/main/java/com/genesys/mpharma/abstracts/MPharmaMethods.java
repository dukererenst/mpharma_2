/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.abstracts;

import com.genesys.mpharma.entity.EntityModel;
import java.util.List;

/**
 *
 * @author Darlington
 */
public interface MPharmaMethods {
    void saveMethod();
    
    void clearMethod();

    void editMethod(EntityModel em);

    void deleteMethod(EntityModel em);

    List findAll();

}
