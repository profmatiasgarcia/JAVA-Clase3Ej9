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

public class AgendaInput {

    private ObjectInputStream entrada;

    public void abrir() throws IOException {
        entrada = new ObjectInputStream(new FileInputStream("src/main/resources/Agenda.ser"));
    }

    public void Leer() throws IOException, ClassNotFoundException {

        Agenda a = null;
        if (entrada != null) {
            try {
                a = (Agenda) entrada.readObject();
                //System.out.println("el nombre es: " + a.getNombre());
                System.out.println(a.toString());
            } catch (EOFException eof) {
                System.out.println("Entro en el catch por no haber mas datos");
            } catch (IOException e) {
                System.err.println("Error al leer el archivo.");
                System.exit(1);
            }

        }

    }

    public void cerrar() throws IOException {
        if (entrada != null) {
            entrada.close();
        }
        System.out.print("Entro en cerrar de AgendaInput \n");

    }

    public AgendaInput() {
        System.out.print("Creado AgendaInput \n");
    }
}
