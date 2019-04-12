package com.exemple.jeuandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class perso implements NodesScene{


    private Bitmap perso;
    private int life;
    private int posX;
    private int posY;
    //rajouter peux etre thread annimation


    public perso(View v){
        perso = BitmapFactory.decodeResource(v.getResources(),R.drawable.marche2);
        life = 5;
        posX = 50;
        posY = v.getHeight()-50;

    }


    public void setLife(){
        life -=1;
    }

    public int getLife(){
        return life;
    }

    public Bitmap getMap(){
        return perso;
    }

    public void setMap(Bitmap bm){
        perso = bm;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosX(int x){
        posX=x;
    }

    public void setPosY(int y){
        posY=y;
    }


}
