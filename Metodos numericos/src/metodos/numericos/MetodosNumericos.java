/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos.numericos;

import javax.swing.JOptionPane;

/**
 *
 * @author paran
 */
public class MetodosNumericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double base=Double.parseDouble(JOptionPane.showInputDialog("Dame la base"));
        double altura=Double.parseDouble(JOptionPane.showInputDialog("dame la altura"));
        double area=base*altura/2;
        System.out.println("El area es: "+ area);
        // TODO code application logic here
        
        //hacer un programa para calcular el pago mensual correspondiente en una compra de X cantidad dividida en 15 mensualidades al 5%
    }
    
}
