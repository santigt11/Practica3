/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import javax.swing.table.AbstractTableModel;
import modelo.Venta;

/**
 *
 * @author santi
 */
public class ModeloTablaVenta extends AbstractTableModel {

    private DynamicList<Venta> ventas;

    @Override
    public int getRowCount() {
        return ventas.getLength();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Venta p = ventas.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (p != null) ? p.getCasa().getDireccion(): " ";
                case 1:
                    return (p != null) ? p.getCasa().getTipoCasa(): " ";
                case 2:
                    return (p != null) ? p.getPrecio(): " ";    
                case 3:
                    return (p != null) ? p.getVendedor().getApellidos(): " ";    
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
                return "DIRECCION";
            case 1:
                return "TIPO DE CASA";
            case 2:
                return "PRECIO";
            case 3:
                return "VENDEDOR";
            default:
                return null;
        }
    }

    public DynamicList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(DynamicList<Venta> ventas) {
        this.ventas = ventas;
    }

}
