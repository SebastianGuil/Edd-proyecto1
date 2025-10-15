/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class ListaAdyacencia {
    Arco Pfirst;
    Arco Plast;

    public ListaAdyacencia() {
        this.Pfirst = null;
        this.Plast = null;
    }
   public boolean ListaVacia (){
                  return Pfirst == null;

   }
public void NuevaAdyacencia (String destino)  {
    if (! adyacente(destino)){
        Arco Pnew = new Arco (destino);
        insertar (Pnew, destino);       
    }
}
 
public boolean adyacente (String dato){
    Arco actual;
    boolean encontrado;
    encontrado =  false;
    actual = Pfirst;
    while (actual != null && dato.equals(actual.destino)){
        actual = actual.siguiente;
    }
    if (actual != null){
        encontrado = true ;
    }
    return encontrado;
}
public void insertar (Arco nodo, Object destino){
    if (ListaVacia()){
        Pfirst = nodo;
        Plast = nodo;
    }else {
        if (destino.equals(Pfirst.destino)){
            nodo.siguiente= Pfirst;
            Pfirst = nodo;
        }else{
            if (destino.equals(Plast.destino)){
                Plast.siguiente = nodo;
                Plast = nodo;
            }else { 
                Arco posicion = Pfirst;
                while (destino.equals(posicion.destino)){
                    posicion = posicion.siguiente;  
                }
                nodo.siguiente = posicion.siguiente;
                posicion.siguiente = nodo;
            }
        }
    }
}
public String VerGrafo(){
    String cadena = "";
    Arco temporal = Pfirst;
    while (temporal != null){
        cadena = cadena + temporal.destino + ";";
        temporal = temporal.siguiente;
    }
    return cadena;
}
}
