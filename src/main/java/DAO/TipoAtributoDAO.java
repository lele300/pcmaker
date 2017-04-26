/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Atributo;
import Modelo.TipoAtributo;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author leo_l
 */
public class TipoAtributoDAO {
    
    public List<TipoAtributo> consultarTipoAtributos(){
        
        EntityManager manager = new JPAUtil().getEntityManager();
        List<TipoAtributo> listaTipoAtributos = new ArrayList<>();
        TypedQuery<TipoAtributo> query = manager.createQuery("select tp from TipoAtributo tp",TipoAtributo.class);
        listaTipoAtributos = query.getResultList();
        return listaTipoAtributos;
        
    }
    
}
