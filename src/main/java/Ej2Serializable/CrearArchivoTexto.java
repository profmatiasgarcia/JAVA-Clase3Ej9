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
import java.io.FileNotFoundException;
import java.util.Formatter; // Uso de la clase Formatter p/grabar datos en un arch. de texto
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivoTexto {

    private Formatter ArchivoDeSalida;
    private String nomArch;

    public CrearArchivoTexto(String nomArch) {
        this.nomArch = nomArch;
    }

    public void abrirArchivo() {
        try {
            ArchivoDeSalida = new Formatter(nomArch);
        } catch (SecurityException s) {
            System.err.println("No tiene acceso de escritura");
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        }
    } // fin del método abrirArchivo

    public void agregarRegistros() {

        RegistroCuenta registro = new RegistroCuenta();

        Scanner entradaDelTeclado = new Scanner(System.in);
        String resp = "s";
        System.out.println("ingresa un dato ? s/n");
        resp = entradaDelTeclado.next();
        while (resp.equals("s")) {
            try {
                System.out.println("ingrese el nro de cuenta: ");
                registro.setCuenta(entradaDelTeclado.nextInt());
                System.out.println("ingrese el nombre: ");
                registro.setPrimerNombre(entradaDelTeclado.next());
                System.out.println("ingrese el apellido: ");
                registro.setApellido(entradaDelTeclado.next());
                System.out.println("ingrese el saldo: ");
                registro.setSaldo(entradaDelTeclado.nextDouble());

                if (registro.getCuenta() > 0) {

                    ArchivoDeSalida.format("%d %s %s %.2f\r\n", registro.getCuenta(), registro.getPrimerNombre(),
                            registro.getApellido(), registro.getSaldo());
                } else {
                    System.out.println("El num de cuenta debe ser > que 0.");
                }
            } catch (FormatterClosedException e) {
                System.err.println("Error al escribir archivo.");
                return;
            } catch (NoSuchElementException e) {
                System.err.println("Entrada invalida. De nuevo.");
                entradaDelTeclado.nextLine();
            }

            System.out.println("ingresa mas datos ? s/n");
            resp = entradaDelTeclado.next();
        } // fin de while
    } // fin del método agregarRegistros

    public void cerrarArchivo() {
        if (ArchivoDeSalida != null) {
            ArchivoDeSalida.close();
        }
    }
}
