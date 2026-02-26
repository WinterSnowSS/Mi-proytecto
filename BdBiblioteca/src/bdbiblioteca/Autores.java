/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdbiblioteca;

/**
 *
 * @author paran
 */
public class Autores {
    private int AutorID;
    private String Nombre_Autor;
    private String Nacionalidad;
  
    public Autores(){}

    public Autores(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }
    

    public Autores(int AutorID, String Nombre_Autor, String Nacionalidad) {
        this.AutorID = AutorID;
        this.Nombre_Autor = Nombre_Autor;
        this.Nacionalidad = Nacionalidad;
    }

    public Autores(String Nombre_Autor, String Nacionalidad) {
        this.Nombre_Autor = Nombre_Autor;
        this.Nacionalidad = Nacionalidad;
    }

    public Autores(int AutorID) {
        this.AutorID = AutorID;
    }

    public Autores(int AutorID, String Nombre_Autor) {
        this.Nombre_Autor = Nombre_Autor;
    }

    public int getAutorID() {
        return AutorID;
    }

    public String getNombre_Autor() {
        return Nombre_Autor;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

  
   
    
    
}
