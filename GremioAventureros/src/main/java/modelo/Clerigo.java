/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Clerigo extends Aventurero {

    private String diosVenerado;

    public Clerigo(String nombre, int nivel, String diosVenerado) {
        super(nombre, nivel);
        this.diosVenerado = diosVenerado;
    }

    public String getDiosVenerado() {
        return diosVenerado;
    }

    @Override
    public String getNombreClase() {
        return "Clérigo";
    }

    @Override
    public String simularCombate() {
        return "El Clérigo " + getNombre() + " usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Dios venerado: " + diosVenerado;
    }
}
