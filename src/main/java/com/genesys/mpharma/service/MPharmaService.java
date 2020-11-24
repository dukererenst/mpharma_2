/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.service;

import com.genesys.mpharma.entity.EntityModel;
import com.genesys.mpharma.entity.inventory.Product;
import com.genesys.mpharma.entity.setting.Bank;
import com.genesys.mpharma.entity.setting.BankBranch;
import com.genesys.mpharma.entity.suppliers.Supplier;
import com.genesys.mpharma.entity.suppliers.SupplierProduct;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Darlington
 */
@Stateless
public class MPharmaService implements Serializable{

    private static final long serialVersionUID = -325932686565786895L;
    
    @PersistenceContext(name = "com.genesys_mpharma_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public Boolean delete(EntityModel information) {
        try {
            information.setDeleted(Boolean.TRUE);
            em.merge(information);
            em.flush();
            em.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> t, Object id) {
        try {

            if (em == null) return null;
            
            return (T) em.find(t, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> T save(Object model) {
        try {
            return saveEntity(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> T saveEntity(Object object) {
        em.merge(object);
        em.flush();
        return (T) object;
    }

    public List findAll(Class t) {
        try {
            String qry = "SELECT e FROM " + t.getSimpleName() + " e"
                    + " WHERE e.deleted =:deleted";
            return em.createQuery(qry).setParameter("deleted", false).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<BankBranch> getBankBranchesByBank(Bank bank)
    {
        try {
            String qry = "SELECT e FROM "+BankBranch.class.getSimpleName()+" e "
                    + " WHERE e.bank =:bank "
                    + " AND e.deleted =:deleted ORDER BY e.bank.bankName";
            
            return em.createQuery(qry).setParameter("bank", bank).setParameter("deleted", false).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
    
    public List<SupplierProduct> getSupplierProductBySupplier(Supplier supplier){
        try {
            String qry = "SELECT e FROM " + SupplierProduct.class.getSimpleName() + " e "
                    + " WHERE e.supplier =:supplier "
                    + " AND e.deleted =:deleted ORDER BY e.supplier.supplierName";
            
            return em.createQuery(qry).setParameter("supplier", supplier).setParameter("deleted", false).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

}
