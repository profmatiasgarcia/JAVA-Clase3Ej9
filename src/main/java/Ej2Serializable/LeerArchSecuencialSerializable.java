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
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerArchSecuencialSerializable {

    private ObjectInputStream archEntrada;
    private String nomArch;

    public LeerArchSecuencialSerializable(String nomArch) {
        this.nomArch = nomArch;
    }

    public void abrirArchivo() {
        try {
            archEntrada = new ObjectInputStream(new FileInputStream(nomArch));
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void leerRegistros() {
        RegistroCuentaSerializable registro;
        System.out.printf("%-10s%-15s%-15s%10s\n", "Cuenta", "Primer nombre", "Apellido", "Saldo");
        try {
            while (true) {
                registro = (RegistroCuentaSerializable) archEntrada.readObject();

                System.out.printf("%-10d%-15s%-15s%11.2f\r\n", registro.getCuenta(), registro.getPrimerNombre(),
                        registro.getApellido(), registro.getSaldo());
            }
        } catch (EOFException e) {
            return; // fin del archivo
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo crear el objeto.");
        } catch (IOException e) {
            System.err.println("Error al leer del archivo.");
        }
    }

    public void cerrarArchivo() {
        try {
            if (archEntrada != null) {
                archEntrada.close();
            }
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
