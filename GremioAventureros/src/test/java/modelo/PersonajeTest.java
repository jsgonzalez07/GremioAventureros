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
public class PersonajeTest {

    @Test
    public void testNivelTotalSumaLasClases() {
        Personaje zeus = new Personaje("Zeus", 45);
        zeus.agregarClase(new Mago("Zeus", 10, 3));
        zeus.agregarClase(new Guerrero("Zeus", 5, true));
        zeus.agregarClase(new Clerigo("Zeus", 5, "Pelor"));
        assertEquals(20, zeus.getNivelTotal());
    }

    @Test
    public void testNoPermiteNivelMayorA20() {
        Personaje kratos = new Personaje("Kratos", 60);
        kratos.agregarClase(new Guerrero("Kratos", 15, true));
        assertThrows(IllegalArgumentException.class,
                () -> kratos.agregarClase(new Paladin("Kratos", 10, 5)));
    }

    @Test
    public void testNoPermiteMasDeCuatroClases() {
        Personaje atreus = new Personaje("Atreus", 30);
        atreus.agregarClase(new Explorador("Atreus", 2, "Bosque"));
        atreus.agregarClase(new Picaro("Atreus", 2, true));
        atreus.agregarClase(new Bardo("Atreus", 2, "Flauta"));
        atreus.agregarClase(new Monje("Atreus", 2, 3));
        assertThrows(IllegalArgumentException.class,
                () -> atreus.agregarClase(new Mago("Atreus", 2, 1)));
    }

    @Test
    public void testNoPermiteClaseRepetida() {
        Personaje hercules = new Personaje("Hercules", 50);
        hercules.agregarClase(new Guerrero("Hercules", 5, true));
        assertThrows(IllegalArgumentException.class,
                () -> hercules.agregarClase(new Guerrero("Hercules", 5, false)));
    }

    @Test
    public void testLanzarDadoEntreUnoYSeis() {
        Personaje zeus = new Personaje("Zeus", 45);
        for (int i = 0; i < 100; i++) {
            int dado = zeus.lanzarDado();
            assertTrue(dado >= 1 && dado <= 6);
        }
    }

    @Test
    public void testBuscarClase() {
        Personaje zeus = new Personaje("Zeus", 45);
        zeus.agregarClase(new Mago("Zeus", 10, 3));
        assertEquals("Mago", zeus.buscarClase("Mago").getNombreClase());
        assertNull(zeus.buscarClase("Bardo"));
    }
}
