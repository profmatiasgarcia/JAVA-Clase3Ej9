package Ej6Aerolinea;
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
import javax.swing.JOptionPane;

public class EntradaSalida {

    public static String leerCadena(String txt) { // Como en el paquete de Math,
        // tampoco hay q crear
        // objetos
        return JOptionPane.showInputDialog(txt);
    }

    public static int leerInt(String txt) { // Son estaticos porq vamos a usar
        // estos metodos sin crear objetos
        String s = leerCadena(txt);
        return s.equals("") ? 0 : Integer.parseInt(s);
    }

    public static double leerDouble(String txt) { // Son estaticos porq vamos a
        // usar estos metodos sin
        // crear objetos
        return Double.parseDouble(leerCadena(txt));
    }

    public static char leerChar(String txt) {
        return leerCadena(txt).charAt(0);
    }

    public static void imprimir(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
