/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.entity.enums;

/**
 *
 * @author Ernest
 */
public enum CustomerStatus {
  PENDING("Pending"),
  APPROVED("Approved"),
  DISAPPROVED("Disapproved"),
  REJECTED("Rejected");
  
  private String label;

    private CustomerStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return  label ;
    }
  
  
  
}
