/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.AtributoDAO;
import DAO.ComponenteDAO;
import DAO.TipoAtributoDAO;
import DAO.TipoComponenteDAO;
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

@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarTipoComponente", "/cadastrarComponente", "/consultarComponente", "/deletarComponente", "/alterarComponente", "/consultarPorIdComponente", "/iniciarCadastroComponente"})

public class ControleComponente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.equals(req.getContextPath() + "/cadastrarTipoComponente")) {
            try {
                cadastrarTipoComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/alterarComponente")) {
            try {
                alterarComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/cadastrarComponente")) {
            try {
                cadastrarComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleComponente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.equals(req.getContextPath() + "/consultarComponente")) {
            try {
                consultaTodosComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/deletarComponente")) {
            try {
                deletarComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/consultarPorIdComponente")) {
            try {
                consultarPorIdComponente(req, resp);
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
        req.getRequestDispatcher("cadastroTipoComponente.jsp").forward(req, resp);

    }

    public void cadastrarTipoComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

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

    public void cadastrarComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        String marca = req.getParameter("marca");
        String modelo = req.getParameter("modelo");
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));
        String descricao = req.getParameter("descricao");
        double preco = Double.parseDouble(req.getParameter("preco"));
        int idTipoComponente = Integer.parseInt(req.getParameter("tipoComponente"));

        //Instância do objeto Componente
        Componente componente = new Componente();

        //Setando os valores para a tabela Componente
        componente.setMarca(marca);
        componente.setModelo(modelo);
        componente.setQuantidade(quantidade);
        componente.setDescricao(descricao);
        componente.setPreco(preco);     

        TipoComponente tipoComponente = new TipoComponente();
        tipoComponente.setId(idTipoComponente);
        
        TipoComponenteDAO tipoComponenteDAO = new TipoComponenteDAO();
        tipoComponente =  tipoComponenteDAO.consultarTipoComponentePorId(tipoComponente);
        
        
        componente.setTipoComponente(new TipoComponente());
        componente.getTipoComponente().setId(idTipoComponente);
        
        
        List<Atributo> listaAtributo = new ArrayList<>();
        for (TipoAtributo at : tipoComponente.getTipoAtributos()) {

            String valorAtributo = req.getParameter("atributo" + at.getId());
            Atributo atributo = new Atributo();
            atributo.setValor(valorAtributo);
            TipoAtributo tp = new TipoAtributo();
            tp.setId(at.getId());
            atributo.setTipoAtributo(tp);
            listaAtributo.add(atributo);
            at.setAtributos(listaAtributo);
            atributo.setComponentes(componente);

        }

        componente.setAtributos(listaAtributo);

        ComponenteDAO daoComponente = new ComponenteDAO();
        daoComponente.cadastrarComponente(componente);
        
//        for (Atributo atributo : componente.getAtributos()) {
//
//            AtributoDAO daoAtributo = new AtributoDAO();
//            daoAtributo.cadastrarAtributo(atributo);
//            
//        }
        req.getRequestDispatcher("cadastroTipoComponenteOK.jsp").forward(req, resp);

    }

    public void consultaTodosComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        //Instância de TipoComponenteDAO para recuperar a lista de TiposComponente
        //Com seus tiposAtributos definidos
        TipoComponenteDAO daoTipoComponente = new TipoComponenteDAO();

        //Lista para armazenar os tiposComponentes do banco de dados
        List<TipoComponente> listaTipoComponente = daoTipoComponente.consultarTipoComponentes();

        // Atribuir a lista em um objeto para recuperar na JSP listaCadastroTipoComponente.jsp
        req.setAttribute("listaTipoComponente", listaTipoComponente);
        req.getRequestDispatcher("listaCadastroTipoComponente.jsp").forward(req, resp);
        System.out.println(listaTipoComponente);

    }

    public void deletarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        //Instância de TipoComponente
        TipoComponente tipoComponente = new TipoComponente();

        //Recuperando o ID do TipoComponente da JSP
        tipoComponente.setId(Integer.parseInt(req.getParameter("id")));

        //Instância da classe de persistência
        TipoComponenteDAO tipoComponenteDAO = new TipoComponenteDAO();

        //Deletando o objeto TipoComponente do BD
        tipoComponenteDAO.deletarTipoComponente(tipoComponente);

        this.consultaTodosComponente(req, resp);

    }

    public void alterarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

    }

    public void consultarPorIdComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        TipoComponente tipoComponente = new TipoComponente();

        tipoComponente.setId(Integer.parseInt(req.getParameter("id")));

        TipoComponenteDAO tipoComponenteDAO = new TipoComponenteDAO();

        tipoComponente = tipoComponenteDAO.consultarTipoComponentePorId(tipoComponente);

        req.setAttribute("tipoComponente", tipoComponente);
        req.getRequestDispatcher("alterarTipoComponente.jsp");
    }

}
