/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import javax.swing.table.AbstractTableModel;
import modelo.Casa;
import modelo.Venta;

/**
 *
 * @author santi
 */
public class ModeloTablaCasa extends AbstractTableModel {

    private DynamicList<Casa> casas;

    @Override
    public int getRowCount() {
        return casas.getLength();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Casa p = casas.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (p != null) ? p.getDireccion(): " ";
                case 1:
                    return (p != null) ? p.getTipoCasa():" ";
                case 2:
                    return (p != null) ? p.getArea().getAnchoTerreno() * p.getArea().getLargoTerreno(): " ";    
                case 3:
                    return (p != null) ? p.getArea().getAnchoConstruccion()* p.getArea().getLargoConstruccion(): " ";    
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
                return "TIPO_CASA";
            case 2:
                return "AREA_TERRENO (m2)";
            case 3:
                return "AREA_CONSTRUCCION (m2)";
            default:
                return null;
        }
    }

    public DynamicList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(DynamicList<Casa> casas) {
        this.casas = casas;
    }
}
