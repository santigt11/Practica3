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
public class Casa {

    private Integer id;
    private String direccion;
    private TipoCasa tipoCasa;
    private Area area;

    public Casa(Integer id, String direccion, TipoCasa tipoCasa, Area area) {
        this.id = id;
        this.direccion = direccion;
        this.tipoCasa = tipoCasa;
        this.area = area;
    }

    public Casa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoCasa getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(Integer index) {
        if (index == 0) {
            tipoCasa = TipoCasa.CONCRETO;
        } else if (index == 1) {
            tipoCasa = TipoCasa.LADRILLO;
        } else {
            tipoCasa = TipoCasa.MADERA;
        }
    }

    public Boolean compare(Casa c, String field, Integer type) {
        //0 menor 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("areaConstruccion")) {
                    return String.valueOf(area.getAnchoConstruccion() * area.getLargoConstruccion()).
                            compareTo(String.valueOf(c.getArea().getAnchoConstruccion() * c.getArea().getLargoConstruccion())) < 0;
                } else if (field.equalsIgnoreCase("areaTerreno")) {
                    return String.valueOf((area.getAnchoTerreno() * area.getLargoTerreno())).
                            compareTo(String.valueOf((c.getArea().getAnchoTerreno() * c.getArea().getLargoTerreno()))) < 0;
                }else if (field.equalsIgnoreCase("direccion")) {
                    return direccion.compareTo(c.getDireccion()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(c.getId()) < 0;
                } else if (field.equalsIgnoreCase("tipoCasa")) {
                    return tipoCasa.compareTo(c.getTipoCasa()) < 0;
                }
            case 1:
                if (field.equalsIgnoreCase("areaConstruccion")) {
                    return String.valueOf((area.getAnchoConstruccion() * area.getLargoConstruccion())).
                            compareTo(String.valueOf(c.getArea().getAnchoConstruccion() * c.getArea().getLargoConstruccion())) > 0;
                } else if (field.equalsIgnoreCase("areaTerreno")) {
                    return String.valueOf(area.getAnchoTerreno()* area.getLargoTerreno()).
                            compareTo(String.valueOf(c.getArea().getAnchoTerreno()* c.getArea().getLargoTerreno())) > 0;
                }else if (field.equalsIgnoreCase("direccion")) {
                    return direccion.compareTo(c.getDireccion()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(c.getId()) > 0;
                } else if (field.equalsIgnoreCase("tipoCasa")) {
                    return tipoCasa.compareTo(c.getTipoCasa()) > 0;
                }
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public String toString() {
        return getDireccion()+ " " + getId() + "  Construccion:" + getArea().getAnchoConstruccion() * getArea().getLargoConstruccion() +  "  Terreno:" +getArea().getAnchoTerreno()* getArea().getLargoTerreno();
    }
}
