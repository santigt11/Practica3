/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Archivos;

import controlador.DAO.DaoImplement;
import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import modelo.Vendedor;

/**
 *
 * @author santi
 */
public class VendedorArchivos extends DaoImplement<Vendedor> {

    private DynamicList<Vendedor> vendedores;
    private Vendedor vendedor;

    Integer valorQuick = 0;
    Integer valorMerge = 0;

    public VendedorArchivos() {
        super(Vendedor.class);
    }

    public DynamicList<Vendedor> getVendedores() {
        vendedores = all();
        return vendedores;
    }

    public void setVendedores(DynamicList<Vendedor> vendedores) {
        this.vendedores = vendedores;
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

    public Boolean persist() {
        vendedor.setId(all().getLength() + 1);
        return persist(vendedor);
    }

    //Shell
//    public DynamicList<Vendedor> ordenarShell(DynamicList<Vendedor> lista, Integer tipo, String field) throws EmptyException, Exception {
//        Vendedor[] vendedores = lista.toArray();
//        int brecha = vendedores.length / 2;
//
//        while (brecha > 0) {
//            for (int recorrido = brecha; recorrido < vendedores.length; recorrido++) {
//                Vendedor buffer = vendedores[recorrido];
//                int indice = recorrido;
//
//                while (indice >= brecha && buffer.compare(vendedores[indice - brecha], field, tipo)) {
//                    vendedores[indice] = vendedores[indice - brecha];
//                    indice -= brecha;
//                }
//                vendedores[indice] = buffer;
//            }
//
//            brecha = brecha / 2;
//        }
//        return lista.toList(vendedores);
//    }
//    
//    
//    public DynamicList<Vendedor> ordenar(DynamicList<Vendedor> lista, String field, Integer tipo) throws EmptyException {
//        if (lista.getLength() > 1) {
//            DynamicList<Vendedor> izquierda = new DynamicList<>();
//            DynamicList<Vendedor> derecha = new DynamicList<>();
//            int mitad = lista.getLength() / 2;
//            for (int i = 0; i < mitad; i++) {
//                izquierda.add(lista.getInfo(i));
//            }
//            for (int i = mitad; i < lista.getLength(); i++) {
//                derecha.add(lista.getInfo(i));
//            }
//            izquierda = ordenar(izquierda, field, tipo);
//            derecha = ordenar(derecha, field, tipo);
//            mezclar(lista, izquierda, derecha, field, tipo);
//        }
//        return lista;
//    }
//
//    private void mezclar(DynamicList<Vendedor> lista, DynamicList<Vendedor> list1, DynamicList<Vendedor> list2, String field, Integer tipo) throws EmptyException {
//        int indiceIzq = 0, indiceDer = 0, indiceLista = 0;
//        Vendedor[] izquierda = list1.toArray();
//        Vendedor[] derecha = list2.toArray();
//        while (indiceIzq < izquierda.length && indiceDer < derecha.length) {
//            if (izquierda[indiceIzq].compare(derecha[indiceDer], field, tipo)) {
//                lista.merge(izquierda[indiceIzq], indiceLista);
//                indiceIzq += 1;
//            } else {
//                lista.merge(derecha[indiceDer], indiceLista);
//                indiceDer += 1;
//            }
//            indiceLista += 1;
//        }
//        
//        while (indiceIzq < izquierda.length) {
//            lista.merge(izquierda[indiceIzq], indiceLista);
//            indiceIzq += 1;
//            indiceLista += 1;
//        }
//        
//        while (indiceDer < derecha.length) {
//            lista.merge(derecha[indiceDer], indiceLista);
//            indiceDer += 1;
//            indiceLista += 1;
//        }
//    }
    //Quicksort
    public DynamicList<Vendedor> ordenarQuick(DynamicList<Vendedor> lista, String field, Integer tipo) throws EmptyException {
        Vendedor[] array = lista.toArray();
        ordenarRecursivo(array, 0, array.length - 1, field, tipo);
        System.out.println("Iteraciones Quicksort " + valorQuick);
        valorQuick = 0;
        return lista.toList(array);
    }

    private Integer ordenarSeccion(Vendedor[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        Vendedor pivote = array[indiceDer];
        int elemento = indiceIzq - 1;

        for (int indice = indiceIzq; indice < indiceDer; indice++) {
            valorQuick++;
            if (array[indice].compare(pivote, field, tipo)) {
                elemento++;
                Vendedor bufferI = array[elemento];
                array[elemento] = array[indice];
                array[indice] = bufferI;
            }
        }
        elemento++;
        Vendedor bufferPivote = array[elemento];
        array[elemento] = array[indiceDer];
        array[indiceDer] = bufferPivote;

        return elemento;
    }

    private void ordenarRecursivo(Vendedor[] array, Integer indiceIzq, Integer indiceDer, String field, Integer tipo) {
        if (indiceIzq < indiceDer) {
            Integer inicio = ordenarSeccion(array, indiceIzq, indiceDer, field, tipo);
            ordenarRecursivo(array, indiceIzq, inicio - 1, field, tipo);
            ordenarRecursivo(array, inicio + 1, indiceDer, field, tipo);
        }
    }

    //MergeSort
    public DynamicList<Vendedor> ordenarMerge(DynamicList<Vendedor> lista, String field, Integer tipo) throws EmptyException {
        if (lista.getLength() > 1) {
            DynamicList<Vendedor> izquierda = new DynamicList<>();
            DynamicList<Vendedor> derecha = new DynamicList<>();
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

    private void mezclar(DynamicList<Vendedor> lista, DynamicList<Vendedor> list1, DynamicList<Vendedor> list2, String field, Integer tipo) throws EmptyException {
        int indiceIzq = 0, indiceDer = 0, indiceLista = 0;
        Vendedor[] izquierda = list1.toArray();
        Vendedor[] derecha = list2.toArray();
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

    public DynamicList<Vendedor> ordenar(DynamicList<Vendedor> lista, String field, Integer tipo, Integer ordenar) throws EmptyException {
        if (ordenar == 0) {
            System.out.println("Iteraciones Merge " + valorMerge);
            valorMerge = 0;
            return ordenarMerge(lista, field, tipo);
        } else {
            return ordenarQuick(lista, field, tipo);
        }
    }
}
