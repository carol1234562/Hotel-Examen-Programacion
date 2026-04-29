/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modeloo.Habitacion;

/**
 *
 * @author hanks
 */
public interface IDAO {
    void guardar(List<Habitacion> lista);
    List<Habitacion> cargar();
}
