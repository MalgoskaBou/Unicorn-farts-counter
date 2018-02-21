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
    var pointsForUnorn1 = 0
    var pointsForUnorn2 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vibe = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

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

        if(mMediaPlayer!=null){
            mMediaPlayer!!.release()
        }
        mMediaPlayer = MediaPlayer.create(this, R.raw.fart_sound_effect)
        mMediaPlayer!!.start()
    }


    fun puffFart1Unicor1(view: View) {

        pointsForUnorn1++
        pointsUnicornL.setText(pointsForUnorn1.toString())
        effects(fartL)

    }
    fun puffFart2Unicor1(view: View) {

        pointsForUnorn1 = pointsForUnorn1+2
        pointsUnicornL.setText(pointsForUnorn1.toString())
        effects(fartL)

    }


    fun puffFart2Unicor2(view: View) {

        pointsForUnorn2 = pointsForUnorn2+2
        pointsUnicornR.setText(pointsForUnorn2.toString())
        effects(fartR)

    }

    fun puffFart1Unicor2(view: View) {

        pointsForUnorn2++
        pointsUnicornR.setText(pointsForUnorn2.toString())
        effects(fartR)

    }

    fun resetBtn(view: View) {

        pointsForUnorn2 = 0
        pointsForUnorn1 = 0
        pointsUnicornR.setText(pointsForUnorn1.toString())
        pointsUnicornL.setText(pointsForUnorn2.toString())


    }
}


