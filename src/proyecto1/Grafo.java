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
            while (posicion != null && !posicion.dato.equals(origen)){
                posicion = posicion.Pnext;
            }
            if(posicion!=null){
            posicion.lista.NuevaAdyacencia(destino);
            }
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
    
    public void MarcarVisitado(boolean estado){
        NodoGrafo temp = Pfirst;
        while (temp != null){
            temp.Visitado = estado;
            temp = temp.Pnext;
        }
    }
    
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
    
public void EliminarNodo (String dato){
        NodoGrafo temp = Pfirst;
        while ( temp != null){
            if (temp.dato.equals(dato)){
                NodoGrafo Aux = Pfirst;
                if(temp == Pfirst){
                    Pfirst = Pfirst.Pnext;
                }else{
                while(Aux.Pnext != temp){
                    Aux = Aux.Pnext;
                }
                Aux.Pnext = temp.Pnext;  
                }
             
            }
            temp = temp.Pnext;
        }
    }

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
    return "Usuarios:\n" + Usuarios.toString() + "\n" + "Relaciones: \n" + Relaciones.toString();
}

}
    
    
