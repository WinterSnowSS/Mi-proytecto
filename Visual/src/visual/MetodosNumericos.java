package visual;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.Math;

public class MetodosNumericos {

    private static final ScriptEngine engine;

    static {
        ScriptEngineManager manager = new ScriptEngineManager();
        // Inicializa el motor de JavaScript (estándar en Java)
        engine = manager.getEngineByName("js"); 
        if (engine == null) {
            throw new RuntimeException("ERROR FATAL: Motor JavaScript no encontrado.");
        }
    }

    /**
     * Evalúa la función f(x) para un valor dado de x. 
     * NOTA: La función debe usar Math.pow(x, n) para potencias.
     * Ejemplo: "Math.pow(x, 3) - 2*Math.pow(x, 2) - 5*x + 2"
     */
    public static double evaluar(String funcionStr, double x) {
        try {
            engine.put("x", x); 
            
            // Evalúa la expresión
            Object resultado = engine.eval(funcionStr);

            if (resultado instanceof Number) {
                return ((Number) resultado).doubleValue();
            }
            return Double.NaN;
            
        } catch (ScriptException e) {
            System.err.println("Error de sintaxis en la función ingresada.");
            return Double.NaN;
        } catch (Exception e) {
            System.err.println("Error general al evaluar: " + e.getMessage());
            return Double.NaN;
        }
    }
    
    // --- MÉTODOS NUMÉRICOS (No requieren cambios funcionales, solo se asegura el manejo de errores) ---
    
    public static String biseccion(String func, double a, double b, double tol, int maxIter) {
        StringBuilder sb = new StringBuilder();
        sb.append("i \t a \t\t b \t\t c \t\t f(c) \t\t Error\n");
        
        double fa = evaluar(func, a);
        double fb = evaluar(func, b);
        
        if (fa == Double.NaN || fb == Double.NaN) {
             return "ERROR: La función tiene un error de sintaxis o formato incorrecto (usa Math.pow()).";
        }
        
        if (fa * fb >= 0) {
            return "ERROR: f(a) y f(b) deben tener signos opuestos.";
        }
        
        double c = a;
        double fc;
        double error = Double.MAX_VALUE;
        
        for (int i = 1; i <= maxIter; i++) {
            double c_old = c;
            c = (a + b) / 2.0;
            fc = evaluar(func, c);
            
            error = Math.abs(c - c_old);
            
            sb.append(String.format("%d \t %.6f \t %.6f \t %.6f \t %.6f \t %.6f\n", i, a, b, c, fc, error));
            
            if (Math.abs(fc) < tol || error < tol) {
                sb.append("\nCONVERGENCIA ALCANZADA.\n");
                sb.append(String.format("Raíz aproximada: %.6f", c));
                return sb.toString();
            }
            
            if (evaluar(func, a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        
        sb.append("\nFin de Iteraciones. No se alcanzó la tolerancia.\n");
        sb.append(String.format("Mejor aproximación: %.6f", c));
        return sb.toString();
    }
    
    public static String newtonRaphson(String func, double x0, double tol, int maxIter) {
        StringBuilder sb = new StringBuilder();
        double h = 0.000000000001; // Paso para la aproximación de la derivada
        double x_actual = x0;
        double error = Double.MAX_VALUE;
        
        sb.append("i \t x_i \t\t f(x_i) \t x_i+1 \t\t Error\n");
        
        for (int i = 1; i <= maxIter; i++) {
            double fx = evaluar(func, x_actual);
            
            // Aproximación de la Derivada (f'(x) ≈ (f(x+h) - f(x)) / h)
            double fx_prima = (evaluar(func, x_actual + h) - fx) / h;
            
            if (fx == Double.NaN || fx_prima == Double.NaN) {
                 return "ERROR: La función tiene un error de sintaxis o formato incorrecto (usa Math.pow()).";
            }
            
            if (Math.abs(fx_prima) < 1e-10) { 
                return "ERROR: Derivada cercana a cero en x = " + x_actual;
            }
            
            double x_next = x_actual - fx / fx_prima;
            error = Math.abs(x_next - x_actual);
            
            sb.append(String.format("%d \t %.6f \t %.6f \t %.6f \t %.6f\n", i, x_actual, fx, x_next, error));

            if (error < tol) {
                sb.append("\nCONVERGENCIA ALCANZADA.\n");
                sb.append(String.format("Raíz aproximada: %.6f", x_next));
                return sb.toString();
            }
            
            x_actual = x_next;
        }
        
        sb.append("\nFin de Iteraciones. No se alcanzó la tolerancia.\n");
        sb.append(String.format("Mejor aproximación: %.6f", x_actual));
        return sb.toString();
    }
    
    public static String secante(String func, double x0, double x1, double tol, int maxIter) {
        StringBuilder sb = new StringBuilder();
        double x_prev = x0;
        double x_curr = x1;
        double error = Double.MAX_VALUE;

        sb.append("i \t x_i-1 \t\t x_i \t\t x_i+1 \t\t Error\n");

        for (int i = 1; i <= maxIter; i++) {
            double fx_prev = evaluar(func, x_prev);
            double fx_curr = evaluar(func, x_curr);

            if (fx_prev == Double.NaN || fx_curr == Double.NaN) {
                 return "ERROR: La función tiene un error de sintaxis o formato incorrecto (usa Math.pow()).";
            }

            double denominador = fx_curr - fx_prev;
            
            if (Math.abs(denominador) < 1e-10) {
                 return "ERROR: El denominador es casi cero (f(x_i) ≈ f(x_i-1)).";
            }
            
            double x_next = x_curr - fx_curr * (x_curr - x_prev) / denominador;
            error = Math.abs(x_next - x_curr);

            sb.append(String.format("%d \t %.6f \t %.6f \t %.6f \t %.6f\n", i, x_prev, x_curr, x_next, error));

            if (error < tol) {
                sb.append("\nCONVERGENCIA ALCANZADA.\n");
                sb.append(String.format("Raíz aproximada: %.6f", x_next));
                return sb.toString();
            }

            x_prev = x_curr;
            x_curr = x_next;
        }

        sb.append("\nFin de Iteraciones. No se alcanzó la tolerancia.\n");
        sb.append(String.format("Mejor aproximación: %.6f", x_curr));
        return sb.toString();
    }
    // Dentro de MetodosNumericos.java

/**
 * Método "Von" (Versión de Newton-Raphson con función ingresada por el usuario).
 * Utiliza la aproximación numérica de la derivada (igual que el método Newton-Raphson).
 */
public static String metodoVon(String func, double x0, double tol, int maxIter) {
    // Este método es funcionalmente idéntico a newtonRaphson, 
    // pero lo renombramos para cumplir con la solicitud del botón "Von".
    // Reutilizamos el mismo código de newtonRaphson para mantener el evaluador de string.
    
    StringBuilder sb = new StringBuilder();
    double h = 0.0001; // Usamos 1e-4 para mejor estabilidad
    double x_actual = x0;
    
    sb.append("i \t x_i \t\t f(x_i) \t x_i+1 \t\t Error\n");
    
    for (int i = 1; i <= maxIter; i++) {
        double fx = evaluar(func, x_actual);
        
        // Aproximación de la Derivada
        double fx_prima = (evaluar(func, x_actual + h) - fx) / h;
        
        if (fx == Double.NaN || fx_prima == Double.NaN) {
             return "ERROR: La función tiene un error de sintaxis o formato incorrecto (usa Math.pow()).";
        }
        
        if (Math.abs(fx_prima) < 1e-10) { 
            return "ERROR: Derivada cercana a cero en x = " + x_actual;
        }
        
        double x_next = x_actual - fx / fx_prima;
        double error = Math.abs(x_next - x_actual);
        
        sb.append(String.format("%d \t %.6f \t %.6f \t %.6f \t %.6f\n", i, x_actual, fx, x_next, error));

        if (error < tol) {
            sb.append("\nCONVERGENCIA ALCANZADA.\n");
            sb.append(String.format("Raíz aproximada: %.6f", x_next));
            return sb.toString();
        }
        
        x_actual = x_next;
    }
    
    sb.append("\nFin de Iteraciones. No se alcanzó la tolerancia.\n");
    sb.append(String.format("Mejor aproximación: %.6f", x_actual));
    return sb.toString();
}
// Dentro de MetodosNumericos.java

/**
 * Método de Búsqueda de Raíces por Barrido (Scanning).
 * Utiliza x0 como Limite Negativo, x1 como Limite Positivo y la Tolerancia como Delta X.
 */
public static String busquedaRaices(String func, double limiteNegativo, double limitePositivo, double deltaX) {
    StringBuilder sb = new StringBuilder();
    int contadorDeRaices = 0;
    
    double x1 = limiteNegativo;
    double x2, y1, y2;
    
    sb.append("Raíces encontradas por intervalos:\n");

    do {
        x2 = x1 + deltaX;
        
        if (x2 > limitePositivo && x1 < limitePositivo) {
             x2 = limitePositivo; // Asegura que no se pase del límite positivo en la última iteración
        }
        
        y1 = evaluar(func, x1);
        y2 = evaluar(func, x2);
        
        if (y1 == Double.NaN || y2 == Double.NaN) {
             return "ERROR: La función tiene un error de sintaxis o formato incorrecto (usa Math.pow()).";
        }
        
        // Criterio de cambio de signo
        if ((y1 * y2) < 0) {
            contadorDeRaices++;
            sb.append(String.format("Raíz #%d: Intervalo [%.4f, %.4f] (Cambio de signo).\n", contadorDeRaices, x1, x2));
        }
        
        x1 = x2;
        
    } while (x1 < limitePositivo);
    
    if (contadorDeRaices == 0) {
        sb.append("No se detectó ningún cambio de signo en el intervalo con Delta X = " + deltaX);
    } else {
        sb.append("\nTotal de intervalos con cambio de signo: " + contadorDeRaices);
    }
    
    return sb.toString();
}
}