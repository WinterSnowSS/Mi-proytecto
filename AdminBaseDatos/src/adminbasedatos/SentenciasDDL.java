package adminbasedatos;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class SentenciasDDL  {
    private Connection con = null;
    Conexion prueba1=new Conexion();
    
    public SentenciasDDL(Connection conexionRecibida) {
        this.con = conexionRecibida;
    }


    public void crearTablas() {
        if (this.con == null) {
            System.err.println("Error: La conexión no existe.");
            return;
        }

        String sentenciaDDL1 = "CREATE TABLE tGeraClientes (" +
                "codtipos INTEGER NOT NULL PRIMARY KEY, " +
                "nontipo VARCHAR(20) NOT NULL, " +
                "costo FLOAT NOT NULL, " +
                "MultaDia FLOAT NOT NULL" +
                ")";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sentenciaDDL1);
            System.out.println("Tablas Creadas con éxito");
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
     public void alterarTabla(){
        String sentenciaDDL="ALTER TABLE tGeraClientes ADD clase VARCHAR(20)";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sentenciaDDL);
            System.out.println("Campo clase agregado");
        } catch(SQLException e){
            System.err.println(e.getMessage()); 
        }
    }
      public void borrarTablaTipos(){
        String sentenciaDDL="DROP TABLE tGeraClientes";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sentenciaDDL);
            System.out.println("Tabla Borrada");
        } catch(SQLException e){
            System.err.println(e.getMessage()); 
        }
    }
    
    public void mostrarTablas() {
    String sql = "SHOW TABLES";
    
    try {
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        System.out.println("--- Tablas en la Base de Datos ---");
        while (rs.next()) {
            String nombreTabla = rs.getString(1);
            System.out.println("- " + nombreTabla);
        }
        
    } catch (SQLException e) {
        System.err.println("Error al mostrar tablas: " + e.getMessage());
    }
}
   public void obtenerPropiedades(){
   DatabaseMetaData dm=null;
   ResultSet rs=null;
   try{
   if(con!=null){
   dm= con.getMetaData();
       System.out.println("Driver Information");
       System.out.println("\tNombre del Driver: "+ dm.getDriverName());
       System.out.println("\tVersion del Driver: "+ dm.getDriverVersion());
       System.out.println("\nInformacion de la BD"+ dm.getDatabaseProductName());
       System.out.println("\tVersion de la BD: "+dm.getDatabaseProductVersion());
       
       System.out.println("Catalogos Disponibles");
       rs=dm.getCatalogs();
       while(rs.next()){
           System.out.println("\tCatalogo: "+rs.getString(1));
       }
   
   boolean soportaSavepoints= dm.supportsSavepoints();
   if (soportaSavepoints == true)
           System.out.println("Los Savepoints son soportados");
   else 
           System.out.println("Los savepoints no son soportados");
   rs.close();
   rs= null;
   prueba1.desconectar ();
   }
   else System.out.println("Error: no se tiene una conexion activa");
   }catch (Exception e){
    e.printStackTrace();
}
   dm=null;
   }
   public void consultarDato(){
   ResultSet rs;
   Statement stm;
   
   String sentenciaSQL = "SELECT * FROM alumnos";
   try{
   stm =con.createStatement();
   rs=stm.executeQuery(sentenciaSQL);
   while (rs.next())
   {
       System.out.println(rs.getString("MatriculaAlumnos"));
       System.out.println(rs.getString("NombreAlumno"));   
       System.out.println(rs.getString("ID_Especialidad")); 
       System.out.println(rs.getString("FechaIngreso")); 
   }
   }
   catch (SQLException sqle){
       System.out.println(sqle.getMessage());
       sqle.printStackTrace();
   
   }
   }
   /*
  public void consultarDato2(){
   ResultSet rs;
   Statement stm;
   
   String sentenciaSQL = "SELECT * FROM alumnos";
   try{
   stm =con.createStatement();
   rs=stm.executeQuery(sentenciaSQL);
   while (rs.next())
   {
  
System.out.printf("%-12s %-32s %-10s %-12s %n", 
    rs.getString("MatriculaAlumnos"), 
    rs.getString("NombreAlumno"), 
    rs.getString("ID_Especialidad"), 
    rs.getString("FechaIngreso"));
   }
   }
   catch (SQLException sqle){
       System.out.println(sqle.getMessage());
       sqle.printStackTrace();
   
   }
   }
  */
public void consultarDato2() {
    // 1. Definimos el ArrayList para almacenar objetos de la clase Alumno
    List<Alumnos> listaAlumnos = new ArrayList<>();
    String sentenciaSQL = "SELECT * FROM alumnos";
    
    try {
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sentenciaSQL);

        // 2. Llenado del ArrayList desde la base de datos
        while (rs.next()) {
            // Creamos el objeto usando el constructor de tu clase Alumno
            Alumnos alu = new Alumnos(
                rs.getString("MatriculaAlumnos"),
                rs.getString("NombreAlumno"),
                rs.getString("ID_Especialidad"),
                rs.getString("FechaIngreso")
            );
            listaAlumnos.add(alu);
        }

        // 3. Impresión estética (todo dentro del mismo método)
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay datos para mostrar.");
        } else {
            // Línea decorativa superior
            System.out.println("\n" + "=".repeat(85));
            // Encabezados con formato de columnas fijas
            System.out.printf("| %-12s | %-30s | %-15s | %-15s |%n", 
                              "MATRICULA", "NOMBRE COMPLETO", "ESPECIALIDAD", "FECHA INGRESO");
            System.out.println("-".repeat(85));

            // Ciclo para recorrer el ArrayList e imprimir cada fila
            for (Alumnos a : listaAlumnos) {
                // Aquí usamos los métodos de tu clase Alumno
                System.out.printf("| %-12s | %-30s | %-15s | %-15s |%n", 
                    a.getMatriculaAlumno(), 
                    a.getNombreAlumno(), 
                    a.getID_Especialidad(), 
                    a.getFechaIngreso());
            }
            // Línea decorativa inferior
            System.out.println("=".repeat(85));
        }

    } catch (SQLException sqle) {
        System.out.println("Error al consultar: " + sqle.getMessage());
        sqle.printStackTrace();
    }
}
   
     public static void main(String[] args) {
          Conexion conexionBD = new Conexion();
        SentenciasDDL ddl = new SentenciasDDL(conexionBD.getConexion());
        ddl.mostrarTablas();
        ddl.obtenerPropiedades();
        ddl.consultarDato2();
        conexionBD.desconectar();
       
    }
}

        
      
    
