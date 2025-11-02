/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class Grafo {
    private NodoGrafo Pfirst;
    private NodoGrafo Plast;

    public Grafo() {
        this.Pfirst = null;
        this.Plast = null;
    }
    public boolean GrafoVacio (){
      return  Pfirst == null; 
    } 
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
    public void NuevaArista (Object origen, String destino){
            NodoGrafo posicion = Pfirst;
            while (!posicion.dato.equals(origen)){
                posicion = posicion.Pnext;
            }
            posicion.lista.NuevaAdyacencia(destino);
    }
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
    public String VerGrafo (){
        String cadena = "";
        NodoGrafo temporal = Pfirst;
        while (temporal != null){
            cadena = cadena + temporal.dato + " --> " + temporal.lista.VerGrafo()+ "\n";
            temporal = temporal.Pnext;
        }
        return cadena;
    }

    public NodoGrafo getPfirst() {
        return Pfirst;
    }

    public NodoGrafo getPlast() {
        return Plast;
    }
    
    
    
}
