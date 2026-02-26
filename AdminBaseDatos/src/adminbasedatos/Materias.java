
package adminbasedatos;

/**
 *
 * @author paran
 */
public class Materias {
    private String Clave_Materia;
    private String Nombre_Materia;
    private int creditos;
    private String ID_Especialidad;
    public Materias(){
    
    }

    public Materias(String Clave_Materia, String Nombre_Materia, int creditos, String ID_Especialidad) {
        this.Clave_Materia = Clave_Materia;
        this.Nombre_Materia = Nombre_Materia;
        this.creditos = creditos;
        this.ID_Especialidad = ID_Especialidad;
    }
    

    public String getClave_Materia() {
        return Clave_Materia;
    }

    public String getNombre_Materia() {
        return Nombre_Materia;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getID_Especialidad() {
        return ID_Especialidad;
    }
    
    
    
}
