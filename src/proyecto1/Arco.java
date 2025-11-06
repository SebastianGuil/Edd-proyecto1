/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class Arco {
    String destino;
    Arco Pnext;

    public Arco(String dato) {
        this.destino = dato;
        this.Pnext = null;
    }
}
