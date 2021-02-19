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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class LeerArchivoDeVuelos {

    private Scanner entrada;

    public void abrirArchivo(String archivoVuelos) {
        try {
            entrada = new Scanner(new File(archivoVuelos)); // ("ConjuntoDeVuelos.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }

    public void mostrarDatosDelArchivoVuelosPorPantalla() { // leerVuelos(){
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Nro de vuelo:", "Lugares:", "Ocupados:", "Libres:");
        String mensaje = String.format("%-15s %-15s %-15s %-15s\n", "Nro de vuelo:", "Lugares:", "Ocupados:", "Libres:");
        try {
            int num, lug, lugOcup;
            while (entrada.hasNext()) { // mientras q entrada tenga un proximo
                num = entrada.nextInt();
                lug = entrada.nextInt();
                lugOcup = entrada.nextInt();
                System.out.printf("%-15d %-15d %-15d %-15d\n", num, lug, lugOcup, lug - lugOcup);
                mensaje += String.format("%-25d %-20d %-25d %-25d\n", num, lug, lugOcup, lug - lugOcup);
            }
            EntradaSalida.imprimir(mensaje);

        } catch (NoSuchElementException e) {
            System.err.println("El archivo no está bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException e) {
            System.err.println("Error al leer el archivo.");
            System.exit(1);
        }
    }

    public ArrayList guardarDatosDelArchivoVuelosEnUnArrayList() {// guardarDatos(){
        ArrayList cv = new ArrayList();
        if (entrada != null) {

            int num, lug, ocup;
            while (entrada.hasNext()) {
                num = entrada.nextInt();
                lug = entrada.nextInt();
                ocup = entrada.nextInt();
                Vuelo v = new Vuelo(num, lug, ocup);
                cv.add(v);
            }
        }
        return cv;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        }
    }
}
