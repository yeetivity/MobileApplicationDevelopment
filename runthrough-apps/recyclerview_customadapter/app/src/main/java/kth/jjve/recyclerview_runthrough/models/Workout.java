package kth.jjve.recyclerview_runthrough.models;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- recyclerviews
- creating adapters

Last code review:
28-10-22
 */

public class Workout {
    //Model for a single workout
    public String title, type;

    public Workout(String title, String type){
        this.title = title;
        this.type = type;
    }
}
