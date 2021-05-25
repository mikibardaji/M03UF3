/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Diccionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ArrayList<String> palabras = new ArrayList<String>();
        
        
        palabras = leer_ficheroDiccionario(palabras);
        //arraylist tiene todas las palabras
        
        for (int i = 'A'; i <= 'Z'; i++) {
            char letra = (char) i;
            System.out.println(i + "-" + letra);
            File file = new File(letra + ".txt");
            try {
                FileWriter f = new FileWriter(file);
                for (int j = 0; j < palabras.size(); j++) {
                    //recorrer todas las palabras
                    if (palabras.get(j).toUpperCase().charAt(0)==letra)
                    {
                        f.write(palabras.get(j)+"\n");
                    }
                }
                f.close();  
            } catch (IOException ex) {
                System.out.println("error");
            }
            
        }
        
    }

    private static ArrayList<String> leer_ficheroDiccionario(ArrayList<String> palabras) {
         // Lectura de diccionario.txt
                File fileDiccionario = new File("diccionario.txt");
                Scanner reader;
        try {
            reader = new Scanner(fileDiccionario);
                while (reader.hasNext()) {
                    palabras.add(reader.nextLine());
                }

                // Cerramos archivo
                reader.close();
                } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existente");
        }
        return palabras;
    }
    
}
