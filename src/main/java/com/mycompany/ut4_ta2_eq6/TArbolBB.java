package com.mycompany.ut4_ta2_eq6;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    public boolean insertarConContador(TElementoAB<T> unElemento, int[] contador) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            contador[0] = 0;
            return raiz.insertarConContador(unElemento, contador);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.raiz == null){
            return null;
        }
        return raiz.buscar(unaEtiqueta);
    }

    public TElementoAB<T> buscarConContador(Comparable unaEtiqueta, int[] contador) {
        if (esVacio()) {
            return null;
        } else {
            contador[0] = 0;
            return raiz.buscarConContador(unaEtiqueta, contador);
        }
    }

    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }
        else {
            System.out.println("Arbol vacio");
        }
    }

    public boolean esVacio() {
        return raiz == null;
    }
}
