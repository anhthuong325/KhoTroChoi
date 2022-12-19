package com.example.flappybird.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.flappybird.ChessboardAdapter;
import com.example.flappybird.R;

import java.util.ArrayList;

public class GameFragment extends Fragment {

    private RecyclerView rv_chessboard;
    private ChessboardAdapter chessboardAdapter;
    public static boolean turnO = true;
    public static TextView txt_turn;
    private Button btn_reset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        rv_chessboard = view.findViewById(R.id.rv_chessboard);
        txt_turn = view.findViewById(R.id.txt_turn);
        btn_reset = view.findViewById(R.id.btn_reset);
        ArrayList<Bitmap> arrBms = new ArrayList<>();
        for(int i = 0; i<9; i++){
            arrBms.add(null);
        }
        chessboardAdapter = new ChessboardAdapter(getContext(), arrBms);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        rv_chessboard.setLayoutManager(layoutManager);
        rv_chessboard.setAdapter(chessboardAdapter);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        return view;
    }

    private void reset() {
        ArrayList<Bitmap> arrBms = new ArrayList<>();
        for(int i = 0; i<9; i++){
            arrBms.add(null);
        }
        chessboardAdapter.setArrBms(arrBms);
        chessboardAdapter.notifyDataSetChanged();
        turnO = true;
        txt_turn.setText("Turn of O");
    }
}