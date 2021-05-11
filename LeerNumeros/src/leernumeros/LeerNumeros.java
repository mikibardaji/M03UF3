/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leernumeros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class LeerNumeros {

    public static final int NUM_VALORES=10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //leer_fichero_numeros();
        //escribir_fichero_numeros();
        //leer_fichero_strings();
        escribir_strings();
        
        
    }

    private static void leer_fichero_numeros() {
         Scanner lector_f=null;
        try {
            File f = new File("enteros.txt");
            lector_f = new Scanner(f);
            while (lector_f.hasNext()) //true si es cierto
            {
                int valor = lector_f.nextInt();
                System.out.println("he leido " + valor);
            }
            lector_f.close(); //cerrar fic
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido algo que no es un numero");
            lector_f.close();
        }
        
        System.out.println("Fin de programa");
    }

    private static void escribir_fichero_numeros() {
        
        try {
            File f = new File("Numeros_escritos.txt");
            FileWriter fw = new FileWriter(f,true);
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("Pon numeros, pon -1 para terminar");
            int valor;
            do{
             valor = teclado.nextInt();
             if(valor!=-1)
             {
                 fw.write(valor + " ");
                 //fw.write("\n"); salto linea
             }
            }while(valor!=-1);
            
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LeerNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void leer_fichero_strings() {
       Scanner lector_f=null;
        try {
            File f = new File("libro.txt");
            lector_f = new Scanner(f); //scanner apunta file
            String frase;
            while (lector_f.hasNext()) //true si es cierto
            {
                frase = lector_f.nextLine();
                if (frase.equalsIgnoreCase("Pepe"))
                {
                    System.out.println("No escribo pepe");
                 }
                else
                {
                    System.out.println("he leido " + frase);
                }
                
            }
            lector_f.close(); //cerrar fic
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido algo que no es un numero");
            lector_f.close();
        }
        
        System.out.println("Fin de programa");
    }

    private static void escribir_strings() {
        try {
        File f = new File("Novela.txt");
        
            FileWriter fw = new FileWriter(f,true);
        
        Scanner teclado = new Scanner(System.in);
            System.out.println("Escribe lo que quieras escribe fin para terminar");
        String frase;
        do
        {
            frase = teclado.nextLine();
            if (!frase.equalsIgnoreCase("fin"))
            {
                fw.write(frase+"\n");
            }
            
            
        }while(!frase.equalsIgnoreCase("fin"));
        fw.close();
        
        } catch (IOException ex) {
            System.out.println("Error escribiendo fichero" + ex.getMessage());
        }
    }
    
}
