/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.commons;

import com.genesys.mpharma.entity.customer.CustomerCategory;
import com.genesys.mpharma.entity.enums.CustomerGroup;
import com.genesys.mpharma.entity.enums.CustomerStatus;
import com.genesys.mpharma.entity.enums.TransactionType;
import com.genesys.mpharma.entity.inventory.Product;
import com.genesys.mpharma.entity.inventory.ProductCategory;
import com.genesys.mpharma.entity.inventory.WareHouse;
import com.genesys.mpharma.entity.manufacturer.Manufacturer;
import com.genesys.mpharma.entity.purchases.Purchases;
import com.genesys.mpharma.entity.setting.Bank;
import com.genesys.mpharma.entity.setting.MobileNetwork;
import com.genesys.mpharma.entity.suppliers.Supplier;
import com.genesys.mpharma.service.MPharmaService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Darlington
 */
@Named(value = "commonOptions")
@SessionScoped
public class CommonOptions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of CommonOptions
     */
    @Inject 
    private MPharmaService mPharmaService;
    
    public CommonOptions() {
    }

    public List<Bank> getAllBank()
    {
        return mPharmaService.findAll(Bank.class);
    }
    
    public List<MobileNetwork> getMobileNetworks(){
        return mPharmaService.findAll(MobileNetwork.class);
    }
    
    public List<ProductCategory> getProductCategories(){
        return mPharmaService.findAll(ProductCategory.class);
    }
    
    public List<Manufacturer> getManufacturers(){
        return mPharmaService.findAll(Manufacturer.class);
    }
    
    public List<Supplier> getSuppliers(){
        return mPharmaService.findAll(Supplier.class);
    }
    
    public List<Product> getProducts(){
        return mPharmaService.findAll(Product.class);
    }
    
    public List<CustomerGroup> getCustomerGroups(){
        return Arrays.asList(CustomerGroup.values());
    }
    
    public List<CustomerCategory> getCustomerCategories(){
        return mPharmaService.findAll(CustomerCategory.class);
    }
    
    public List<WareHouse> getWarehouses(){
        return mPharmaService.findAll(WareHouse.class);
    }
    
    public List<CustomerStatus> getCustomerStatuses(){
        return Arrays.asList(CustomerStatus.values());
    }
    
    public List<TransactionType> getTransactionTypes(){
        return Arrays.asList(TransactionType.values());
    }
    
    public List<Purchases> getPurchaseses(){
        return mPharmaService.findAll(Purchases.class);
    }
}
