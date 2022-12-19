package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.flappybird.Fragments.StartFragment;

public class CaroMain extends AppCompatActivity {

    private FrameLayout main_frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_caro_main);
        main_frame = findViewById(R.id.main_frame);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, new StartFragment());
        transaction.commit();
    }
}