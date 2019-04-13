package com.exemple.jeuandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class gameView extends View {

    //ecran touché
    private boolean touch = false;
    private float touchY = 0;
    private float touchX = 0;
    private int persoVelocity = 0;

    //score
    private Paint score;

    //perso
    private Perso perso;

    //background
    private Bitmap bg;
    private int minPos = 0;
    private int maxPos = 0;

    //private int nbBg;


    //ennemis
    //private ArrayList<Enemy> enemies = new ArrayList<>();

    public gameView(Context context) {
        super(context);

        //init score
        score = new Paint();
        //nbBg = 0;
        score.setColor(Color.WHITE);
        score.setTextSize(36);
        score.setTypeface(Typeface.DEFAULT_BOLD);

        //init perso
        perso = new Perso(this);


        //init background
        bg = BitmapFactory.decodeResource(getResources(), R.drawable.forest);


    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        //canvas score
        canvas.drawText("Score : ", canvas.getWidth()/2, 850, score);
        //moveBackground(canvas);
        canvas.drawBitmap(bg,0,0,null);
        //perso.setPosY(canvas.getHeight()-100);
        //canvas.drawBitmap(perso.getMap(), perso.getPosX(),perso.getPosY(),null);
        movePerso(perso,canvas);
    }


    protected void moveBackground(Canvas c){

        //on fais bouger les deux background quand un des trois sort on le replace derriere
        /*while(bg.length!=3){
            bg[nbBg] = new Background(this);
            c.drawBitmap(bg[nbBg].getMap(),Background.getNextWidth(this),0,null);
            nbBg++;
        }*/
        /*for(int i =0;i<3;i++){
            int newPosX = bg[i].getPosX()-bg[i].getBackgroundVelocity();
            if(newPosX<=-this.getWidth()) {
                c.drawBitmap(bg[i].getMap(), Background.setNextWidth(this), bg[i].getPosY(), null);
                bg[i].setPosX(Background.getNextWidth(this));
            }
            else {
                c.drawBitmap(bg[i].getMap(),newPosX,bg[i].getPosY(),null);
                bg[i].setPosX(newPosX);
            };
        }*/

    }

    protected void movePerso(Perso p,Canvas c){
        /* saut et frappe*/
        /*
        On verifie si on touche le haut de l'écran (ou bien cette fonction est exe quand on touche lecran
        On verifie ou on touche l'écran
        Et on agit en conséquence
         */
        minPos = perso.getMap().getHeight()-60;
        maxPos = c.getHeight() - perso.getMap().getHeight();

        perso.setPosY(perso.getPosY()+persoVelocity);
        persoVelocity += 2;

        if(perso.getPosY() < minPos) perso.setPosY(minPos);
        if(perso.getPosY() > maxPos) perso.setPosY(maxPos);


        if(touch){
            if(touchY>c.getHeight()/2){
                //On frappe
                //c.drawBitmap(p.getMap(), p.getPosX(), p.getPosY(),null);
                touch = false;
            }
            if(touchY<=c.getHeight()/2){
                persoVelocity = -20;
                c.drawBitmap(p.getMap(),p.getPosX(),p.getPosY(),null);
                touch = false;
            }
        }
        else c.drawBitmap(p.getMap(),p.getPosX(),p.getPosY(),null);

    }


    protected void addEnemy(){
        /*toutes les x secondes*/
        /*
        On ajoute les ennemis au hasard si le chiffre correspond au random sortit
        */


    }

    //Traiter ensuite les animations
    //Verifier si les ennemis sortent de l'écran et on les effaces


    @Override
    public boolean onTouchEvent(MotionEvent event) {
       if (event.getAction()==MotionEvent.ACTION_DOWN){
           touch = true;
           touchY = event.getY();
           touchX = event.getX();
           return true;
       }
        return false;
    }
}

