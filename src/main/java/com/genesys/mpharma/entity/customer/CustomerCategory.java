/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.customer;

import com.genesys.mpharma.entity.EntityModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ErnestDuker
 */
@Table(name = "category_category")
@Entity
@Getter
@Setter
public class CustomerCategory extends EntityModel{
  @Column(name = "category_name")
    private String catgeoryName;
    
    @Column(name = "category_code")
    private String catgeoryCode;  
    
    @Column(name = "credit_limit")
    private Double creditLimit;  
}
