///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controle;
//
//<<<<<<< HEAD
//
//=======
//import DAO.ComponenteDAO;
//>>>>>>> eb15f4c24a30a42a7a7a2f13a33390b67205f28d
//import Modelo.Atributo;
//import Modelo.Componente;
//import Modelo.TipoAtributo;
//import Modelo.TipoComponente;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//<<<<<<< HEAD
//=======
//import java.util.List;
//>>>>>>> eb15f4c24a30a42a7a7a2f13a33390b67205f28d
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//<<<<<<< HEAD
// 
//@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarComponente","/consultarComponente","/deletarComponente","/alterarComponente","/consultarPorIdComponente"})
//=======
//@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarComponente", "/consultarComponente", "/deletarComponente", "/alterarComponente", "/consultarPorIdComponente"})
//>>>>>>> eb15f4c24a30a42a7a7a2f13a33390b67205f28d
//public class ControleComponente extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//<<<<<<< HEAD
//        
//        
//        String uri = req.getRequestURI();
//        
//        
//        if (uri.equals(req.getContextPath() + "/cadastrarUsuario")){
//            try {
//                cadastrarComponente(req,resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if(uri.equals(req.getContextPath() + "/alterarUsuario")){
//            try {
//                alterarUsuario(req, resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }    
//    }
//    
//     @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//        
//        String uri = req.getRequestURI();
//        
//        
//        if(uri.equals(req.getContextPath() + "/consultarUsuario")){
//            try {
//                consultaTodosUsuarios(req,resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if(uri.equals(req.getContextPath() + "/deletarUsuario")) {
//            try {
//                deletarUsuario(req, resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if(uri.equals(req.getContextPath() + "/consultarPorId")){
//            try {
//                consultarPorId(req, resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }    
//    }
//    
//    
//
//    public void cadastrarComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
//        
//        String nomeComponente = req.getParameter("nomeComponente");
//        
//        TipoComponente tipoComponente = new TipoComponente();
//        tipoComponente.setNomeComponente(nomeComponente);
//        
//        
//        String[] opcoesSelecionadas = req.getParameterValues("opcaoAtributo");
//        ArrayList<TipoAtributo> listaAtributo = new ArrayList<>();
//        
//        for (String opcaoSelecionada : opcoesSelecionadas) {
//            int idTipoAtributo = Integer.parseInt(opcaoSelecionada);
//            TipoAtributo objta = new TipoAtributo();
//            objta.setId(idTipoAtributo);
//            listaAtributo.add(objta);
//        }
//        
//        //tipoComponente.setTipoAtributos(listaAtributo);
//        
////        Criando o objeto TipoComponente e setando o nome do componentea
//            
//        
//=======
//
//        String uri = req.getRequestURI();
//
//        if (uri.equals(req.getContextPath() + "/cadastrarComponente")) {
//            try {
//                cadastrarComponente(req, resp);
//            } catch (ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (uri.equals(req.getContextPath() + "/alterarComponente")) {
//            alterarComponente(req, resp);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String uri = req.getRequestURI();
//
//        if (uri.equals(req.getContextPath() + "/consultarComponente")) {
//            consultarComponente(req, resp);
//        } else if (uri.equals(req.getContextPath() + "/deletarComponente")) {
//            deletarComponente(req, resp);
//        } else if (uri.equals(req.getContextPath() + "/consultarPorIdComponente")) {
//            consultarPorIdComponente(req, resp);
//        }
//    }
//
//    public void cadastrarComponente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
//
////        String nomeComponente = req.getParameter("nomeComponente");
////        int quantidade = Integer.parseInt(req.getParameter("quantidade"));
////        String marca = req.getParameter("marca");
////        String modelo = req.getParameter("modelo");
////        String descricao = req.getParameter("descricao");
////        String[] opcoesSelecionadas = req.getParameterValues("opcaoAtributo");
////        ArrayList<TipoAtributo> listaAtributo = new ArrayList<>();
////
////        //Criando o objeto TipoComponente e setando o nome do componente
////        TipoAtributo objta;
////        TipoComponente tipoComponente = new TipoComponente();
////        tipoComponente.setNomeComponente(nomeComponente);
////        objta = new TipoAtributo();
////        objta.setId(opcoesSelecionadas[i]);
////        listaAtributo.add(objta);
////
//>>>>>>> eb15f4c24a30a42a7a7a2f13a33390b67205f28d
////        componente.getMarca(marca)   
////        componente.setQuantidade(quantidade);
////        componente.setDescricao(descricao);
////        componente.setListaAtributo(listaAtributo);
//<<<<<<< HEAD
//        
//        
//        
//    }
//     
//    public void consultaTodosUsuarios(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
//        
//
//    }
//    
//    public void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
//        
//     
//    }
//      
//    public void alterarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
//       
//             
//    }
//    
//    public void consultarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
//        
//       
//        
//    }
//    
//}
//
//=======
//
//    }
//
//    private void alterarComponente(HttpServletRequest req, HttpServletResponse resp) {
//        
//        //TODO
//        
//    }
//
//    private void consultarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//         //Instância da ComponenteDAO
//        ComponenteDAO daoComponente = new ComponenteDAO();
//        
//        // Setando o resultado da consulta na listaComponentes 
//        List<Componente> listaComponentes = daoComponente.consultarComponentes();
//        
//        //Atribuindo uma String para enviar á JSP consultarComponente.jsp
//        req.setAttribute("listaComponentes", listaComponentes);
//        req.getRequestDispatcher("consultaComponente.jsp").forward(req, resp);// TODO
//        
//    }
//
//    private void deletarComponente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//        //Recuperando o id do atributo da JSP e fazendo parse para Integer
//        int id = Integer.parseInt(req.getParameter("id"));
//        
//        //Instanciando objeto Componente e setando o id
//        Componente componente = new Componente();
//        componente.setId(id);
//        
//        //Instanciando o objeto componentDao para operações do banco de dados
//        ComponenteDAO daoComponente = new ComponenteDAO();
//        
//        //Deleta o componente do banco de dados
//        daoComponente.deletarComponente(componente);
//        
//        //Chama o método para consultar todos os componentes  e retornar á pagina de listagem dos componentes.
//        this.consultarComponente(req, resp);
//        
//    }
//
//    private void consultarPorIdComponente(HttpServletRequest req, HttpServletResponse resp) {
//        //recuperando o valor do ID e convertendo para int
//         int id = Integer.parseInt(req.getParameter("id"));
//       //criando um objeto componente e setando o ID no mesmo
//       Componente componente = new Componente();
//       componente.setId(id);
//       //criando um objeto da dao e chamando o metodo que vai conectar no banco e trazer os dados
//       ComponenteDAO daoAtributo = new ComponenteDAO();
//       componente = daoAtributo.consultarPorIdComponente(componente);
//       //setadno um atributo para view
//       req.setAttribute("componente", componente);
//       //redirecionando para pagina alterarComponente
//       req.getRequestDispatcher("alterarComponente.jsp");//TODO
//        
//    }
//}
//
//
//>>>>>>> eb15f4c24a30a42a7a7a2f13a33390b67205f28d
