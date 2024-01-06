/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public class Vendedor {
    Integer id;
    String cedula;
    String nombres;
    String apellidos;
    String telefono;

    public Vendedor(Integer id, String cedula, String nombres, String apellidos, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public Vendedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Boolean compare(Vendedor v, String field, Integer type) {
        //0 menor 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("apellidos")) {
                    return String.valueOf(apellidos).compareTo(String.valueOf(v.getApellidos())) < 0;
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(v.getCedula()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(v.getId()) < 0;
                } else if (field.equalsIgnoreCase("nombres")) {
                    return nombres.compareTo(v.getNombres()) < 0;
                } else if (field.equalsIgnoreCase("telefono")) {
                    return telefono.compareTo(v.getTelefono()) < 0;
                }
            case 1:
                if (field.equalsIgnoreCase("apellidos")) {
                    return String.valueOf(apellidos).compareTo(String.valueOf(v.getApellidos())) > 0;
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(v.getCedula()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(v.getId()) > 0;
                } else if (field.equalsIgnoreCase("nombres")) {
                    return nombres.compareTo(v.getNombres()) > 0;
                } else if (field.equalsIgnoreCase("telefono")) {
                    return telefono.compareTo(v.getTelefono()) > 0;
                }
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return getApellidos() + " " + getCedula() + " " +getNombres();
    }
}
