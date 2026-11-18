/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public class Picaro extends Aventurero {

    private boolean herramientasLadron;

    public Picaro(String nombre, int nivel, boolean herramientasLadron) {
        super(nombre, nivel);
        this.herramientasLadron = herramientasLadron;
    }

    public boolean isHerramientasLadron() {
        return herramientasLadron;
    }

    @Override
    public String getNombreClase() {
        return "Pícaro";
    }

    @Override
    public String simularCombate() {
        return "El Pícaro " + getNombre() + " aprovecha la ventaja táctica para asestar un Ataque Furtivo masivo y se reposiciona.";
    }

    @Override
    public String toString() {
        return super.toString() + " - Herramientas de ladrón: " + (herramientasLadron ? "Si" : "No");
    }
}
