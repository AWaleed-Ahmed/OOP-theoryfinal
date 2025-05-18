//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.util.Scanner;

public class WorkoutPlan {
    private int pushUps;
    private int pullUps;
    private int squats;
    private int lunges;
    private int burpees;
    private int sitUps;

//    private int running;
    int totalExercises = 0;
    int totalReps = 0;
    private Scanner sc;

    public WorkoutPlan() {
        this.sc = new Scanner(System.in);
    }

    public int getPushUps() {
        return this.pushUps;
    }

    public void setPushUps(int pushUps) {
        if (pushUps < 0) {
            System.out.println("Invalid number");
        } else {
            this.pushUps = pushUps;
        }

    }

    public int getPullUps() {
        return this.pullUps;
    }

    public void setPulls(int pullUps) {
        if (pullUps < 0) {
            System.out.println("Invalid number");
        } else {
            this.pullUps = pullUps;
        }

    }

    public int getSquats() {
        return this.squats;
    }

    public void setSquats(int squats) {
        if (squats < 0) {
            System.out.println("Invalid number");
        } else {
            this.squats = squats;
        }

    }

    public int getBurpees() {
        return this.burpees;
    }

    public void setBurpees(int burpees) {
        if (burpees < 0) {
            System.out.println("Invalid number");
        } else {
            this.burpees = burpees;
        }

    }

    public int getSitUps() {
        return this.sitUps;
    }

    public void setSitUps(int sitUps) {
        if (sitUps < 0) {
            System.out.println("Invalid number");
        } else {
            this.sitUps = sitUps;
        }

    }

    public int getLunges() {
        return this.lunges;
    }

    public void setLunges(int lunges) {
        if (lunges < 0) {
            System.out.println("Invalid number");
        } else {
            this.lunges = lunges;
        }

    }

//    public int getRunning() {
//        return this.running;
//    }
//
//    public void setRunning(int running) {
//        if (running < 0) {
//            System.out.println("Invalid number");
//        } else {
//            this.running = running;
//        }
//
//    }

    public void inputWorkout() {
        System.out.println("\n******** ENTER YOUR WORKOUT ROUTINE ********");
        System.out.print("Number of pushUps you can do: ");
        this.setPushUps(this.sc.nextInt());
        System.out.print("Number of pullups you can do: ");
        this.setPulls(this.sc.nextInt());
        System.out.print("Number of squats you can do: ");
        this.setSquats(this.sc.nextInt());
        System.out.print("Number of chinups you can do: ");
        this.setBurpees(this.sc.nextInt());
        System.out.print("Number of situps you can do: ");
        this.setSitUps(this.sc.nextInt());
        System.out.print("Number of lunges you can do: ");
        this.setLunges(this.sc.nextInt());
//        System.out.print("Number of km you can run: ");
//        this.setRunning(this.sc.nextInt());
    }

    public void analyzeWorkout() {
        if (this.pushUps > 0) {
            ++this.totalExercises;
            this.totalReps += this.pushUps;
        }

        if (this.pullUps > 0) {
            ++this.totalExercises;
            this.totalReps += this.pullUps;
        }

        if (this.squats > 0) {
            ++this.totalExercises;
            this.totalReps += this.squats;
        }

        if (this.burpees > 0) {
            ++this.totalExercises;
            this.totalReps += this.burpees;
        }

        if (this.sitUps > 0) {
            ++this.totalExercises;
            this.totalReps += this.sitUps;
        }

        if (this.lunges > 0) {
            ++this.totalExercises;
            this.totalReps += this.lunges;
        }

//        if (this.running > 0) {
//            ++this.totalExercises;
//            this.totalReps += this.running;
//        }

    }

    public String showRank() {
        System.out.println("\n******** YOUR MUSCLE RANK ********");
        if (this.totalExercises == 0) {
            return "F";
        } else {
            double averageReps = (double)this.totalReps / (double)this.totalExercises;
            System.out.println("\nYour average reps per exercise: " + averageReps);
            if (averageReps >= (double)30.0F) {
                return "A";
            } else {
                return averageReps >= (double)15.0F ? "B" : "C";
            }
        }
    }
}
