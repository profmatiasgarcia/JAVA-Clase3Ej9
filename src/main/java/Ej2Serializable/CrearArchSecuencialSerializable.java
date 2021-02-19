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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchSecuencialSerializable {

    private ObjectOutputStream archSalida;
    private String nomArch;

    public CrearArchSecuencialSerializable(String nomArch) {
        this.nomArch = nomArch;
    }

    public void abrirArchivo() {
        try {
            archSalida = new ObjectOutputStream(new FileOutputStream(nomArch));
        } // fin de try
        catch (IOException e) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void agregarRegistros() {
        RegistroCuentaSerializable registro;
        int numeroCuenta = 0;
        String primerNombre;
        String apellido;
        double saldo;

        Scanner entrada = new Scanner(System.in);
        String resp = "s";

        System.out.println("ingresa un dato ? s/n");
        resp = entrada.next();

        while (resp.equals("s")) {
            try {
                System.out.println("ingrese el nro de cuenta: ");
                numeroCuenta = entrada.nextInt();
                System.out.println("ingrese el nombre: ");
                primerNombre = entrada.next();
                System.out.println("ingrese el apellido: ");
                apellido = entrada.next();
                System.out.println("ingrese el saldo: ");
                saldo = entrada.nextDouble();

                if (numeroCuenta > 0) {
                    registro = new RegistroCuentaSerializable(numeroCuenta, primerNombre, apellido, saldo);
                    archSalida.writeObject(registro); // graba
                } else {
                    System.out.println("El numero de cuenta debe ser mayor de 0.");
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en elarchivo.");
                return;
            } catch (NoSuchElementException e) {
                System.err.println("Entrada inválida, otra vez");
                entrada.nextLine();
            }

            System.out.println("ingresa mas datos ? s/n");
            resp = entrada.next();
        }
    }

    public void cerrarArchivo() {
        try {
            if (archSalida != null) {
                archSalida.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
