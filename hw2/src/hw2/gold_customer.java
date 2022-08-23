
package hw2;

import java.util.Iterator;

public class gold_customer extends customer
{

    public gold_customer(String customerName)
    {
        super(customerName);
        accumulatePointsPercentage = 0.05;
        transactionPromotionPercentage = 0.1;
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

        return transactionFinalPrice * (1.0D - transactionPromotionPercentage);
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

    private double accumulatePointsPercentage;
    private double transactionPromotionPercentage;
}
