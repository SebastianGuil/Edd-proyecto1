/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */

class NodoPila {
    NodoGrafo dato;
    NodoPila Pnext;

    public NodoPila(NodoGrafo dato) {
        this.dato = dato;
        this.Pnext = null;
    }
    
}
public class Pila {
    NodoPila Pfirst;

    public Pila() {
        this.Pfirst = null;
    }
    
    public boolean EstaVacia (){
        return Pfirst == null;
    }
    
    public void InsertarNodo(NodoGrafo dato){
        NodoPila Pnew = new NodoPila(dato);
        if (EstaVacia()){
        Pfirst = Pnew;
    }else{
            Pnew.Pnext = Pfirst;
            Pfirst = Pnew;
        }
}
    public void SacarNodo (){
        if (!EstaVacia()){
            Pfirst = Pfirst.Pnext;
        }
    }
    
    public NodoGrafo getPfirstData(){
        if (EstaVacia()){
            return null;
        }
        return Pfirst.dato;
    }
}
