/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdbiblioteca;

/**
 *
 * @author paran
 */
public class Libros {
    private int IDLibro;
    private String titulo;
    private String ISBN;
    private String Publicacion;
    private int AutorID;
    private int EditorialID;
    private String Estado;
    
    
    public Libros(){
    
    }

    public int getAutorID() {
        return AutorID;
    }

    public void setAutorID(int AutorID) {
        this.AutorID = AutorID;
    }

    public int getEditorialID() {
        return EditorialID;
    }

    public void setEditorialID(int EditorialID) {
        this.EditorialID = EditorialID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    public int getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(int IDLibro) {
        this.IDLibro = IDLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(String Publicacion) {
        this.Publicacion = Publicacion;
    }

    public Libros(int IDLibro, String titulo, String ISBN, String Publicacion) {
        this.IDLibro = IDLibro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.Publicacion = Publicacion;
    }

    public Libros(int IDLibro, String titulo) {
        this.IDLibro = IDLibro;
        this.titulo = titulo;
    }
    

    public Libros(String Publicacion) {
        this.Publicacion = Publicacion;
    }

    public Libros(int IDLibro) {
        this.IDLibro = IDLibro;
    }

    public Libros(int IDLibro, String titulo, String ISBN, String Publicacion, int AutorID, int EditorialID, String Estado) {
        this.IDLibro = IDLibro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.Publicacion = Publicacion;
        this.AutorID = AutorID;
        this.EditorialID = EditorialID;
        this.Estado = Estado;
    }
    
    
}
