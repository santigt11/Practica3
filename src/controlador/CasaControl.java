/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import modelo.Casa;

/**
 *
 * @author santi
 */
public class CasaControl {

    private Casa casa = new Casa();
    private DynamicList<Casa> casas;

    public CasaControl(Casa casa) {
        this.casa = casa;
    }

    public CasaControl() {
        this.casas = new DynamicList<>();    
    }
    

    //Metodo que permite guardar
    public Boolean guardar() {
        try {
            getCasa().setId(getCasas().getLength());
            getCasas().add(getCasa());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer posVerificar() throws EmptyException {
        
        Integer bandera = 0;

        for (Integer i = 0; i <= this.casas.getLength(); i++) {
            
            if (this.getCasas().getInfo(i) == null) {
                bandera = i;
                break;
            }
        }
        return bandera;
    }

    public void imprimir() throws EmptyException {
        for (int i = 0; i < this.getCasas().getLength(); i++) {
            System.out.println(getCasas().getInfo(i));
        }
    }

    public Casa getCasa() {
        if (casa == null) {
            casa = new Casa();
        }
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public DynamicList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(DynamicList<Casa> casas) {
        this.casas = casas;
    }

    @Override
    public String toString() {
        return "DNI: ";
    }
}
