package com.exemple.jeuandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button bt_jouer;
    private Button bt_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_jouer = (Button) findViewById(R.id.jouer);
        bt_scores = (Button) findViewById(R.id.scores);

        /*bt_jouer.setOnClickListener(this);
        bt_scores.setOnClickListener(this);*/


    }


    public void onClick(View v) {
        if (v.getId() == R.id.jouer){
            Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(gameIntent);
            finish();
        }
        if(v.getId() == R.id.scores){
            Intent scoresIntent = new Intent(MainActivity.this,TableScoreActivity.class);
            startActivity(scoresIntent);
            finish();
        }
    }
}
