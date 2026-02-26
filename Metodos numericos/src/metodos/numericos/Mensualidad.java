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
public class Mensualidad {
    public static void main(String[] args) {
    double Precio= Double.parseDouble(JOptionPane.showInputDialog("Que precio tiene el producto?"));
    double Interes=Precio*0.05;
    double Mensualidad=(Precio+Interes)/15;
    System.out.println("El pagp mesual durante los siguientes 15 meses es: "+ Mensualidad);
}
}