package com.gogo.fcmnotification

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gogo.fcmnotification.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var datastring: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        if ( intent !=null){
//            if (intent.hasExtra("Key")){
//              for (key in intent.extras!!.keySet()){
//                  datastring = datastring+intent.extras!!.getString(key)+"\n"
//              }
//                binding.text.text = datastring
//            }
//        }

        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
            Log.d("token", token)
        }
    }

    }
