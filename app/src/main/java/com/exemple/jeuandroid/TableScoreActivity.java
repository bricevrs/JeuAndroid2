package com.exemple.jeuandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TableScoreActivity extends AppCompatActivity {


    private ListView myListView;
    private MyAdapterArray myAd;
    private MyDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_score);

        myDb = new MyDatabase(this);
        myDb.open();

        myListView = (ListView) findViewById(R.id.listV);
        registerForContextMenu(myListView);

        myAd = new MyAdapterArray(this, myDb.getAllScore());
        myListView.setAdapter(myAd);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo m = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Score s = myAd.getItem(m.position);
        if(item.getItemId()==R.id.delete){
            myAd.remove(s);
            myDb.removeScore(s.getId());
        }
        return super.onContextItemSelected(item);
    }

}
