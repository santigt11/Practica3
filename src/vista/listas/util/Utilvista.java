/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.TDA.listas.Exception.EmptyException;
import enumeraciones.TipoCasa;
import javax.swing.JComboBox;

/**
 *
 * @author santi
 */
public class Utilvista {

    public static void cargarcomboTiposCasa(JComboBox cbx) throws EmptyException {
        cbx.removeAllItems();
        cbx.addItem(TipoCasa.CONCRETO);
        cbx.addItem(TipoCasa.LADRILLO);
        cbx.addItem(TipoCasa.MADERA);
    }

    public static TipoCasa obtenerTipoCasaControl(JComboBox cbx) {
        return (TipoCasa) cbx.getSelectedItem();
    }
}
