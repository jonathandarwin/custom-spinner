package com.jonathandarwin.customspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.jonathandarwin.customspinner.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSpinner()

        binding.btnHome.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun setSpinner(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.history, android.R.layout.simple_list_item_1)
        adapter.setDropDownViewResource(R.layout.custom_dropdown_item)
        binding.spinner.adapter = adapter

    }
}
