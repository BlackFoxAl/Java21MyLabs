package com.java21.lesson8;

import java.util.HashMap;

public class ComicBooks2 {
    public ComicBooks2() {

    }
    public static void main(String[] arguments) {
        HashMap quality = new HashMap();
        quality.put("pristine mint",5.00F);
        quality.put("mint",3.00F);
        quality.put("near mint",2.00F);
        quality.put("very fine",1.50F);
        quality.put("fine",1.00F);
        quality.put("good",0.50F);
        quality.put("poor",0.25F);
        quality.put("coverless",0.10F);
        Comic[] comix = new Comic[5];
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine",
                12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition));
        comix[1] = new Comic("Incredible Hulk", "181", "near mint",
                680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        comix[3] = new Comic("Prez", "1", "pristine mint", 30.00F);
        comix[3].setPrice( (Float)quality.get(comix[3].condition) );
        comix[4] = new Comic("Night Nurse", "1", "coverless", 22.00F);
        comix[4].setPrice( (Float)quality.get(comix[4].condition) );
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }

    }
}
class Comic {
    String title;
    String issueNumber;
    String condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssueNumber, String inCondition,
          float inBasePrice) {

        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }
}
