package com.exemple.jeuandroid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private gameView gameView;
    private Handler handler = new Handler();
    private Intent intent;
    private final static long REFRESH = 3;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        gameView = new gameView(this);
        setContentView(gameView);
        intent = new Intent(GameActivity.this, scoreActivity.class);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameView.invalidate();
                endGame();
            }
        }, 0, REFRESH);
    }



    protected void endGame(){
        if(gameView.getGameOver()){
            intent.putExtra("val", gameView.getScore());
            timer.cancel();
            GameActivity.this.startActivity(intent);
            finish();
        }
    }
}
