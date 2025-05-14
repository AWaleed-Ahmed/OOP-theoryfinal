package backend.models;

public class calculation extends habit{
   private double bmi;
   double weigth;
   double heigth;

    public void bmical(double weight,double heigth){
        this.weigth=weight;
        this.heigth=heigth;
        System.out.println();
        System.out.println("*******************************************************************");
        System.out.println();

    }
    public double index(){
        bmi=(weigth*10000.0d)/ Math.pow(heigth,2.0d);
        return bmi;
    }

    public void display2(){
        System.out.println("your BMI is : "+ bmi);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Do you want tips acc to your bmi  ");
        System.out.println("Enter yes or no ");
        String input=sc.next();
        System.out.println("***********************************************************************");
        if(input.equalsIgnoreCase("yes")){
            if(bmi<18.5){
                System.out.println();
                System.out.println("YOU ARE UNDERWEIGTH");
                System.out.println();
                System.out.println("⛳Tips:\n" +
                        "\n" +
                        "⛳Eat more calories than you burn — aim for a calorie surplus\n" +
                        "\n" +
                        "⛳Focus on nutrient-dense foods: nuts, whole grains, avocados, lean meats\n" +
                        "\n" +
                        "⛳Do strength training to build healthy muscle mass\n" +
                        "\n" +
                        "⛳Eat frequently (every 2-3 hours)\n" +
                        "\n" +
                        "⛳Track your progress weekly — don’t just rely on weight");
            } else if (bmi>18.5&&bmi<24.9) {
                System.out.println();
                System.out.println("YOU ARE NORMAL");
                System.out.println();
                System.out.println("Tips:\n" +
                        "\n" +
                        "⛳Maintain your weight with a balanced diet (carbs, proteins, fats)\n" +
                        "\n" +
                        "⛳Combine cardio (3x a week) with strength workouts\n" +
                        "\n" +
                        "\n" +
                        "⛳Drink enough water (2-3 liters/day)\n" +
                        "\n" +
                        "⛳Focus on flexibility & mobility: try yoga or stretching");
                
            } else if (bmi>24.9&&bmi<30) {
                System.out.println();
                System.out.println("YOU ARE OVERWEIGTH");
                System.out.println();
                System.out.println(" Tips:\n" +
                        "\n" +
                        "⛳Aim for a calorie deficit: eat fewer calories than you burn\n" +
                        "\n" +
                        "⛳Cut down on sugary and processed foods\n" +
                        "\n" +
                        "⛳Start with light to moderate cardio: walking, cycling, swimming\n" +
                        "\n" +
                        "⛳Add high-protein meals to feel full longer\n" +
                        "\n" +
                        "⛳Avoid crash diets — go for slow, steady weight loss");
            } else if (bmi>30) {
                System.out.println();
                System.out.println("YOU ARE normal");
                System.out.println();
                System.out.println("Tips:\n" +
                        "\n" +
                        "⛳Consult a doctor or nutritionist before starting\n" +
                        "\n" +
                        "⛳Begin with low-impact activities: walking, aqua aerobics\n" +
                        "\n" +
                        "⛳Track meals and portions with a food diary or app\n" +
                        "\n" +
                        "⛳Avoid sugary drinks — go for water or herbal tea\n" +
                        "\n" +
                        "⛳Stay consistent. Even small changes lead to big results over time");
            }
        }else if(input.equalsIgnoreCase("no")){
            System.out.println("why do you not want any progress for u");
            System.out.println("you should keep an eye that what going in your body");

        }

    }

}
