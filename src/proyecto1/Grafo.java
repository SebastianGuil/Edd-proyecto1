/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Representa una estructura de datos de Grafo dirigido, implementada como una lista
 * <p>
 * La clase mantiene una lista enlazada de vértices, y cada vértice contiene una lista
 * enlazada de arcos que representan sus relaciones con otros vértices
 * @author Sebatián Guillen 
 */
public class Grafo {
    /**
     * Apuntador al primer nodo de la lista
     */
    private NodoGrafo Pfirst;
    /**
     * Apuntador al último nodo de la lista
     */
    private NodoGrafo Plast;
    /**
     * Constructor de la clase grafo, inicializándolo como vacío
     */
    public Grafo() {
        this.Pfirst = null;
        this.Plast = null;
    }
    /**
     * Verifica si el grafo está vacío
     * @return true si está vacío, o false de lo contrario
     */
    public boolean GrafoVacio (){
      return  Pfirst == null; 
    } 
    /**
     * Comprueba si ya existe un nodo con el identificador especificado
     * @param dato El dato que se desea buscar
     * @return true si el vértice se encuentra en el grafo, false en caso contrario
     */
    public boolean ExisteVertice (Object dato){
        boolean Existe = false;
        if (!GrafoVacio()){
            NodoGrafo temporal = Pfirst;
            while (temporal != null && !Existe){
                if (temporal.dato.equals(dato)){
                        Existe = true;
                }
                temporal = temporal.Pnext;
            }
        }
        return Existe;
    }
    /**
     * Añade un nuevo arco al grafo, conectando un vértice de origen con uno de destino
     * <p> 
     * Busca el nodo origen, en caso de que exista, añade el destino a su lista
     * @param origen El dato del vértice de origen
     * @param destino El dato del vértice de destino
     */
    public void NuevaArista (Object origen, String destino){
            NodoGrafo posicion = Pfirst;
            while (posicion != null && !posicion.dato.equals(origen)){
                posicion = posicion.Pnext;
            }
            if(posicion!=null){
            posicion.lista.NuevaAdyacencia(destino);
            }
    }
    /**
     * Añade un nodo al grafo, si no existe de antes
     * <p>
     * El nuevo nodo se añade al final
     * @param dato El identificador del nuevo vértice a crear
     */
    public void NuevoNodo (String dato){
         if (!ExisteVertice(dato)){
             NodoGrafo pnew = new NodoGrafo(dato);
             if(GrafoVacio()){
                 Pfirst = pnew;
                 Plast = pnew;
             } else { 
                 
                     Plast.Pnext = pnew;
                     Plast = pnew;
                 
                     }
                 
             
         }   
       }
    /**
     * Genera una representación de la lista del grafo
     * <p>
     * Recorre cada vértice y muestra sus destinos 
     * @return Un string que describe el grafo
     */
    public String VerGrafo (){
        String cadena = "";
        NodoGrafo temporal = Pfirst;
        while (temporal != null){
            cadena = cadena + temporal.dato + " --> " + temporal.lista.VerGrafo()+ "\n";
            temporal = temporal.Pnext;
        }
        return cadena;
    }
    /**
     * Obtiene el primer nodo de la lista
     * @return el nodo pfirst
     */
    public NodoGrafo getPfirst() {
        return Pfirst;
    }
    /**
     * Obtiene el último nodo de la lista
     * @return el nodo plast
     */
    public NodoGrafo getPlast() {
        return Plast;
    }
    /**
     * Establece el estado de visitado de todos los nodos
     * @param estado Se asigna true o false a cada nodo visitado
     */
    public void MarcarVisitado(boolean estado){
        NodoGrafo temp = Pfirst;
        while (temp != null){
            temp.Visitado = estado;
            temp = temp.Pnext;
        }
    }
    /**
     * Busca y devuelve un nodo específico
     * @param dato El dato del nodo a buscar
     * @return El objeto si se encuentra, de lo contrario, null
     */
    public NodoGrafo EncontrarNodo (String dato){
        NodoGrafo temp = Pfirst;
        while (temp!=null){
            if(temp.dato.equals(dato)){
                return temp;
            }
            temp = temp.Pnext;
            }
        return null;
        }
    /**
     * Genera un string para guardar el estado del grafo
     * <p>
     * Crea una lista de usuarios y una lista de relaciones
     * @return Un string formateado
     */
    public String Guardardo(){
        StringBuilder Usuarios = new StringBuilder();
        StringBuilder Relaciones = new StringBuilder ();
        NodoGrafo temp = this.Pfirst;

        while (temp!=null){
            Usuarios.append(temp.dato).append("\n");
            Arco Arcotemp = temp.lista.Pfirst;
           while (Arcotemp!=null){
               Relaciones.append(temp.dato).append(",").append(Arcotemp.destino).append("\n");
               Arcotemp = Arcotemp.Pnext;
           }
           temp = temp.Pnext;
        }
        return "usuarios:\n" + Usuarios.toString() + "\n" + "relaciones: \n" + Relaciones.toString();
    }
    /**
     * Elimina un arco específico
     * <p>
     * Busca el nodo de origen y le ordena eliminar el arco apuntador al destino de su lista
     * @param origen El identificador del vértice de origen
     * @param destino El identificador del vértice de destino
     */
    public void EliminarArco(String origen, String destino) {
        if (GrafoVacio() || !ExisteVertice(origen) || !ExisteVertice(destino)) {
            return;
        }
        NodoGrafo nodoOrigen = EncontrarNodo(origen);
        if (nodoOrigen != null) {
            nodoOrigen.lista.EliminarArco(destino);
        }
    }
    /**
     * Elimina un nodo y todas las relaciones asociadas a él
     * <p>
     * Recorre todos los nodos para eliminar las relaciones que apuntan al nodo a borrar. 
     * Luego elimina el nodo
     * @param dato El identificador del nodo a eliminar
     */
    public void EliminarNodo (String dato){
        if (GrafoVacio() || !ExisteVertice(dato)) {
            return;
        }
        NodoGrafo temp = Pfirst;
        while (temp != null) {
            if (!temp.dato.equals(dato)) {
                temp.lista.EliminarArco(dato);
            }
            temp = temp.Pnext;
        }
        temp = Pfirst;
        NodoGrafo Aux = null;
        while (temp != null && !temp.dato.equals(dato)) {
            Aux = temp;
            temp = temp.Pnext;
        }
        if (temp == null){ 
            return;
        }
        if (Aux == null) {
            Pfirst = Pfirst.Pnext;
            if (Pfirst == null) {
                Plast = null;
            }
        } else {
            Aux.Pnext = temp.Pnext;
            if (Aux.Pnext == null) {
                Plast = Aux;
            }
        }
    }

}  
