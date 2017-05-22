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
@WebServlet(name = "ControleCarrinho", urlPatterns = {"/ControleCarrinho"})
public class ControleCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
            resp.sendRedirect("carrinho.jsp");
        } catch(Exception ex){
            Logger.getLogger(ControleCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
