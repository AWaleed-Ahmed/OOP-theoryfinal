package backend.models;

import java.util.HashMap;
import java.util.Scanner;

public class calorietracker {
private HashMap<String,Double>foodcalorie=new HashMap<>();
private double totalcalories=0;

    public void settingcalorie()
    {
        foodcalorie.put("rice",1.3);
        foodcalorie.put("chicken",2.4);
        foodcalorie.put("beef",2.5);
        foodcalorie.put("wheatgrain ",3.4);
        foodcalorie.put("milk",0.6);
        foodcalorie.put("chickpeas",1.6);
        foodcalorie.put("kidneybeans",1.3);
        foodcalorie.put("banana",1.1);
        foodcalorie.put("egg",1.1);
        foodcalorie.put("mutton",1.1);
        foodcalorie.put("oats",1.1);
        foodcalorie.put("dates",1.1);
        foodcalorie.put("peanutbutter",1.1);


    }
    public void takeinput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of food items u have taken today");
        int items=sc.nextInt();
        float incal=0;
        for(int i=0;i<items;i++){
            System.out.println("Enter item : ");
            String item2=sc.next().toLowerCase();

            if(!foodcalorie.containsKey(item2)){
                System.out.println("kindly enter its calorie: ");
                incal=sc.nextFloat();
            }else{
                System.out.println("enter grams of "+item2+"u have taken today");
                int gram=sc.nextInt();
                double calorie=(gram* foodcalorie.get(item2))+incal;
                totalcalories+=calorie;
            }
        }
    }
    public double getTotalcalories(){
        return totalcalories;
    }
}
