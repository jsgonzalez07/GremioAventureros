/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Monje extends Aventurero {

    private int puntosKi;

    public Monje(String nombre, int nivel, int puntosKi) {
        super(nombre, nivel);
        this.puntosKi = puntosKi;
    }

    public int getPuntosKi() {
        return puntosKi;
    }

    @Override
    public String getNombreClase() {
        return "Monje";
    }

    @Override
    public String simularCombate() {
        return "El Monje " + getNombre() + " gasta puntos de Ki para ejecutar una Ráfaga de Golpes y un Ataque Aturdidor.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Puntos de Ki: " + puntosKi;
    }
}
