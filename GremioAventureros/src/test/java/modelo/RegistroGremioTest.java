/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author juans
 */
public class RegistroGremioTest {

    @Test
    public void testGuardarAnexaLaLineaAlArchivo() throws IOException {
        String linea = "Prueba unica " + System.nanoTime();
        RegistroGremio.guardar(linea);

        List<String> lineas = Files.readAllLines(Paths.get(RegistroGremio.ARCHIVO));
        assertEquals(linea, lineas.get(lineas.size() - 1));
    }
}
