/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherobinario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class FicheroBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String ruta_archivo ="imagenes/s5_logo.png";
       leer_escribir_fichero_binario(ruta_archivo);
    }

    private static void leer_escribir_fichero_binario(String ruta_archivo) {
        int cont=0, byteLeido;
        boolean fin_fichero=false;
        FileInputStream FicheroLectura=null;
        FileOutputStream Fichero_copia=null;
        
        try {
            FicheroLectura = new FileInputStream(ruta_archivo);
            Fichero_copia = new FileOutputStream("imagenes/s5_logo3.png");
            do
            {
                byteLeido = FicheroLectura.read();
                if (byteLeido==-1)
                {
                    fin_fichero=true;
                }
                else
                {
                byteLeido = byteLeido + 10;
                //escribo en el nuevo
                Fichero_copia.write(byteLeido);    
                //System.out.println("copiando byte.... " + byteLeido);
                cont++;
                }
            }while(!fin_fichero);
            FicheroLectura.close();
            Fichero_copia.close();
            System.out.println("Bytes copiados->" + cont);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (IOException ex) {
            System.out.println("Error lectura");
            try {
                FicheroLectura.close();
                Fichero_copia.close();
            } catch (IOException ex1) {
                System.out.println("Error cerrando");
            }
        }
        System.out.println("Fichero copiado...");
    }
    
}
