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
public class CasaArchivos extends DaoImplement<Casa> {

    private DynamicList<Casa> casas;
    private Casa casa;

    public CasaArchivos() {
        super(Casa.class);
    }

    Integer valorQuick = 0;
    Integer valorMerge = 0;

    public DynamicList<Casa> getCasas() {
        return casas;
    }

    public DynamicList<Casa> getCasasTotal() {
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

    public Boolean persist() {
        casa.setId(all().getLength() + 1);
        return persist(casa);
    }

//    public DynamicList<Casa> ordenarShell(DynamicList<Casa> lista, Integer tipo, String field) throws EmptyException, Exception {
//        Casa[] casas = lista.toArray();
//        int brecha = casas.length / 2;
//
//        while (brecha > 0) {
//            for (int recorrido = brecha; recorrido < casas.length; recorrido++) {
//                Casa buffer = casas[recorrido];
//                int indice = recorrido;
//
//                while (indice >= brecha && buffer.compare(casas[indice - brecha], field, tipo)) {
//                    casas[indice] = casas[indice - brecha];
//                    indice -= brecha;
//                }
//                casas[indice] = buffer;
//            }
//
//            brecha = brecha / 2;
//        }
//        return lista.toList(casas);
//    }
    //QuickSort
    public DynamicList<Casa> ordenarQuick(DynamicList<Casa> lista, String field, Integer tipo) throws EmptyException {
        Casa[] array = lista.toArray();
        ordenarRecursivo(array, 0, array.length - 1, field, tipo);
        System.out.println("Iteraciones Quicksort " + valorQuick);
        valorQuick = 0;
        return lista.toList(array);
    }

    private Integer ordenarSeccion(Casa[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        Casa pivote = array[indiceDer];
        int elemento = indiceIzq - 1;

        for (int indice = indiceIzq; indice < indiceDer; indice++) {
            valorQuick++;
            if (array[indice].compare(pivote, field, tipo)) {
                elemento++;
                Casa bufferI = array[elemento];
                array[elemento] = array[indice];
                array[indice] = bufferI;
            }
        }
        elemento++;
        Casa bufferPivote = array[elemento];
        array[elemento] = array[indiceDer];
        array[indiceDer] = bufferPivote;

        return elemento;
    }

    private void ordenarRecursivo(Casa[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        if (indiceIzq < indiceDer) {
            Integer inicio = ordenarSeccion(array, indiceIzq, indiceDer, field, tipo);
            ordenarRecursivo(array, indiceIzq, inicio - 1, field, tipo);
            ordenarRecursivo(array, inicio + 1, indiceDer, field, tipo);
        }
    }

    //MergeSort
    public DynamicList<Casa> ordenarMerge(DynamicList<Casa> lista, String field, Integer tipo) throws EmptyException {
        if (lista.getLength() > 1) {
            DynamicList<Casa> izquierda = new DynamicList<>();
            DynamicList<Casa> derecha = new DynamicList<>();
            int mitad = lista.getLength() / 2;
            for (int i = 0; i < mitad; i++) {
                izquierda.add(lista.getInfo(i));
            }
            for (int i = mitad; i < lista.getLength(); i++) {
                derecha.add(lista.getInfo(i));
            }
            izquierda = ordenarMerge(izquierda, field, tipo);
            derecha = ordenarMerge(derecha, field, tipo);
            mezclar(lista, izquierda, derecha, field, tipo);
        }
        return lista;
    }

    private void mezclar(DynamicList<Casa> lista, DynamicList<Casa> list1, DynamicList<Casa> list2, String field, Integer tipo) throws EmptyException {
        int indiceIzq = 0, indiceDer = 0, indiceLista = 0;
        Casa[] izquierda = list1.toArray();
        Casa[] derecha = list2.toArray();
        while (indiceIzq < izquierda.length && indiceDer < derecha.length) {
            if (izquierda[indiceIzq].compare(derecha[indiceDer], field, tipo)) {
                lista.merge(izquierda[indiceIzq], indiceLista);
                indiceIzq += 1;
            } else {
                lista.merge(derecha[indiceDer], indiceLista);
                indiceDer += 1;
            }
            indiceLista += 1;
            valorMerge++;
        }

        while (indiceIzq < izquierda.length) {
            lista.merge(izquierda[indiceIzq], indiceLista);
            indiceIzq += 1;
            indiceLista += 1;
            valorMerge++;
        }

        while (indiceDer < derecha.length) {
            lista.merge(derecha[indiceDer], indiceLista);
            indiceDer += 1;
            indiceLista += 1;
            valorMerge++;
        }
    }

    public DynamicList<Casa> ordenar(DynamicList<Casa> lista, String field, Integer tipo, Integer ordenar) throws EmptyException {
        if (ordenar == 0) {
            System.out.println("Iteraciones Merge " + valorMerge);
            valorMerge = 0;
            return ordenarMerge(lista, field, tipo);
        } else {
            return ordenarQuick(lista, field, tipo);
        }
    }
}
