
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
public class Raices {
    public static double curva (double x){
    double y=Math.cos(x)-Math.exp(x);
    return y;
    }
    public static void main(String[] args) {
        double ln=Double.parseDouble(JOptionPane.showInputDialog("Dame ln"));
        double lp=Double.parseDouble(JOptionPane.showInputDialog("Dame lp"));
        double ax=Double.parseDouble(JOptionPane.showInputDialog("Dame delta x"));
        int r=0;
        double x1=ln;
        double x2=0;
        do{
            x2=x1+ax;
            double y1=curva(x1);
            double y2=curva(x2);
            if ((y1*y2)<0){
        r++;
            System.out.println("r= "+x1+"...... X2= "+x2);
        }
        x1=x2;
        }while (x2<lp);
        System.out.println("Esta ecuacion tuvo X"+r+" Raizes");

    }
}
