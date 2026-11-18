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
import modelo.RegistroGremio;
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
        this.vista.getBtnRegistrar().addActionListener(this);    
        this.vista.getBtnVerGremio().addActionListener(this);
        this.vista.getBtnLanzarDados().addActionListener(this);
        this.vista.getBtnSimular().addActionListener(this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vista.getBtnRegistrar()) {
            registrarDesdeVista();
        } else if (fuente == vista.getBtnVerGremio()) {
            vista.mostrarMensaje(listarGremio());
        } else if (fuente == vista.getBtnLanzarDados()) {
            vista.mostrarMensaje(lanzarDados());
        } else if (fuente == vista.getBtnSimular()) {
            vista.mostrarMensaje(simularCombate());
        }
    }

    private void registrarDesdeVista() {
        String nombre = vista.getTxtNombre().getText().trim();
        String textoVida = vista.getTxtPuntosVida().getText().trim();

        if (nombre.isEmpty() || textoVida.isEmpty()) {
            vista.mostrarMensaje("Debe ingresar el nombre y los puntos de vida.");
            return;
        }

        try {
            int puntosVida = Integer.parseInt(textoVida);
            if (puntosVida <= 0) {
                vista.mostrarMensaje("Los puntos de vida deben ser mayores que 0.");
                return;
            }

            Personaje nuevo = new Personaje(nombre, puntosVida);

            for (int fila = 1; fila <= 4; fila++) {
                String clase = (String) vista.getCmbClase(fila).getSelectedItem();
                if (clase.equals("Ninguna")) {
                    continue;
                }
                String textoNivel = vista.getTxtNivel(fila).getText().trim();
                String atributo = vista.getTxtAtributo(fila).getText().trim();

                if (textoNivel.isEmpty() || atributo.isEmpty()) {
                    vista.mostrarMensaje("Complete el nivel y el atributo de la clase " + clase + ".");
                    return;
                }

                int nivel = Integer.parseInt(textoNivel);
                if (nivel <= 0) {
                    vista.mostrarMensaje("El nivel de la clase " + clase + " debe ser mayor que 0.");
                    return;
                }

                nuevo.agregarClase(crearClase(clase, nombre, nivel, atributo));
            }

            if (nuevo.getClases().isEmpty()) {
                vista.mostrarMensaje("Debe elegir al menos una clase.");
                return;
            }

            personajes.add(nuevo);
            RegistroGremio.guardar("Registro: " + nuevo.toString());
            vista.mostrarMensaje("Aventurero registrado:\n" + nuevo.toString());
            limpiarCampos();

        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Error: los puntos de vida, los niveles y los atributos numéricos deben ser números enteros.");
        } catch (IllegalArgumentException ex) {
            vista.mostrarMensaje("Error: " + ex.getMessage());
        }
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

    public String listarGremio() {
        if (personajes.isEmpty()) {
            return "El gremio no tiene aventureros registrados.";
        }
        String texto = "Aventureros del gremio (" + personajes.size() + "):\n\n";
        int numero = 1;
        for (Personaje p : personajes) {
            texto = texto + numero + ". " + p.toString() + "\n\n";
            numero++;
        }
        return texto;
    }    

    public String lanzarDados() {
        if (personajes.size() < 2) {
            return "Se necesitan al menos 2 aventureros para lanzar los dados.";
        }

        ArrayList<Personaje> candidatos = new ArrayList<>(personajes);
        String texto = "Lanzamiento de dados:\n";

        while (candidatos.size() > 1) {
            int mayor = 0;
            ArrayList<Personaje> empatados = new ArrayList<>();
            for (Personaje p : candidatos) {
                int dado = p.lanzarDado();
                texto = texto + "  " + p.getNombre() + ": " + dado + "\n";
                if (dado > mayor) {
                    mayor = dado;
                    empatados.clear();
                    empatados.add(p);
                } else if (dado == mayor) {
                    empatados.add(p);
                }
            }
            if (empatados.size() > 1) {
                texto = texto + "Empate con " + mayor + ". Se vuelve a lanzar entre los empatados:\n";
            }
            candidatos = empatados;
        }

        ganador = candidatos.get(0);

        vista.getCmbClaseCombate().removeAllItems();
        for (Aventurero clase : ganador.getClases()) {
            vista.getCmbClaseCombate().addItem(clase.getNombreClase());
        }

        return texto + "\nGanador: " + ganador.getNombre()
             + ". Elige la clase para pelear y presiona Simular combate.";
    }

    public String simularCombate() {
        if (ganador == null) {
            return "Primero debe lanzar los dados.";
        }
        String nombreClase = (String) vista.getCmbClaseCombate().getSelectedItem();
        Aventurero clase = ganador.buscarClase(nombreClase);

        String accion = clase.simularCombate();
        RegistroGremio.guardar("Combate: " + accion);

        ganador = null;
        vista.getCmbClaseCombate().removeAllItems();
        return "Simulación de combate:\n\n" + accion;
    }
    
    private void limpiarCampos() {
        vista.getTxtNombre().setText("");
        vista.getTxtPuntosVida().setText("");
        for (int fila = 1; fila <= 4; fila++) {
            vista.getCmbClase(fila).setSelectedIndex(0);
            vista.getTxtNivel(fila).setText("");
            vista.getTxtAtributo(fila).setText("");
        }
    }    
    
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
