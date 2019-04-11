package com.exemple.jeuandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;

public class gameView extends View {

    private Bitmap perso;
    private int sceneX;
    private int sceneY;

    public gameView(Context context) {
        super(context);

        //Dimensions fenêtre
        DisplayMetrics ecran = new DisplayMetrics();

        sceneX = getWidth();
        sceneY = getHeight();

        perso = BitmapFactory.decodeResource(getResources(), R.drawable.marche1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawBitmap(perso, 100, 100, null);

    }
}
