/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.TipoAtributoDAO;
import Modelo.TipoAtributo;
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
@WebServlet(name = "ControleTipoAtributo", urlPatterns = {"/cadastrarTipoAtributo","/consultarTipoAtributo","/deletarTipoAtributo","/alterarTipoAtributo"})
public class ControleTipoAtributo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        
        
        if (uri.equals(req.getContextPath() + "/cadastrarTipoAtributo")){
            try {
                cadastrarTipoAtributo(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
    
    
    public void cadastrarTipoAtributo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        String nomeTipoAtributo = req.getParameter("nomeTipoAtributo");
        
        TipoAtributo tipoAtributo = new TipoAtributo();
        
        tipoAtributo.setNome(nomeTipoAtributo);
        
        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();
        daoTipoAtributo.cadastrarTipoAtributo(tipoAtributo);
        req.getRequestDispatcher("cadastroTipoAtributoOK.jsp").forward(req, resp);   
    }
}
