package backend.models;
import java.util.Scanner;

public class dietplan extends calculation{
    double bmi;
    public void suggestPlanBasedOnGoalAndBMI( double bmi) {
        this.bmi=bmi;
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want a diet plan? (cut/maintain/bulk)");
        String goal = in.next().toLowerCase();

        System.out.println("\n Based on your goal and BMI (" + bmi + "), here’s your diet suggestion:\n");

         switch (goal) {
             case "cut":

                     System.out.println("➤ Lower your intake by 500 kcal/day.\n➤ Focus on lean protein, veggies, and whole grains.");
                     System.out.println("Breakfast: 4 egg whites, 2 whole eggs, spinach, 1 slice whole grain toast\n" +
                             "\n" +
                             "Lunch: Grilled chicken breast, quinoa, steamed broccoli\n" +
                             "\n" +
                             "Snack: Greek yogurt (0% fat) + berries\n" +
                             "\n" +
                             "Dinner: Salmon, mixed vegetables, small sweet potato\n" +
                             "\n" +
                             "Post-workout (optional): Whey protein shake with water");

                 break;

             case "maintain":
                 System.out.println("➤ Maintain current intake.\n➤ Eat balanced meals (carbs, protein, fat) and stay active.");
                 System.out.println("Breakfast: Oats + banana + whey + peanut butter\n" +
                         "\n" +
                         "Lunch: Turkey breast wrap + side salad\n" +
                         "\n" +
                         "Snack: Mixed nuts + protein bar\n" +
                         "\n" +
                         "Dinner: Beef stir-fry with brown rice\n" +
                         "\n" +
                         "Dessert: Cottage cheese with honey");
                 break;

             case "bulk":

                    System.out.println("➤ Increase intake by 300–500 kcal/day.\n➤ Prioritize protein, complex carbs, and strength training.");
                    System.out.println("Breakfast: 4 eggs + oats + banana\n" +
                            "\n" +
                            "Lunch: Grilled chicken burrito with avocado\n" +
                            "\n" +
                            "Snack: Mass gainer or whey + peanut butter + banana\n" +
                            "\n" +
                            "Dinner: Pasta with lean beef sauce, side veggies\n" +
                            "\n" +
                            "Post-workout: Whey + banana + rice cakes");


             default:
                System.out.println(" Invalid goal. Please enter cut, maintain, or bulk.");
                in.close();
                System.exit(0);

         }
    }
}

