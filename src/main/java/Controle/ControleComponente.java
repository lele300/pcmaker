/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ComponenteDAO;
import DAO.TipoAtributoDAO;
import DAO.TipoComponenteDAO;
import Modelo.Atributo;
import Modelo.Componente;
import Modelo.TipoAtributo;
import Modelo.TipoComponente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarTipoComponente", "/cadastrarComponente", "/consultarComponente", "/deletarComponente", "/alterarComponente", "/consultarPorIdTipoComponente", "/iniciarCadastroComponente", "/itensCarrinhoComponente", "/consultarComponenteAJAX", "/consultarTipoComponenteAJAX"})

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
        } else if (uri.equals(req.getContextPath() + "/consultarPorIdTipoComponente")) {
            try {
                consultarPorIdTipoComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(req.getContextPath() + "/iniciarCadastroComponente")) {
            try {
                iniciarCadastroComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((uri.equals(req.getContextPath() + "/itensCarrinhoComponente"))) {
            try {
                itensCarrinhoComponente(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((uri.equals(req.getContextPath() + "/consultarComponenteAJAX"))) {
            try {
                consultarComponenteAJAX(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((uri.equals(req.getContextPath() + "/consultarTipoComponenteAJAX"))) {
            try {
                consultarTipoComponenteAJAX(req, resp);
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

        //Para cada opção selecionada no checkbox, gravar o id do TipoAtributo e setar em listaTipoAtributo
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

        req.getRequestDispatcher("cadastroTipoComponenteOK.jsp").forward(req, resp);

    }

    public void consultaTodosComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        //Instância de TipoComponenteDAO para recuperar a lista de TiposComponente
        //Com seus tiposAtributos definidos
        TipoComponenteDAO daoTipoComponente = new TipoComponenteDAO();

        //Lista para armazenar os tiposComponentes do banco de dados
        List<TipoComponente> listaTipoComponente = daoTipoComponente.consultarTipoComponentes();

        //String retorno = request.getPArameter("retorno");
        
        //if (retorno.equals("json") {
        //GSon 
        //JSONParser jp = new JSONParser(Componente.class);
        ///String listaEMJson = jp.parse(listaComponente);
        // response.getWriter().println(listaEmJSON);
        // } else { //faz o que ja fazia abaixo
        // Atribuir a lista em um objeto para recuperar na JSP listaCadastroTipoComponente.jsp
        req.setAttribute("listaTipoComponente", listaTipoComponente);
        req.getRequestDispatcher("listaCadastroTipoComponente.jsp").forward(req, resp);
        System.out.println(listaTipoComponente);

    }

    public void deletarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        //Recuperando o ID do TipoComponente da JSP
        int id = Integer.parseInt(req.getParameter("id"));
        
        //Instância de TipoComponente
        TipoComponente tipoComponente = new TipoComponente();
        Componente componente = new Componente();
        
        
        tipoComponente.setId(id);
        componente.setId(id);

        //Instância da classe de persistência
        TipoComponenteDAO tipoComponenteDAO = new TipoComponenteDAO();
        ComponenteDAO daoComponente = new ComponenteDAO();

        //Deletando o objeto TipoComponente do BD
        daoComponente.deletarComponente(componente);
        tipoComponenteDAO.deletarTipoComponente(tipoComponente);
        

        this.consultaTodosComponente(req, resp);

    }

    public void alterarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

    }

    public void consultarPorIdTipoComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        TipoComponente tipoComponente = new TipoComponente();

        tipoComponente.setId(Integer.parseInt(req.getParameter("id")));

        TipoComponenteDAO tipoComponenteDAO = new TipoComponenteDAO();

        tipoComponente = tipoComponenteDAO.consultarTipoComponentePorId(tipoComponente);

        req.setAttribute("tipoComponente", tipoComponente);
        req.getRequestDispatcher("alterarTipoComponente.jsp");
    }
    
    
    public void itensCarrinhoComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {

        ComponenteDAO daoComponente = new ComponenteDAO();
        
        List<Componente> listaComponentes = new ArrayList<>();
        listaComponentes = daoComponente.consultarComponentes();
        
        req.setAttribute("listaComponentes", listaComponentes);
        req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
        
    }
    
    
    public void consultarComponenteAJAX(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        TipoComponenteDAO daoTipoComponente = new TipoComponenteDAO();
        List<TipoComponente> listaTipoComponentes = daoTipoComponente.consultarTipoComponentes();
        
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new TipoComponente.ExclusaoComponenteDeTipoComponente())
                .addSerializationExclusionStrategy(new TipoComponente.ExclusaoTipoAtributoDeTipoComponente()).create();
        
        
        
        String listaComponentesJSON = gson.toJson(listaTipoComponentes);
        
        resp.getWriter().println(listaComponentesJSON);
        
        
    }
    
    public void consultarTipoComponenteAJAX(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        
        TipoComponenteDAO daoTipoComponente = new TipoComponenteDAO();
        
        List<TipoComponente> listaTipoComponente = daoTipoComponente.consultarTipoComponentes();
        
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new TipoComponente.ExclusaoComponenteDeTipoComponente())
                .addSerializationExclusionStrategy(new TipoComponente.ExclusaoTipoAtributoDeTipoComponente()).create();
        
        String listaTipoComponenteJSON = gson.toJson(listaTipoComponente);
        
        resp.getWriter().println(listaTipoComponenteJSON);
        
    }
    
}
