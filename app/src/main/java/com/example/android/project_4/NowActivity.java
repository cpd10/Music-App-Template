package com.example.android.project_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * Created by dhook_000 on 6/23/2017.
 */

public class NowActivity extends AppCompatActivity
{
    RelativeLayout now_playing;
    ImageView next;
    ImageView previous;
    ImageView menu;


    ImageView forward10;

    ImageView back10;

    TextView song_total;
    TextView song_current;
    SeekBar seek;

    boolean home;
    boolean library;
    boolean payment;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        home = getIntent().getBooleanExtra("HOME_ACTIVITY",true);
        library = getIntent().getBooleanExtra("LIBRARY_ACTIVITY",true);
        payment = getIntent().getBooleanExtra("PAYMENT_ACTIVITY",true);

        seek = (SeekBar)findViewById(R.id.seekBar);
        song_current = (TextView)findViewById(R.id.currentTime);
        song_total = (TextView)findViewById(R.id.totalTime);

        menu = (ImageView)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

            }
        });

        now_playing = (RelativeLayout) findViewById(R.id.nowPlaying);
        now_playing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent i;
                if(home)
                {
                    i = new Intent(NowActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else if(library)
                {
                    i = new Intent(NowActivity.this, LibraryActivity.class);
                    startActivity(i);
                }
                else if(payment)
                {
                    i = new Intent(NowActivity.this, PaymentActivity.class);
                    startActivity(i);
                }
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

        next = (ImageView) findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        previous = (ImageView) findViewById(R.id.previousButton);
        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        forward10 = (ImageView) findViewById(R.id.forwardButton);
        forward10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

            }
        });

        back10 = (ImageView) findViewById(R.id.backButton);
        back10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

            }
        });
    }



    @Override
    public void onResume()
    {
        super.onResume();
    }

}


