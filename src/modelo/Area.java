/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author santi
 */
public class Area {
    private Double anchoConstruccion;
    private Double largoConstruccion;
    private Double anchoTerreno;
    private Double largoTerreno;

    public Area(Double anchoConstruccion, Double largoConstruccion, Double anchoTerreno, Double largoTerreno) {
        this.anchoConstruccion = anchoConstruccion;
        this.largoConstruccion = largoConstruccion;
        this.anchoTerreno = anchoTerreno;
        this.largoTerreno = largoTerreno;
    }

    public Area() {
    }

    public Double getAnchoConstruccion() {
        return anchoConstruccion;
    }

    public void setAnchoConstruccion(Double anchoConstruccion) {
        this.anchoConstruccion = anchoConstruccion;
    }

    public Double getLargoConstruccion() {
        return largoConstruccion;
    }

    public void setLargoConstruccion(Double largoConstruccion) {
        this.largoConstruccion = largoConstruccion;
    }

    public Double getAnchoTerreno() {
        return anchoTerreno;
    }

    public void setAnchoTerreno(Double anchoTerreno) {
        this.anchoTerreno = anchoTerreno;
    }

    public Double getLargoTerreno() {
        return largoTerreno;
    }

    public void setLargoTerreno(Double largoTerreno) {
        this.largoTerreno = largoTerreno;
    }
    
}
