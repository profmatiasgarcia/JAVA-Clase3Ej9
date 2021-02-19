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

public class AgendaOutput {

    private ObjectOutputStream salida;

    public void abrir() throws IOException {
        salida = new ObjectOutputStream(new FileOutputStream("src/main/resources/Agenda.ser"));

    }

    public void agregarDatos() throws IOException {

        System.out.println("Ingrese Nombre: ");
        String n = "";
        n = Leer1.dato();
        System.out.println("telefono-Casa: ");
        String c = "";
        c = Leer1.dato();
        System.out.println("telefono-Oficina: ");
        String o = "";
        o = Leer1.dato();
        System.out.println("Celular: ");
        String cel = "";
        cel = Leer1.dato();

        Agenda a = new Agenda(n, c, o, cel);
        if (salida != null) {
            salida.writeObject(a);
            System.out.println("Entro en salida!=null");
        }

    }

    public void cerrar() throws IOException {
        if (salida != null) {
            salida.close();
        }
        System.out.print("Entro en cerrar de AgendaOutput\n");

    }

    public AgendaOutput() {
        System.out.print("Creado el AgendaOutput \n");
    }

}
