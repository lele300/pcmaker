/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ComponenteDAO;
import Modelo.Carrinho;
import Modelo.Componente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leo_l
 */
@WebServlet(name = "ControleCarrinho", urlPatterns = {"/carrinho", "/inserirComponenteNoCarrinho", "/removerComponenteDoCarrinho"})
public class ControleCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        String url = req.getRequestURI();

        if (url.equals(req.getContextPath() + "/inserirComponenteNoCarrinho")) {
            try {
                inserirComponenteNoCarrinho(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleCarrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (url.equals(req.getContextPath() + "/removerComponenteDoCarrinho")) {
            try {
                removerComponenteDoCarrinho(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleCarrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    private void inserirComponenteNoCarrinho(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Componente componente = new Componente();
            componente.setId(id);
            
            ComponenteDAO daoComponente = new ComponenteDAO();
            componente = daoComponente.consultarPorIdComponente(componente);
            
            Carrinho carrinho = (Carrinho) req.getSession(true).getAttribute("carrinho");
            
            if(carrinho == null){
                carrinho = new Carrinho();
                req.getSession().setAttribute("carrinho", carrinho);
            }
            
            carrinho.adicionarNoCarrinho(componente);
            System.out.println(carrinho.getComponentes());
            resp.sendRedirect("carrinhoComponente.jsp");
            
        } catch(IOException | NumberFormatException ex){
            Logger.getLogger(ControleCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
     private void removerComponenteDoCarrinho(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

         try{
             int id = Integer.parseInt(req.getParameter("id"));
             Componente removerComponente = new Componente();
             removerComponente.setId(id);
             
             ComponenteDAO daoComponente = new ComponenteDAO();
             removerComponente = daoComponente.consultarPorIdComponente(removerComponente);
             
             Carrinho carrinho = (Carrinho) req.getSession().getAttribute("carrinho");
             carrinho.removerDoCarrinho(removerComponente);
             resp.sendRedirect("carrinhoComponente.jsp");
             
         }catch(Exception ex){
             ex.getMessage();
             System.out.println("Não foi possível retirar o componente do carrinho "+ex);
         }
     }
}
