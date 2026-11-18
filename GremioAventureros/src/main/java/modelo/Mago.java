/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Mago extends Aventurero {

    private int espaciosConjuro;

    public Mago(String nombre, int nivel, int espaciosConjuro) {
        super(nombre, nivel);
        this.espaciosConjuro = espaciosConjuro;
    }

    public int getEspaciosConjuro() {
        return espaciosConjuro;
    }

    @Override
    public String getNombreClase() {
        return "Mago";
    }

    @Override
    public String simularCombate() {
        return "El Mago " + getNombre() + " gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Espacios de conjuro: " + espaciosConjuro;
    }
}
