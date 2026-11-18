/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Bardo extends Aventurero {

    private String instrumentoMusical;

    public Bardo(String nombre, int nivel, String instrumentoMusical) {
        super(nombre, nivel);
        this.instrumentoMusical = instrumentoMusical;
    }

    public String getInstrumentoMusical() {
        return instrumentoMusical;
    }

    @Override
    public String getNombreClase() {
        return "Bardo";
    }

    @Override
    public String simularCombate() {
        return "El Bardo " + getNombre() + " toca su instrumento para otorgar Inspiración Bárdica a un aliado.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Instrumento: " + instrumentoMusical;
    }
}
