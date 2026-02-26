/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminbasedatos;

/**
 *
 * @author paran
 */
public class Especialidad {
    private String ID_Especialidad;
    private String NombreEspecialidad;

public Especialidad(){

}

    public Especialidad(String ID_Especialidad, String NombreEspecialidad) {
        this.ID_Especialidad = ID_Especialidad;
        this.NombreEspecialidad = NombreEspecialidad;
    }

    public String getID_Especialidad() {
        return ID_Especialidad;
    }

    public String getNombreEspecialidad() {
        return NombreEspecialidad;
    }



}