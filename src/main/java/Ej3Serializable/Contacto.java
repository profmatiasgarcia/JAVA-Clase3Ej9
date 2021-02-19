package Ej3Serializable;
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

public class Contacto implements Serializable {

    private String nombre;
    private String telefono;
    private String direccion;
    private Fecha cumple;

    public Contacto() {

    }

    public Contacto(String n, String t, String d, Fecha f) {
        setNombre(n);
        setTelefono(t);
        setDireccion(d);
        setCumple(f);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Fecha getCumple() {
        return cumple;
    }

    public void setCumple(Fecha cumple) {
        this.cumple = cumple;
    }

    public String toString() {
        return "Nombre: " + getNombre() + " Telefono: " + getTelefono() + " Direccion: " + getDireccion() + " Fecha de cumple: " + getCumple();
    }

}
