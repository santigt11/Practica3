/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import javax.swing.table.AbstractTableModel;
import modelo.Vendedor;

/**
 *
 * @author santi
 */
public class ModeloTablaVendedor extends AbstractTableModel {

    private DynamicList<Vendedor> vendedores;

    @Override
    public int getRowCount() {
        return vendedores.getLength();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Vendedor p = vendedores.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (p != null) ? p.getCedula(): " ";
                case 1:
                    return (p != null) ? p.getApellidos() + " " + p.getNombres() : "";
                case 2:
                    return (p != null) ? p.getTelefono(): "";    
                default:
                    return null;
            }
        } catch (EmptyException ex) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "CEDULA";
            case 1:
                return "USUARIO";
            case 2:
                return "TELEFONO";
            default:
                return null;
        }
    }

    public DynamicList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(DynamicList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

}
