/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author juans
 */
public class Personaje {

    public static final int MAX_CLASES = 4;
    public static final int MAX_NIVEL = 20;
    private static final Random DADO = new Random();

    private String nombre;
    private int puntosVida;
    private ArrayList<Aventurero> clases;

    public Personaje(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.clases = new ArrayList<>();
    }

    public void agregarClase(Aventurero clase) {
        if (clases.size() >= MAX_CLASES) {
            throw new IllegalArgumentException("un aventurero puede tener máximo " + MAX_CLASES + " clases.");
        }
        if (buscarClase(clase.getNombreClase()) != null) {
            throw new IllegalArgumentException("la clase " + clase.getNombreClase() + " está repetida.");
        }
        if (getNivelTotal() + clase.getNivel() > MAX_NIVEL) {
            throw new IllegalArgumentException("el nivel total no puede pasar de " + MAX_NIVEL + ".");
        }
        clases.add(clase);
    }

    public int getNivelTotal() {
        int total = 0;
        for (Aventurero clase : clases) {
            total = total + clase.getNivel();
        }
        return total;
    }

    public Aventurero buscarClase(String nombreClase) {
        for (Aventurero clase : clases) {
            if (clase.getNombreClase().equals(nombreClase)) {
                return clase;
            }
        }
        return null;
    }

    public int lanzarDado() {
        return DADO.nextInt(6) + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public ArrayList<Aventurero> getClases() {
        return clases;
    }

    @Override
    public String toString() {
        String texto = nombre + " | PV: " + puntosVida + " | Nivel total: " + getNivelTotal();
        for (Aventurero clase : clases) {
            texto = texto + "\n     - " + clase.toString();
        }
        return texto;
    }
}
