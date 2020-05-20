package com.example.udacityandroidme

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.udacityandroidme.viewmodels.MyViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyTag", "onCreate main activity");


        supportFragmentManager.beginTransaction()
            .replace(R.id.head_fragment_container, HeadPartFragment()).commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.body_fragment_container, BodyPartFragment()).commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.legs_fragment_container, LegsPartFragment()).commit()
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.side_bar_container, ChoosePartsFragment()).commit()
        }

    }
}
