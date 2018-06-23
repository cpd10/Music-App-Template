package com.example.android.project_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class LibraryActivity extends AppCompatActivity
{
    Button home;
    Button payment;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        home = (Button)findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        payment = (Button)findViewById(R.id.paymentButton);
        payment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LibraryActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });

        MainActivity.play_pause = (ImageView) findViewById(R.id.playButton);
        isPlaying = false;
        MainActivity.play_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if (!isPlaying)
                {
                    MainActivity.play_pause.setImageResource(R.drawable.pause);
                    isPlaying = true;
                }
                else
                {
                    MainActivity.play_pause.setImageResource(R.drawable.play);
                    isPlaying = false;
                }

            }
        });

        MainActivity.now_playing = (RelativeLayout) findViewById(R.id.nowPlaying);
        MainActivity.now_playing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LibraryActivity.this, NowActivity.class);
                boolean libraryScreen = true;
                boolean homeScreen = false;
                i.putExtra("HOME_ACTIVITY",homeScreen);
                i.putExtra("LIBRARY_ACTIVITY",libraryScreen);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }
}
