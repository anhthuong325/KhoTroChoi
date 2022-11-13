package com.example.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

public class Pipe extends BaseObjectFlappyBird{
    public static int speed;
    public Pipe(float x, float y, int with, int height){
        super(x, y, with, height);
        speed = 10*ConstanstFlappyBird.SCREEN_WIDTH/1080;
    }
    public void draw(Canvas canvas){
        this.x = this.x - speed;
        canvas.drawBitmap(this.bm, this.x, this.y, null);
    }

    public void randomY(){
        Random r = new Random();
        this.y = r.nextInt((0+this.height/4)+1)-this.height/4;
    }
    @Override
    public void setBm(Bitmap bm) {
        this.bm = Bitmap.createScaledBitmap(bm, width, height, true);
    }
}
