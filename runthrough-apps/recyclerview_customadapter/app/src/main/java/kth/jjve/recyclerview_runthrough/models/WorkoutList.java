package kth.jjve.recyclerview_runthrough.models;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- recyclerviews
- creating adapters

Last code review:
28-10-22
 */

import java.util.ArrayList;

public class WorkoutList {
    private ArrayList<Workout> workoutList;

    public ArrayList<Workout> getWorkoutList(){
        workoutList = new ArrayList<>();
        setWorkoutList();
        return workoutList;
    }

    private void setWorkoutList() {
        //Hardcoded way of getting your data
        workoutList.add(new Workout("Fran", "for-time"));
        workoutList.add(new Workout("Cindy", "amrap"));
        workoutList.add(new Workout("Karen", "for-time"));
        workoutList.add(new Workout("BackSquat 1RM", "for-weight"));
        workoutList.add(new Workout("Tabata This", "tabata"));
        workoutList.add(new Workout("Murph", "for-time"));
        workoutList.add(new Workout("Interval Cardio", "for-rounds"));
        workoutList.add(new Workout("Michael", "for-time"));
        workoutList.add(new Workout("Clean and Jerk 1RM", "for-weight"));
    }
}
