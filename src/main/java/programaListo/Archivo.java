/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package programaListo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author junior
 */
public class Archivo {
    private BufferedOutputStream bos;
    private BufferedInputStream bis;
    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

//serializar
    public void guardarInfo(ArbolNodos objeto) {
        try {
            if (bos == null) {
                FileOutputStream fos = new FileOutputStream(nombreArchivo);
                this.bos = new BufferedOutputStream(fos);
            }
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(objeto);
            oos.flush();
        } catch (IOException e) {
            System.err.println(" El objeto no se pudo guardar ");
        }
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
//deserializar
    public ArbolNodos montarInfo() {
        ArbolNodos objeto = null;
        try {
            FileInputStream fis = new FileInputStream(nombreArchivo);
            this.bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            objeto = (ArbolNodos) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(" El objeto no se pudo leer ");
        }
        return objeto;
    }
}
