/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Sebastian Guillen
 */
public class Kosaraju {
    Grafo Original;
    Grafo Transpuesto;

    public Kosaraju(Grafo Original) {
        this.Original = Original;
        this.Transpuesto = null;
    }
    
    
    
    
    public String EncontrarRelacionados (){
        String Resultado;
        Pila Relacionados = new Pila();
        this.Original.MarcarVisitado(false);
        NodoGrafo temp = this.Original.getPfirst();
        while (temp != null){
            if(!temp.Visitado){
                ArmarPila (temp, Relacionados);
            }
            temp = temp.Pnext;
        }
        this.getTraspuesto();
        this.Transpuesto.MarcarVisitado(false);
        Resultado = "Elementos fuertemente conectados: \n ";
        while (!Relacionados.EstaVacia()){
            NodoGrafo NodoPila = Relacionados.getPfirstData();
            NodoGrafo NodoTrans = this.Transpuesto.EncontrarNodo(NodoPila.dato);
            if(NodoTrans != null && !NodoTrans.Visitado){
                Resultado = Resultado + "Fuertemente conectados: [" + FuertementeConec(NodoTrans) + "] \n";
                
            }
            Relacionados.SacarNodo();
        }
        return Resultado;
    }
    
    private void ArmarPila (NodoGrafo Actual, Pila Orden){
        Actual.Visitado = true;
        Arco Arcotemp = Actual.lista.Pfirst;
        while(Arcotemp != null){
            NodoGrafo Vecino = this.Original.EncontrarNodo(Arcotemp.destino);
          if(Vecino!=null && !Vecino.Visitado){
              ArmarPila(Vecino,Orden);
          }  
          Arcotemp = Arcotemp.Pnext;
        }
        Orden.InsertarNodo(Actual);
    }
    
    private void getTraspuesto (){
        this.Transpuesto = new Grafo ();
        NodoGrafo temp = Original.getPfirst();
        while (temp != null){
            this.Transpuesto.NuevoNodo(temp.dato);
            temp = temp.Pnext;
}
temp = Original.getPfirst();
while(temp !=  null){
    Arco Arcotemp = temp.lista.Pfirst;
    while (Arcotemp != null){
        this.Transpuesto.NuevaArista(Arcotemp.destino, temp.dato);
        Arcotemp = Arcotemp.Pnext;
    }
    temp = temp.Pnext;
    }
    }
    
    public String FuertementeConec (NodoGrafo NodoTrans){
        String Fuerte = "";
        NodoTrans.Visitado = true;
        Fuerte = Fuerte + NodoTrans.dato + "";
        Arco Arcotemp = NodoTrans.lista.Pfirst;
        while (Arcotemp != null){
            NodoGrafo Vecino = this.Transpuesto.EncontrarNodo(Arcotemp.destino);
            if(Vecino != null && !Vecino.Visitado){
                Fuerte = Fuerte + "," + FuertementeConec(Vecino);
            }Arcotemp = Arcotemp.Pnext;
            
        }
        return Fuerte;
    }

    
}
