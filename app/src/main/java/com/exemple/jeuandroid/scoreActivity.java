package com.exemple.jeuandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class scoreActivity extends AppCompatActivity /*implements View.OnClickListener*/ {


    private Button bt_mainMenu;
    private Button bt_save;

    private EditText champ_text;

    private MyDatabase myDb;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        champ_text = (EditText) findViewById(R.id.editText);

        bt_mainMenu = (Button) findViewById(R.id.jouer);
        bt_save = (Button) findViewById(R.id.scores);

        /*bt_mainMenu.setOnClickListener(this);
        bt_save.setOnClickListener(this);*/

        myDb = new MyDatabase(this);
        myDb.open();

    }

    public void onClick(View v) {
        if(v.getId()==R.id.mainMenu){
            intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }

        if(v.getId()==R.id.save){
            intent = new Intent(getApplicationContext(), TableScoreActivity.class);
            Intent data = getIntent();
            int score = data.getIntExtra("val",-1);
            String text = champ_text.getText().toString();
            myDb.insertScore(text,score);
            myDb.close();
            startActivity(intent);
            finish();
        }
    }
}
