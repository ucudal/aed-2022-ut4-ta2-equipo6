package com.mycompany.ut4_ta2_eq6;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return 
     */
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        }
        if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscarConContador(Comparable unaEtiqueta, int[] contador) {
        contador[0]++;
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        }else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscarConContador(unaEtiqueta, contador);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscarConContador(unaEtiqueta, contador);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return getHijoIzq().insertar(elemento);
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return getHijoDer().insertar(elemento);
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean insertarConContador(TElementoAB<T> elemento, int[] contador) {
        contador[0]++;
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return getHijoIzq().insertarConContador(elemento, contador);
            }
        } else if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return getHijoDer().insertarConContador(elemento, contador);
            }
        } else {
            return false;
        }
    }

    @Override
    public String preOrden() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(etiqueta.toString());
        if (hijoIzq != null) {
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            resultado.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            resultado.append(getHijoDer().preOrden());
        }
        return resultado.toString();
    }

    @Override
    public String inOrden() {
        StringBuilder resultado = new StringBuilder();
        if (hijoIzq != null) {
            resultado.append(getHijoIzq().inOrden());
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        resultado.append(etiqueta.toString());
        if (hijoDer != null) {
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            resultado.append(getHijoDer().inOrden());
        }

        return resultado.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder resultado = new StringBuilder();
        if (hijoIzq != null) {
            resultado.append(getHijoIzq().postOrden());
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            resultado.append(getHijoDer().postOrden());
            resultado.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        resultado.append(etiqueta.toString());
        return resultado.toString();
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   	
}
