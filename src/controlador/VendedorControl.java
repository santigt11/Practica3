/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import modelo.Venta;
import modelo.Vendedor;

/**
 *
 * @author santi
 */
public class VendedorControl {

    private Vendedor vendedor = new Vendedor();
    private DynamicList<Vendedor> vendedores;

    public VendedorControl(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public VendedorControl() {
        this.vendedores = new DynamicList<>();    
    }
    

    //Metodo que permite guardar
    public Boolean guardar() {
        
        try {
            getVendedor().setId(getVendedores().getLength());
            getVendedores().add(getVendedor());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer posVerificar() throws EmptyException {
        
        Integer bandera = 0;

        for (Integer i = 0; i <= this.vendedores.getLength(); i++) {
            
            if (this.getVendedores().getInfo(i) == null) {
                bandera = i;
                break;
            }
        }
        return bandera;
    }

    public void imprimir() throws EmptyException {
        for (int i = 0; i < this.getVendedores().getLength(); i++) {
            System.out.println(getVendedores().getInfo(i));
        }
    }

    public Vendedor getVendedor() {
        if (vendedor == null) {
            vendedor = new Vendedor();
        }
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public DynamicList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(DynamicList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    @Override
    public String toString() {
        return "DNI: ";
    }
}
