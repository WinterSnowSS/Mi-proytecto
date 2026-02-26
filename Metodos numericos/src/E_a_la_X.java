import javax.swing.JOptionPane;
public class E_a_la_X {
    public static void main(String[] args) {
        double x=Double.parseDouble(JOptionPane.showInputDialog("Dame X:"));
        double e=Double.parseDouble(JOptionPane.showInputDialog("Dame el error:"));
        double sum=1+x,rel=0,term=0,num=0,del=0;
        int pot=1;
        do{
            pot++;
            double acum=sum;
            num=Math.pow(x,pot);
            del=1;
            for(int i=1;i<=pot;i++){
                del*=i;
            }
            term=num/del;
            sum=sum+term;
            rel=sum-acum;
            System.out.println("Sum= "+sum+"0..... "+"rel= "+rel);
        }while(Math.abs(rel)>=e);
        System.out.println("El valor de E a la "+x+" es: "+sum);
        }
    }
//Serie del seno y del coseno.
