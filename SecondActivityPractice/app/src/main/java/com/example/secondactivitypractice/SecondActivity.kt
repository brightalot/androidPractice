package com.example.secondactivitypractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.secondactivitypractice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var secondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)

        // MainActivity에서 전달한 메시지를 받아와서 TextView에 표시
        val message = intent.getStringExtra("message")
        secondBinding.tvGivenMessage.text = message

        secondBinding.btnSecond.setOnClickListener {
            // 버튼을 눌렀을 때 실행될 코드
            val backmessage = secondBinding.etBack.text.toString()
            val second_intent = Intent(this@SecondActivity, MainActivity::class.java)
                .putExtra("message", backmessage)
            setResult(Activity.RESULT_OK, second_intent)
            finish()
        }
    }


}
