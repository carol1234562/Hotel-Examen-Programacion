/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modeloo.Habitacion;
import java.util.List;
import persistencia.FicheroHabitaciones;

/**
 *
 * @author hanks
 */
public class Hotel {

    private List<Habitacion> habitacion;
    private FicheroHabitaciones gestor;

    public Hotel() {
        this.gestor = new FicheroHabitaciones();
        this.habitacion = gestor.cargar();
    }
   

    public void registrar(Habitacion h) throws Exception {
        if (buscar(h.getNumero()) == null) {
        } else {
            throw new Exception("Error" + h.getNumero());
        }
        habitacion.add(h);
    }

    public Habitacion buscar(int numero) {
        for (Habitacion v : habitacion) {
            if (v.getNumero() == (numero)) {
                return v;
            }
        }
        return null;
    }

    public void eliminar(int numero) throws Exception {
        Habitacion v = buscar(numero);
        if (v == null) {
            throw new Exception("Error, no se encontraron datos");
        }
        habitacion.remove(v);
    }

    //=====================================================
    //REVISAR LUEGO 
    //=====================================================
    public void cambiar(int numero) throws Exception {
        Habitacion h = buscar(numero);
        if (h == null) {
            throw new Exception("Habitación no encontrada");
        }
        h.setDisponible(!h.isDisponible());
    }

    public List<Habitacion> listar() {
        return new ArrayList<>(habitacion);
    }

    public void guardarDatos() {
        gestor.guardar(habitacion);
    }

    public void cargarDatos() {
        gestor.cargar();
    }
}
