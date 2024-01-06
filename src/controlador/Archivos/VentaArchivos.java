/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Archivos;

import controlador.DAO.DaoImplement;
import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import modelo.Venta;

/**
 *
 * @author santi
 */
public class VentaArchivos extends DaoImplement<Venta> {

    private DynamicList<Venta> ventas;
    private Venta venta;

    Integer valorQuick = 0;
    Integer valorMerge = 0;

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

    public Boolean persist() {
        venta.setId(all().getLength() + 1);
        return persist(venta);
    }

//    ShellSort 
//    public DynamicList<Venta> ordenarShell(DynamicList<Venta> lista, Integer tipo, String field) throws EmptyException, Exception {
//        Venta[] ventas = lista.toArray();
//        
//        int brecha = ventas.length / 2;
//
//        while (brecha > 0) {
//            for (int recorrido = brecha; recorrido < ventas.length; recorrido++) {
//                Venta buffer = ventas[recorrido];
//                int indice = recorrido;
//
//                while (indice >= brecha && buffer.compare(ventas[indice - brecha], field, tipo)) {
//                    ventas[indice] = ventas[indice - brecha];
//                    indice -= brecha;
//                }
//                ventas[indice] = buffer;
//            }
//
//            brecha = brecha / 2;
//        }
//        return lista.toList(ventas);
//    }
    //QuickSort
    public DynamicList<Venta> ordenarQuick(DynamicList<Venta> lista, String field, Integer tipo) throws EmptyException {
        Venta[] array = lista.toArray();
        ordenarRecursivo(array, 0, array.length - 1, field, tipo);
        System.out.println("Iteraciones Quicksort " + valorQuick);
        valorQuick = 0;
        return lista.toList(array);
    }

    private Integer ordenarSeccion(Venta[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        Venta pivote = array[indiceDer];
        int elemento = indiceIzq - 1;

        for (int indice = indiceIzq; indice < indiceDer; indice++) {
            valorQuick++;
            if (array[indice].compare(pivote, field, tipo)) {
                elemento++;
                Venta bufferI = array[elemento];
                array[elemento] = array[indice];
                array[indice] = bufferI;
            }
        }
        elemento++;
        Venta bufferPivote = array[elemento];
        array[elemento] = array[indiceDer];
        array[indiceDer] = bufferPivote;

        return elemento;
    }

    private void ordenarRecursivo(Venta[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        if (indiceIzq < indiceDer) {
            Integer inicio = ordenarSeccion(array, indiceIzq, indiceDer, field, tipo);
            ordenarRecursivo(array, indiceIzq, inicio - 1, field, tipo);
            ordenarRecursivo(array, inicio + 1, indiceDer, field, tipo);
        }
    }

    //MergeSort
    public DynamicList<Venta> ordenarMerge(DynamicList<Venta> lista, String field, Integer tipo) throws EmptyException {
        if (lista.getLength() > 1) {
            DynamicList<Venta> izquierda = new DynamicList<>();
            DynamicList<Venta> derecha = new DynamicList<>();
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

    private void mezclar(DynamicList<Venta> lista, DynamicList<Venta> list1, DynamicList<Venta> list2, String field, Integer tipo) throws EmptyException {
        int indiceIzq = 0, indiceDer = 0, indiceLista = 0;
        Venta[] izquierda = list1.toArray();
        Venta[] derecha = list2.toArray();
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

    public DynamicList<Venta> ordenar(DynamicList<Venta> lista, String field, Integer tipo, Integer ordenar) throws EmptyException {
        if (ordenar == 0) {
            System.out.println("Iteraciones Merge " + valorMerge);
            valorMerge = 0;
            return ordenarMerge(lista, field, tipo);
        } else {
            return ordenarQuick(lista, field, tipo);
        }
    }

    public static void main(String[] args) throws EmptyException {
        VentaArchivos v = new VentaArchivos();
        System.out.println(v.all().toString());
        System.out.println(v.ordenarQuick(v.all(), "precio", 1).toString());
    }
}
