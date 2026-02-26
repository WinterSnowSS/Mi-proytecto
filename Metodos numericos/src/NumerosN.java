
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
public class NumerosN {
    public static void main(String[] args) {
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un limite: "));
     int x=5;   
    while (x<=n) {
        System.out.println(x);
        x+=5;             
    }   
    
    }
    
}
