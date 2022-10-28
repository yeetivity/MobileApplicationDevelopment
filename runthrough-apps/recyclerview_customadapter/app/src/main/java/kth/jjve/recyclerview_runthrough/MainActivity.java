package kth.jjve.recyclerview_runthrough;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- recyclerviews
- creating adapters

Last code review:
28-10-22
 */


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import kth.jjve.recyclerview_runthrough.models.WorkoutList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook the recyclerview to its viewID
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Set the layout to a linear layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Create a new model object
        WorkoutList workoutList = new WorkoutList();

        //Create new customadapter and feed it the workoutlist [arraylist]
        CustomAdapter customAdapter = new CustomAdapter(workoutList.getWorkoutList());
        recyclerView.setAdapter(customAdapter);
    }
}