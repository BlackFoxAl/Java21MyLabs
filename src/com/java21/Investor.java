package com.java21;

public class Investor {


    public static void main(String[] arguments){
        float investments = 14000;
        float percentIncreaseFirstYear = 0.4f;
        float percentIncreaseThirdYear = 0.12f;
        int lostSecondYear = 1_500;
        System.out.println("Original investments: $" + investments);
        investments += investments * percentIncreaseFirstYear;
        System.out.println("After first year: $" + investments);
        investments -= lostSecondYear;
        System.out.println("After second year: $" + investments);
        investments += investments * percentIncreaseThirdYear;
        System.out.println("After third year: $" + investments);

        float total = 14000;
        System.out.println("Original investment: $" + total);
        // Inceases by 40 percent the first year
        total = total + (total * .4F);
        System.out.println("After one year: $" + total);
        // Loses $1,500 the second year
        total = total - 1500F;
        System.out.println("After two years: $" + total);
        // Increases by 12 percent the third year
        total = total + (total * .12F);
        System.out.println("After three years: $" + total);


    }
}
