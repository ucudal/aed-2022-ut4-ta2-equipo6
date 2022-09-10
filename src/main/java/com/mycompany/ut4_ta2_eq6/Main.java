package com.mycompany.ut4_ta2_eq6;


/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolBB<Integer> arbol = new TArbolBB<>();

        /*
        Ejercicio 1 - Subequipo A
         */
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src\\claves1.txt");
        String[] clavesInsertadas = new String[claves.length];
        int[] contadorInserciones = {0};
        for (int i = 0; i < claves.length; i++) {
            int clave = Integer.parseInt(claves[i]);
            TElementoAB<Integer> elementoAInsertar = new TElementoAB<>(clave, null);
            boolean insertado = arbol.insertarConContador(elementoAInsertar, contadorInserciones);
            if (insertado) {
                clavesInsertadas[i] = clave + ", " + (contadorInserciones[0]);
            } else {
                clavesInsertadas[i] = clave + ", " + "-1";
            }
        }
        ManejadorArchivosGenerico.escribirArchivo("src\\clavesInsertadas.txt", clavesInsertadas);
        System.out.println("Preorden: " + arbol.preOrden());


        /*
        Ejercicio 1 - Subequipo B
         */
        String[] consultas = ManejadorArchivosGenerico.leerArchivo("src\\consultaPrueba.txt");
        String[] clavesBuscadas = new String[consultas.length];
        int[] contadorBusquedas = {0};
        for (int i = 0; i < consultas.length; i++) {
            int clave = Integer.parseInt(consultas[i]);
            TElementoAB<Integer> buscado = arbol.buscarConContador(clave, contadorBusquedas);
            if (buscado != null) {
                clavesBuscadas[i] = clave + ", " + (contadorBusquedas[0]);
            } else {
                clavesBuscadas[i] = clave + ", " + "-1";
            }
        }
        ManejadorArchivosGenerico.escribirArchivo("src\\clavesBuscadas.txt", clavesBuscadas);
        System.out.println("Inorden: " + arbol.inOrden());
        System.out.println("Postorden: " + arbol.postOrden());


        /*
        Ejercicio 2
         */
        TArbolBB<Integer> arbol2 = new TArbolBB<>();
        int[] clavesParaInsertar = {12, 25, 14, 1, 33, 88, 45, 2, 7, 66, 5, 99};
        for (int j : clavesParaInsertar) {
            TElementoAB<Integer> nuevaClave = new TElementoAB<>(j, null);
            arbol2.insertar(nuevaClave);
        }

        // Imprimimos preorden, inorden y postorden.
        System.out.println("\n");
        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Inorden: " + arbol2.inOrden());
        System.out.println("Postorden: " + arbol2.postOrden());

        // Eliminamos las claves como en el ejercicio de clase.
        arbol2.eliminar(99);
        arbol2.eliminar(2);
        arbol2.eliminar(12);
        arbol2.eliminar(33);

        // Volvemos a imprimir el preorden, inorden y postorden.
        System.out.println("\n");
        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Inorden: " + arbol2.inOrden());
        System.out.println("Postorden: " + arbol2.postOrden());
    }
}
