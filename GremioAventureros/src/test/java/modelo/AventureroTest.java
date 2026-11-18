/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author juans
 */
public class AventureroTest {

    @Test
    public void testSubirNivelSinParametro() {
        Explorador explorador = new Explorador("Kratos", 10, "Montaña");
        explorador.subirNivel();
        assertEquals(11, explorador.getNivel());
    }

    @Test
    public void testSubirNivelConParametro() {
        Explorador explorador = new Explorador("Kratos", 10, "Montaña");
        explorador.subirNivel(3);
        assertEquals(13, explorador.getNivel());
    }

    @Test
    public void testSubirNivelConValorNegativoNoCambia() {
        Explorador explorador = new Explorador("Kratos", 10, "Montaña");
        explorador.subirNivel(-2);
        assertEquals(10, explorador.getNivel());
    }

    @Test
    public void testToStringIncluyeLosDatos() {
        Guerrero guerrero = new Guerrero("Kratos", 5, true);
        String texto = guerrero.toString();
        assertTrue(texto.contains("Guerrero"));
        assertTrue(texto.contains("nivel 5"));
        assertTrue(texto.contains("Armadura pesada: Sí"));
    }

    @Test
    public void testNombreClaseConTilde() {
        Aventurero a = new Paladin("Atreus", 4, 7);
        assertEquals("Paladín", a.getNombreClase());
    }
}
