package com.exemple.jeuandroid;

import android.graphics.Bitmap;

public interface NodesScene {

    public void setMap(Bitmap bm);
    public Bitmap getMap();
    public int getPosX();
    public int getPosY();
    public void setPosX(int x);
    public void setPosY(int y);
    public float getWidth();
    public float getHeight();

}
