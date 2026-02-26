package visual;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluadorFuncion {

    public static double evaluar(String funcion, double X) {
        try {
            // Reemplaza potencias tipo X^2 → Math.pow(X,2)
            funcion = funcion.replaceAll("X\\^(\\d+)", "Math.pow(X,$1)");

            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");

            // Define la variable X dentro del motor
            engine.put("X", X);

            Object resultado = engine.eval(funcion);
            return Double.parseDouble(resultado.toString());

        } catch (ScriptException | NumberFormatException e) {
            System.out.println("Error al evaluar la función: " + e.getMessage());
            return Double.NaN;
        }
    }
}
