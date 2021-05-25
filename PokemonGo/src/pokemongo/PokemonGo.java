/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class PokemonGo {
    public static final String RutaRelativa = "ficheros_pokemon/";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fase1_mostrarLogo();
        String usuario = fase2_validar_usuario();
        PokemonDAO utils = new PokemonDAO();
        ArrayList<Pokemon> mochila = new ArrayList<Pokemon>();
        if(!usuario.equalsIgnoreCase("ERROR"))
        {
            mochila= cargar_mochilaUsuarioSesionesAnteriores(mochila,usuario);
            System.out.println("pokemon en mochila" + mochila.size());
             int opcion;
            do{
            opcion = menu();
            switch(opcion)
            {
                case 1: 
                    utils.CazarPokemon(mochila);
                    break;
                case 2: 
                    utils.ListarPokemon(mochila);
                    break;    
                case 3: 
                    utils.RecibirPokemon(mochila);
                    break;
                case 4: 
                    utils.TransferirPokemon(mochila);
                    break;    
                case 0: 
                    System.out.println("Saliendo y grabando");
                    guardar_mochila_usuario(mochila,usuario);
                    break;    
                
            }
            }while(opcion!=0);
        }
        else
        {
            System.out.println("Adios no estas registrado...");
        }
    }

    private static void fase1_mostrarLogo() {
        Scanner lector_f=null;
        try {
            File f = new File(RutaRelativa + "logo.pok");
            lector_f = new Scanner(f); 
            String frase;
            while (lector_f.hasNext()) 
            {
            frase = lector_f.nextLine();
                System.out.println(frase);
            }
            lector_f.close(); //cerrar fic
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido algo que no es un numero");
            lector_f.close();
        }

    }

    private static String fase2_validar_usuario()  {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pon tu usuario");
        String usuario=teclado.nextLine();
        System.out.println("Pon tu password");
        String password=teclado.nextLine();
        String correcto="ERROR";
         Scanner lector_f=null;
          File f =null;
        try {
            f = new File(RutaRelativa + usuario +"_user.dat");
            lector_f = new Scanner(f); 
            String frase=null;
            if (lector_f.hasNext()) //fitxer no esta buit
            {   frase = lector_f.nextLine();      }
            if (frase.equals(password))
            {
                System.out.println("password correcto");  
                correcto=usuario;
            }
            else
            {
                System.out.println("Login incorrecto");
                correcto="ERROR";
            }
            lector_f.close(); //cerrar fic
        } catch (FileNotFoundException ex) {
            
            FileWriter fw = null;
            try {
                System.out.println("Usuario nuevo en el juego");
                fw = new FileWriter(f);
                fw.write(password);
                fw.close();
                correcto=usuario;
            } catch (IOException ex1) {
                Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex1) {
                    Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido algo que no es un numero");
            lector_f.close();
         
        }
        
        return correcto;
    }

    private static int menu() {
        
        System.out.println( "**************** POkEMON GO *");
	System.out.println("*  1.- Cazar POkEMON                       *");
		System.out.println( "*  2.- Listar Mochila de Cazados           *");
		System.out.println( "*  0.- Salir del Juego                     *");
		System.out.println( "********************************************\n\n");
		System.out.print("  ** ELIGE OPCIÓN -> ");
                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();
                return opcion;
    }

    private static void guardar_mochila_usuario(ArrayList<Pokemon> mochila, String usuario) {
        String nombre_archivo = "mochila_" + usuario + ".dat";
          FileOutputStream escritura;
        ObjectOutputStream StreamDatosEscritura=null;
        try {
            escritura = new FileOutputStream(nombre_archivo); //el true es para añadirlo al final
            StreamDatosEscritura = new ObjectOutputStream(escritura); 
          
            StreamDatosEscritura.writeObject(mochila);
            System.out.println("Guardada mochila");
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

    private static ArrayList<Pokemon> cargar_mochilaUsuarioSesionesAnteriores(ArrayList<Pokemon> mochila, String usuario) {
        FileInputStream  ficheroLectura = null;
        ObjectInputStream fichero=null;
        String nombre_archivo = "mochila_" + usuario + ".dat";
        try {
            ficheroLectura =  new FileInputStream(nombre_archivo);
            fichero= new ObjectInputStream(ficheroLectura);
            System.out.println("Leyendo");
            mochila = (ArrayList<Pokemon>) fichero.readObject();
            System.out.println("siez->" + mochila.size());
            fichero.close();
            
        //podria mostrar los datos
        } catch (FileNotFoundException ex) {
            System.out.println("No existe fichero");
            mochila = new ArrayList<Pokemon>();
          
            
        } catch (IOException ex) {
            System.out.println("Lectura incorrecta datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no correcta");
              
        }
        
        return mochila;
    }
    
}
