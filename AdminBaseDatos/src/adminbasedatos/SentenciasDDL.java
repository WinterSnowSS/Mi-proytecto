package adminbasedatos;
import java.sql.*;
public class SentenciasDDL  {
    private Connection con = null;
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
     public static void main(String[] args) {
        Conexion conexionBD = new Conexion();
        SentenciasDDL ddl = new SentenciasDDL(conexionBD.getConexion());
        ddl.mostrarTablas();
        conexionBD.desconectar();
    }
}
        
      
    
