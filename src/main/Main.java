package dz.hashcode2022.one_pizza.onepizzahashcode2022;

import dz.hashcode2022.one_pizza.onepizzahashcode2022.service.Helper;
import dz.hashcode2022.one_pizza.onepizzahashcode2022.service.LocalScoreBoardSimulator;
import dz.hashcode2022.one_pizza.onepizzahashcode2022.model.Customer;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amine gasa
 */
public class Main {

    public static void main(String args[]) throws IOException {
        Helper helper = new Helper();
        String firstGroup[] = {"a_an_example.in.txt", "b_basic.in.txt"
        };
         
        for (String input : firstGroup) {
           List<Customer> customers= helper.getInputFromFile(input);
           Map<String,Integer>allIngredient=helper.getAllIngredient();
           Map<String,Integer> choosedIngredient=helper.algorithm_1(customers,allIngredient);
           List<String>choosedIngredientList=helper.toArrayList(choosedIngredient);
           helper.writeIntoFile(choosedIngredientList, input);
           LocalScoreBoardSimulator localScoreBoardSimulator=
                   new LocalScoreBoardSimulator(customers,choosedIngredient);
            System.out.println("Score : "+localScoreBoardSimulator.getScore());
        }
        String secondGroup[] = {"c_coarse.in.txt","d_difficult.in.txt","e_elaborate.in.txt"

        };
        for (String input : secondGroup) {//3 1441 1658
           List<Customer> customers= helper.getInputFromFile(input);
           Map<String,Integer> choosedIngredient= helper.algorithm_2(customers);
           List<String>choosedIngredientList=helper.toArrayList(choosedIngredient);
           helper.writeIntoFile(choosedIngredientList, input);
           LocalScoreBoardSimulator localScoreBoardSimulator=
                   new LocalScoreBoardSimulator(customers,choosedIngredient);
            System.out.println("Score: "+localScoreBoardSimulator.getScore());

    }
}
}
