package PivoteoParcial;

import java.util.Scanner;
import java.util.Arrays; 

public class PivoteoParcial {

    /**
     * Calcula la suma de los elementos de la diagonal principal 
     * de la submatriz de coeficientes (A[i][i]).
     *
     * @param matriz La matriz aumentada (n x n+1).
     * @return La suma de la diagonal principal.
     */
    public static double calcularSumaDiagonal(double[][] matriz) {
        int n = matriz.length;
        double suma = 0.0;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    public static void realizarIntercambiosExhaustivos(double[][] A_matriz) {
        int n = A_matriz.length; 
        double maxSumaDiagonal = Double.NEGATIVE_INFINITY;
        double[][] matrizConMaxDiagonal = null;
        
        System.out.println("\n--- Iniciando Intercambios Exhaustivos de Filas y Análisis Diagonal ---");
        
        for (int i = 0; i < n; i++) {
                      for (int j = i + 1; j < n; j++) {
                
                double[][] matrizTemporal = new double[n][A_matriz[0].length];
                for (int k = 0; k < n; k++) {
                    matrizTemporal[k] = Arrays.copyOf(A_matriz[k], A_matriz[k].length);
                }
                double[] temp = matrizTemporal[i];
                matrizTemporal[i] = matrizTemporal[j];
                matrizTemporal[j] = temp;

                double sumaDiagonalActual = calcularSumaDiagonal(matrizTemporal);
                
                System.out.printf("\n*** Intercambio Fila %d <-> Fila %d ***\n", i + 1, j + 1);
                imprimirMatriz(matrizTemporal);
                System.out.printf("    Suma de la Diagonal Principal: %.4f\n", sumaDiagonalActual);
                
                if (sumaDiagonalActual > maxSumaDiagonal) {
                    maxSumaDiagonal = sumaDiagonalActual;
                    
                    matrizConMaxDiagonal = new double[n][A_matriz[0].length];
                    for (int k = 0; k < n; k++) {
                        matrizConMaxDiagonal[k] = Arrays.copyOf(matrizTemporal[k], matrizTemporal[k].length);
                    }
                }
            }
        }
        
        System.out.println("\n============================================");
        System.out.println("✅ Todos los intercambios de pares de filas han sido realizados.");
        
        System.out.println("\n*** RESULTADO DEL ANÁLISIS ***");
        System.out.printf("La MAYOR Suma de la Diagonal Principal encontrada fue: %.4f\n", maxSumaDiagonal);
        
        if (matrizConMaxDiagonal != null) {
            System.out.println("La Matriz que produce esa suma es:");
            imprimirMatriz(matrizConMaxDiagonal);
        }
    }

    public static double[][] ingresarMatriz(Scanner scanner) {
        int n;

        System.out.println("=== Ingreso de la Matriz Aumentada ===");
        System.out.print("Ingrese la dimensión (número de filas 'n' de la matriz de coeficientes): ");
        n = scanner.nextInt();

        double[][] matriz = new double[n][n + 1];

        System.out.println("\nIngrese los elementos de la matriz fila por fila:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j < n) {
                    System.out.printf("A[%d][%d] (Coeficiente): ", i + 1, j + 1);
                } else {
                    System.out.printf("b[%d] (Término independiente): ", i + 1);
                }
                matriz[i][j] = scanner.nextDouble();
            }
        }
        
        System.out.println("\n✅ Matriz Ingresada:");
        imprimirMatriz(matriz);
        return matriz;
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                System.out.printf("%10.4f ", elemento);
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            double[][] matrizIngresada = ingresarMatriz(scanner);
            realizarIntercambiosExhaustivos(matrizIngresada);
            
        } catch (Exception e) {
            System.err.println("\n❌ Error de entrada. Asegúrate de ingresar números.");
        
        }
    }
}