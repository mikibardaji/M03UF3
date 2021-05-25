/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongo;

import java.util.ArrayList;

/**
 *
 * @author mati
 */
public interface OperacionsBasiques {
 
    public void CazarPokemon(ArrayList<Pokemon> mochila);
    public void ListarPokemon(ArrayList<Pokemon> mochila);
    public void TransferirPokemon(ArrayList<Pokemon> mochila);
    public void RecibirPokemon(ArrayList<Pokemon> mochila);
}
