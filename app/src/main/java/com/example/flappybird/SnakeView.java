package com.example.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SnakeView extends View {
    private Bitmap bmGrass1, bmGrass2, bmSnake;
    public static int sizeOfMap = 75*ConstantsSnake.SCREEN_WIDTH/1080;
    private  int h = 25, w = 13;
    private ArrayList<GrassSnake> arrGrass = new ArrayList<>();
    private SnakeMain snake;
    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeOfMap, sizeOfMap, true);
        bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass03);
        bmSnake = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake1);
        bmSnake = Bitmap.createScaledBitmap(bmSnake, 14*sizeOfMap, sizeOfMap, true);
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if((i+j)%2==0){
                    arrGrass.add(new GrassSnake(bmGrass1, j*sizeOfMap + ConstantsSnake.SCREEN_WIDTH/2-(w/2)*sizeOfMap,
                            i*sizeOfMap+100*ConstantsSnake.SCREEN_HEIGHT/1920, sizeOfMap, sizeOfMap));
                } else {
                    arrGrass.add(new GrassSnake(bmGrass2, j*sizeOfMap + ConstantsSnake.SCREEN_WIDTH/2-(w/2)*sizeOfMap,
                            i*sizeOfMap+100*ConstantsSnake.SCREEN_HEIGHT/1920, sizeOfMap, sizeOfMap));
                }
            }
        }
        //126 kich thuoc cua 1 o
        snake = new SnakeMain(bmSnake, arrGrass.get(126).getX(), arrGrass.get(126).getY(), 4);
    }
    //draw snake
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(0xFF1A6100);
        for(int i=0; i<arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
        snake.draw(canvas);
    }
}
