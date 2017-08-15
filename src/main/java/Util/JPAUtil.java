/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leonardo
 */
public class JPAUtil {
    
    @SuppressWarnings("FieldMayBeFinal")
    private static final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("pcmaker");

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    
}

        
  
