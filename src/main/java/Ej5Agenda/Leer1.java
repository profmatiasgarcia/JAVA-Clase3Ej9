package Ej5Agenda;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.io.*;

public class Leer1 {

    public static String dato() {
        String sdato = "";
        try {
            // Definir un flujo de caracteres de entrada: flujoE
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            // Leer. La entrada finaliza al pulsar la tecla Entrar
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return sdato; // devolver el dato tecleado
    }

    public static short datoShort() {
        try {
            return Short.parseShort(dato());
        } catch (NumberFormatException e) {
            return Short.MIN_VALUE; // valor mas pequeño
        }
    }

    public static int datoInt() {
        try {
            return Integer.parseInt(dato());
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE; // valor mas pequeño
        }
    }

    public static long datoLong() {
        try {
            return Long.parseLong(dato());
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE; // valor mas pequeño
        }
    }

    public static float datoFloat() {
        try {
            return Float.parseFloat(dato());
        } catch (NumberFormatException e) {
            return Float.NaN; // No es un Numero; valor float.
        }
    }

    public static double datoDouble() {
        try {
            return Double.parseDouble(dato());
        } catch (NumberFormatException e) {
            return Double.NaN; // No es un Numero; valor double.
        }
    }
}
