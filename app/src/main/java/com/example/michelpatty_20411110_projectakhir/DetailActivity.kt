@file:Suppress("DEPRECATION")

package com.example.michelpatty_20411110_projectakhir
import android.content.Intent
import android.content.pm.ChangedPackages
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay

class DetailActivity : AppCompatActivity() {

    private var handler = Handler()
    private lateinit var runnable: Runnable

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail)

        val detail = intent.getParcelableExtra<itemData>(MainActivity.INTENT_PARCELABLE)

            val imageView = findViewById<ImageView>(R.id._imgDetail)
            val textViewTitle = findViewById<TextView>(R.id._judulDetail)
            val textViewDesc = findViewById <TextView>(R.id._artisDetail)

            val imageView2 = findViewById<ImageView>(R.id._imglagu1)
            val textViewTitle2 = findViewById<TextView>(R.id._judullagu1)
            val textViewDesc2 = findViewById <TextView>(R.id._artislagu1)

            val imageView3 = findViewById<ImageView>(R.id._imglagu2)
            val textViewTitle3 = findViewById<TextView>(R.id._judullagu2)
            val textViewDesc3 = findViewById <TextView>(R.id._artislagu2)

            val imageView4 = findViewById<ImageView>(R.id._imglagu3)
            val textViewTitle4 = findViewById<TextView>(R.id._judullagu3)
            val textViewDesc4 = findViewById <TextView>(R.id._artislagu3)



            imageView.setImageResource(detail!!.img)
            textViewTitle.text = detail.album
            textViewDesc.text = detail.artis

            imageView2.setImageResource(detail!!.img1)
            textViewTitle2.text = detail.judul1
            textViewDesc2.text = detail.artis1

            imageView3.setImageResource(detail!!.img2)
            textViewTitle3.text = detail.judul2
            textViewDesc3.text = detail.artis2

            imageView4.setImageResource(detail!!.img3)
            textViewTitle4.text = detail.judul3
            textViewDesc4.text = detail.artis3

        val btn_back = findViewById<ImageView>(R.id.btn_back)

        btn_back.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
        //        val mp = MediaPlayer()

//=======================LAGU 1=====================================
        val seekbar1 = findViewById<SeekBar>(R.id.seekbar1)
        val play1 = findViewById<ImageButton>(R.id.play1)
        val mediaplayer1:MediaPlayer = MediaPlayer.create(this,R.raw.theweeknd2)
        seekbar1.progress = 0
        seekbar1.max = mediaplayer1.duration
        play1.setOnClickListener{
            if(!mediaplayer1.isPlaying){
                mediaplayer1.start()
                play1.setImageResource(R.drawable.pause_icon)
            }else{
                mediaplayer1.pause()
                play1.setImageResource(R.drawable.play_icon)
            }
        }
        seekbar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaplayer1.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekbar1.progress = mediaplayer1.currentPosition
            handler.postDelayed(runnable, 100)
        }
        handler.postDelayed(runnable,100)
        mediaplayer1.setOnCompletionListener {
            mediaplayer1.pause()
            play1.setImageResource(R.drawable.play_icon)
        }

//=======================LAGU 2=====================================
        val seekbar2 = findViewById<SeekBar>(R.id.seekbar2)
        val play2 = findViewById<ImageButton>(R.id.play2)
        val mediaplayer2:MediaPlayer = MediaPlayer.create(this,R.raw.theweeknd1)
        seekbar2.progress = 0
        seekbar2.max = mediaplayer2.duration
        play2.setOnClickListener{
            if(!mediaplayer2.isPlaying){
                mediaplayer2.start()
                play2.setImageResource(R.drawable.pause_icon)
            }else{
                mediaplayer2.pause()
                play2.setImageResource(R.drawable.play_icon)
            }
        }
        seekbar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaplayer2.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekbar2.progress = mediaplayer2.currentPosition
            handler.postDelayed(runnable, 100)
        }
        handler.postDelayed(runnable,100)
        mediaplayer2.setOnCompletionListener {
            mediaplayer2.pause()
            play2.setImageResource(R.drawable.play_icon)
        }

//=======================LAGU 3=====================================
        val seekbar3 = findViewById<SeekBar>(R.id.seekbar3)
        val play3 = findViewById<ImageButton>(R.id.play3)
        val mediaplayer3:MediaPlayer = MediaPlayer.create(this,R.raw.theweeknd3)
        seekbar3.progress = 0
        seekbar3.max = mediaplayer3.duration
        play3.setOnClickListener{
            if(!mediaplayer3.isPlaying){
                mediaplayer3.start()
                play3.setImageResource(R.drawable.pause_icon)
            }else{
                mediaplayer3.pause()
                play3.setImageResource(R.drawable.play_icon)
            }
        }
        seekbar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaplayer3.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekbar3.progress = mediaplayer3.currentPosition
            handler.postDelayed(runnable, 100)
        }
        handler.postDelayed(runnable,100)
        mediaplayer3.setOnCompletionListener {
            mediaplayer3.pause()
            play3.setImageResource(R.drawable.play_icon)
        }


    }
}
