///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controle;
//
//
//import Modelo.Atributo;
//import Modelo.Componente;
//import Modelo.TipoAtributo;
//import Modelo.TipoComponente;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
// 
//@WebServlet(name = "ControleComponente", urlPatterns = {"/cadastrarComponente","/consultarComponente","/deletarComponente","/alterarComponente","/consultarPorIdComponente"})
//public class ControleComponente extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
//        int quantidade = Integer.parseInt(req.getParameter("quantidade"));
//        String marca = req.getParameter("marca");
//        String modelo = req.getParameter("modelo");
//        String descricao = req.getParameter("descricao");
//        String[] opcoesSelecionadas = req.getParameterValues("opcaoAtributo");
//        ArrayList<TipoAtributo> listaAtributo = new ArrayList<>();
//        
//        //Criando o objeto TipoComponente e setando o nome do componentea
//  TipoAtributo objta;
//        TipoComponente tipoComponente = new TipoComponente();
//        tipoComponente.setNomeComponente(nomeComponente);
//                objta = new TipoAtributo();
//                objta.setId(opcoesSelecionadas[i]);
//                listaAtributo.add(objta);
//            }
//        }
//        componente.getMarca(marca)   
//        componente.setQuantidade(quantidade);
//        componente.setDescricao(descricao);
//        componente.setListaAtributo(listaAtributo);
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
