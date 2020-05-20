package com.example.taskapp.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskapp.MainActivity;
import com.example.taskapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Boardfragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Boardfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.boardfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=view.findViewById(R.id.fragmentText);
        ImageView imageView=view.findViewById(R.id.imageView);
        Button button=view.findViewById(R.id.getStarted);

        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                button.setVisibility(View.INVISIBLE);
               imageView.setImageResource(R.drawable.ic_face1);

                textView.setText("ПРИВЕТ");
                view.setBackgroundColor(Color.CYAN);
                break;

            case 1:
                button.setVisibility(View.INVISIBLE);
                imageView.setImageResource(R.drawable.ic_face2);
                textView.setText("КАК ДЕЛА?");
                view.setBackgroundColor(Color.RED);
                break;

            case 2:
                button.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.ic_child);
                textView.setText("ЧТО ДЕЛАШЬ?");
                view.setBackgroundColor(Color.MAGENTA);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveIsShown();
                                Intent intent = new Intent(getContext(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                    }

                });
                break;

        }
    }
    private void saveIsShown() {
        SharedPreferences preferences= getActivity().getSharedPreferences("setting", Context.MODE_PRIVATE);
        preferences.edit().putBoolean("isShown",true).apply();
    }
}
