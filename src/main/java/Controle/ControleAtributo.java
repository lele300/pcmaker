/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.AtributoDAO;
import DAO.TipoAtributoDAO;
import Modelo.Atributo;
import Modelo.TipoAtributo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControleAtributo", urlPatterns = {"/cadastrarAtributo", "/consultarAtributo", "/deletarAtributo", "/alterarAtributo", "/consultarPorIdTipoAtributo"})
public class ControleAtributo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.equals(req.getContextPath() + "/cadastrarAtributo")) {
            try {
                cadastrarAtributo(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/alterarAtributo")) {
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

        if (uri.equals(req.getContextPath() + "/consultarAtributo")) {
            try {
                consultaTodosAtributos(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/deletarAtributo")) {
            try {
                deletarAtributo(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/consultarPorIdTipoAtributo")) {
            try {
                consultarPorIdTipoAtributo(req, resp);
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

        // Código retirado
        

        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();
        daoTipoAtributo.cadastrarTipoAtributo(tipoAtributo);
        req.getRequestDispatcher("cadastroTipoAtributoOK.jsp").forward(req, resp);

    }

    public void consultaTodosAtributos(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        //Instância da AtributoDAO
        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();

        // Setando o resultado da consulta na listaAtributos
        List<TipoAtributo> listaTipoAtributos = daoTipoAtributo.consultarTipoAtributos();

        //Atribuindo uma String para enviar á JSP consultaAtributos.jsp o objeto listaAtributos
        req.setAttribute("listaTipoAtributos", listaTipoAtributos);
        req.getRequestDispatcher("consultaAtributos.jsp").forward(req, resp);

    }

    public void deletarAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        //Recuperando o id do atributo da JSP e fazendo parse para Integer
        int id = Integer.parseInt(req.getParameter("id"));

        //Instanciando objeto Atributo e setando o id
        Atributo atributo = new Atributo();
        atributo.setId(id);
        
        TipoAtributo tipoAtributo = new TipoAtributo();
        tipoAtributo.setId(id);

        //Instanciando o objeto AtributoDAO para operações do banco de dados
        AtributoDAO daoAtributo = new AtributoDAO();
        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();

        //Deleta o atributo do banco de dados
        daoTipoAtributo.deletarTipoAtributo(tipoAtributo);
        daoAtributo.deletarAtributo(atributo);

        //Chama o método para consultar todos os atributos e retornar á pagina de listagem dos atributos.
        this.consultaTodosAtributos(req, resp);

    }

    public void alterarAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        //Recuperando o tipoAtributo do formulário
        int id = Integer.parseInt(req.getParameter("idTipoAtributo"));
        String nomeTipoAtributo = req.getParameter("nomeTipoAtributo");

        //Criando objeto TipoAtributo para setar o nomeTipoAtributo
        TipoAtributo tipoAtributo = new TipoAtributo();
        tipoAtributo.setId(id);
        tipoAtributo.setNomeAtributo(nomeTipoAtributo);

//        //Criando um ArrayList listaAtributo para popula-lo e inseri-lo em tipoAtributo
//        ArrayList<Atributo> listaAtributo = new ArrayList<>();
//        Atributo atributo = new Atributo();
//
//        //Setando o objeto tipoAtributo dentro do objeto Atributo
//        atributo.setTipoAtributo(tipoAtributo);
//
//        //Inserindo o objeto Atributo dentro da lista
//        listaAtributo.add(atributo);
//
//        //Setando listaAtributo no objeto TipoAtributo
//        tipoAtributo.setAtributos(listaAtributo);

        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();
        daoTipoAtributo.alterarTipoAtributo(tipoAtributo);
        this.consultaTodosAtributos(req, resp);

    }

    public void consultarPorIdTipoAtributo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        int id = Integer.parseInt(req.getParameter("id"));

        TipoAtributo tipoAtributo = new TipoAtributo();

        tipoAtributo.setId(id);

        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();
        tipoAtributo = daoTipoAtributo.consultarPorIdTipoAtributo(tipoAtributo);

        req.setAttribute("tipoAtributo", tipoAtributo);
        req.getRequestDispatcher("alterarAtributo.jsp").forward(req, resp);
        System.out.println(tipoAtributo);

    }

}
