/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Paladin extends Aventurero {

    private int puntosFuerza;

    public Paladin(String nombre, int nivel, int puntosFuerza) {
        super(nombre, nivel);
        this.puntosFuerza = puntosFuerza;
    }

    public int getPuntosFuerza() {
        return puntosFuerza;
    }

    @Override
    public String getNombreClase() {
        return "Paladín";
    }

    @Override
    public String simularCombate() {
        return "El Paladín " + getNombre() + " consume magia para imbuir su arma con un Castigo Divino de daño radiante.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Puntos de fuerza: " + puntosFuerza;
    }
}
