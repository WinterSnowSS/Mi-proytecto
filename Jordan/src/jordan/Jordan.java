/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jordan;
import javax.swing.*;
/**
 *
 * @author paran
 */
public class Jordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz:"));
        int m=n+1;
        double[][] a= new double[n][m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                a[i][j]= Double.parseDouble(JOptionPane.showInputDialog("Teclea a ["+i+"]["+j+"]"));

        }
        }
        System.out.println("SISTEMA ORIGINAL");    
        for(int i=0; i<n;i++){ 
           for(int j=0; j<m;j++)
               System.out.print(a[i][j]+"   ");
            System.out.println();      
        }
        for (int piv=0;piv<n;piv++){
            double pivote=a[piv][piv];
            for(int j=0; j<m;j++)
                a[piv][j]=a[piv][j]/pivote;
            for (int ren=0;ren<n;ren++){
               if(ren!=piv){
                    double cero=a[ren][piv];
                    for(int j=0; j<m;j++)
                        a[ren][j]=a[ren][j]-cero*a[piv][j];    
               }   
            }
        }
        
        for(int i=0; i<n;i++)
               System.out.println("x["+(i+1)+"].- "+a[i][n]);   
}
    }
