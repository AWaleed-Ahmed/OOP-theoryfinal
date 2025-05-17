//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.util.HashMap;
import java.util.Scanner;

public class CalorieCalculator {
    private HashMap <String, Double> foodCalorie = new HashMap() ;
    private double totalcalories = (double)0.0F ;

    public void settingCalorie() {
        this.foodCalorie.put( "rice", 130.0 );
        this.foodCalorie.put( "chicken", 240.0 );
        this.foodCalorie.put( "beef", 250.0 );
        this.foodCalorie.put( "wheatGrain ", 340.0 );
        this.foodCalorie.put( "milk", 103.0 );
        this.foodCalorie.put( "chickpeas", 160.0 );
        this.foodCalorie.put( "kidneyBeans", 130.0 );
        this.foodCalorie.put( "banana", 110.0) ;
        this.foodCalorie.put( "egg", 90.0 );
        this.foodCalorie.put( "mutton", 11.0 );
        this.foodCalorie.put( "oats", 11.0 );
        this.foodCalorie.put( "peanutButter", 110.0 );
    }

    public void takeInput() {
        Scanner sc = new Scanner ( System.in );
        System.out.println( "Enter number of food items u have taken today" );
        int items = sc.nextInt();
        float incal = 0.0F;

        for(int i = 0; i < items; ++i) {
            System.out.println("Enter item : ");
            String item2 = sc.next().toLowerCase();
            if (!this.foodCalorie.containsKey(item2)) {
                System.out.println("kindly enter its calorie: ");
                incal = sc.nextFloat();
            } else {
                System.out.println("enter grams of " + item2 + "u have taken today");
                int gram = sc.nextInt();
                double calorie = (double)gram * (Double)this.foodCalorie.get(item2) + (double)incal;
                this.totalcalories += calorie;
            }
        }

    }

    public double getTotalCalories() {
        return this.totalcalories;
    }
}
