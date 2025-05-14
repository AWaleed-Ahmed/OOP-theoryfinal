package backend.models;

public class ranker {
    public String getRank(int reps) {
         if (reps >= 50) {
         return "S";
        } else if (reps >= 40) {
         return "A";
         } else if (reps >= 30) {
        return "B";
        } else if (reps >= 20) {
            return "C";
        } else if (reps >= 10) {
            return "D";
        } else if (reps >= 5) {
             return "E";
        } else {
             return "F";
        }
    }
}

