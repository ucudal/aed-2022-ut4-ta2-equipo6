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
        //ManejadorArchivosGenerico mag = new ManejadorArchivosGenerico();
        
        String [] leerConsultas = ManejadorArchivosGenerico.leerArchivo("consultaPrueba.txt");
        
        String[] clavesBuscadas = new String[leerConsultas.length];
        
        int laClave = 0;
        TArbolBB<Integer> arbol = new TArbolBB<>();
        
        int[] contadorBusquedas = {0};
        
        for (int i =0; i<leerConsultas.length;i++){
            laClave=Integer.parseInt(leerConsultas[i]);
            TElementoAB<Integer> buscado = arbol.buscarConContador(laClave, contadorBusquedas);           
            clavesBuscadas[i]= String.valueOf(laClave) + contadorBusquedas;  
     
        }
        
        ManejadorArchivosGenerico.escribirArchivo("clavesBuscadas.txt",clavesBuscadas);
        
        
        
    }
    
}
