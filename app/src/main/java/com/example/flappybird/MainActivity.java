package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnFlappyBird, btnSnake, btnCaro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFlappyBird = (Button) findViewById(R.id.btn_flappy_bird);
        btnSnake = (Button) findViewById(R.id.btn_snake);
        btnCaro = (Button) findViewById(R.id.btn_caro);
        btnFlappyBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FlappyBird.class);
                startActivity(intent);
            }
        });
        btnSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Snake.class);
                startActivity(intent);
            }
        });
        btnCaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaroMain.class);
                startActivity(intent);
            }
        });
    }
}