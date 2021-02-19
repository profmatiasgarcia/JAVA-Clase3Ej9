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
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class CrearArchivoDeVuelos {

    private Formatter salida;

    public void abrirArchivo(String nomArchivoDeVuelos) {
        try {
            salida = new Formatter(nomArchivoDeVuelos);// ("ConjuntoDeVuelos.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } catch (SecurityException s) { // Si quiero acceder a un archivo o una
            // carpeta a la q no tngo acceso
            // (permiso)
            System.err.println("No tiene permiso de escritura para este archivo.");
            System.exit(1);
        }
    }

    public void agregarRegistrosDesdeConjDeVuelos(ConjVuelos cv) {
        for (int i = 0; i < cv.size(); i++) {
            Vuelo v = (Vuelo) cv.get(i);
            try {
                salida.format(("%d\r\n%d\r\n%d\r\n"), v.getNum(), v.getTotalLug(), v.getLugOcup());
            } catch (FormatterClosedException e) {
                System.err.println("Error al grabar el archivo."); // se imprime
                // en rojo
                return;
            } catch (NoSuchElementException e) {
                System.err.println("Error en el tipo de dato ingresado, pruebe de nuevo.");
            }
        }
    }

    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
