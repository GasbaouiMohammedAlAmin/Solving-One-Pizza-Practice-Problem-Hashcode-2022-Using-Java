/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashcode2022.one_pizza.onepizzahashcode2022.service;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import java.util.Map;
import java.util.List;

/**
 *
 * @author amine gasa
 */
public class LocalScoreBoardSimulator {
    List<Customer> customers;
    Map<String,Integer> ingredient;

    public LocalScoreBoardSimulator(List<Customer> customers, Map ingredient) {
        this.customers = customers;
        this.ingredient = ingredient;
    }
    public int getScore(){
        int customerCount=0;
        boolean likedStatus;
        boolean dislikedStatus;
        
        for (Customer customer :customers) {
        likedStatus=true;
        dislikedStatus=true;
            for(String likedIngredient :customer.getLikedIngredients()){
                if(!ingredient.containsKey(likedIngredient)){
                    likedStatus=false;
                    break;
                }
            }
            for(String dislikedIngredient :customer.getDislikedIngredients()){
                if(ingredient.containsKey(dislikedIngredient)){
                    dislikedStatus=false;
                    break;
                }
            }
            if(likedStatus && dislikedStatus)
            customerCount++;
        }
        
    return customerCount;}
}
