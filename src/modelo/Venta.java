/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enumeraciones.TipoCasa;

/**
 *
 * @author santi
 */
public class Venta {

    private Integer id;
    private Casa casa;
    private Double precio;
    private Vendedor vendedor;

    public Venta(Integer id, Casa casa, Double precio, Vendedor vendedor) {
        this.id = id;
        this.casa = casa;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public Venta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Double getPrecio() {
        Double precio = calcularPrecio();
        switch (casa.getTipoCasa()) {
            case LADRILLO:
                return this.precio = precio + precio * 1;
            case CONCRETO:
                return this.precio = precio + precio * 0.75;
            case MADERA:
                return this.precio = precio + precio * 0.5;
            default:
                return null;
        }
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double calcularPrecio() {
        if (casa == null || casa.getArea() == null) {
            return 0.0;
        } else {
            Double construccion = casa.getArea().getAnchoConstruccion() * casa.getArea().getLargoConstruccion();
            Double terreno = casa.getArea().getAnchoTerreno() * casa.getArea().getLargoTerreno();
            return construccion + terreno;
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
}
