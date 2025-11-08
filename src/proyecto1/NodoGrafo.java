/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class NodoGrafo {
    
    String dato;
    ListaAdyacencia lista;
    NodoGrafo Pnext;
    boolean Visitado;
    
    public NodoGrafo(String x) {
        this.dato = x;
        this.lista = new ListaAdyacencia();
        this.Pnext = null;
        this.Visitado = false;
    }
}
