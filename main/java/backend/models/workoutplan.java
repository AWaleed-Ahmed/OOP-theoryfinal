//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.util.Scanner;

public class workoutplan {
    private int pushups;
    private int pullups;
    private int squats;
    private int chinups;
    private int situps;
    private int lunges;
    private int running;
    int totalExercises = 0;
    int totalReps = 0;
    private Scanner sc;

    public workoutplan() {
        this.sc = new Scanner(System.in);
    }

    public int getPushups() {
        return this.pushups;
    }

    public void setPushups(int pushups) {
        if (pushups < 0) {
            System.out.println("Invalid number");
        } else {
            this.pushups = pushups;
        }

    }

    public int getPullups() {
        return this.pullups;
    }

    public void setPullups(int pullups) {
        if (pullups < 0) {
            System.out.println("Invalid number");
        } else {
            this.pullups = pullups;
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

    public int getChinups() {
        return this.chinups;
    }

    public void setChinups(int chinups) {
        if (chinups < 0) {
            System.out.println("Invalid number");
        } else {
            this.chinups = chinups;
        }

    }

    public int getSitups() {
        return this.situps;
    }

    public void setSitups(int situps) {
        if (situps < 0) {
            System.out.println("Invalid number");
        } else {
            this.situps = situps;
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

    public int getRunning() {
        return this.running;
    }

    public void setRunning(int running) {
        if (running < 0) {
            System.out.println("Invalid number");
        } else {
            this.running = running;
        }

    }

    public void inputWorkout() {
        System.out.println("\n******** ENTER YOUR WORKOUT ROUTINE ********");
        System.out.print("Number of pushups you can do: ");
        this.setPushups(this.sc.nextInt());
        System.out.print("Number of pullups you can do: ");
        this.setPullups(this.sc.nextInt());
        System.out.print("Number of squats you can do: ");
        this.setSquats(this.sc.nextInt());
        System.out.print("Number of chinups you can do: ");
        this.setChinups(this.sc.nextInt());
        System.out.print("Number of situps you can do: ");
        this.setSitups(this.sc.nextInt());
        System.out.print("Number of lunges you can do: ");
        this.setLunges(this.sc.nextInt());
        System.out.print("Number of km you can run: ");
        this.setRunning(this.sc.nextInt());
    }

    public void analyzeWorkout() {
        if (this.pushups > 0) {
            ++this.totalExercises;
            this.totalReps += this.pushups;
        }

        if (this.pullups > 0) {
            ++this.totalExercises;
            this.totalReps += this.pullups;
        }

        if (this.squats > 0) {
            ++this.totalExercises;
            this.totalReps += this.squats;
        }

        if (this.chinups > 0) {
            ++this.totalExercises;
            this.totalReps += this.chinups;
        }

        if (this.situps > 0) {
            ++this.totalExercises;
            this.totalReps += this.situps;
        }

        if (this.lunges > 0) {
            ++this.totalExercises;
            this.totalReps += this.lunges;
        }

        if (this.running > 0) {
            ++this.totalExercises;
            this.totalReps += this.running;
        }

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
