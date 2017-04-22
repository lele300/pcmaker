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
                alterarUsuario(req, resp);
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
                consultaTodosUsuarios(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/deletarAtributo")) {
            try {
                deletarUsuario(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/consultarPorIdAtributo")){
            try {
                consultarPorId(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    

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
     
    public void consultaTodosUsuarios(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        

    }
    
    public void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
     
    }
      
    public void alterarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
       
             
    }
    
    public void consultarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
       
        
    }
    
}

