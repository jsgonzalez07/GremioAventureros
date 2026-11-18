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

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
