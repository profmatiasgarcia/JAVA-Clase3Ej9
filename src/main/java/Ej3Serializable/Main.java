package Ej3Serializable;
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
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String n = "Jorge";
        String t = "1524536897";
        String d = "por alla 2506";
        Fecha f = new Fecha(4, 8, 1980);

        Contacto c = new Contacto(n, t, d, f);
        Contacto h = new Contacto("Matias", "1547865767", "aca a la vuelta 123", f);

        ContactoOutput salida;
        salida = new ContactoOutput();
        salida.abrir();
        salida.escribir(c);
        salida.escribir(h);
        salida.cerrar();

        ContactoInput entrada;
        entrada = new ContactoInput();
        entrada.abrir();
        do {
            c = entrada.leer();
            h = entrada.leer();
            System.out.println(c);
            System.out.println(h);
        } while (h != null);
        entrada.cerrar();
    }
}
