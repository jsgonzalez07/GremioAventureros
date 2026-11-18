/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public abstract class Aventurero implements IAccionCombate {

    private String nombre;
    private int nivel;

    public Aventurero(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Aventurero(String nombre) {
        this(nombre, 1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void subirNivel() {
        nivel++;
    }

    public void subirNivel(int niveles) {
        if (niveles > 0) {
            nivel = nivel + niveles;
        }
    }

    public abstract String getNombreClase();

    @Override
    public String toString() {
        return getNombreClase() + " (nivel " + nivel + ")";
    }
}
