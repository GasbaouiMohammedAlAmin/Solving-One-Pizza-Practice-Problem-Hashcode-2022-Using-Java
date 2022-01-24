/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashcode2022.one_pizza.onepizzahashcode2022.service;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import dz.hashcode2022.one_pizza.onepizzahashcode2022.service.CustomerComparator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amine gasa
 */
public class Helper {
private Map<String,Integer> allIngredient;

    

    public List<Customer> getInputFromFile(String fileName) throws FileNotFoundException, IOException {
        allIngredient=new HashMap<>();
        List<Customer> customers = new ArrayList<Customer>();
               
        try {
            BufferedReader fr = new BufferedReader(new FileReader("input\\" + fileName ));
            String line;
            int nbrCustomer;
            nbrCustomer = Integer.parseInt(fr.readLine());// this info does not important because i used dynamic table

            while ((line = fr.readLine()) != null) {

                String likedIngredientInput[] = line.split(" ");
                List<String> likedIngredientCustomer = new ArrayList();

                for (int i = 1; i < likedIngredientInput.length; i++) {
                    //i started from 1 to avoid reading the lenght ingredient (dynamic table) 
                    likedIngredientCustomer.add(likedIngredientInput[i]);
                    allIngredient.put(likedIngredientInput[i], 0);
                }
                line =fr.readLine();
                String dislikedIngredientInput[] = line.split(" ");
                List<String> dislikedIngredientCustomer = new ArrayList();

                for (int i = 1; i < dislikedIngredientInput.length; i++) {
                    //i started from 1 to avoid reading the lenght ingredient (dynamic table) 
                    dislikedIngredientCustomer.add(dislikedIngredientInput[i]);
                    allIngredient.put(dislikedIngredientInput[i], 0);
                }
                Customer customer = new Customer(likedIngredientCustomer, dislikedIngredientCustomer);
                customers.add(customer);

            }
            fr.close();
            
        } catch (IOException ex) {
            System.out.println("ex "+ex.getMessage());

        }
        return customers;
    }
    public Map<String, Integer> getAllIngredient() {
        return allIngredient;
    }
   public Map<String,Integer> algorithm_1( List<Customer> customers ,Map<String,Integer>allIngredient){
        for(Customer customer:customers){
            for (String dislikedIngredient : customer.getDislikedIngredients()) {
                if(allIngredient.containsKey(dislikedIngredient))
                    allIngredient.remove(dislikedIngredient);
            }
        }
        return allIngredient;
        
    }
     public List<String>toArrayList(Map<String,Integer>allIngredient){
        List<String>choosedIngredient=new ArrayList();
        for (String key : allIngredient.keySet()) {
       choosedIngredient.add(key);
               
    }
    return choosedIngredient;}
    
   public Map<String,Integer>algorithm_2(List<Customer> customers ){
        Collections.sort(customers, new CustomerComparator());
        Map<String,Integer> choosedIngredient=new HashMap();
        for (Customer customer : customers) {
            boolean isTakenIngredient=true;
            for (String dislikedIngredient : customer.getDislikedIngredients()) {
                if(choosedIngredient.containsKey(dislikedIngredient)){
                    isTakenIngredient=false;
                    break;
                }
            }
            if(isTakenIngredient){
               for (String likedIngredient : customer.getLikedIngredients()) {
                   choosedIngredient.put(likedIngredient, 0);
               }
            }
            
        }
    return choosedIngredient;}
    
     public void writeIntoFile(List<String>choosedIngredient,String fileName) {
        try {
            System.out.println("\n------- output " + fileName);
            PrintWriter outputFile = new PrintWriter("output\\" + fileName + ".out", "UTF-8");
            outputFile.print(choosedIngredient.size()+" ");
            for(String ingredient:choosedIngredient){
                outputFile.print(ingredient+" ");
            }
            
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }
}
