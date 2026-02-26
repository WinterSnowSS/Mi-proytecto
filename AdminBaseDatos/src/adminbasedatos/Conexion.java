package adminbasedatos;
import java.sql.*;
import javax.swing.*;


public class Conexion 
{
    private Connection con=null;
    
    public Conexion()
    {
    conectar();
    
    }
    public void conectar (){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection
                         /*127.0.0.0*/
            ("jdbc:mysql://localhost/admin_basededatos?user=root&password=1218");
        System.out.println("Conectado a la base de datos de MYSQL");
        System.out.println("Ya esta listo");
    } catch (ClassNotFoundException cnfe){
        System.out.println(cnfe.getMessage());
    }catch (SQLException sqle){
        System.out.println(sqle.getMessage());
    }    
    }
    public void desconectar(){
    try{
    if(con!=null)
        con.close();
    
    
    con=null;
    
    } catch(Exception e){
    
    e.printStackTrace();
    }
    
    
    }
      public void altaAlumnos (Alumnos obj){
/*         
String sentenciaSQL = "INSERT INTO Alumnos VALUES (" 
        + obj.getMatriculaAlumno() + " ,' " 
        + obj.getNombreAlumno() +"," 
        + obj.getID_Especialidad()+ "',"
        + obj.getFechaIngreso()+")";
try{
Statement stm = con.createStatement (); 
int filasAfectadas = stm.executeUpdate (sentenciaSQL); 
System.out.println("Se ha agregado un nuevo registro"); 
System.out.println("Se ha afectado: " + filasAfectadas);
}catch ( SQLException sqle){
System.out.println(sqle.getMessage());
sqle.printStackTrace();
}
     }
      */
         
      try
    {
        System.out.println(obj);
        PreparedStatement ps=con.prepareStatement("INSERT INTO alumnos (MatriculaAlumnos, NombreAlumno, ID_Especialidad, FechaIngreso) VALUES (?,?,?,?)");
        ps.setString(1,obj.getMatriculaAlumno());
        ps.setString(2,obj.getNombreAlumno());
        ps.setString(3,obj.getID_Especialidad());
        ps.setString(4,obj.getFechaIngreso());
        
        
        int filasAfectadas=ps.executeUpdate();
        System.out.println("Numero de filas afectadas"+filasAfectadas);
        
        
    }
    catch (SQLException sqle){
        System.out.println(sqle.getMessage());
        sqle.printStackTrace();
    }
      }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
    }  
    
    }



    

