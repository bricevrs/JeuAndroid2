package com.exemple.jeuandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import java.util.Random;

public class Enemy implements NodesScene {

    private Bitmap enemy;
    private int posX;
    private int posY;
    private int enemyVelocity;



    public Enemy(View v){
        enemy = BitmapFactory.decodeResource(v.getResources(),R.drawable.enemmi1);
        posX=0;
        posY=0;
        enemyVelocity=8;
    }


    @Override
    public void setMap(Bitmap bm) {
        enemy = bm;
    }

    @Override
    public Bitmap getMap() {
        return enemy;
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

    @Override
    public float getWidth() {
        return enemy.getWidth();
    }

    @Override
    public float getHeight() {
        return enemy.getHeight();
    }

    public void move(){
        posX -= enemyVelocity;
    }


}
