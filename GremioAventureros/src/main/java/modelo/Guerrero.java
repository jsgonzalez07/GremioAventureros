/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Guerrero extends Aventurero {

    private boolean armaduraPesada;

    public Guerrero(String nombre, int nivel, boolean armaduraPesada) {
        super(nombre, nivel);
        this.armaduraPesada = armaduraPesada;
    }

    public boolean isArmaduraPesada() {
        return armaduraPesada;
    }

    @Override
    public String getNombreClase() {
        return "Guerrero";
    }

    @Override
    public String simularCombate() {
        return "El Guerrero " + getNombre() + " usa Oleada de Acción para realizar múltiples ataques físicos continuos.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Armadura pesada: " + (armaduraPesada ? "Sí" : "No");
    }
}
