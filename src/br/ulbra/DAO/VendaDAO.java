/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import static br.ulbra.DAO.AbstractDAO.getConnection;
import br.ulbra.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author devVHarthmann
 */
public class VendaDAO extends AbstractDAO implements CrudRepository<Venda>{

    @Override
    public void salvar(Venda v) throws SQLException {
        String sql = "INSERT INTO venda (dataVenda, valorTotal, idUsuario, idCliente) VALUES (?,?,?,?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, v.getDataVendaSql());
            ps.setDouble(2, v.getValorTotal());
            ps.setInt(3, v.getIdVendedor().getId_usuario());
            ps.setInt(4, v.getIdCliente().getIdCliente());
            
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Falha ao gerar venda.");
            } else {

            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    v.setIdVenda(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Venda buscarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Venda obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
