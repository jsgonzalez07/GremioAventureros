/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Personaje;
import vista.VistaGremio;
import modelo.Aventurero;
import modelo.Bardo;
import modelo.Clerigo;
import modelo.Explorador;
import modelo.Guerrero;
import modelo.Mago;
import modelo.Monje;
import modelo.Paladin;
import modelo.Picaro;
/**
 *
 * @author juans
 */
public class ControladorGremio implements ActionListener {

    private VistaGremio vista;
    private ArrayList<Personaje> personajes;
    private Personaje ganador;

    public ControladorGremio(VistaGremio vista) {
        this.vista = vista;
        this.personajes = new ArrayList<>();
        this.ganador = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();        
    }

    public Aventurero crearClase(String clase, String nombre, int nivel, String atributo) {
        switch (clase) {
            case "Guerrero":
                return new Guerrero(nombre, nivel, convertirSiNo(atributo, clase));
            case "Mago":
                return new Mago(nombre, nivel, convertirNumero(atributo, clase));
            case "Clérigo":
                return new Clerigo(nombre, nivel, atributo);
            case "Monje":
                return new Monje(nombre, nivel, convertirNumero(atributo, clase));
            case "Paladín":
                return new Paladin(nombre, nivel, convertirNumero(atributo, clase));
            case "Explorador":
                return new Explorador(nombre, nivel, atributo);
            case "Pícaro":
                return new Picaro(nombre, nivel, convertirSiNo(atributo, clase));
            case "Bardo":
                return new Bardo(nombre, nivel, atributo);
            default:
                throw new IllegalArgumentException("clase no válida.");
        }
    }

    private boolean convertirSiNo(String texto, String clase) {
        String valor = texto.toLowerCase();
        if (valor.equals("sí") || valor.equals("si")) {
            return true;
        }
        if (valor.equals("no")) {
            return false;
        }
        throw new IllegalArgumentException("el atributo de " + clase + " debe ser sí o no.");
    }

    private int convertirNumero(String texto, String clase) {
        int numero = Integer.parseInt(texto);
        if (numero < 0) {
            throw new IllegalArgumentException("el atributo de " + clase + " no puede ser negativo.");
        }
        return numero;
    }    

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
