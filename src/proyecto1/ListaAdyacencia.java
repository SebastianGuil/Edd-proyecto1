/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Representa una lista de adyacencia para un nodo del grafo
 * @author Sebastian Guillen
 */
public class ListaAdyacencia {
    /**
     * Apuntador al primer arco de la lista
     */
    Arco Pfirst;
        /**
     * Apuntador al último arco de la lista
     */
    Arco Plast;
/**
 * Constructor para una nueva lista de adyacencia, inicia como vacía
 */
    public ListaAdyacencia() {
        this.Pfirst = null;
        this.Plast = null;
    }
    /**
     * Verifica si la lista está vacía 
     * @return true si pfirst es null, false de lo contrario
     */
    public boolean ListaVacia (){
                  return Pfirst == null;
    }
    /**
     * Crea y añade una nueva arista al final de la lista
     * @param destino 
     */
    public void NuevaAdyacencia (String destino)  {
        if (! adyacente(destino)){
            Arco Pnew = new Arco (destino);
            insertar (Pnew, destino);       
        }
    }
/**
 * Si no existe una lista de adyacencia con el mismo destino, crea uno nuevo
 * @param dato El identificador del nodo de destino a buscar
 * @return true si se encuentra una arista que apunte a dato
 */
    public boolean adyacente(String dato) {
        Arco actual = Pfirst;
        while (actual != null) {
            if (dato.equals(actual.destino)) {
                return true; 
            }
            actual = actual.Pnext;
        }
        return false;
    }
/**
 * Inserta un nuevo objeto al final de la lista
 * @param nodo el objeto a insertar
 * @param destino el destino
 */
    public void insertar (Arco nodo, Object destino){
        if (adyacente(nodo.destino)){
             return;
         }
         if (ListaVacia()){
             Pfirst = nodo;
             Plast = nodo;
         } else {
             Plast.Pnext = nodo;
             Plast = nodo; 
         }
     }
/*
     
        if (ListaVacia()){
            Pfirst = nodo;
            Plast = nodo;
        }else {
            if (destino.equals(Pfirst.destino)){
                nodo.Pnext= Pfirst;
                Pfirst = nodo;
            }else{
                if (destino.equals(Plast.destino)){
                    Plast.Pnext = nodo;
                    Plast = Plast.Pnext;
            }else{
                    Arco posicion = Pfirst;
                    while (destino.equals(posicion.destino)){
                        posicion = posicion.Pnext;  
                    }
                    nodo.Pnext = posicion.Pnext;
                    posicion.Pnext = nodo;
                    */
                
            
        
    
    
    /**
     * devuelve una representación en string de la lista
     * @return Un string que representa los destinos adyacentes
     */
    public String VerGrafo(){
        String cadena = "";
        Arco temporal = Pfirst;
        while (temporal != null){
            if (temporal.Pnext == null){
                cadena = cadena + temporal.destino + ";";
                temporal = temporal.Pnext;
            }else{
                cadena = cadena + temporal.destino + ", ";
                temporal = temporal.Pnext;
        }
        
    }
        return cadena;
}
    /**
     * Elimina un arco de la lista de adyacencia 
     * @param destino El string del nodo de destino de la arista que se quiere eliminar
     */
    public void EliminarArco(String destino) {
        if (ListaVacia()) {
            return;
        }
        Arco temp = Pfirst;
        Arco anterior = null;
        while (temp != null && !temp.destino.equals(destino)) {
            anterior = temp;
            temp = temp.Pnext;
        }
        if (temp == null) {
            return;
        }
        if (anterior == null) {
            Pfirst = temp.Pnext;
        }else{
            anterior.Pnext = temp.Pnext;
        }
        if (temp == Plast) {
            Plast = anterior;
        }
    }
    
    
}
