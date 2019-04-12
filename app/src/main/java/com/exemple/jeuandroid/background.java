package com.exemple.jeuandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class background implements NodesScene {

    private Bitmap background;
    private int posX;
    private int posY;
    private int backgroundVelocity;

    public background(View v){
        background = BitmapFactory.decodeResource(v.getResources(),R.drawable.forest);
        posX = 0;
        posY = 0;
        backgroundVelocity = -3;
    }

    @Override
    public void setMap(Bitmap bm) {
        background = bm;
    }

    @Override
    public Bitmap getMap() {
        return background;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public void setPosX(int x) {
        posX=x;
    }

    @Override
    public void setPosY(int y) {
        posY=y;
    }

}
