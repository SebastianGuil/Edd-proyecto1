/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Representa un Arco en una lista de adyacencia de un grafo.
 * <p>
 * Esta clase funciona como una lista enlazada simple, 
 * almacenando el nombre del vértice de destino y apuntador al siguiente
 * @author Sebastian Guillen
 */
public class Arco {
    /**
     * El nombre del vértice al que apunta este arco.
     */
    String destino;
    /**
     * Apuntador al siguiente arco en la lista de adyacencia.
     * Su valor es null si este es el último arco de la lista.
     */
    Arco Pnext;
    /**
     * Constructor de la clase Arco
     * <p>
     * Inicializa un nuevo arco estableciendo su destino y 
     * el apuntador al siguiente arco como null
     * @param dato El nombre del vértice de destino al que apuntará  este arco
     */
    public Arco(String dato) {
        this.destino = dato;
        this.Pnext = null;
    }
}
