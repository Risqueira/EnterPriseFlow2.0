/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.DAO.VendaDAO;
import br.ulbra.model.Venda;
import java.sql.SQLException;

/**
 *
 * @author devVHarthmann
 */
public class VendaController {
    private VendaDAO dao = new VendaDAO();
    
    public void salvar(Venda v) throws SQLException{
        dao.salvar(v);
    }
}
