//sucesion para imprimir numeros del 1 al n

import javax.swing.*;
public class Ciclos{

    public static void main (String[] args){
    	
    	//int a=Integer.parseInt(JOptionPane.showInputDialog("Inicio del Ciclo"));
    	int b=Integer.parseInt(JOptionPane.showInputDialog("Fin del Ciclo"));
    	int c=Integer.parseInt(JOptionPane.showInputDialog("Multiplos"));
    	
    	int x=c;
    	
    	while(x<=b){
    		System.out.println(x+" ");
    		x=x+c;	
    	}
	}

}
