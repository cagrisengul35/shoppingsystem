
package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class test
{

    public test()
    {
    }

    public static void main(String args[])
    {
        product coke = new product("Coke", 2, 7D, false, 3D);
        product whiskey = new product("Whiskey", 2, 35D, true, 0.0D);
        product keyboard = new product("Logitech", 1, 100D, true, 15D);
        product keyboard2 = new product("HyperX", 1, 150D, true, 10D);
        product egg = new product("Bilibili", 0, 14D, false, 5D);
        product egg2 = new product("GezenTavuk", 0, 20D, false, 7.5D);
        
        productsOfCompany = (ArrayList)Stream.of(new product[] {
            coke, whiskey, keyboard, keyboard2, egg, egg2
        }).collect(Collectors.toList());
        
        customer customer1 = new regular_customer("Ahmet_Kaya");
        customer customer2 = new gold_customer("Thomas_Shelby");
        
        transaction transaction0001 = new transaction(new ArrayList(Arrays.asList(new pair[] {
            new pair(egg2, 8), new pair(coke, 6)
        })), customer1, 0.0D);
        transaction transaction0002 = new transaction(new ArrayList(Arrays.asList(new pair[] {
            new pair(egg, 20)
        })), customer1, 20D);
        transaction transaction0003 = new transaction(new ArrayList(Arrays.asList(new pair[] {
            new pair(whiskey, 50)
        })), customer2, 75D);
        transaction transaction0004 = new transaction(new ArrayList(Arrays.asList(new pair[] {
            new pair(keyboard2, 5), new pair(keyboard, 5), new pair(whiskey, 10)
        })), customer2, 0.0D);
        

    }

    public static ArrayList productsOfCompany = null;

}
