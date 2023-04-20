/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaListo;

import java.io.Serializable;

/**
 *
 * @author junior
 */
public class Nodo implements Serializable {

    private String informacion;
    private Nodo izquierda;
    private Nodo derecha;
    private boolean esRespuesta;

    public Nodo(String pregunta) {
        this.informacion = pregunta;
        izquierda = null;
        derecha = null;
        esRespuesta = false;
    }
    public Nodo(String pregunta,boolean b) {
        this.informacion = pregunta;
        izquierda = null;
        derecha = null;
        esRespuesta = b;
    }

    public boolean isEsRespuesta() {
        return esRespuesta;
    }

    public String getInformacion() {
        return informacion;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
     public boolean esHoja() {
        return  izquierda== null && derecha == null;
    }
    
}
