package com.skudacity.android.scorekeeperudacity

import android.content.Context
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Vibrator



@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null
    var vibe: Vibrator? = null
    var pointsForUnornL = 0
    var pointsForUnornR = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vibe = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        mMediaPlayer = MediaPlayer.create(this, R.raw.fart_sound_effect)

    }

    fun effects(view: View)
    {
        ViewAnimator
                .animate(view)
                .translationY(0f, -1000f)
                .alpha(1f,0f)
                .scale(0.8f,1.5f)
                .duration(2000)
                .start()

        vibe!!.vibrate(100)
        mMediaPlayer!!.start()
    }


    fun puffFartUnicorL(view: View) {

        if(view.id == addOneToUnicornL.id)
        {
            pointsForUnornL++
            pointsUnicornL.setText(pointsForUnornL.toString())
        }
        else if(view.id == addTwoToUnicornL.id)
        {
            pointsForUnornL = pointsForUnornL +2
            pointsUnicornL.setText(pointsForUnornL.toString())
        }
        effects(fartL)

    }


    fun puffFartUnicorR(view: View) {

        if(view.id == addOneToUnicornR.id) {
            pointsForUnornR = pointsForUnornR + 2
            pointsUnicornR.setText(pointsForUnornR.toString())
        }
        else if(view.id == addTwoToUnicornR.id){
            pointsForUnornR++
            pointsUnicornR.setText(pointsForUnornR.toString())
        }
        effects(fartR)

    }


    fun resetBtn(view: View) {

        pointsForUnornR = 0
        pointsForUnornL = 0
        pointsUnicornR.setText(pointsForUnornL.toString())
        pointsUnicornL.setText(pointsForUnornR.toString())


    }
}


