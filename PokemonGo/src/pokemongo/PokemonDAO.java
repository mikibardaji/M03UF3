/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class PokemonDAO implements OperacionsBasiques{

    @Override
    public void CazarPokemon(ArrayList<Pokemon> mochila) {
        Pokemon cazar = new Pokemon();
        cazar.visualizarPokemon();
        
        
        boolean cazado = cazar(cazar);
        
        if(cazado)
        {
            mochila.add(cazar);
            System.out.println("pokemon cazado");
        }
        else
        {
            System.out.println("se ha escapado");
        }
        
    }

    @Override
    public void ListarPokemon(ArrayList<Pokemon> mochila) {
        Collections.sort(mochila);
        for (int i = 0; i < mochila.size(); i++) {
            System.out.println(mochila.get(i).toString());
        }
        System.out.println("Pokemons en tu mochila" + mochila.size());
       
    }

    @Override
    public void TransferirPokemon(ArrayList<Pokemon> mochila) {
        System.out.println("tranferi..");
    }

    @Override
    public void RecibirPokemon(ArrayList<Pokemon> mochila) {
        System.out.println("recibineid..");
    }

    private boolean cazar(Pokemon cazar) {
        Scanner sc = new Scanner(System.in);
       
        int numero_pokemon = (int)(Math.random()*(cazar.getCP()/10))+1;
        //System.out.println("aleatorio es " + numero_pokemon);
        System.out.println("Pon el numero para cazar pokemon");
        int num_user = sc.nextInt();
        
        return num_user ==numero_pokemon;
    }
    
}
