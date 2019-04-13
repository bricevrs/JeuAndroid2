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

import java.util.ArrayList;
import java.util.Random;

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
    private ArrayList<Enemy> enemies;
    private Random rand;

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

        //init Enemy
        rand = new Random();
        enemies = new ArrayList<>();


    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        //canvas score
        //moveBackground(canvas);
        canvas.drawBitmap(bg,0,0,null);
        canvas.drawText("Score : ", canvas.getWidth()/2, 850, score);
        //perso.setPosY(canvas.getHeight()-100);
        //canvas.drawBitmap(perso.getMap(), perso.getPosX(),perso.getPosY(),null);
        movePerso(perso,canvas);
        addEnemyInList(canvas);
        addEnemyInCanvas(canvas);
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


    protected Enemy CreateEnemy(Canvas c){
        /*toutes les x secondes*/
        /*
        On ajoute les ennemis au hasard si le chiffre correspond au random sortit
        */
        Enemy ennemi = new Enemy(this);
        ennemi.setPosX(new Random().nextInt((c.getWidth()*2) - c.getWidth()+1) + c.getWidth());
        ennemi.setPosY(new Random().nextInt(c.getHeight()));
        //ennemi.setPosX(200);
        //ennemi.setPosY(200);
        return ennemi;

    }

    protected void addEnemyInList(Canvas c){
        int nbRand = rand.nextInt(80);
        if (nbRand==7){
            enemies.add(CreateEnemy(c));
        }
    }

    protected void DetectCollisions(Canvas c){
        for(int i = 0; i< enemies.size();i++){
            if (collision(perso,enemies.get(i))){
                //score+=1;
                enemies.remove(i);
            }
        }
    }

    protected void addEnemyInCanvas(Canvas c){
        //Pour chaque ennemi dans la liste ajout dans canvas
        //A chaque exe de la fonction move
        for (int i = 0;i<enemies.size();i++){
            Enemy enemyX = enemies.get(i);
            c.drawBitmap(enemyX.getMap(),enemyX.getPosX(),enemyX.getPosY(),null);
            enemyX.move();
            if(enemyX.getPosX()<0){
                enemies.remove(i);
            }
        }
    }

    /*protected void MovedEnemies(Canvas c){
        //Changer les valeurs x de chaqu
        for(int i = 0; i<enemies.size();i++){
            Enemy enemyX = enemies.get(i);
            enemyX.setPosX(enemyX.getPosX()-);
        }
    }*/





    //Traiter ensuite les animations
    //Verifier si les ennemis sortent de l'écran et on les effaces

    protected boolean collision(NodesScene n1, NodesScene n2){
        return n1.getPosX()<n2.getPosX()+n2.getWidth() && (n1.getPosX()+n2.getWidth())>n1.getPosX() && n1.getPosY()<n2.getPosY()+n2.getHeight() && n1.getPosY()+n2.getHeight()>n2.getPosY();
    }

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

