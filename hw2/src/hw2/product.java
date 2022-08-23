// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 5/15/2022 6:48:35 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   product.java

package hw2;


public class product
{

    public product(String productName, int productType, double productPrice, boolean productLuxuryTaxGroup, double productPromotion)
    {
        luxuryTax = 1.05D;
        regularTax = 1.01D;
        setProductName(productName);
        this.productType = productType;
        this.productPrice = productPrice;
        this.productLuxuryTaxGroup = productLuxuryTaxGroup;
        this.productPromotion = productPromotion;
        productFinalPrice = (productPrice * (productLuxuryTaxGroup ? luxuryTax : regularTax) * (100D - productPromotion)) / 100D;
        customer.setTotalPromotionMade(customer.getTotalPromotionMade() + (productPrice * (productLuxuryTaxGroup ? luxuryTax : regularTax) - productFinalPrice));
    }

    public double getProductFinalPrice()
    {
        return productFinalPrice;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    private double luxuryTax;
    private double regularTax;
    private String productName;
    private int productType;
    private double productPrice;
    private boolean productLuxuryTaxGroup;
    private double productPromotion;
    private double productFinalPrice;
}
