package bdbiblioteca;
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
            ("jdbc:mysql://localhost/biblioteca?user=root&password=1218");
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
    public void altaAutores (Autores obj) {
    try
    {
        System.out.println(obj);
        PreparedStatement ps=con.prepareStatement("INSERT INTO Autores (AutorID, Nombre_Autor, Nacionalidad) VALUES (?,?,?)");
        ps.setInt(1,obj.getAutorID());
        ps.setString(2,obj.getNombre_Autor());
        ps.setString(3,obj.getNacionalidad());
        
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
    

