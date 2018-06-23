package com.example.android.project_4;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity
{
    public static ImageView play_pause;
    public static RelativeLayout now_playing;

    Button library;
    Button payment;

    public static String STORAGE_PATH;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        STORAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
            library = (Button) findViewById(R.id.libraryButton);
            library.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(MainActivity.this, LibraryActivity.class);
                    startActivity(i);
                }
            });

            payment = (Button) findViewById(R.id.paymentButton);
            payment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(MainActivity.this, PaymentActivity.class);
                    startActivity(i);
                }
            });

            play_pause = (ImageView) findViewById(R.id.playButton);
            isPlaying = false;
            play_pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isPlaying)
                    {
                        play_pause.setImageResource(R.drawable.pause);
                        isPlaying = true;
                    }
                    else
                    {
                        play_pause.setImageResource(R.drawable.play);
                        isPlaying = false;
                    }
                }
            });

            now_playing = (RelativeLayout) findViewById(R.id.nowPlaying);
            now_playing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(MainActivity.this, NowActivity.class);
                    boolean homeScreen = true;
                    boolean libraryScreen = false;
                    boolean paymentScreen = false;
                    i.putExtra("HOME_ACTIVITY", homeScreen);
                    i.putExtra("LIBRARY_ACTIVITY", libraryScreen);
                    i.putExtra("PAYMENT_ACTIVITY", paymentScreen);
                    startActivity(i);
                }
            });
    }
}
