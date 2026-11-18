/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author juans
 */
public final class RegistroGremio {

    public static final String ARCHIVO = "registro_gremio.txt";

    private RegistroGremio() {
    }

    public static boolean guardar(String linea) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            escritor.println(linea);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
