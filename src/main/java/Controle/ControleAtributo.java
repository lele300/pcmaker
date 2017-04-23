/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import DAO.AtributoDAO;
import Modelo.Atributo;
import Modelo.Componente;
import Modelo.TipoAtributo;
import Modelo.TipoComponente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(name = "ControleAtributo", urlPatterns = {"/cadastrarAtributo","/consultarAtributo","/deletarAtributo","/alterarAtributo","/consultarPorIdAtributo"})
public class ControleAtributo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String uri = req.getRequestURI();
        
        
        if (uri.equals(req.getContextPath() + "/cadastrarAtributo")){
            try {
                cadastrarAtributo(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/alterarAtributo")){
            try {
                alterarAtributo(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String uri = req.getRequestURI();
        
        
        if(uri.equals(req.getContextPath() + "/consultarAtributo")){
            try {
                consultaTodosAtributos(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/deletarAtributo")) {
            try {
                deletarAtributo(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/consultarPorIdAtributo")){
            try {
                consultarPorIdAtributo(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    
    //Método para cadastrar um atributo novo no banco de dados
    public void cadastrarAtributo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        //Recuperando o tipoAtributo do formulário
        String nomeTipoAtributo = req.getParameter("nomeTipoAtributo");
        
        //Criando objeto TipoAtributo para setar o nomeTipoAtributo
        TipoAtributo tipoAtributo = new TipoAtributo();
        tipoAtributo.setNomeAtributo(nomeTipoAtributo);
        
        //Criando um ArrayList listaAtributo para popula-lo e inseri-lo em tipoAtributo
        ArrayList<Atributo> listaAtributo = new ArrayList<>();
        Atributo atributo = new Atributo();
        
        //Setando o objeto tipoAtributo dentro do objeto Atributo
        atributo.setTipoAtributo(tipoAtributo);
        
        //Inserindo o objeto Atributo dentro da lista
        listaAtributo.add(atributo);
        
        //Setando a listaAtributo dentro do objeto tipoAtributo
        tipoAtributo.setAtributo(listaAtributo);
        
        AtributoDAO daoAtributo = new AtributoDAO();
        daoAtributo.cadastrarAtributo(atributo);
        req.getRequestDispatcher("cadastroTipoAtributoOK.jsp").forward(req, resp);
        
    }
     
    //Método para consultar todos os atributos cadastrados no banco de dados
    public void consultaTodosAtributos(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        //Instância da AtributoDAO
        AtributoDAO daoAtributo = new AtributoDAO();
        
        // Setando o resultado da consulta na listaAtributos
        List<Atributo> listaAtributos = daoAtributo.consultarAtributos();
        
        //Atribuindo uma String para enviar á JSP consultaAtributos.jsp
        req.setAttribute("listaAtributos", listaAtributos);
        req.getRequestDispatcher("consultaAtributos.jsp").forward(req, resp);

    }
    
    public void deletarAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
        //Recuperando o id do atributo da JSP e fazendo parse para Integer
        int id = Integer.parseInt(req.getParameter("id"));
        
        //Instanciando objeto Atributo e setando o id
        Atributo atributo = new Atributo();
        atributo.setId(id);
        
        //Instanciando o objeto AtributoDAO para operações do banco de dados
        AtributoDAO daoAtributo = new AtributoDAO();
        
        //Deleta o atributo do banco de dados
        daoAtributo.deletarAtributo(atributo);
        
        //Chama o método para consultar todos os atributos e retornar á pagina de listagem dos atributos.
        this.consultaTodosAtributos(req, resp);
     
    }
      
    public void alterarAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
       
        //Recuperando o tipoAtributo do formulário
        String nomeTipoAtributo = req.getParameter("nomeTipoAtributo");
        
        //Criando objeto TipoAtributo para setar o nomeTipoAtributo
        TipoAtributo tipoAtributo = new TipoAtributo();
        tipoAtributo.setNomeAtributo(nomeTipoAtributo);
        
        //Criando um ArrayList listaAtributo para popula-lo e inseri-lo em tipoAtributo
        ArrayList<Atributo> listaAtributo = new ArrayList<>();
        Atributo atributo = new Atributo();
        
        //Setando o objeto tipoAtributo dentro do objeto Atributo
        atributo.setTipoAtributo(tipoAtributo);
        
        //Inserindo o objeto Atributo dentro da lista
        listaAtributo.add(atributo);
        
        //Setando listaAtributo no objeto TipoAtributo
        tipoAtributo.setAtributo(listaAtributo);
        
        AtributoDAO daoAtributo = new AtributoDAO();
        daoAtributo.alterarAtributo(atributo);
        this.consultaTodosAtributos(req, resp);
             
    }
    
    public void consultarPorIdAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
       int id = Integer.parseInt(req.getParameter("id"));
       
       Atributo atributo = new Atributo();
       atributo.setId(id);
       
       AtributoDAO daoAtributo = new AtributoDAO();
       atributo = daoAtributo.consultarPorIdAtributo(atributo);
       
       req.setAttribute("atributo", atributo);
       req.getRequestDispatcher("alterarAtributo.jsp");
        
    }
    
}

