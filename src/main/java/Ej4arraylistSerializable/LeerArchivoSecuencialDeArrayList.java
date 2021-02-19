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
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class LeerArchivoSecuencialDeArrayList {

    private ObjectInputStream entrada;

    public void abrirArchivo(String nomArch) {
        try {
            entrada = new ObjectInputStream(new FileInputStream(nomArch));

        } catch (IOException e) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public ArrayList leerArrayList() {
        ArrayList arL = null;
        try {
            arL = (ArrayList) entrada.readObject();
        } catch (EOFException e) {
            // se llegó al fin del archivo
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo crear el objeto.");
        } catch (IOException e) {
            System.err.println("Error al leer del archivo.");
        }
        return arL;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }

        } // fin de try
        catch (IOException e) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    } // fin del método cerrarArchivo
}
