package com.example.simplememo

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.simplememo.databinding.ActivityMainBinding

var memoData: String = ""

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val text = binding.edtMemo.text.toString()
            val intent = Intent(this, SavedMemosActivity::class.java)
            intent.putExtra("Memo", text)
            startActivity(intent)
        }

    }
//    override fun onResume() {
//        super.onResume()
//            binding.edtMemo.setText(memoData)
//    }
    override fun onPause() {
        super.onPause()
        memoData = binding.edtMemo.text.toString()
    }

    override fun onRestart() {
        super.onRestart()

        var builder = AlertDialog.Builder(this)
        builder.setTitle("Memo")
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("네", DialogInterface.OnClickListener {
                    dialog, which -> binding.edtMemo.text.clear()
            })
            .setNegativeButton("아니오", DialogInterface.OnClickListener {
                    dialog, which -> memoData = ""
            })
            .create()
            .show()
    }

}