// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 5/15/2022 6:50:19 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   transaction.java

package hw2;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package hw2:
//            customer, test, pair, product

public class transaction
{

    Scanner input;
    double totalRevanue;
    double totalDiscountMade;
    ArrayList itemAmountPairs;
    private customer Customer;
    private double extraDiscountCode;
	
    public transaction(ArrayList itemAmountPairs, customer customer, double transacionDiscount)
    {
        input = new Scanner(System.in);
        this.itemAmountPairs = new ArrayList();
        this.itemAmountPairs = itemAmountPairs;
        Customer = customer;
        extraDiscountCode = transacionDiscount;
        InitializePurchase();
    }

    public void InitializePurchase()
    {
        DisplayTransaction();
        double usedPoints = 0.0D;
        System.out.println("Input 1 to complete transaction, 2 to add item, 3 to cancel item");
        for(int state = input.nextInt(); state != 1;)
        {
            if(state == 2)
            {
                AddItem(SelectItem());
                DisplayTransaction();
                System.out.println("Input 1 to complete transaction, 2 to add item, 3 to cancel item");
                state = input.nextInt();
            }
            if(state == 3)
            {
                CancelItem(SelectItem());
                DisplayTransaction();
                System.out.println("Input 1 to complete transaction, 2 to add item, 3 to cancel item");
                state = input.nextInt();
            }
        }

        double totalPayement = Customer.TransactionPromotion(this);
        totalRevanue += totalPayement;
        
        if(extraDiscountCode > 0.0D)
            System.out.println((new StringBuilder("Discount Code = ")).append(extraDiscountCode).toString());
        System.out.printf("Total Payement is %.2f \n \n", new Object[] {
            Double.valueOf(totalPayement)
        });
        if(Customer.getPointsAccumulated() > 0.0D && totalPayement != 0.0D)
        {
            System.out.printf("Customer %s has %.2f points for transaction: \n", new Object[] {
                Customer.getCustomerName(), Double.valueOf(Customer.getPointsAccumulated())
            });
            System.out.println("How many points should be used ?");
            usedPoints = input.nextDouble();
            Customer.setPointsAccumulated(Customer.getPointsAccumulated() - usedPoints);
            System.out.printf("Total Payement is %.2f \n \n", new Object[] {
                Double.valueOf(totalPayement - usedPoints)
            });
        }
        Customer.AccumulatePoint(this);
    }

    public pair SelectItem()
    {
        test test = new test();
        System.out.println("Select Item \n");
        int item = askQuestion(test.productsOfCompany);
        System.out.println("Select Amount \n");
        int amount = input.nextInt();
        return new pair((product)test.productsOfCompany.get(item - 1), amount);
    }

    public void DisplayTransaction()
    {
        System.out.printf("Customer %s's cart:\n", new Object[] {
            Customer.getCustomerName()
        });
        pair pair;
        for(Iterator iterator = itemAmountPairs.iterator(); iterator.hasNext(); System.out.printf("%d x %s \n", new Object[] {
    Integer.valueOf(pair.getPairAmount()), pair.getPairProduct().getProductName()
}))
            pair = (pair)iterator.next();

        System.out.println();
    }

    public void AddItem(pair pair)
    {
        for(Iterator iterator = itemAmountPairs.iterator(); iterator.hasNext();)
        {
            pair existingpair = (pair)iterator.next();
            if(existingpair.getPairProduct() == pair.getPairProduct())
            {
                existingpair.setPairAmount(existingpair.getPairAmount() + pair.getPairAmount());
                return;
            }
        }

        itemAmountPairs.add(pair);
    }

    public void CancelItem(pair pair)
    {
        pair p = null;
        for(Iterator iterator = itemAmountPairs.iterator(); iterator.hasNext();)
        {
            pair existingpair = (pair)iterator.next();
            if(existingpair.getPairProduct() == pair.getPairProduct())
            {
                existingpair.setPairAmount(existingpair.getPairAmount() - pair.getPairAmount());
                if(existingpair.getPairAmount() < 0)
                    existingpair.setPairAmount(0);
                p = existingpair;
                break;
            }
        }

        if(p.getPairAmount() <= 0)
            itemAmountPairs.remove(p);
    }

    public static int askQuestion(ArrayList list)
    {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < list.size(); i++)
        {
            String string = ((product)list.get(i)).getProductName();
            System.out.println((new StringBuilder(" Enter ")).append(i + 1).append(" for ").append(string).toString());
        }

        int returnVal = 0;
        for(int i = 0; i == 0;)
            try
            {
                for(returnVal = input.nextInt(); returnVal < 1 || returnVal > list.size(); returnVal = input.nextInt())
                    System.out.println("Enter a valid number please");

                i = 1;
            }
            catch(Exception e)
            {
                System.out.println("Enter a valid number please");
                input.next();
            }

        return returnVal;
    }


}
