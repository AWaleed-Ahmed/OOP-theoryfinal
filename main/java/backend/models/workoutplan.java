package backend.models;
import backend.models.ranker;
import java.util.Scanner;

public class workoutplan {
    private int running;
    private int pushups;
    private int pullups;
    private int squats;
    private int chinups;
    private int situps;
    private int lunges;

    Scanner sc = new Scanner(System.in);

    public void inputWorkout() {
        System.out.println("\n******** ENTER YOUR WORKOUT ROUTINE ********");

        System.out.print("Number of pushups you can do: ");
        pushups = sc.nextInt();

        System.out.print("Number of pullups you can do: ");
        pullups = sc.nextInt();

        System.out.print("Number of squats you can do: ");
        squats = sc.nextInt();

        System.out.print("Number of chinups you can do: ");
        chinups = sc.nextInt();

        System.out.print("Number of situps you can do: ");
        situps = sc.nextInt();

        System.out.print("Number of lunges you can do: ");
        lunges = sc.nextInt();

        System.out.print("Number of km you can run: ");
        running =sc.nextInt();
    }

    public void analyzeWorkout() {
        int totalExercises = 0;
        int totalReps = 0;

        if (pushups > 0) {
            totalExercises++;
            totalReps += pushups;
        }
        if (pullups > 0) {
            totalExercises++;
            totalReps += pullups;
        }
        if (squats > 0) {
            totalExercises++;
            totalReps += squats;
        }
        if (chinups > 0) {
            totalExercises++;
            totalReps += chinups;
        }
        if (situps > 0) {
            totalExercises++;
            totalReps += situps;
        }
        if (lunges > 0) {
            totalExercises++;
            totalReps += lunges;
        }
        if (running > 0) {
            totalExercises++;
            totalReps += running;
        }

        if (totalExercises == 0) {
            System.out.println("\nYou have not entered any exercises! 😔");
        } else {
            double averageReps = (double) totalReps / totalExercises;
            System.out.println("\nYour average reps per exercise: " + averageReps);

            if (averageReps >= 30) {
                System.out.println("🏆 You are a PRO-level athlete!");
            } else if (averageReps >= 15) {
                System.out.println("🔥 You are at AMATEUR-level. Great job!");
            } else {
                System.out.println("💪 You are at BEGINNER-level. Keep working!");
            }
        }
    }
            public void showRank(){
                ranker r = new ranker();
                System.out.println("\n******** YOUR MUSCLE RANKINGS ********");

                if (pushups > 0) {
                    System.out.println("Pushups Rank: " + r.getRank(pushups));
                }
                 if (pullups > 0) {
                 System.out.println("Pullups Rank: " + r.getRank(pullups));
                 }
                 if (squats > 0) {
                 System.out.println("Squats Rank: " + r.getRank(squats));
                 }
                 if (chinups > 0) {
                 System.out.println("Chinups Rank: " + r.getRank(chinups));
                 }
                 if (situps > 0) {
                     System.out.println("Situps Rank: " + r.getRank(situps));
                 }

                 if (lunges > 0) {
                System.out.println("Lunges Rank: " + r.getRank(lunges));
                 }
                if (running > 0 ){
                    System.out.println("running Rank: " + r.getRank(running));
                }
            }
}



