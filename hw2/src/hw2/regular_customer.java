
package hw2;

import java.util.ArrayList;
import java.util.Iterator;

public class regular_customer extends customer
{
	
    private double accumulatePointsPercentage;
    private double transactionPromotionPercentage;
    private double transactionLimitForDiscount;
    
    public regular_customer(String customerName)
    {
        super(customerName);
        accumulatePointsPercentage = 0.03;
        transactionPromotionPercentage = 0.05;
        transactionLimitForDiscount = 100D;
    }

    public void AccumulatePoint(transaction t)
    {
        pair pair;
        for(Iterator iterator = t.itemAmountPairs.iterator(); iterator.hasNext(); setPointsAccumulated(getPointsAccumulated() + accumulatePointsPercentage * (pair.getPairProduct().getProductFinalPrice() * (double)pair.getPairAmount())))
            pair = (pair)iterator.next();

    }

    public double TransactionPromotion(transaction t)
    {
        double transactionFinalPrice = 0.0D;
        for(Iterator iterator = t.itemAmountPairs.iterator(); iterator.hasNext();)
        {
            pair pair = (pair)iterator.next();
            transactionFinalPrice += pair.getPairProduct().getProductFinalPrice() * (double)pair.getPairAmount();
        }

        if(transactionFinalPrice > transactionLimitForDiscount)
            transactionPromotionPercentage = 0.01;
        double promotedPrice = transactionFinalPrice * (1.0 - transactionPromotionPercentage);
        setTotalPromotionMade((getTotalPromotionMade() + transactionFinalPrice) - promotedPrice);
        setTotalRevanueMade(getTotalRevanueMade() + promotedPrice);
        return promotedPrice;
    }

    public String getCustomerName()
    {
        return super.getCustomerName();
    }

    public void setPointsAccumulated(double d)
    {
        super.setPointsAccumulated(d);
    }

    public void setCustomerName(String s)
    {
        super.setCustomerName(s);
    }

    public double getPointsAccumulated()
    {
        return super.getPointsAccumulated();
    }


}
