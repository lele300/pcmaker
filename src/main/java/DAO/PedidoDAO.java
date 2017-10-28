package DAO;

import Modelo.Pedido;
import Modelo.Usuario;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author leo_l
 */
public class PedidoDAO {
    
    // Cadastrar Pedido no Banco de Dados.
    public void cadastrarPedido(Pedido pedido) {

        EntityManager manager = new Util.JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        try{
            manager.persist(pedido);
            manager.getTransaction().commit();
        } catch(Exception ex){
            ex.getMessage();
            System.err.println("Não foi possível cadastrar o pedido no banco de dados "+ex);
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    //Método para listar todos os clientes do banco de dados
    public List<Pedido> consultarTodosPedidos() {

        EntityManager manager = new JPAUtil().getEntityManager();
        List<Pedido> listaPedidos = new ArrayList<>();      
        try{
            TypedQuery<Pedido> query = manager.createQuery("select ped from Pedido ped", Pedido.class);
            listaPedidos = query.getResultList();
        } catch(Exception ex){
            ex.getMessage();
            System.err.println("Não foi possível consultar Pedidos: "+ex);
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }      
        return listaPedidos;
    }

    // Deletar Pedido do banco de dados.
    public void deletarPedido(Pedido pedido) {

        EntityManager manager = new JPAUtil().getEntityManager(); //Inicia um Entity Manager      
        manager.getTransaction().begin(); //Inicia uma transação
        try {
            pedido = manager.find(Pedido.class, pedido.getIdPedido()); // Resgata um cliente através da primary key
            manager.remove(pedido); //Exclui o cliente do Banco de dados.
            manager.getTransaction().commit(); //Comita a transação 
        } catch (Exception ex) {
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Não foi possível deletar o pedido: " + ex);
        } finally {
            manager.close(); //Fecha a transação
        }
    }

    public Pedido consultarPedidoPorId(Pedido pedido) {

        EntityManager manager = new JPAUtil().getEntityManager();
        pedido = manager.find(Pedido.class, pedido.getIdPedido());
        return pedido;

    }
   
    
    public List<Pedido> consultarTodosPedidoPorUsuario(Usuario usuario){
        
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        List<Pedido> listaPedidos = new ArrayList<>();
        try{
            TypedQuery<Pedido> query = manager.createQuery("select p from Pedido p where p.usuarioDoPedido.idUsuario=:pIdUsuario",Pedido.class);
            query.setParameter("pIdUsuario",usuario.getIdUsuario());
            return listaPedidos = (List<Pedido>) query.getResultList();
        } catch (Exception ex){
            ex.getMessage();
            manager.getTransaction().rollback();
            System.out.println("Não foi possível consultar os pedidos "+ex);
        } finally {
            manager.close();
        }
        return null;
    }
    
}
