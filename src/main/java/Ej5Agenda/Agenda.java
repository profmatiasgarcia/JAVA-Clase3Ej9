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
import java.io.Serializable;

public class Agenda implements Serializable {

    private String nombre;
    private String telfCasa;
    private String telfOficina;
    private String celular;

    public Agenda() {

    }

    public Agenda(String n, String tc, String to, String c) {

        setNombre(n);
        setTelfCasa(tc);
        setTelfOficina(to);
        setCelular(c);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelfCasa() {
        return telfCasa;
    }

    public void setTelfCasa(String telfCasa) {
        this.telfCasa = telfCasa;
    }

    public String getTelfOficina() {
        return telfOficina;
    }

    public void setTelfOficina(String telfOficina) {
        this.telfOficina = telfOficina;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String toString() {
        return "Nombre: " + getNombre() + "\nTelefono_Casa: " + getTelfCasa() + "\nTelefono_Oficina: "
                + getTelfOficina() + "\nCelular: " + getCelular();
    }

}
