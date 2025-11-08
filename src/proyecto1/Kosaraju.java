/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Implementa el algoritmo Kosaraju para encontrar componentes fuertemente conectados
 * <p>El algoritmo funciona en dos fases principales:</p>
 * <ol>
 * <li>Realiza un DFS en el grafo original para obtener
 * el orden de finalización de los nodos.</li>
 * <li>Calcula el grafo transpuesto.</li>
 * <li>Realiza un DFS en el grafo transpuesto, procesando los nodos en el orden
 * determinado por la pila. Cada árbol generado en este segundo DFS
 * corresponde a un componente fuertemente conectado.</li>
 * </ol>
 * @author Sebastian Guillen
 */
public class Kosaraju {
    /**
     * El grafo dirigido original donde se buscarán los SCC
     */
    Grafo Original;
    /**
     * El grafo transpuesto utilizado después
     */
    Grafo Transpuesto;
/** 
 * Inicializa la instancia con el grafo original
 * @param Original El grafo de entrada
 */
    public Kosaraju(Grafo Original) {
        this.Original = Original;
        this.Transpuesto = null;
    }
    /**
     * Se ejecuta el algoritmo Kosaraju para encontrar todos los componentes fuertemente conectados
     * @return Un string que lista todos los componentes fuertemente conectados
     */
    
    
    
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
    /**
     * Realiza el primer recorrido DFS sobre el grafo original. 
     * Este método es recursivo
     * @param Actual Nodo que se está visitando actualmente en el DFS
     * @param Orden La pila donde se insertan los nodos al terminar de visitar
     */
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
    /**
     * Genera el grafo transpuesto a partir del original
     * La diferencia es que todas las aristas están invertidas
     */
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
    /**
     * Realiza el segundo recorrido DFS, pero esta vez sobre el grafo transpuesto
     * @param NodoTrans El nodo que se está visitando actualmente
     * @return Un string que contiene los datos de los nodos fuertemente conectados
     */
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
