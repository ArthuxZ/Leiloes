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
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

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
    
    public static void venderProduto(int idd){
        try {
            conectaDAO conector = new conectaDAO();
            conector.conectar();
            Statement stmt = conectaDAO.conn.createStatement();
            
            String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = " + idd;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso. Venda realizada!");
            listagemVIEW.listarProdutos();
            
        } catch (SQLException sqle) {
           JOptionPane.showMessageDialog(null, "Erro. Venda não realizada.");
        } 
    }        
    
    public static void listarProdutosVendidos(){
       
        try{
        ((DefaultTableModel) (listagemVendasVIEW.listaProdutosVendidos).getModel()).setRowCount(0);
        
        conectaDAO conector = new conectaDAO();
        conector.conectar();
        DefaultTableModel model = (DefaultTableModel) (listagemVendasVIEW.listaProdutosVendidos).getModel();
        String sql = "SELECT*FROM produtos WHERE status = 'Vendido'";
        Statement stmt = conectaDAO.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                    String id = rs.getString("id");
                    String nome = rs.getString("nome");
                    String valor = rs.getString("valor");
                    String status = rs.getString("status");
                    model.addRow(new Object[]{id, nome, valor, status});
            }   
        } catch (SQLException ex) {
            System.out.println( "Erro: " + ex.getMessage());
        }  
    }
}