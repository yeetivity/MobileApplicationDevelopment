package yeetivity.jjve.tic_tac_toe;
/*
This app is created by Jitse van Esch for the @yeetivity channel
This app is highly inspired by Anders Lindström and meant for education purposes only.
Intended learnings:
- Imageviews to display images as displays
- Custom layout components (SquareLayout)
- Load drawables
- Text to speech (only on hardware devices)
- Animation with ValueAnimator

Last code review:
28-10-2022

 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

import yeetivity.jjve.tic_tac_toe.model.Logic;

public class MainActivity extends AppCompatActivity {

    private Logic logic;
    private TicView ticView;

    private TextToSpeech textToSpeech;
    private static final int utteranceID = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ticView = (TicView) findViewById(R.id.ticView);
        ticView.setOnTouchListener(new TicTouchListener());;

        logic = Logic.getInstance();
    }

    private class TicTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (MotionEvent.ACTION_DOWN == motionEvent.getAction()){
                float x = motionEvent.getX();
                float y = motionEvent.getY();

                //compute corresponding row and col
                int row = (int) Math.floor(y / ticView.getCellSize());
                int col = (int) Math.floor(x / ticView.getCellSize());

                //update logic
                if (logic.isLegalMove(row, col)){
                    logic.makeMove(row, col);

                    //update view
                    ticView.fadeInDrawable();

                    if (logic.isDecided()){
                        String msg = "";
                        switch (logic.getWinner()) {
                            case CROSS:
                                msg = "Cross won, congrats";
                                break;
                            case NOUGHT:
                                msg = "Nought won, congrats";
                                break;
                            case NONE:
                                msg = "Draw, try again!";
                        }
                        createDialog("Game over", msg).show();
                        sayIt(msg);
                    }
                }
                return true;
            }
            return false;
        }
    }

    public void onGameRestart(View view){
        logic.reset();
        ticView.invalidate();
        sayIt("Restarting");
    }

    private void sayIt(String utterance){
        textToSpeech.speak(utterance, TextToSpeech.QUEUE_FLUSH,
                null, new String ("" + utteranceID));
    }

    @Override
    protected void onPause() {
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Init tts service
        textToSpeech = new TextToSpeech(getApplicationContext(),
                i -> {
                    if (i == TextToSpeech.SUCCESS){
                        textToSpeech.setLanguage(Locale.UK);
                    }
                });
    }

    private Dialog createDialog(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            // Do nothing on button press
        });
        return builder.create();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) setStatusBarHiddenInLandscapeMode();
    }

    private void setStatusBarHiddenInLandscapeMode(){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }
}