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
public class CombateTest {

    @Test
    public void testCombateGuerrero() {
        Aventurero a = new Guerrero("Kratos", 5, true);
        assertEquals("El Guerrero Kratos usa Oleada de Acción para realizar múltiples ataques físicos continuos.",
                a.simularCombate());
    }

    @Test
    public void testCombateMago() {
        Aventurero a = new Mago("Zeus", 5, 3);
        assertEquals("El Mago Zeus gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.",
                a.simularCombate());
    }

    @Test
    public void testCombateClerigo() {
        Aventurero a = new Clerigo("Atreus", 4, "Pelor");
        assertEquals("El Clérigo Atreus usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.",
                a.simularCombate());
    }

    @Test
    public void testCombateMonje() {
        Aventurero a = new Monje("Ares", 6, 4);
        assertEquals("El Monje Ares gasta puntos de Ki para ejecutar una Ráfaga de Golpes y un Ataque Aturdidor.",
                a.simularCombate());
    }

    @Test
    public void testCombatePaladin() {
        Aventurero a = new Paladin("Apolo", 7, 10);
        assertEquals("El Paladín Apolo consume magia para imbuir su arma con un Castigo Divino de daño radiante.",
                a.simularCombate());
    }

    @Test
    public void testCombateExplorador() {
        Aventurero a = new Explorador("Kratos", 10, "Montaña");
        assertEquals("El Explorador Kratos aplica Marca del Cazador sobre el objetivo para maximizar su daño sostenido.",
                a.simularCombate());
    }

    @Test
    public void testCombatePicaro() {
        Aventurero a = new Picaro("Hermes", 3, false);
        assertEquals("El Pícaro Hermes aprovecha la ventaja táctica para asestar un Ataque Furtivo masivo y se reposiciona.",
                a.simularCombate());
    }

    @Test
    public void testCombateBardo() {
        Aventurero a = new Bardo("Hercules", 2, "Laúd");
        assertEquals("El Bardo Hercules toca su instrumento para otorgar Inspiración Bárdica a un aliado.",
                a.simularCombate());
    }
}

