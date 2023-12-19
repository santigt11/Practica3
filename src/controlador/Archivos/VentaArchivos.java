/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Archivos;

import controlador.DAO.DaoImplement;
import controlador.TDA.listas.DynamicList;
import modelo.Venta;

/**
 *
 * @author santi
 */
public class VentaArchivos extends DaoImplement<Venta>{
    private DynamicList<Venta> ventas;
    private Venta venta;

    public VentaArchivos() {
        super(Venta.class);
    }

    public DynamicList<Venta> getVentas() {
        ventas = all();
        return ventas;
    }

    public void setVentas(DynamicList<Venta> ventas) {
        this.ventas = ventas;
    }

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Boolean persist(){
        venta.setId(all().getLength() + 1);
        return persist(venta);
    }
}
