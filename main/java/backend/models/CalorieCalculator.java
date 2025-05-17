//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.util.HashMap;
import java.util.Scanner;

public class calorietracker {
    private HashMap<String, Double> foodcalorie = new HashMap();
    private double totalcalories = (double)0.0F;

    public void settingcalorie() {
        this.foodcalorie.put("rice", 1.3);
        this.foodcalorie.put("chicken", 2.4);
        this.foodcalorie.put("beef", (double)2.5F);
        this.foodcalorie.put("wheatgrain ", 3.4);
        this.foodcalorie.put("milk", 0.6);
        this.foodcalorie.put("chickpeas", 1.6);
        this.foodcalorie.put("kidneybeans", 1.3);
        this.foodcalorie.put("banana", 1.1);
        this.foodcalorie.put("egg", 1.1);
        this.foodcalorie.put("mutton", 1.1);
        this.foodcalorie.put("oats", 1.1);
        this.foodcalorie.put("peanutbutter", 1.1);
    }

    public void takeinput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of food items u have taken today");
        int items = sc.nextInt();
        float incal = 0.0F;

        for(int i = 0; i < items; ++i) {
            System.out.println("Enter item : ");
            String item2 = sc.next().toLowerCase();
            if (!this.foodcalorie.containsKey(item2)) {
                System.out.println("kindly enter its calorie: ");
                incal = sc.nextFloat();
            } else {
                System.out.println("enter grams of " + item2 + "u have taken today");
                int gram = sc.nextInt();
                double calorie = (double)gram * (Double)this.foodcalorie.get(item2) + (double)incal;
                this.totalcalories += calorie;
            }
        }

    }

    public double getTotalcalories() {
        return this.totalcalories;
    }
}
