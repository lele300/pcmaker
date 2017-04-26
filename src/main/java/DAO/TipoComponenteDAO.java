/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Componente;
import Modelo.TipoComponente;
import Util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author leo_l
 */
public class TipoComponenteDAO {
    
    public void cadastrarTipoComponente(TipoComponente tipoComponente){
        
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        try{
            manager.persist(tipoComponente);
            manager.getTransaction().commit();
        } catch(Exception ex){
            ex.getMessage();
            System.out.println("Erro ao inserir um Tipo Componente: "+ex);
        }
    }
    
    
    
}
