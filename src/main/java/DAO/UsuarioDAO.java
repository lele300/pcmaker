/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.JPAUtil;
import Enum.TipoAdm;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;

/**
 *
 * @author Leonardo
 */
public class UsuarioDAO {

    //Método para cadastrar um cliente no banco de dados
    public void cadastrarUsuario(Usuario usuario) {

        EntityManager manager = new JPAUtil().getEntityManager();
        try {
            manager.getTransaction().begin(); // Inicia uma transação
            if (usuario.getIdUsuario() == null) {
                manager.persist(usuario);
            } else {
                manager.merge(usuario); // Carrega a entitade Cliente e o torna MANAGED
            }
            manager.flush(); // Força uma sincronia com o banco de dados
            manager.getTransaction().commit(); // Comita uma transação. 
            System.out.println("Usuário inserido com sucesso");
        } catch (Exception ex) {
            ex.getMessage();
            manager.getTransaction().rollback();// Executa um rollback em caso de erros
            System.out.println("Erro ao inserir usuário: " + ex);
        } finally {
            manager.close(); //Encerra uma transação
        }

    }

    //Método para listar todos os clientes do banco de dados
    public List<Usuario> consultarTodosUsuarios() {

        // Instancia um objeto EntityManager para utilizar operações SQL
        EntityManager manager = new JPAUtil().getEntityManager();
        List<Usuario> listaUsuarios = new ArrayList<>();
        try{

            TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u join u.enderecos", Usuario.class);
            listaUsuarios = query.getResultList();
        
        } catch(Exception ex){
            ex.getMessage();
            System.err.println("Ocorreu um erro ao consultar usuários: "+ex);
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
        return listaUsuarios;
    }

    // Método para deletar um cliente do Banco de Dados
    public void deletarUsuario(Usuario usuario) {

        EntityManager manager = new JPAUtil().getEntityManager(); //Inicia um Entity Manager      
        manager.getTransaction().begin(); //Inicia uma transação

        try {
            usuario = manager.find(Usuario.class, usuario.getIdUsuario()); // Resgata um cliente através da primary key
            manager.remove(usuario); //Exclui o cliente do Banco de dados.
            manager.getTransaction().commit(); //Comita a transação 
        } catch (Exception ex) {
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Erro ao deletar usuário: " + ex);
        }
        manager.close(); //Fecha a transação

    }

    // Método para autenticar um cliente no banco de dados.
    public Usuario autenticaUsuarioComum(Usuario usuario) {

        EntityManager manager = new JPAUtil().getEntityManager(); //Cria um Entity Manager

        try {
            TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login=:pLogin"
                    + " and u.senha=:pSenha", Usuario.class); //Cria um retorno do tipo Usuario e um select personalizado

            query.setParameter("pLogin", usuario.getLogin()); //Atribui o valor no parâmetro pLogin
            query.setParameter("pSenha", usuario.getSenha()); //Atribui o valor no parâmetro pSenha
            usuario.setTipoAdm(TipoAdm.CLIENTE);
            usuario = query.getSingleResult(); //Retorna um valor único no objeto cliente.   
            manager.close(); //Fecha uma conexão
        } catch (HibernateException ex) {
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Erro ao autenticar usuário: " + ex);
        }

        return usuario; //Retorna um valor cliente.
    }

    public void alterarUsuario(Usuario usuario) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        try {
            if (usuario.getIdUsuario() != null) {
                manager.merge(usuario);
                manager.getTransaction().commit();
                System.err.println("Usuário alterado com sucesso");
            }
        } catch (HibernateException ex) {
            ex.getMessage();
            manager.getTransaction().rollback();
            System.err.println("Erro ao alterar usuário: " + ex);
        } finally {
            manager.close();
        }

    }

    public Usuario consultarPorId(Usuario usuario) {

        EntityManager manager = new JPAUtil().getEntityManager();
        usuario = manager.find(Usuario.class, usuario.getIdUsuario());
        return usuario;

    }
}
