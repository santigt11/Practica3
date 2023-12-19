/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Archivos;

import controlador.DAO.DaoImplement;
import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import controlador.Utiles.Utiles;
import java.lang.reflect.Field;
import modelo.Casa;

/**
 *
 * @author santi
 */
public class CasaArchivos extends DaoImplement<Casa>{
    private DynamicList<Casa> casas;
    private Casa casa;

    public CasaArchivos() {
        super(Casa.class);
    }

    public DynamicList<Casa> getCasas() {
        casas = all();
        return casas;
    }

    public void setCasas(DynamicList<Casa> personas) {
        this.casas = personas;
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
    
    public Boolean persist(){
        casa.setId(all().getLength() + 1);
        return persist(casa);
    }
    
    public DynamicList<Casa> ordenar(DynamicList<Casa> lista, Integer tipo, String field) throws EmptyException, Exception {
        Field attribute = Utiles.getField(Casa.class, field);
        Integer n = lista.getLength();
        Casa[] casas = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Casa t = casas[i];
                for (int j = i + 1; j < n; j++) {
//                    if (casas[j].getApellidos().compareTo(t.getApellidos()) < 0) {
                    if (casas[j].compare(t, field, tipo)) {
                        t = casas[j];
                        k = j;
                    }
                }
                casas[k] = casas[i];
                casas[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(casas);
    }
    
    public DynamicList<Casa> shellSort(DynamicList<Casa> lista, Integer tipo, String field) throws EmptyException, Exception {
        Field attribute = Utiles.getField(Casa.class, field);
        Integer brecha5 = lista.getLength()/2;
        Casa[] casas = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < brecha; i++) {
                int k = i;
                Casa t = casas[i];
                for (int j = i + 1; j < brecha; j++) {
//                    if (casas[j].getApellidos().compareTo(t.getApellidos()) < 0) {
                    if (casas[j].compare(t, field, tipo)) {
                        t = casas[j];
                        k = j;
                    }
                }
                casas[k] = casas[i];
                casas[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(casas);
    }
}
