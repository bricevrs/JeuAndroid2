package com.exemple.jeuandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class Perso implements NodesScene{


    private Bitmap perso;
    private Bitmap persoFrappe[];
    private int life;
    private int posX;
    private int posY;
    private boolean dead;
    //rajouter peux etre thread annimation


    public Perso(View v){
        perso = BitmapFactory.decodeResource(v.getResources(),R.drawable.marche5);
        persoFrappe = new Bitmap[4];
        persoFrappe[0] = BitmapFactory.decodeResource(v.getResources(), R.drawable.frappe1);
        persoFrappe[1] = BitmapFactory.decodeResource(v.getResources(), R.drawable.frappe2);
        persoFrappe[2] = BitmapFactory.decodeResource(v.getResources(), R.drawable.frappe3);
        persoFrappe[3] = BitmapFactory.decodeResource(v.getResources(), R.drawable.frappe4);
        //this.hit = hit;
        life = 1;
        posX = 50;
        posY = 750;
        dead = false;
        //hit = new Thread();
        //hit.setDaemon(true);

    }

    /*public void frapper(){

    }*/


    public void setLife(){
        life -=1;
        if(life<=0){
            dead = true;
        }
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

    @Override
    public float getWidth() {
        return perso.getWidth();
    }

    @Override
    public float getHeight() {
        return perso.getHeight();
    }

    public Bitmap[] getPersoFrappe(){
        return persoFrappe;
    }

    public boolean getDead(){
        return dead;
    }


}
