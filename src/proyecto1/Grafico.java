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

/**
 *
 * @author Daniel Barreda
 */
public class Grafico {
    private Grafo grafo;
    private Graph graph;
    
    public Grafico(Grafo g){
        this.grafo = g;
        System.setProperty("org.graphstream.ui", "swing");
        this.graph = new SingleGraph("RedSocial");
        this.graph.setAutoCreate(true);
        this.graph.setStrict(false);
        this.graph.setAttribute("ui.quality");
        this.graph.setAttribute("ui.antialias");
        String hojaEstilos = 
            "graph {" +
            "fill-color: white;" +
            "}" +
            "node {" +
            "size: 20px;" +
            "fill-color: #3498db;" +
            "stroke-mode: plain;" +
            "stroke-color: #2980b9;" +
            "text-mode: normal;" +  
            "text-alignment: under;" +
            "text-background-mode: plain;" +
            "text-background-color: white;" +
            "text-size: 16;" +
            "text-color: black;" +
            "}" +
            "node:clicked {" +
            "fill-color: #e74c3c;" +
            "}" +
            "edge {" +
            "shape: line;" +
            "fill-color: #95a5a6;" +
            "arrow-size: 8px, 5px;" +
            "z-index: 0;" +
            "}";
        this.graph.setAttribute("ui.stylesheet", hojaEstilos);
    }
    
    public void generarGrafoGs(){
        this.graph.clear();
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
                adyacentes = adyacentes.siguiente;
            }
            primero = primero.Pnext;
        }
    }
    
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