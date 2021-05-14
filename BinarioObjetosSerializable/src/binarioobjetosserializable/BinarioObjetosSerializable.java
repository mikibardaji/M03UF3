/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarioobjetosserializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class BinarioObjetosSerializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Amigo> agenda = new ArrayList<>();
        cargar_amigos(agenda);
        escribir_ficheroBinario(agenda);
        ArrayList<Amigo> copia_agenda = new ArrayList<>();
        copia_agenda=lectura_ficheroBinario(copia_agenda);
        System.out.println("->" + copia_agenda.size());
        for (int i = 0; i < copia_agenda.size(); i++) {
            System.out.println("nombre " + copia_agenda.get(i).getNombre());
            System.out.println("edat " + copia_agenda.get(i).getEdad());
        }
        
        
        
        
        
        
    }

    private static void cargar_amigos(ArrayList<Amigo> agenda) {
        agenda.add(new Amigo("Carlos Gutierrez", 40));
        agenda.add(new Amigo("Vicente Pulido", 24));
        agenda.add(new Amigo("Sergi Pons",50));
        agenda.add(new Amigo("Pau Cañizares", 50));
    }

    private static void escribir_ficheroBinario(ArrayList<Amigo> agenda) {
        FileOutputStream escritura=null;
        ObjectOutputStream StreamDatosEscritura=null;
        try {
            escritura = new FileOutputStream("amigos3.bin",true); //el true es para añadirlo al final
            StreamDatosEscritura = new ObjectOutputStream(escritura); 
            
            //escribir de uno en uno
           // for (int i = 0; i < agenda.size(); i++) {
          //      StreamDatosEscritura.writeObject(agenda.get(i));
            //}
            StreamDatosEscritura.writeObject(agenda);
            System.out.println("Escrito fichero binario");
            StreamDatosEscritura.close();
            System.out.println("cerrando");
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Error escritura");
            try {
                StreamDatosEscritura.close();
            } catch (IOException ex1) {
                System.out.println("error cerrando archivo");
            }
        }
    }

    private static ArrayList<Amigo> lectura_ficheroBinario(ArrayList<Amigo> copia_agenda) {
        FileInputStream  ficheroLectura = null;
        ObjectInputStream fichero=null;
        
        try {
            ficheroLectura =  new FileInputStream("amigos3.bin");
            fichero= new ObjectInputStream(ficheroLectura);
            System.out.println("Leyendo");
            copia_agenda = (ArrayList<Amigo>) fichero.readObject();
            System.out.println("siez->" + copia_agenda.size());
            
        //podria mostrar los datos
        } catch (FileNotFoundException ex) {
            System.out.println("No existe fichero");
        } catch (IOException ex) {
            System.out.println("Lectura incorrecta datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no correcta");
              
        }
        try {
            fichero.close();
        } catch (IOException ex) {
            System.out.println("Error cerrando fichero");
        }
        
        return copia_agenda;
    }
    
}
