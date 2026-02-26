
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
/*
public class Playeras {
    public static void main(String[] args) {
        double precio=Double.parseDouble(JOptionPane.showInputDialog("Cual es el precio de la playera?"));
        String color=String.valueOf(JOptionPane.showInputDialog("Cual es el color? "));
        if(color.equals("Blanco")){
        double descuento=precio*0.30;
        double preciofinal=precio-descuento;
       System.out.println("El precio de tu playera blanca es: "+ preciofinal);    
        
        
        }else if (color.equals("Verde")){
    double descuento=precio*0.20;
        double preciofinal=precio-descuento;
       System.out.println("El precio de tu playera verde es: "+ preciofinal); 
    }
        else if (color.equals("Amarillo")){
    double descuento=precio*0.10;
        double preciofinal=precio-descuento;
       System.out.println("El precio de tu playera Amarillo es: "+ preciofinal); 
    } 
        else if (color.equals("Azul")){
    double descuento=precio*0.05;
        double preciofinal=precio-descuento;
       System.out.println("El precio de tu playera Azul es: "+ preciofinal); 
    } 
        else {
        System.out.println("Tu camisa no aplica para el descuento "+ precio);
        }
    }
    
}
*/
//Para imprimir el total a pagar en la compra de una playera 
//considerando que si es de color blanco tiene un descuento del 30%, las demas no tienen descuento

//Las verdes 20%, las amarillas 10%, azul 5%

public class Playeras{

    public static void main (String[] args){
    	
    	double Descuento=0;
    	double Precio=Double.parseDouble(JOptionPane.showInputDialog("Dame el Precio"));
    	
    	int Opc=Integer.parseInt(JOptionPane.showInputDialog("1- Blanco\n 2-Verde\n 3-Amarillo\n 4-Azul\n Elige el Color"));
    	switch(Opc){
    		case 1: Descuento=(Precio*0.3); break;
    		case 2: Descuento=(Precio*0.2); break;
    		case 3: Descuento=(Precio*0.1); break;
    		case 4: Descuento=(Precio*0.05); break;
    		default: Descuento=0;
    	}
    	
    	Precio=(Precio-Descuento);
    	System.out.println("El total a pagar $"+Precio);
	}
}