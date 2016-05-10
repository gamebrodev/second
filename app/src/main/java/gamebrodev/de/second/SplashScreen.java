package gamebrodev.de.second;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


public class SplashScreen extends AppCompatActivity {

    MediaPlayer ourSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ourSound = MediaPlayer.create(SplashScreen.this, R.raw.splash);
        ourSound.start();

        /** Dieser Thread zeigt einen StartScreen für x Sekunden bevor die App startet */
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        Class myClass = Class.forName("gamebrodev.de.second.Menu");
                        Intent openMenu = new Intent(SplashScreen.this, myClass);
                        startActivity(openMenu);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        /* beendet den Startsound vor dem nächsten Screen */
        ourSound.release();
        /* beendet den Splashscreen */
        finish();
    }
}