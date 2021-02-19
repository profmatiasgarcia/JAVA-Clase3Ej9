package Ej2Serializable;
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

public class LeerArchivoTexto {

    private Scanner ArchivoDeEntrada;
    private String nomArch;

    public LeerArchivoTexto(String nomArch) {
        this.nomArch = nomArch;
    }

    public void abrirArchivo() {
        try {
            ArchivoDeEntrada = new Scanner(new File(nomArch));
        } catch (FileNotFoundException e) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }

    public void leerRegistros() {
        RegistroCuenta registro = new RegistroCuenta();

        System.out.printf("%-9s%-15s%-18s%10s\n", "Cuenta", "Primer nombre", "Apellido", "Saldo");

        try // lee registros del archivo, usando el objeto Scanner
        {
            while (ArchivoDeEntrada.hasNext()) {
                registro.setCuenta(ArchivoDeEntrada.nextInt());
                registro.setPrimerNombre(ArchivoDeEntrada.next());
                registro.setApellido(ArchivoDeEntrada.next());
                registro.setSaldo(ArchivoDeEntrada.nextDouble());

                // muestra el contenido del registro
                System.out.printf("%-9d%-15s%-18s%10.2f\r\n", registro.getCuenta(), registro.getPrimerNombre(),
                        registro.getApellido(), registro.getSaldo());
            } // fin de while
        } // fin de try
        catch (NoSuchElementException e) {
            System.err.println("El archivo no esta bien formado.");
            ArchivoDeEntrada.close();
            System.exit(1);
        } catch (IllegalStateException e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
    }

    public void cerrarArchivo() {
        if (ArchivoDeEntrada != null) {
            ArchivoDeEntrada.close();
        }
    }
} // fin clase LeerArchivoTexto
