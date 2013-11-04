package org.kie.tests.wb.base.war;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Supplies various persistence related beans for dependencies (jbpm-kie-services, etc.) used in the war. 
 */
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
public class TestPersistenceProducer {

    @PersistenceUnit(unitName="org.jbpm.persistence.jpa")
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public void closeEntityManager(@Disposes EntityManager em) {
        em.close();
    }
    
    @Produces
    public EntityManagerFactory createPersistenceUnit() { 
        return emf;
    }
    
}
