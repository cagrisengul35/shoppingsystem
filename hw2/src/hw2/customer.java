// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 5/15/2022 6:51:09 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   customer.java

package hw2;


// Referenced classes of package hw2:
//            transaction

abstract class customer
{


    private String customerName;
    private double pointsAccumulated;
    private static double totalRevanueMade;
    private static double totalPromotionMade;
    
    public customer(String customerName)
    {
        pointsAccumulated = 0.0D;
        this.customerName = customerName;
    }

    public abstract void AccumulatePoint(transaction transaction);

    public abstract double TransactionPromotion(transaction transaction);

    public double getPointsAccumulated()
    {
        return pointsAccumulated;
    }

    public void setPointsAccumulated(double pointsAccumulated)
    {
        this.pointsAccumulated = pointsAccumulated;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public static double getTotalRevanueMade()
    {
        return totalRevanueMade;
    }

    public static void setTotalRevanueMade(double totalRevanueMade)
    {
        customer.totalRevanueMade = totalRevanueMade;
    }

    public static double getTotalPromotionMade()
    {
        return totalPromotionMade;
    }

    public static void setTotalPromotionMade(double totalPromotionMade)
    {
        customer.totalPromotionMade = totalPromotionMade;
    }

}
