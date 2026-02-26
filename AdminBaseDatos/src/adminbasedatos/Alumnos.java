package adminbasedatos;

public class Alumnos {

    private String MatriculaAlumno;
    private String NombreAlumno;
    private String ID_Especialidad;
    private String FechaIngreso;

    public Alumnos() {
    }

    public Alumnos(String MatriculaAlumno, String NombreAlumno, String ID_Especialidad, String FechaIngreso) {
        this.MatriculaAlumno = MatriculaAlumno;
        this.NombreAlumno = NombreAlumno;
        this.ID_Especialidad = ID_Especialidad;
        this.FechaIngreso = FechaIngreso;
    }

    public Alumnos(String MatriculaAlumno) {
        this.MatriculaAlumno = MatriculaAlumno;
    }

    public Alumnos(String MatriculaAlumno, String NombreAlumno) {
        this.MatriculaAlumno = MatriculaAlumno;
        this.NombreAlumno = NombreAlumno;
    }

    public Alumnos(String MatriculaAlumno, String NombreAlumno, String ID_Especialidad) {
        this.MatriculaAlumno = MatriculaAlumno;
        this.NombreAlumno = NombreAlumno;
        this.ID_Especialidad = ID_Especialidad;
    }

    public void setMatricula(String MatriculaAlumno) {
        this.MatriculaAlumno = MatriculaAlumno;
    }

    public String getMatriculaAlumno() {
        return MatriculaAlumno;
    }

    public String getNombreAlumno() {
        return NombreAlumno;
    }

    public String getID_Especialidad() {
        return ID_Especialidad;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setMatriculaAlumno(String MatriculaAlumno) {
        this.MatriculaAlumno = MatriculaAlumno;
    }

    public void setNombreAlumno(String NombreAlumno) {
        this.NombreAlumno = NombreAlumno;
    }

    public void setID_Especialidad(String ID_Especialidad) {
        this.ID_Especialidad = ID_Especialidad;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }
    

    @Override
    public String toString() {
        return "La matricula es " + MatriculaAlumno + " El nombre es: " + NombreAlumno + " la especialidad es: " + ID_Especialidad + " e ingreso el: " + FechaIngreso;
    }
}
