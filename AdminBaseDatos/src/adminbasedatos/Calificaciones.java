/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminbasedatos;

/**
 *
 * @author paran
 */
public class Calificaciones {
   private String MatriculaAlumnos;
   private String Clave_Materia;
   private int Calificacion_Final;
   private String Periodo;
    
  public Calificaciones(){
  
  } 

    public Calificaciones(String MatriculaAlumnos, String Clave_Materia, int Calificacion_Final, String Periodo) {
        this.MatriculaAlumnos = MatriculaAlumnos;
        this.Clave_Materia = Clave_Materia;
        this.Calificacion_Final = Calificacion_Final;
        this.Periodo = Periodo;
    }

    public String getMatriculaAlumnos() {
        return MatriculaAlumnos;
    }

    public void setMatriculaAlumnos(String MatriculaAlumnos) {
        this.MatriculaAlumnos = MatriculaAlumnos;
    }

    public String getClave_Materia() {
        return Clave_Materia;
    }

    public void setClave_Materia(String Clave_Materia) {
        this.Clave_Materia = Clave_Materia;
    }

    public int getCalificacion_Final() {
        return Calificacion_Final;
    }

    public void setCalificacion_Final(int Calificacion_Final) {
        this.Calificacion_Final = Calificacion_Final;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }
  
  
}
