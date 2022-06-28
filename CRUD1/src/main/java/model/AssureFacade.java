/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entities.Assure;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author mac
 */
@Stateless
public class AssureFacade extends AbstractFacade<Assure> {

    @PersistenceContext(unitName = "com.mycompany_CRUD1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AssureFacade() {
        super(Assure.class);
    }
    
  
}