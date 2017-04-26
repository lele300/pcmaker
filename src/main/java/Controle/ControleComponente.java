/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ComponenteDAO;
import DAO.TipoAtributoDAO;
import DAO.TipoComponenteDAO;
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

@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarComponente", "/consultarComponente", "/deletarComponente", "/alterarComponente", "/consultarPorIdComponente", "/iniciarCadastroComponente"})

public class ControleComponente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.equals(req.getContextPath() + "/cadastrarComponente")) {
            try {
                cadastrarComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/alterarComponente")) {
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

        if (uri.equals(req.getContextPath() + "/consultarComponente")) {
            try {
                consultaTodosUsuarios(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/deletarComponente")) {
            try {
                deletarUsuario(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/consultarPorIdComponente")) {
            try {
                consultarPorId(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/iniciarCadastroComponente")) {
            try {
                iniciarCadastroComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void iniciarCadastroComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        //Instância da AtributoDAO
        TipoAtributoDAO daoTipoAtributo = new TipoAtributoDAO();

        // Setando o resultado da consulta na listaAtributos
        List<TipoAtributo> listaTipoAtributos = daoTipoAtributo.consultarTipoAtributos();

        //Atribuindo uma String para enviar á JSP consultaAtributos.jsp o objeto listaAtributos
        req.setAttribute("listaTipoAtributos", listaTipoAtributos);
        req.getRequestDispatcher("cadastroComponente.jsp").forward(req, resp);

    }

    public void cadastrarComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        //Recuperando o valor do nomeComponente
        String nomeComponente = req.getParameter("nomeComponente");

        //Criando objeto tipoComponente para setar o nome 
        TipoComponente tipoComponente = new TipoComponente();
        tipoComponente.setNomeComponente(nomeComponente);

        //Recuperando os valores do checkbox 
        String[] opcoesSelecionadas = req.getParameterValues("opcaoAtributo");
        ArrayList<TipoAtributo> listaTipoAtributo = new ArrayList<>();

        //Para cada opção selecionada no checkbox, gravar o id do TipoAtributo
        for (String opcaoSelecionada : opcoesSelecionadas) {
            int idTipoAtributo = Integer.parseInt(opcaoSelecionada);
            TipoAtributo atributos = new TipoAtributo();
            atributos.setId(idTipoAtributo);
            listaTipoAtributo.add(atributos);
        }

        //Setando a lista de Atributos dentro de tipoComponente
        tipoComponente.setTipoAtributos(listaTipoAtributo);

        TipoComponenteDAO daoTipoComponente = new TipoComponenteDAO();
        daoTipoComponente.cadastrarTipoComponente(tipoComponente);
        req.getRequestDispatcher("cadastroTipoComponenteOK.jsp").forward(req, resp);

    }

    public void consultaTodosUsuarios(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

    }

    public void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

    }

    public void alterarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

    }

    public void consultarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

    }

}
