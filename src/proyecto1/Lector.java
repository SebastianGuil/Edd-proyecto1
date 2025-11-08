/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es para leer y procesar un archivo de texto
 * El archivo de texto está dividido en dos secciones principales: usuarios y relaciones
 * @author Daniel Barreda
 */
public class Lector {
    /**
     * El archivo de texto a leer
     */
    private File archivo;
    /**
     * Almacena el contenido de la sección usuarios como un string
     */
    private String usuariosString;
    /**
     * Almacena el contenido de la sección relaciones como un string
     */
    private String relacionesString;
/**
 * Constructor de la clase lector
 * <p>
 * Inicializa el lector con el archivo de texto especificado
 * @param archivo El file que apunta al archivo de texto a procesar
 */
    public Lector(File archivo) {
        this.archivo = archivo;
        this.usuariosString = usuariosString;
        this.relacionesString = relacionesString;
    }
    /**
     * Lee el archivo especificado en el constructor y divide su contenido
     */
    public void leer (){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.archivo));
            String linea;
            StringBuilder usuarios = new StringBuilder();
            StringBuilder relaciones = new StringBuilder();
            while (!(linea = reader.readLine()).toLowerCase().trim().contains("relaciones")) {
                if (!linea.contains("usuarios")){
                    usuarios.append(linea).append("\n");
                }
            }
            this.usuariosString = usuarios.toString();
            while ((linea = reader.readLine()) != null) {
                if (!linea.contains("relaciones")){
                    relaciones.append(linea).append("\n");
                }
            } 
            this.relacionesString = relaciones.toString();
            reader.close();
            //return usuarios.toString(), relaciones.toString();
        }catch (IOException e) {
            //return e.print;
        }
    }
    
    /*public void actualizarRepositorio(){
        try {
            FileWriter writer = new FileWriter(this.archivo);
            writer.flush();
            writer.write("usuarios\n" + this.usuariosString + "relaciones\n" + this.relacionesString);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    /**
     * Obtiene los datos de los usuarios
     * @return El contenido de los usuarios leído del archivo
     * o null si no se ha llamado
     */
    public String getUsuariosString() {
        return usuariosString;
    }
/**
 * Obtiene los datos de las relaciones
 * @return El contenido de las relaciones leído del archivo
     * o null si no se ha llamado
 */
    public String getRelacionesString() {
        return relacionesString;
    }
/**
 * Actualiza los usuarios
 * @param usuariosString nuevo string de los usuarios
 */
    public void setUsuariosString(String usuariosString) {
        this.usuariosString = usuariosString;
    }
/**
 * Actualiza las relaciones
 * @param relacionesString nuevo string de las relaciones
 */
    public void setRelacionesString(String relacionesString) {
        this.relacionesString = relacionesString;
    }
    
    
    
}
