package Ej4arraylistSerializable;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class CrearArchivoSecuencialDeArrayList {

    private ObjectOutputStream salida; // envía los datos a un archivo

    public void abrirArchivo(String nomArch) {
        try // abre el archivo
        {
            salida = new ObjectOutputStream(new FileOutputStream(nomArch));
        } // fin de try
        catch (IOException e) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void agregarUnArrayList(ArrayList al) {
        try {
            salida.writeObject(al);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException e) {
            System.err.println("Entrada invalida. ");
        }
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException e) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    } // fin del método cerrarArchivo
}
