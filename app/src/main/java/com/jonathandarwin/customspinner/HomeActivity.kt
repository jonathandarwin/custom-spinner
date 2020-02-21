package com.jonathandarwin.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.jonathandarwin.customspinner.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setSpinner()
    }

    private fun setSpinner(){
        val data = ArrayList<String>()
        data.add("Last 7 days")
        data.add("Last 14 days")
        data.add("Last 30 days")
        val adapter = SpinnerAdapter(this, R.layout.custom_dropdown_item, data)
        adapter.setDropDownViewResource(R.layout.custom_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                adapter.setSelectedIndex(position)
                Toast.makeText(this@HomeActivity, "$position : ${data[position]}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
