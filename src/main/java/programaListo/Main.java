/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaListo;

/**
 *
 * @author junior
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static ArbolNodos arbol = new ArbolNodos();
    static Scanner t = new Scanner(System.in);
    static Nodo nodoActual;
    static boolean jugar;
    static boolean escape;
    static Archivo a;
    static boolean juegoReiniciado=true;

    public static void main(String[] args) throws IOException {
        String respuesta;
        File archivo;
                
        a = new Archivo("conocimiento.txt");
        // Agregar datos predeterminados
        archivo = new File("conocimiento.txt");
        if (archivo.exists()) {
            arbol = a.montarInfo();
        } else {
            arbol.agregarNodo("¿Es de Noxus?", "Darius");
        }

        jugar = true;
        while (jugar) {
            if (juegoReiniciado) {
                nodoActual = arbol.getRaiz();
                juegoReiniciado=false;
            }
            escape = true;
            preguntas();
            if (nodoActual.isEsRespuesta()) {
                System.out.println("¿Tu personaje es " + nodoActual.getInformacion() + "?");
                respuesta = t.nextLine().toLowerCase();
                if (respuesta.equalsIgnoreCase("si")) {
                    System.out.println("¡Gané!");
                    reiniciar();
                } else {
                    if (nodoActual.esHoja()) {
                        aprender();
                        reiniciar();
                    } else {
                        nodoActual = nodoActual.getDerecha();
                        preguntas();
                    }
                }
            }

        }
    }

    public static void aprender() {
        String personaje, nuevaPregunta;

        System.out.println("No sé qué personaje es. ¿Podrías decirme?");
        personaje = t.nextLine();
        if (nodoActual.isEsRespuesta()) {
            System.out.println("¿Qué pregunta puedo hacer para distinguir a " + personaje + " de " + nodoActual.getInformacion() + "?");
        } else {
            System.out.println("Que caracteristica posee");
        }
        nuevaPregunta = "¿" + t.nextLine() + "?";
        arbol.añadirNodoAprendido(nodoActual.getInformacion(), nuevaPregunta, personaje);

    }

    public static void reiniciar() throws IOException {
        String respuesta;

        System.out.println("¿Quieres jugar de nuevo? (sí/no)");
        respuesta = t.nextLine().toLowerCase();
        if (!respuesta.equals("si")) {
            jugar = false;
            a.guardarInfo(arbol);
        }else{
            juegoReiniciado=true;
        }
    }

    public static void preguntas() throws IOException {
        String respuesta;

        while (!nodoActual.esHoja() && escape) {
            System.out.println(nodoActual.getInformacion());
            respuesta = t.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
                
                if (nodoActual.getIzquierda() != null) {
                    if (nodoActual.getIzquierda().isEsRespuesta()) {
                        nodoActual = nodoActual.getIzquierda();
                        break;
                    }

                }
            } else {
                if (nodoActual.getDerecha() == null) {
                    aprender();
                    reiniciar();
                    escape = false;
                } else {
                    nodoActual = nodoActual.getDerecha();
                }
            }
        }
    }

}
