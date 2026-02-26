
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
public class Fuerzas {
    public static void main(String[] args) {
        double f1=Double.parseDouble(JOptionPane.showInputDialog("Dame F1"));
        double f2=Double.parseDouble(JOptionPane.showInputDialog("Dame F2"));
        double f3=Double.parseDouble(JOptionPane.showInputDialog("Dame F3"));
        double a1=Double.parseDouble(JOptionPane.showInputDialog("Dame A1"));
        double a2=Double.parseDouble(JOptionPane.showInputDialog("Dame A2"));
        double a3=Double.parseDouble(JOptionPane.showInputDialog("Dame A3"));
        double fx1=f1*Math.cos(a1);
        double fx2=f1*Math.cos(a2);
        double fx3=f1*Math.cos(a3);
        double fy1=f1*Math.sin(a1);
        double fy2=f1*Math.sin(a2);
        double fy3=f1*Math.sin(a3);
        
        double sfx=fx1+fx2+fx3;
        double sfy=fy1+fy2+fy3;
        
        double fr=Math.sqrt(Math.pow(sfx,2)+Math.pow(sfy,2));
        double ar=Math.atan(sfy/sfx);
        System.out.println("la fuerza resultante es: "+fr);
        System.out.println("El angunlo resultadnte es: "+ar);
        
        
    }
    
}
