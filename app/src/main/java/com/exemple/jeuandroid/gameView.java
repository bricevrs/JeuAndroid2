package com.exemple.jeuandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class gameView extends View {

    private Bitmap perso;


    public gameView(Context context) {
        super(context);

        perso = BitmapFactory.decodeResource(getResources(), R.drawable.marche1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(perso, 0, 0, null);

    }
}
