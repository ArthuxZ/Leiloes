/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        try {
            conectaDAO conector = new conectaDAO();
            conector.conectar();
            Statement stmt = conectaDAO.conn.createStatement();
            
            String sql = "INSERT INTO produtos(nome, valor, status) VALUES('" + produto.getNome() + "','" + produto.getValor() + "','" + produto.getStatus() + "')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso em cadastramento de produto.");
        } catch (SQLException ex) {
           System.out.println( "Erro inserindo dados");
        }        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }        
}