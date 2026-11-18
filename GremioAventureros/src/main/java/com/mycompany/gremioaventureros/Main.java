/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gremioaventureros;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import modelo.Aventurero;
import modelo.Personaje;
import controlador.ControladorGremio;
import vista.VistaGremio;
/**
 *
 * @author juans
 */
public class Main {

    public static void main(String[] args) {
        VistaGremio vista = new VistaGremio();
        new ControladorGremio(vista);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public static String reporteCantidadPorClase(ArrayList<Personaje> lista) {
        Map<String, Integer> conteo = new LinkedHashMap<>();
        for (Personaje p : lista) {
            for (Aventurero clase : p.getClases()) {
                String nombreClase = clase.getNombreClase();
                conteo.put(nombreClase, conteo.getOrDefault(nombreClase, 0) + 1);
            }
        }

        String texto = "Cantidad de aventureros por clase:\n";
        for (Map.Entry<String, Integer> fila : conteo.entrySet()) {
            texto = texto + "  - " + fila.getKey() + ": " + fila.getValue() + "\n";
        }
        return texto;
    }
    
    public static double reporteNivelPromedio(ArrayList<Personaje> lista) {
        if (lista.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (Personaje p : lista) {
            suma = suma + p.getNivelTotal();
        }
        return (double) suma / lista.size();
    }    
}
