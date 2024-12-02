package com.example.puriesfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.puriesfooddelivery.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private  val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.loginbutton.setOnClickListener{
            val intent = Intent(this , SigninActivity::class.java)
            startActivity(intent)
        }
        binding.dontHaveAccountButton.setOnClickListener{
            val intent = Intent(this , SigninActivity::class.java)
            startActivity(intent)
        }
    }
}