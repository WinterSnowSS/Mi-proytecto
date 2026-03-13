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
    public Connection getCon() {
    return con;
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
    public void altaLibros (Libros obj) {
    try
    {
        System.out.println(obj);
        PreparedStatement ps=con.prepareStatement("INSERT INTO Libros (LibroID, Titulo, ISBN, Año_Publicacion, AutorID, EditorialID ,Estado) VALUES (?,?,?,?,?,?,?)");
        ps.setInt(1,obj.getIDLibro());
        ps.setString(2,obj.getTitulo());
        ps.setString(3,obj.getISBN());
        ps.setString(4,obj.getPublicacion());
        ps.setInt(5,(obj.getAutorID()));
        ps.setInt(6,obj.getEditorialID());
        ps.setString(7,obj.getEstado());
         
        
        int filasAfectadas=ps.executeUpdate();
        System.out.println("Numero de filas afectadas"+filasAfectadas);
        
         }
    catch (SQLException sqle){
        System.out.println(sqle.getMessage());
        sqle.printStackTrace();
    }
      }
    public boolean eliminar(String tabla, String nombreColumnaID, int idValor) {
    String sql = "DELETE FROM " + tabla + " WHERE " + nombreColumnaID + " = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idValor);
        
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
        
    } catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null, "No se puede eliminar: El registro está siendo usado en otra tabla.\n" + sqle.getMessage(), "Error de Restricción", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    
      public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
    }
    }
    

