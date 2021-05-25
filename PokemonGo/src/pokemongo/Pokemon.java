/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


/**
 *
 * @author mati
 */
class Pokemon implements Serializable, Comparable<Pokemon>{
    private String nombrePokemon;
    private int CP;
 

    public Pokemon() {
        ArrayList<String> todosPokemon= new ArrayList<>();//lista de todos 
    //los pokemons del juego//
        cargar_Pokemons(todosPokemon);
        int pos = (int)(Math.random()*todosPokemon.size());
        System.out.println("pos " + pos);
        nombrePokemon = todosPokemon.get(pos); //asigno nombre
        CP = (int)(Math.random()*100 + 1);
        System.out.println("es un " + nombrePokemon);
        
    }
    
    
    
    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public int getCP() {
        return CP;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombrePokemon=" + nombrePokemon + ", CP=" + CP + '}';
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        if (!this.nombrePokemon.equalsIgnoreCase(other.nombrePokemon)) {
            return false;
        }
        return true;
    }

    private void cargar_Pokemons(ArrayList<String> todosPokemon) {
        //todosPokemon = new ArrayList<>();
       todosPokemon.add("Charmander");
       todosPokemon.add("Bulbasaur");
       todosPokemon.add("Squirtle");
    }
    
    
    public void visualizarPokemon()
    {
        Scanner lector_f=null;
        try {
            File f = new File(this.nombrePokemon + ".pok");
            lector_f = new Scanner(f); 
            String frase;
            while (lector_f.hasNext()) 
            {
            frase = lector_f.nextLine();
                System.out.println(frase);
            }
            lector_f.close(); //cerrar fic
            System.out.println("Fuerza de combate: " + CP);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido algo que no es un numero");
            lector_f.close();
        }
        
    }



    @Override
    public int compareTo(Pokemon o) {
        int comparacion =  this.nombrePokemon.compareTo(o.getNombrePokemon());
        if (comparacion!=0)
                {
                    return comparacion;
                }
        else
        {
            return Integer.compare(this.CP, o.getCP());
        }
    }
    
}
