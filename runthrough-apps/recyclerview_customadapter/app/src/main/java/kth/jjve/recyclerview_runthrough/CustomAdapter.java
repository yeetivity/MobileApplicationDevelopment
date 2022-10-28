package kth.jjve.recyclerview_runthrough;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- recyclerviews
- creating adapters

Last code review:
28-10-22
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kth.jjve.recyclerview_runthrough.models.Workout;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Viewholder> {
    private ArrayList<Workout> workoutList;

    //Constructor
    public CustomAdapter(ArrayList<Workout> workoutList){this.workoutList = workoutList;}


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_card, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.cardTitleView.setText(workoutList.get(position).title);
        holder.cardSubtitleView.setText(workoutList.get(position).type);

    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView cardTitleView, cardSubtitleView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            cardTitleView = itemView.findViewById(R.id.workout_title);
            cardSubtitleView = itemView.findViewById(R.id.workout_subtitle);
        }
    }
}
