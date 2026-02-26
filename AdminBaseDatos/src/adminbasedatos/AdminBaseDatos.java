/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbasedatos;
import javax.swing.JOptionPane;


public class AdminBaseDatos{  
   
    public static void main(String[] args) {
       
       var Matricula=JOptionPane.showInputDialog("Cual es tu matricula?");
       var Nombre=JOptionPane.showInputDialog("Cual es tu Nombre?");
       var ID_Especialidad=JOptionPane.showInputDialog("Cual es tu especialidad \n Matematicas 1111 \n Español: 1112");
       var FechaIngreso=JOptionPane.showInputDialog("Cual es tu Fecha de ingreso");
       
       
       JOptionPane.showMessageDialog(null,Matricula);
       JOptionPane.showMessageDialog(null, Nombre);
       JOptionPane.showMessageDialog(null, ID_Especialidad);
       JOptionPane.showMessageDialog(null, FechaIngreso);
       
       
       Alumnos a1=new Alumnos(Matricula,Nombre,ID_Especialidad,FechaIngreso);
        System.out.println(a1);
        Conexion obj=new Conexion();
        obj.altaAlumnos(a1);
        
    }
    
}
