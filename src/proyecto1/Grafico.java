/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.Viewer;
/** Gestiona la visualización de la estructura del grafo utilizando Graphstream.
 * Esta clase funciona como adaptador que traduce la estructura interna a un objeto
 * de Graphstream 
 *
 * @author Daniel Barreda
 */
public class Grafico {
    /** El grafo y su respectiva estructura interna */
    private Grafo grafo;
    /** La instancia del grafo de GraphStream que se usará para la visualización. */
    private Graph graph;
    /** Cadena de texto que contiene las reglas CSS para estilizar el grafo. */
    private String hojaEstilos;
    /** 
     * Constructor de la clase Gráfico
     * @param g La instancia del grafo interno que se desea visualizar.
     */
    public Grafico(Grafo g){
        this.grafo = g;
        System.setProperty("org.graphstream.ui", "swing");
        this.graph = new SingleGraph("RedSocial");
        this.graph.setAutoCreate(true);
        this.graph.setStrict(false);
        this.graph.setAttribute("ui.quality");
        hojaEstilos = 
            "graph {" +
            "fill-color: white;" +
            "}" +
            "node {" +
            "size: 15px;" +
            "fill-color: #3498db;" +
            "stroke-mode: plain;" +
            "stroke-color: #2980b9;" +
            "text-mode: normal;" +  
            "text-alignment: under;" +
            "text-background-mode: plain;" +
            "text-background-color: white;" +
            "text-size: 12;" +
            "text-color: black;" +
            "}" +
            "edge {" +
            "shape: line;" +
            "fill-color: #95a5a6;" +
            "arrow-size: 8px, 5px;" +
            "z-index: 0;" +
            "}";
    }
    /**
     * Construye o actualiza el grafo de GraphStream a partir de la estructura interna
     * <p>
     * Limpia el grafo visual generado anteriormente y recorre la lista de adyacencia 
     * para añadir los usuarios y las relaciones
     */
    public void generarGrafoGs(){
        this.graph.clear();
        this.graph.setAttribute("ui.quality");
        this.graph.setAttribute("ui.stylesheet", hojaEstilos);
        NodoGrafo primero = grafo.getPfirst();
        int id = 0;
        while (primero != null){
            if (this.graph.getNode(primero.dato) == null) {
                 this.graph.addNode(primero.dato).setAttribute("ui.label", primero.dato);
            }
            Arco adyacentes = primero.lista.Pfirst;
            while (adyacentes != null){
                if (this.graph.getNode(adyacentes.destino) == null) {
                   this.graph.addNode(adyacentes.destino).setAttribute("ui.label", adyacentes.destino);
                }
                this.graph.addEdge(Integer.toString(id), primero.dato, adyacentes.destino, true);
                id++;
                adyacentes = adyacentes.Pnext;
            }
            primero = primero.Pnext;
        }
    }
    /**
     * Muestra el grafo visual de Graphstream
     * <p>
     * Limpia el panel, configura un BorderLayout y añade 
     * el Viewpanel de Graphstream para renderizar el grafo
     * @param panel El componente JPanel de Swing donde se dibujará el grafo.
     */
    public void mostrarGrafoEnPanel(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        
        Viewer viewer = new SwingViewer(this.graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);
        
        panel.add(viewPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}