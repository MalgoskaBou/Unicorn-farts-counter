package com.skudacity.android.scorekeeperudacity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;

/**
 * Created by narcy on 21.02.2018.
 */

public class MainActivity extends AppCompatActivity {


    //global variables
    MediaPlayer mMediaPlayer = null;
    Vibrator vibe = null;
    int pointsForUnornL = 0;
    int pointsForUnornR = 0;

    Button addOneToUnicornL;
    Button addTwoToUnicornL;
    Button addOneToUnicornR;
    Button addTwoToUnicornR;

    TextView pointsUnicornL;
    TextView pointsUnicornR;

    ImageView fartL;
    ImageView fartR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mMediaPlayer = MediaPlayer.create(this, R.raw.fart_sound_effect);

        //binding data
        addOneToUnicornL = (Button) findViewById(R.id.addOneToUnicornL);
        addTwoToUnicornL = (Button) findViewById(R.id.addTwoToUnicornL);
        addOneToUnicornR = (Button) findViewById(R.id.addOneToUnicornR);
        addTwoToUnicornR = (Button) findViewById(R.id.addTwoToUnicornR);

        pointsUnicornL = (TextView) findViewById(R.id.pointsUnicornL);
        pointsUnicornR = (TextView) findViewById(R.id.pointsUnicornR);

        fartL = (ImageView) findViewById(R.id.fartL);
        fartR = (ImageView) findViewById(R.id.fartR);
    }

    public void effects(View view) {
        ViewAnimator
                .animate(view)
                .translationY(0f, -1000f)
                .alpha(1f, 0f)
                .scale(0.8f, 1.5f)
                .duration(2000)
                .start();

        vibe.vibrate(100);
        mMediaPlayer.start();
    }

    public void puffFartUnicorL(View view) {

        if (view == addOneToUnicornL) {
            pointsForUnornL++;
            pointsUnicornL.setText(String.valueOf(pointsForUnornL));
        } else if (view == addTwoToUnicornL) {
            pointsForUnornL = pointsForUnornL + 2;
            pointsUnicornL.setText(String.valueOf(pointsForUnornL));
        }
        effects(fartL);
    }

    public void puffFartUnicorR(View view) {

        if (view == addOneToUnicornR) {
            pointsForUnornR = pointsForUnornR + 2;
            pointsUnicornR.setText(String.valueOf(pointsForUnornR));
        } else if (view == addTwoToUnicornR) {
            pointsForUnornR++;
            pointsUnicornR.setText(String.valueOf(pointsForUnornR));
        }
        effects(fartR);
    }

    public void resetBtn(View view) {

        pointsForUnornR = 0;
        pointsForUnornL = 0;
        pointsUnicornR.setText(String.valueOf(pointsForUnornL));
        pointsUnicornL.setText(String.valueOf(pointsForUnornR));
    }
}




