package com.exemple.jeuandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class Background {

    private Bitmap background;
    private int posX;
    private int posY;
    private int backgroundVelocity;
    private static int nextWidth = 0;

    public Background(View v){
        background = BitmapFactory.decodeResource(v.getResources(),R.drawable.forest);
        posX = setNextWidth(v);
        posY = 0;
        backgroundVelocity = -3;
    }

    public void setMap(Bitmap bm) {
        background = bm;
    }

    public Bitmap getMap() {
        return background;
    }


    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }


    public void setPosX(int x) {
        posX=x;
    }


    public void setPosY(int y) {
        posY=y;
    }


    public float getWidth() {
        return background.getWidth();
    }


    public float getHeight() {
        return background.getHeight();
    }

    public int getBackgroundVelocity() {return backgroundVelocity;}

    public static int setNextWidth(View v){
        if(nextWidth!=3*v.getWidth()){
            nextWidth += v.getWidth();
            return nextWidth-v.getWidth();
        }
        else return nextWidth;
    };

    public static int getNextWidth(View v){
        return nextWidth;
    }

}
