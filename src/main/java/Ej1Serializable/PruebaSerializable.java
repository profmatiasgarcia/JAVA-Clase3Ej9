package Ej1Serializable;
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
import java.util.Date;

public class PruebaSerializable {

    public static void main(String args[]) {
        try {
            // Un OutputStream sobre el que escribir los bytes
            FileOutputStream f = new FileOutputStream("src/main/resources/prueba.dat");
            // El objeto serializador
            ObjectOutputStream ost = new ObjectOutputStream(f);
            Persona persona1 = new Persona("Matias", 41);
            Date fecha = new Date();
            ost.writeObject(persona1);
            ost.writeObject(fecha);
            ost.writeInt(14);
            System.out.println("Se serializo el objeto en el archivo");
            ost.flush(); // vaciar el buffer
            ost.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        
        //-----LECTURA----
        
        try {
            // Un InputStream subyacente del cuál leer los bytes
            FileInputStream f = new FileInputStream("src/main/resources/prueba.dat");
            // El objeto deserializador
            ObjectInputStream ist = new ObjectInputStream(f);
            Persona personaN = (Persona) ist.readObject();
            Date fecha = (Date) ist.readObject();
            int entero = ist.readInt();
            System.out.println(personaN);
            System.out.println(fecha);
            System.out.println(entero);
            System.out.println("Se deserealizo el objeto");
            ist.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }

    }
}
