/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Componente;
import Util.JPAUtil;
import javax.persistence.EntityManager;


public class ComponenteDAO {
    
    public void cadastrarComponente(Componente componente){
        
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        try{
            manager.persist(componente);
            manager.getTransaction().commit();
        } catch(Exception ex){
            ex.getMessage();
            System.out.println("Erro ao inserir componente: "+ex);
        }
    }
     
}
