/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// import java.io.ArrayList;

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
            while (!(linea = reader.readLine()).contains("relaciones")) {
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

    public String getUsuariosString() {
        return usuariosString;
    }

    public String getRelacionesString() {
        return relacionesString;
    }
    
    
}
