/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.TipoAtributo;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;

/**
 *
 * @author devops
 */
public class TipoAtributoDAO {
    
    //Método para cadastrar um Tipo atributo  no banco de dados
    public void cadastrarTipoAtributo(TipoAtributo tipoAtributo) {

        EntityManager manager = new JPAUtil().getEntityManager();
        try {
            manager.getTransaction().begin(); // Inicia uma transação
            manager.persist(tipoAtributo);
            manager.flush(); // Força uma sincronia com o banco de dados
            manager.getTransaction().commit(); // Comita uma transação. 
            System.out.println(" Novo Tipo Atributo inserido com sucesso");
        } catch (Exception ex) {
            ex.getMessage();
            manager.getTransaction().rollback();// Executa um rollback em caso de erros
            System.out.println("Erro ao inserir um tipo atributo novo: "+ex);
        } finally {
            manager.close(); //Encerra uma transação
        }

    }
    
    //Metodo para consultar todos os tipos de atributos existentes
    public List<TipoAtributo> consultarTipoAtributo() {

        // Instancia um objeto EntityManager para utilizar operações SQL
        EntityManager manager = new JPAUtil().getEntityManager();
        List<TipoAtributo> litaTipoAtributo = new ArrayList<>();
        TypedQuery<TipoAtributo> query = manager.createQuery("select tp from TipoAtributo tp", TipoAtributo.class);
        litaTipoAtributo = query.getResultList();
        return litaTipoAtributo;
    }
    
    //Metodo para deletar um Tipo atributo do banco
    public void deletarTipoAtributo(TipoAtributo tipoAtributo) {

        EntityManager manager = new JPAUtil().getEntityManager(); //Inicia um Entity Manager      
        manager.getTransaction().begin(); //Inicia uma transação

        try {
            tipoAtributo = manager.find(TipoAtributo.class, tipoAtributo.getId()); // Resgata um Tipo Atributo através da primary key
            manager.remove(tipoAtributo); //Exclui o tipoAtributo do Banco de dados.
            manager.getTransaction().commit(); //Comita a transação 
        } catch (Exception ex) {
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Erro ao deletar tipoAtributo: "+ex);
        }
        manager.close(); //Fecha a transação

    }
    
    //Metodo 
    public void alterarTipoAtributo(TipoAtributo tipoAtributo) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        try{
            if(tipoAtributo.getNome() != null){
            manager.merge(tipoAtributo);
            manager.getTransaction().commit();
            System.err.println("Tipo atributo  alterado com sucesso");
            }
        } catch(HibernateException ex){
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Erro ao alterar um tipo atributo: "+ex);
        } finally{
            manager.close();
        }

    }
 
    
}
