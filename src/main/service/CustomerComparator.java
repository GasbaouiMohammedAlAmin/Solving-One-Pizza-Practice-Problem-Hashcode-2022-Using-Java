package dz.hashcode2022.one_pizza.onepizzahashcode2022.service;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import java.util.Comparator;

/**
 *
 * @author amine gasa
 */
public class CustomerComparator implements Comparator<Customer>{
    
    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getDislikedIngredients().size()==o2.getDislikedIngredients().size()){
            return o1.getLikedIngredients().size()-o2.getLikedIngredients().size();
        }
       return o1.getDislikedIngredients().size()
               -o2.getDislikedIngredients().size();
    }
    
}
