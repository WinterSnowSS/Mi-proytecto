
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paran
 */
public class Ventas {
    public static void main(String[] args) {
        double caja=0;
        double total=0;
        String ticket="Super Tienda Winter \n";
        String res;
        do{
         total=0;
         
          String productos=String.valueOf(JOptionPane.showInputDialog("Ibgrese el producto:  "));
          double precio=Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio: "));
          ticket+=productos+" .................. $"+precio+"\n";
          total+=precio;
          caja+=total;
          res=String.valueOf(JOptionPane.showInputDialog("Quieres Seguir comprando? Si/No  "));
         
        }while(res.equals("Si"));
       JOptionPane.showInputDialog(ticket);
        JOptionPane.showInputDialog(ticket+"Total dentro de la caja: "+caja);
    }
    
}
