/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarioobjetosserializable;

import java.io.Serializable;

/**
 *
 * @author mati
 */
public class Amigo implements Serializable{
    private String nombre;
    private int edad;

    public Amigo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    
}
