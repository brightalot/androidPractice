package com.example.simplemusicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.simplemusicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var handler: Handler
    private var isPlaying = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.sample) // 음악 파일 설정
        handler = Handler()

        // 음악 재생/일시정지 버튼 클릭 시 이벤트 처리
        binding.buttonPlayPause.setOnClickListener {
            if (isPlaying) {
                pauseMusic()
            } else {
                playMusic()
            }
        }

        // 음악 정지 버튼 클릭 시 이벤트 처리
        binding.buttonStop.setOnClickListener {
            stopMusic()
        }

        // SeekBar 변경 시 이벤트 처리
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // 아무 동작 없음
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // 아무 동작 없음
            }
        })

        // SeekBar 업데이트
        updateSeekBar()
    }

    private fun playMusic() {
        mediaPlayer.start()
        binding.buttonPlayPause.text = "일시정지"
        isPlaying = true
    }

    private fun pauseMusic() {
        mediaPlayer.pause()
        binding.buttonPlayPause.text = "재생"
        isPlaying = false
    }

    private fun stopMusic() {
        mediaPlayer.stop()
        mediaPlayer.prepare()
        mediaPlayer.seekTo(0)
        binding.buttonPlayPause.text = "재생"
        isPlaying = false
    }

    private fun updateSeekBar() {
        binding.seekBar.max = mediaPlayer.duration

        Thread(Runnable {
            while (mediaPlayer != null) {
                try {
                    val currentPosition = mediaPlayer.currentPosition
                    binding.seekBar.progress = currentPosition
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
