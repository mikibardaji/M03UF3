/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasalumnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class NotasAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector_f=null;
         String frase;
         ArrayList<Alumnos> clase = new ArrayList<Alumnos> ();
        try {
            File f = new File("alumnos_notas.txt");
            lector_f = new Scanner(f); 
            int notas_acum = 0, nota_unica, num_notas=0;
            while (lector_f.hasNext()) 
            {
                notas_acum = 0;
                num_notas=0;
            frase = lector_f.nextLine(); 
             //System.out.println(frase);
            String[] texto_separado = frase.split(" ");
                for (int i = 0; i < texto_separado.length; i++) {
                    //try{
                    if(i>1)
                    {
                        nota_unica = Integer.parseInt(texto_separado[i]);
                        notas_acum = notas_acum + nota_unica;
                        num_notas++; 
                    }
                    /*}catch(NumberFormatException ex)
                    {                   System.out.println("no es un numero era " + texto_separado[i]);
                    }*/
                }
                double nota_media = (double) notas_acum/num_notas;          
                String nombreApellido = texto_separado[0] + "-" +texto_separado[1];
                System.out.println(nombreApellido + nota_media);
                Alumnos afegir = new Alumnos(nombreApellido, nota_media);
                clase.add(afegir);
               
            }
            lector_f.close(); //cerrar fic
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe");
        } catch (InputMismatchException ex)
        {
            System.out.println("he leido caracter raro");
            lector_f.close();
        }
        
        
         metodo_burbuja(clase);
         clase.toString();
    }

     private static void metodo_burbuja(ArrayList<Alumnos> clase) {
        //int i,j;
       int ele_ordenados, j;
       Alumnos aux;
       
        for (ele_ordenados = 0; ele_ordenados < clase.size(); ele_ordenados++) {
            for(j=0;j<(clase.size()-ele_ordenados-1);j++)
            {//resto ele_ordenados, porque cuando
                //los finales ya estan ordenados 
                //no quiero que llegue a esas posiciones, se podria hacer sin la resta también
             System.out.println("comparo posicion" + j + "con la " + (j+1));
                if(clase.get(j).nota_media>clase.get(j+1).nota_media)
                {//intercambio valores
                   aux = new Alumnos(clase.get(j).nombre_apellido, clase.get(j).nota_media);
                   clase.get(j).nombre_apellido = clase.get(j+1).nombre_apellido; 
                   clase.get(j).nota_media = clase.get(j+1).nota_media;         
                    clase.get(j+1).nombre_apellido = aux.nombre_apellido; 
                   clase.get(j+1).nota_media = aux.nota_media;  
                    System.out.println("cambio posicion");
                    
                }
                
            }
            System.out.println("Elementos ordenados al terminar el for interno" + ele_ordenados);
            
        }
    
}
}
