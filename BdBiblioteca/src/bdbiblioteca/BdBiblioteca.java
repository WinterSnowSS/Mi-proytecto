package bdbiblioteca;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;


public class BdBiblioteca {

    public static void main(String[] args) {
       //Agregar autores
       var AutorID=parseInt(JOptionPane.showInputDialog("Cual es el Id del Autor?"));
       var Nombre_Autor=JOptionPane.showInputDialog("Cual es el nombre del autor?");
       var Nacionalidad=JOptionPane.showInputDialog("Cual es la nacionalidad de tu autor");       
       //Ver autores agregados
       JOptionPane.showMessageDialog(null,AutorID);
       JOptionPane.showMessageDialog(null, Nombre_Autor);
       JOptionPane.showMessageDialog(null, Nacionalidad);
       //Agregar autores a la base de datos
       Autores a1=new Autores(AutorID,Nombre_Autor,Nacionalidad);
       System.out.println(a1);
       Conexion obj=new Conexion();
       obj.altaAutores(a1);
       }
    }
