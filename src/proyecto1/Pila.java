/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class Pila {
    NodoGrafo Pfirst;

    public Pila() {
        this.Pfirst = null;
    }
    
    public boolean EstaVacia (){
        return Pfirst == null;
    }
    
    public void InsertarNodo(NodoGrafo dato){
    
        if (EstaVacia()){
        Pfirst = dato;
    }else{
            dato.Pnext = Pfirst;
            Pfirst = dato;
        }
}
    public void SacarNodo (){
        if (!EstaVacia()){
            Pfirst = Pfirst.Pnext;
        }
    }
}
