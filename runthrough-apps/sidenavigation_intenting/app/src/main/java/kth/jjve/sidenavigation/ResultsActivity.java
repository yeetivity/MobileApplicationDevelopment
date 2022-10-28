package kth.jjve.sidenavigation;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- Sidenavigations with drawerlayout
- Intenting

Last code review:
28-10-22
 */

import android.os.Bundle;
import android.widget.FrameLayout;

public class ResultsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout content = findViewById(R.id.content_container);
        getLayoutInflater().inflate(R.layout.activity_results, content);

        navigationView.setCheckedItem(R.id.nav_results);
    }

    @Override
    protected void onResume() {
        //NB: not covered in video:
        //Updates checked item when returning with back button

        super.onResume();
        navigationView.setCheckedItem(R.id.nav_results);
    }
}