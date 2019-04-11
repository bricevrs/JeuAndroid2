package com.exemple.jeuandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_jouer;
    private Button bt_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_jouer = (Button) findViewById(R.id.jouer);
        bt_scores = (Button) findViewById(R.id.scores);

        bt_jouer.setOnClickListener(this);
        bt_scores.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.jouer){
            Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(gameIntent);
        }
    }
}
