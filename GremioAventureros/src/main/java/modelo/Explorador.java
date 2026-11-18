/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Explorador extends Aventurero {

    private String terrenoFavorecido;

    public Explorador(String nombre, int nivel, String terrenoFavorecido) {
        super(nombre, nivel);
        this.terrenoFavorecido = terrenoFavorecido;
    }

    public String getTerrenoFavorecido() {
        return terrenoFavorecido;
    }

    @Override
    public String getNombreClase() {
        return "Explorador";
    }

    @Override
    public String simularCombate() {
        return "El Explorador " + getNombre() + " aplica Marca del Cazador sobre el objetivo para maximizar su daño sostenido.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Terreno favorecido: " + terrenoFavorecido;
    }
}

