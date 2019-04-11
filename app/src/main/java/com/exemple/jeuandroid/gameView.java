package com.exemple.jeuandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;

public class gameView extends View {

    private Bitmap perso;
    private Bitmap background;
    private Paint score = new Paint();
    public gameView(Context context) {
        super(context);


        perso = BitmapFactory.decodeResource(getResources(), R.drawable.marche1);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.forest);

        score.setColor(Color.WHITE);
        score.setTextSize(36);
        score.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(background,0,0,null);
        canvas.drawBitmap(perso, 50, 750, null);
        canvas.drawText("Score : ",850,850,score);


    }
}
