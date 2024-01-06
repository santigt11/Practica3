/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import modelo.Venta;

/**
 *
 * @author santi
 */
public class VentaControl {

    private Venta venta = new Venta();
    private DynamicList<Venta> ventas;

    public VentaControl(Venta casa) {
        this.venta = casa;
    }

    public VentaControl() {
        this.ventas = new DynamicList<>();    
    }
    

    //Metodo que permite guardar
    public Boolean guardar() {
        try {
            getVenta().setId(getVentas().getLength());
            getVentas().add(getVenta());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer posVerificar() throws EmptyException {
        
        Integer bandera = 0;

        for (Integer i = 0; i <= this.ventas.getLength(); i++) {
            
            if (this.getVentas().getInfo(i) == null) {
                bandera = i;
                break;
            }
        }
        return bandera;
    }

    public void imprimir() throws EmptyException {
        for (int i = 0; i < this.getVentas().getLength(); i++) {
            System.out.println(getVentas().getInfo(i));
        }
    }

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta casa) {
        this.venta = casa;
    }

    public DynamicList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(DynamicList<Venta> casas) {
        this.ventas = casas;
    }

    @Override
    public String toString() {
        return "DNI: ";
    }
}
