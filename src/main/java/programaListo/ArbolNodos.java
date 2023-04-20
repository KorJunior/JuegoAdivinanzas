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
public class ArbolNodos implements Serializable {

    private Nodo raiz;

    public ArbolNodos() {
        raiz = null;
    }

    public void agregarNodo(String pregunta, String respuesta) {
        if (raiz == null) {
            setRaiz(new Nodo(pregunta));
            raiz.setIzquierda(new Nodo(respuesta, true));
        } else {
            agregarNodo(raiz, pregunta, respuesta);
        }
    }

    private void agregarNodo(Nodo nodoActual, String pregunta, String respuesta) {
        if (nodoActual.getDerecha() == null) {
            nodoActual.setDerecha(new Nodo(pregunta));
            nodoActual.getDerecha().setIzquierda(new Nodo(respuesta, true));
        } else if (nodoActual.getIzquierda() == null) {
            nodoActual.setIzquierda(new Nodo(pregunta));
            nodoActual.getIzquierda().setIzquierda(new Nodo(respuesta, true));
        }
    }

    public void imprimir() {
        imprimir(raiz);
    }

    private void imprimir(Nodo nodoActual) {
        if (nodoActual != null) {
            System.out.println(nodoActual.getInformacion());
            imprimir(nodoActual.getDerecha());
            imprimir(nodoActual.getIzquierda());
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void añadirNodoAprendido(String pregunta, String nuevaPregunta, String nuevaRespuesta) {
        buscarNodo(raiz, pregunta, nuevaPregunta, nuevaRespuesta);

    }

    private void buscarNodo(Nodo nodoActual, String pregunta, String nuevaPregunta, String nuevaRespuesta) {
        if (nodoActual != null) {
            if (!nodoActual.getInformacion().equals(pregunta)) {
                buscarNodo(nodoActual.getIzquierda(), pregunta, nuevaPregunta, nuevaRespuesta);
                buscarNodo(nodoActual.getDerecha(), pregunta, nuevaPregunta, nuevaRespuesta);
            } else {
                nodoActual.setDerecha(new Nodo(nuevaPregunta));
                nodoActual.getDerecha().setIzquierda(new Nodo(nuevaRespuesta, true));

            }
        }
    }
}
