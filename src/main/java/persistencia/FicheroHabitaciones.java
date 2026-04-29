/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modeloo.Habitacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanks
 */
public class FicheroHabitaciones {

    private final String ruta = "data/datos.txt";

    public void guardar(List<Habitacion> lista) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            for (Habitacion e : lista) {
                writer.println(e.toString());
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    public List<Habitacion> cargar() {
        List<Habitacion> lista = new ArrayList<>();
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    int num = Integer.parseInt(datos[0]);
                    String piso = datos[1];
                    int precio = Integer.parseInt(datos[2]);
                    boolean disp = Boolean.parseBoolean(datos[3]);
                    lista.add(new Habitacion(num, piso, precio, disp));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
        return lista;
    }
}
