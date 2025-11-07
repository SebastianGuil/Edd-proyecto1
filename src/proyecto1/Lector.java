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
 *
 * @author Daniel Barreda
 */
public class Lector {
    private File archivo;
    private String usuariosString;
    private String relacionesString;

    public Lector(File archivo) {
        this.archivo = archivo;
        this.usuariosString = usuariosString;
        this.relacionesString = relacionesString;
    }
    
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
    public String getUsuariosString() {
        return usuariosString;
    }

    public String getRelacionesString() {
        return relacionesString;
    }

    public void setUsuariosString(String usuariosString) {
        this.usuariosString = usuariosString;
    }

    public void setRelacionesString(String relacionesString) {
        this.relacionesString = relacionesString;
    }
    
    
    
}
