/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.PedidoDAO;
import DAO.ComponenteDAO;
import Enum.StatusPedido;
import Modelo.Carrinho;
import Modelo.Componente;
import Modelo.Pedido;
import Modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ControlePedido", urlPatterns = {"/cadastrarPedido", "/consultarPedido", "/excluirPedido"})
public class ControlePedido extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.equals(req.getContextPath() + "/excluirPedido")) {
            try {
                excluirPedido(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControlePedido.class.getName()).log(Level.SEVERE, null, ex);
                req.getRequestDispatcher("erro.jsp").forward(req, resp);
            }
        } else if (uri.equals(req.getContextPath() + "/cadastrarPedido")) {
            try {
                cadastrarPedido(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControlePedido.class.getName()).log(Level.SEVERE, null, ex);
                req.getRequestDispatcher("erro.jsp").forward(req, resp);
            }
        } else if (uri.equals(req.getContextPath() + "/consultarPedido")) {
            try {
                consultarPedido(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControlePedido.class.getName()).log(Level.SEVERE, null, ex);
                req.getRequestDispatcher("erro.jsp").forward(req, resp);
            }
        }

    }

    public void cadastrarPedido(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        List<Componente> componentesCarrinho = new ArrayList<>();
        Carrinho carrinho = null;
        Usuario usuarioSessao = new Usuario();
        carrinho = (Carrinho) req.getSession().getAttribute("carrinho");
        usuarioSessao = (Usuario) req.getSession().getAttribute("usuarioAutenticado");
        if (carrinho != null) {

            Date dataPedido = new Date();
            Pedido pedido = new Pedido();
            double valorTotal = 0;

            pedido.setDataPedido(dataPedido);
            pedido.setUsuarioDoPedido(usuarioSessao);
            pedido.setItensComponente(componentesCarrinho);
            pedido.setStatusPedido(StatusPedido.PENDENTE);

            for (Componente comp : carrinho.getComponentes()) {

                //Adicionando o componente da sessão no arrayList
                componentesCarrinho.add(comp);
                ComponenteDAO daoComponente = new ComponenteDAO();
                daoComponente.atualizarEstoque(comp);
                //Somando o valor de cada componente e armazenando no valorTotal
                valorTotal += comp.getPreco();

            }
            //Adicionando os componentes no pedido
            pedido.setItensComponente(componentesCarrinho);
            //Adicionando o valor total
            pedido.setValorTotal(valorTotal);
            PedidoDAO daoPedido = new PedidoDAO();
            //Cadastrar o Pedido no banco de dados

            daoPedido.cadastrarPedido(pedido);

            req.getSession().removeAttribute("carrinho");
        } else {
            System.err.println("Não existe nenhum componente no carrinho");
        }

    }

    public void consultarPedido(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        Usuario usuario = new Usuario();
        usuario = (Usuario) req.getSession().getAttribute("usuarioAutenticado");
        List<Pedido> listaDePedidos = new ArrayList<>();
        PedidoDAO daoPedido = new PedidoDAO();

        listaDePedidos = daoPedido.consultarTodosPedidoPorUsuario(usuario);
        req.setAttribute("listaDePedido", listaDePedidos);
        req.getRequestDispatcher("historicoDePedidos.jsp").forward(req, resp);

    }

    public void excluirPedido(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {

        Pedido pedido = new Pedido();
        PedidoDAO daoPedido = new PedidoDAO();
        
        pedido.setIdPedido(Integer.parseInt(req.getParameter("id")));
        pedido = daoPedido.consultarPedidoPorId(pedido);
        
        for (Componente comp : pedido.getItensComponente()){           
            ComponenteDAO daoComponente = new ComponenteDAO();
            daoComponente.retornaEstoque(comp);
        }     
        daoPedido.deletarPedido(pedido);      
        this.consultarPedido(req, resp);
    }    
}
