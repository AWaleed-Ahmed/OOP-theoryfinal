package backend.models;
import java.util.Scanner;

public class habit {
  public int age;
  public String gender;
  public double weigth;
  public double heigth;
  int hours;
    Scanner sc=new Scanner(System.in);
    public habit(){

    }

  public void display2(){

      System.out.println();
      System.out.println("KINDLY ENTER YOUR AGE : ");
         age = sc.nextInt();
      if (age < 10) {
          System.out.println("OH BRO u are too small just eat healthy things and play😁");
      }
      System.out.println("KINDLY ENTER YOUR GENDER: ");
         gender = sc.next();
      System.out.println("KINDLY ENTER YOUR WEIGTH IN KGS : ");
         weigth = sc.nextFloat();
      System.out.println("KINDLY ENTER YOUR HEIGTH IN CMS : ");
        heigth = sc.nextFloat();
      System.out.println("KINDLY ENTER YOUR SLEEPING HOURS : ");
        hours = sc.nextInt();
        if(hours<8){
            System.out.println("your sleep is less .please sleep more than 8 hours ");
        }else{
            System.out.println("your sleep is normal");
        }
      System.out.println();
      System.out.println("******************************************************************");
      System.out.println("HOW ACTIVE ARE U DAILY? choose one ");
      System.out.println("1. Sedentary (little or no exercise)\n" +
              "2. Lightly active (light exercise 1-3 days/week)\n" +
              "3. Moderately active (moderate exercise 3-5 days/week)\n" +
              "4. Very active (hard exercise 6-7 days/week)\n" +
              "5. Super active (athlete level training)");
      int var=sc.nextInt();
      switch(var){
          case 1:
              System.out.println("OH !!!👍 we will see ");
              break;
          case 2:
              System.out.println("OH !!!👍 we will see ");
              break;
          case 3:
              System.out.println("OH !!!👍 we will see ");
              break;
          case 4:
              System.out.println("OH !!!👍 we will see ");
              break;
          case 5:
              System.out.println("OH !!!👍 we will see ");
              break;
      }
      System.out.println();
      System.out.println("**************************************************************************");

      System.out.println("DO YOU FOLLOW ANY SPECIFIC DIET PLAN : ");
      System.out.println("enter Y/N");
      String choice=sc.next();
      if(choice.equalsIgnoreCase("y")){
          String s1=sc.nextLine();
      }else{
          System.out.println();
          System.out.println("we will give u then no worries !!");
      }

      System.out.println("************************************************************************");
      System.out.println(" What’s your main fitness goal?\n" +
              "   1. Lose weight\n" +
              "   2. Gain muscle\n" +
              "   3. Maintain weight\n" +
              "   4. Improve endurance\n" +
              "   5. General fitness");
      int var2=sc.nextInt();
      switch(var2){
          case 1:
              System.out.println("Ok we will hope to make u thinner and smarter");
              break;
          case 2:
              System.out.println("by following the path we gave to u we hope you will  gain muscle ");
              break;
          case 3:
              System.out.println(" Its nice to maintain the balanced body weigth ");
              break;
          case 4:
              System.out.println("thats nice to hear ");
              break;
          case 5:
              System.out.println(" you came on the rigth place for your general fitness ");
              break;
      }
      System.out.println();
      System.out.println("***************************************************************************");

      System.out.println();
      System.out.println();

      System.out.println("Thanks BUDDY!,  Based on your responses, we’ll generate a personalized fitness plan for you soon.\n" +
              "\n" +
              "Stay motivated ✌️");
      System.out.println("****************************************************************************");
    }
}

