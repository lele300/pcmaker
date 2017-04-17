/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuario;
import DAO.UsuarioDAO;
import Enum.TipoAdm;
import Modelo.Endereco;
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

 
@WebServlet(name = "ControleUsuario", urlPatterns = {"/cadastrarUsuario","/consultarUsuario","/deletarUsuario","/alterarUsuario"})
public class ControleUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String uri = req.getRequestURI();
        
        
        if (uri.equals(req.getContextPath() + "/cadastrarUsuario")){
            try {
                cadastrarUsuario(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/alterarUsuario")){
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
        
        
        if(uri.equals(req.getContextPath() + "/consultarUsuario")){
            try {
                consultaTodosUsuarios(req,resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "/deletarUsuario")) {
            try {
                deletarUsuario(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(uri.equals(req.getContextPath() + "consultarPorId")){
            try {
                consultarPorId(req, resp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    

    public void cadastrarUsuario(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        String nomeCompleto = req.getParameter("nomeCompleto");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String rg = req.getParameter("rg");
        String cpf = req.getParameter("cpf");
        String cep = req.getParameter("cep");
        String rua = req.getParameter("rua");
        String bairro = req.getParameter("bairro");
        String uf = req.getParameter("uf");
        int numero = Integer.parseInt(req.getParameter("numero"));
        String cidade = req.getParameter("cidade");
        String complemento = req.getParameter("complemento");
        
        List<Endereco> listaEnderecos = new ArrayList<>();
        Endereco endereco = new Endereco();
        
        endereco.setCep(cep);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setUf(uf);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setComplemento(complemento);
        
        Usuario usuario = new Usuario();
        
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setRg(rg);
        usuario.setCpf(cpf);
        usuario.setTelefone(telefone);
        usuario.setTipoAdm(TipoAdm.CLIENTE);
        
        listaEnderecos.add(endereco);
        usuario.setEnderecos(listaEnderecos);
        endereco.setUsuario(usuario);
        
        
        UsuarioDAO daoUsuario = new UsuarioDAO(); 
        
        //Cadastrando Endereco e Usuário no BD
        daoUsuario.cadastrarUsuario(usuario);
        
        req.getRequestDispatcher("cadastroUsuarioOK.jsp").forward(req, resp);
    }
     
    public void consultaTodosUsuarios(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, SQLException, ServletException {
        
        UsuarioDAO daoUsuario = new UsuarioDAO();
        List<Usuario> listaUsuarios = daoUsuario.consultarTodosUsuarios();
        req.setAttribute("listaUsuarios", listaUsuarios);
        req.getRequestDispatcher("consulta.jsp").forward(req, resp);
            
    }
    
    public void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
        Usuario usuario= new Usuario();  
    
        usuario.setIdUsuario(Integer.parseInt(req.getParameter("id")));
        
        UsuarioDAO daoUsuario = new UsuarioDAO(); 
        
        daoUsuario.deletarUsuario(usuario);
        this.consultaTodosUsuarios(req, resp);
    }
      
    public void alterarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
       
        int id = Integer.parseInt(req.getParameter("id"));
        String nomeCompleto = req.getParameter("nomeCompleto");
        String senha = req.getParameter("senha");
        String rg = req.getParameter("rg");
        String cpf = req.getParameter("cpf");
        String cep = req.getParameter("cep");
        String rua = req.getParameter("rua");
        String bairro = req.getParameter("bairro");
        String uf = req.getParameter("uf");
        int numero = Integer.parseInt(req.getParameter("numero"));
        String cidade = req.getParameter("cidade");
        String complemento = req.getParameter("complemento");
        
        List<Endereco> listaEnderecos = new ArrayList<>();
        Endereco endereco = new Endereco();
        
        endereco.setCep(cep);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setUf(uf);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setComplemento(complemento);
        
        Usuario usuario = new Usuario();
        
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setSenha(senha);
        usuario.setRg(rg);
        usuario.setCpf(cpf);
        
        listaEnderecos.add(endereco);
        usuario.setEnderecos(listaEnderecos);
        endereco.setUsuario(usuario);
        
        
        UsuarioDAO daoUsuario = new UsuarioDAO();
        
        daoUsuario.alterarUsuario(usuario);
        this.consultaTodosUsuarios(req, resp);        
    }
    
    public void consultarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException, SQLException{
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        
        UsuarioDAO daoUsuario = new UsuarioDAO();
        usuario = daoUsuario.consultarPorId(usuario);
        req.setAttribute("usuario", usuario);
        req.getRequestDispatcher("alterarUsuario.jsp").forward(req, resp);
        
    }
    
}

